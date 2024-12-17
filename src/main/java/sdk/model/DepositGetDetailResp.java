package sdk.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class DepositGetDetailResp {
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
    @SerializedName("order_id")
    private String orderId;
    @SerializedName("url")
    private String url;
    @SerializedName("status")
    private byte status;
    @SerializedName("status_desc")
    private String statusDesc;


    public DepositGetDetailResp(String sourceId, int chainId, int coinId, String address, String tag, String hash, BigDecimal fiatAmount, String symbol, BigDecimal exchangeRate, BigDecimal amount, String orderId, String url, byte status, String statusDesc ) {
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
        this.orderId = orderId;
        this.url = url;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
