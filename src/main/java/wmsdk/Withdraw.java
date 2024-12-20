package wmsdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import wmsdk.model.*;

public class Withdraw {
    private final WmWallet wmWallet;

    private final String routeBrokerWithdrawOrderCreate;
    private final String routeBrokerWithdrawOrderDetail;

    public Withdraw(WmWallet wmWallet) {
        this.wmWallet = wmWallet;
        routeBrokerWithdrawOrderCreate = "/v1/api/broker/order/withdraw";
        routeBrokerWithdrawOrderDetail = "/v1/api/broker/order/withdraw-detail";
    }

    public Resp<WithdrawCreateOrderResp> Create(WithdrawCreateOrderReq req) throws Exception {
        Gson gson = new Gson();
        String body = gson.toJson(req, WithdrawCreateOrderReq.class);
        TypeToken<Resp<WithdrawCreateOrderResp>> typeToken = new TypeToken<Resp<WithdrawCreateOrderResp>>() {};
        String respBody = this.wmWallet.Post(routeBrokerWithdrawOrderCreate, body);
        return gson.fromJson(respBody, typeToken.getType());
    }

    public Resp<WithdrawGetDetailResp> Detail(WithdrawGetDetailReq req) throws Exception {
        Gson gson = new Gson();
        String body = gson.toJson(req, WithdrawGetDetailReq.class);
        TypeToken<Resp<WithdrawGetDetailResp>> typeToken = new TypeToken<Resp<WithdrawGetDetailResp>>() {};
        String respBody = this.wmWallet.Post(routeBrokerWithdrawOrderDetail, body);
        return gson.fromJson(respBody, typeToken.getType());
    }
}
