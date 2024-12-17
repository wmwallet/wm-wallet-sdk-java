package sdk.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class WithdrawCreateOrderReq {
    @SerializedName("source_id")
    private String sourceId;
    @SerializedName("chain_id")
    private int chainId;
    @SerializedName("coin_id")
    private int coinId;
    @SerializedName("address")
    private String address;
    @SerializedName("tag")
    private String tag;
    @SerializedName("amount")
    private BigDecimal amount;

    public WithdrawCreateOrderReq(String sourceId, int chainId, int coinId, String address, String tag, BigDecimal amount) {
        this.sourceId = sourceId;
        this.chainId = chainId;
        this.coinId = coinId;
        this.address = address;
        this.tag = tag;
        this.amount = amount;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}