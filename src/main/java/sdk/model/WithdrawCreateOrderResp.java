package sdk.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class WithdrawCreateOrderResp {
    @SerializedName("source_id")
    private String sourceId;
    @SerializedName("order_id")
    private String orderId;

    public WithdrawCreateOrderResp(String sourceId, String orderId) {
        this.sourceId = sourceId;
        this.orderId = orderId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
