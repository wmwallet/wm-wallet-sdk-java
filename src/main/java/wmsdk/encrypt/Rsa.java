package wmsdk.encrypt;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;

import javax.crypto.Cipher;


public class Rsa {

    static {
        java.security.Security.addProvider(new BouncyCastleProvider());
    }

    public static byte[] getBytes(String path) throws Exception {
        // Read the RSA file
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IOException("Error reading RSA file", e);
        }
    }

    public static RSAPublicKey toRsaPublicKey(String rsaPath, byte[] rsaBytes) throws Exception {
        if ((rsaPath == null || rsaPath.isEmpty()) && (rsaBytes == null || rsaBytes.length == 0)) {
            throw new IllegalArgumentException("Either rsaPath or rsaBytes must be provided");
        }
        byte[] keyBytes = rsaBytes;

        if (rsaPath != null && !rsaPath.isEmpty()) {
            keyBytes = getBytes(rsaPath);
        }

        // Parse PEM bytes into RSAPublicKey
        return parsePemPublicKey(keyBytes);
    }

    private static RSAPublicKey parsePemPublicKey(byte[] keyBytes) throws Exception {
        try (PEMParser pemParser = new PEMParser(new java.io.StringReader(new String(keyBytes)))) {
            Object parsedObject = pemParser.readObject();
            if (parsedObject instanceof org.bouncycastle.asn1.x509.SubjectPublicKeyInfo) {
                org.bouncycastle.asn1.x509.SubjectPublicKeyInfo publicKeyInfo = (org.bouncycastle.asn1.x509.SubjectPublicKeyInfo) parsedObject;
                java.security.PublicKey publicKey = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(publicKeyInfo.getEncoded()));
                return (RSAPublicKey) publicKey;
            } else {
                throw new Exception("Invalid public key format");
            }
        }
    }

    public static String encrypt(String plaintext, RSAPublicKey publicKey) throws Exception {
        // Step 1: Initialize the Cipher with RSA encryption
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // Step 2: Encrypt the plaintext
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

        // Step 3: Encode the encrypted bytes to Base64 for easy display and storage
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}