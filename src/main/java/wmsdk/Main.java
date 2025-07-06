package wmsdk;

public class Main {
    public static void main(String[] args) throws Exception {
        String caPath = "resource/server/ca.crt";
        String cliCertPath = "resource/server/test_client.crt";
        String clientKey = "resource/server/test_client.key";
        String publicKeyPath = "resource/public_key.pem";
        // user platform exchange rate
        String url = "http://43.156.157.230";
        String broker = "wm-n8admin";
        Example example = new Example(caPath,cliCertPath,clientKey,publicKeyPath,url,broker);
        example.deposit();
        Thread.sleep(5000);
        // user control the exchange rate
        Example exampleAnother = new Example(caPath,cliCertPath,clientKey,publicKeyPath,url,broker);
        exampleAnother.depositControlExchangeRate();
        Thread.sleep(5000);
    }
}
