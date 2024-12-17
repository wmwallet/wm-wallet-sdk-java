package sdk;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;

import okhttp3.OkHttpClient;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import sdk.encrypt.Rsa;

import javax.net.ssl.*;


public class Client {
    private static volatile Client instance;
    private final OkHttpClient client;
    private RSAPublicKey publicKey;

    public Client(String clientCertPath, String clientCertPassword,
                  String clientKeyPath, String keystorePassword,
                  String caCertPath,
                  String pubKeyPath) throws Exception {
        this.client = createClient(clientCertPath, clientCertPassword, clientKeyPath, keystorePassword, caCertPath, pubKeyPath);
    }

    public OkHttpClient getClient() {
        return client;
    }

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    private OkHttpClient createClient(
            byte[] clientCertBytes, String clientCertPassword,
            byte[] clientKeyBytes, String keystorePassword,
            byte[] caCertBytes,
            byte[] pubKeyBytes) throws Exception {

        Security.addProvider(new BouncyCastleProvider());

        this.publicKey = Rsa.toRsaPublicKey(null, pubKeyBytes);

        CertificateFactory certFactory = CertificateFactory
                .getInstance("X.509", "BC");

        X509Certificate certificate = (X509Certificate) certFactory
                .generateCertificate(new ByteArrayInputStream(clientCertBytes));

        PEMParser pemParser = new PEMParser(new InputStreamReader(new ByteArrayInputStream(clientKeyBytes)));
        PrivateKeyInfo pk = (PrivateKeyInfo) pemParser.readObject();
        pemParser.close();
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(pk.getEncoded()));

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, null);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyStore.setKeyEntry("client-key", privateKey, "".toCharArray(), new java.security.cert.Certificate[]{certificate});
        keyManagerFactory.init(keyStore, "".toCharArray());

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);
        X509Certificate ca = (X509Certificate) certFactory
                .generateCertificate(new ByteArrayInputStream(caCertBytes));
        trustStore.setCertificateEntry("ca-cert", ca);


        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);


        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        return new OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustManagerFactory.getTrustManagers()[0])
                .build();
    }

    private OkHttpClient createClient(
            String clientCertPath, String clientCertPassword,
            String clientKeyPath, String keystorePassword,
            String caCertPath,
            String pubKeyPath) throws Exception {

        Security.addProvider(new BouncyCastleProvider());

        this.publicKey = Rsa.toRsaPublicKey(pubKeyPath, null);

        CertificateFactory certFactory = CertificateFactory
                .getInstance("X.509", "BC");

        X509Certificate certificate = (X509Certificate) certFactory
                .generateCertificate(new FileInputStream(clientCertPath));


        PEMParser pemParser = new PEMParser(new FileReader(clientKeyPath));
        PrivateKeyInfo pk = (PrivateKeyInfo) pemParser.readObject();
        pemParser.close();
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(pk.getEncoded()));

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, null);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyStore.setKeyEntry("client-key", privateKey, "".toCharArray(), new java.security.cert.Certificate[]{certificate});
        keyManagerFactory.init(keyStore, "".toCharArray());

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);
        X509Certificate ca = (X509Certificate) certFactory
                .generateCertificate(new FileInputStream(caCertPath));
        trustStore.setCertificateEntry("ca-cert", ca);


        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);


        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        return new OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustManagerFactory.getTrustManagers()[0])
                .build();
    }

    public static Client getInstance(String clientCertPath, String clientCertPassword,
                                     String clientKeyPath, String keystorePassword,
                                     String caCertPath,
                                     String pubKeyPath) throws Exception {
        if (instance == null) {
            synchronized (Client.class) {
                if (instance == null) {
                    instance = new Client(clientCertPath, clientCertPassword, clientKeyPath, keystorePassword, caCertPath, pubKeyPath);
                }
            }
        }
        return instance;
    }

    public static Client getInstance(byte[] clientCertPath, String clientCertPassword,
                                     byte[] clientKeyPath, String keystorePassword,
                                     byte[] caCertPath,
                                     byte[] pubKeyPath) throws Exception {
        if (instance == null) {
            synchronized (Client.class) {
                if (instance == null) {
                    instance = new Client(clientCertPath, clientCertPassword, clientKeyPath, keystorePassword, caCertPath, pubKeyPath);
                }
            }
        }
        return instance;
    }

    public Client(byte[] clientCertPath, String clientCertPassword,
                  byte[] clientKeyPath, String keystorePassword,
                  byte[] caCertPath,
                  byte[] pubKeyPath) throws Exception {
        this.client = createClient(clientCertPath, clientCertPassword, clientKeyPath, keystorePassword, caCertPath, pubKeyPath);
    }
}
