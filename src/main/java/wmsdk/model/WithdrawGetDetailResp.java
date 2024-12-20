package wmsdk.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class WithdrawGetDetailResp {
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
    @SerializedName("hash")
    private String hash;
    @SerializedName("fiat_amount")
    private BigDecimal fiatAmount;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("exchange_rate")
    private BigDecimal exchangeRate;
    @SerializedName("amount")
    private BigDecimal amount;
    @SerializedName("service_fee")
    private BigDecimal serviceFee;
    @SerializedName("order_id")
    private String orderId;
    @SerializedName("status")
    private byte status;
    @SerializedName("status_desc")
    private String statusDesc;


    public WithdrawGetDetailResp(String sourceId, int chainId, int coinId, String address, String tag, String hash, BigDecimal fiatAmount, String symbol, BigDecimal exchangeRate, BigDecimal amount, BigDecimal serviceFee, String orderId, byte status, String statusDesc ) {
        this.sourceId = sourceId;
        this.chainId = chainId;
        this.coinId = coinId;
        this.address = address;
        this.tag = tag;
        this.hash = hash;
        this.fiatAmount = fiatAmount;
        this.symbol = symbol;
        this.exchangeRate = exchangeRate;
        this.amount = amount;
        this.serviceFee = serviceFee;
        this.orderId = orderId;
        this.status = status;
        this.statusDesc = statusDesc;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public BigDecimal getFiatAmount() {
        return fiatAmount;
    }

    public void setFiatAmount(BigDecimal fiatAmount) {
        this.fiatAmount = fiatAmount;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
