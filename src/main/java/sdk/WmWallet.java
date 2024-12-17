package sdk;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sdk.model.*;

public class WmWallet {

    private final Client client;
    private final String broker;
    private final String url;

    public WmWallet(String url, String broker, Client client) {
        this.client = client;
        this.broker = broker;
        this.url = url;
    }

    public String Post(String path, String body) throws Exception {
        OkHttpClient client = this.client.getClient();
        Request req = sdk.Request.buildRequest(this.url, path, body.getBytes(), this.broker, this.client.getPublicKey());
        Response response = client.newCall(req).execute();
        String respBody = response.body().string();
        response.close();
        Gson gson = new Gson();
        GatewayResp gw = gson.fromJson(respBody, GatewayResp.class);
        if (gw.getCode() != 0) {
            throw new Exception("request failed:" + gw.getMsg());
        }
        return gw.getData();
    }


    public static void main(String[] args) throws Exception {

    }
}
