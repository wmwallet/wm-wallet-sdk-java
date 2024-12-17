package sdk;

public class Main {
    public static void main(String[] args) throws Exception {
        String caPath = "resource/server/ca.crt";
        String cliCertPath = "resource/server/test_client.crt";
        String clientKey = "resource/server/test_client.key";
        String publicKeyPath = "resource/public_key.pem";
        //todo
        String url = "";
        String broker = "";
        Example example = new Example(caPath,cliCertPath,clientKey,publicKeyPath,url,broker);
        example.deposit();
    }
}
