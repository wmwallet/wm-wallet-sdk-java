package sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sdk.model.*;

public class Deposit {
    private final WmWallet wmWallet;

    private final String routeBrokerOrderCreate;
    private final String routeBrokerOrderDetail;
    private final String routeBrokerOrderCancel;

    public Deposit(WmWallet wmWallet) {
        this.wmWallet = wmWallet;
        routeBrokerOrderCreate = "/v1/api/broker/order/create";
        routeBrokerOrderDetail = "/v1/api/broker/order/detail";
        routeBrokerOrderCancel = "/v1/api/broker/order/cancel";
    }

    public Resp<DepositCreateOrderResp> Create(DepositCreateOrderReq req) throws Exception {
        Gson gson = new Gson();
        String body = gson.toJson(req, DepositCreateOrderReq.class);
        TypeToken<Resp<DepositCreateOrderResp>> typeToken = new TypeToken<Resp<DepositCreateOrderResp>>() {};
        String respBody = this.wmWallet.Post(routeBrokerOrderCreate, body);
        return gson.fromJson(respBody, typeToken.getType());
    }

    public Resp<DepositGetDetailResp> Detail(DepositGetDetailReq req) throws Exception {
        Gson gson = new Gson();
        String body = gson.toJson(req, DepositGetDetailReq.class);
        TypeToken<Resp<DepositGetDetailResp>> typeToken = new TypeToken<Resp<DepositGetDetailResp>>() {};
        String respBody = this.wmWallet.Post(routeBrokerOrderDetail, body);
        return gson.fromJson(respBody, typeToken.getType());
    }

    public Resp<DepositCancelOrderResp> Cancel(DepositCancelOrderReq req) throws Exception {
        Gson gson = new Gson();
        String body = gson.toJson(req, req.getClass());
        TypeToken<Resp<DepositCancelOrderResp>> typeToken = new TypeToken<Resp<DepositCancelOrderResp>>() {};
        String respBody = this.wmWallet.Post(routeBrokerOrderCancel, body);
        return gson.fromJson(respBody, typeToken.getType());
    }
}
