package wmsdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.util.Random;
import okhttp3.RequestBody;
import wmsdk.encrypt.AESEncryptECB;
import wmsdk.encrypt.Rsa;


public class Request {
    private static final String Wsign = "w-sign";
    private static final String Wbroker = "w-broker";
    private static final String Wts = "w-ts";
    private static final String Wnonce = "w-nonce";
    private static final String Wsecret = "w-secret";

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String DIGITS = "0123456789";

    private static String sign(String broker, String ts, String nonce, byte[] body) throws NoSuchAlgorithmException, IOException {
        // Create the byte array to append the body and header values
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byteStream.write(body);
        byteStream.write(broker.getBytes());
        byteStream.write(ts.getBytes());
        byteStream.write(nonce.getBytes());
        // Compute the SHA-256 hash
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] hash = sha256.digest(byteStream.toByteArray());

        // Convert the hash to hex
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }

        // Extract the substring from index 16 to 48 (exclusive) as in Go code
        return hexString.substring(16, 48);
    }

    public static okhttp3.Request buildRequest(String url, String path, byte[] body, String broker, RSAPublicKey pubkey) throws Exception {
        long timestamp = System.currentTimeMillis();
        String ts = String.valueOf(timestamp);
        String nonce = generateRandomString(DIGITS, 6);

        String secretOrigin = generateRandomString(CHARACTERS, 16);

        String str = new String(body, StandardCharsets.UTF_8);
        byte[] bodyCipher = AESEncryptECB.encrypt(str, secretOrigin).getBytes();
        String sk = Rsa.encrypt(secretOrigin, pubkey);
        String s = sign(broker, ts, nonce, body);

        return new okhttp3.Request.Builder()
                .url(url + path)
                .addHeader(Wbroker, broker)
                .addHeader(Wsecret, sk)
                .addHeader(Wnonce, nonce)
                .addHeader(Wts, ts)
                .addHeader(Wsign, s)
                .post(RequestBody.create(bodyCipher))
                .build();
    }

    public static String generateRandomString(String tpl, int length) {
        Random rand = new Random();  // Create a Random instance
        StringBuilder result = new StringBuilder(length);  // Use StringBuilder for efficiency

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(tpl.length());  // Generate a random index
            result.append(tpl.charAt(index));  // Append the character at that index
        }

        return result.toString();  // Convert StringBuilder to string
    }
}