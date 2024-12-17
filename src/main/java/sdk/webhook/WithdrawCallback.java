package sdk.webhook;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class WithdrawCallback {
    @SerializedName("source_id")
    private String sourceId;
    @SerializedName("order_id")
    private String orderId;
    @SerializedName("chain_id")
    private int chainId;
    @SerializedName("coin_id")
    private int coinId;
    @SerializedName("tag")
    private String tag;
    @SerializedName("amount")
    private BigDecimal amount;
    @SerializedName("status")
    private String status;

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

    public int getChainId() {
        return chainId;
    }

    public void setChainId(int chainId) {
        this.chainId = chainId;
    }

    public int getCoinId() {
        return coinId;
    }

    public void setCoinId(int coinId) {
        this.coinId = coinId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
