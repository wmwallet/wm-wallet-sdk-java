package wmsdk.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class DepositCreateOrderResp {
    @SerializedName("source_id")
    private String sourceId;
    @SerializedName("chain_id")
    private int chainId;
    @SerializedName("coin_id")
    private int coinId;
    @SerializedName("fiat_amount")
    private BigDecimal fiatAmount;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("order_id")
    private String orderId;
    @SerializedName("exchange_rate")
    private BigDecimal exchangeRate;
    @SerializedName("amount")
    private BigDecimal amount;
    @SerializedName("url")
    private String url;


    public DepositCreateOrderResp(String sourceId, int chainId, int coinId, BigDecimal fiatAmount, String symbol, String orderId, BigDecimal exchangeRate, BigDecimal amount, String url) {
        this.sourceId = sourceId;
        this.chainId = chainId;
        this.coinId = coinId;
        this.fiatAmount = fiatAmount;
        this.symbol = symbol;
        this.orderId = orderId;
        this.exchangeRate = exchangeRate;
        this.amount = amount;
        this.url = url;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
