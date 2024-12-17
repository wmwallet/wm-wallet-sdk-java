package sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

public class AESEncryptECB {
    // Method to encrypt the data using AES with ECB mode
    public static String encrypt(String plaintext, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getKey(key));
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt the data using AES with ECB mode
    public static String decrypt(String ciphertextBase64, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, getKey(key));
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertextBase64));
        return new String(decryptedBytes);
    }

    private static SecretKeySpec getKey(String key) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] k = sha.digest(key.getBytes());
        return new SecretKeySpec(k, "AES");
    }
}
