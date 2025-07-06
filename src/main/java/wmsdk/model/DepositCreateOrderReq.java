package wmsdk.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class DepositCreateOrderReq {
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
    @SerializedName("exchange_rate")
    private BigDecimal exchangeRate;
    @SerializedName("amount")
    private BigDecimal amount;
    @SerializedName("callback_url")
    private String callbackUrl;

    public DepositCreateOrderReq(String sourceId, int chainId, int coinId, BigDecimal fiatAmount, String symbol) {
        this.sourceId = sourceId;
        this.chainId = chainId;
        this.coinId = coinId;
        this.fiatAmount = fiatAmount;
        this.symbol = symbol;
    }

    public DepositCreateOrderReq(String sourceId, int chainId, int coinId, BigDecimal fiatAmount, String symbol, BigDecimal exchangeRate, BigDecimal amount) {
        this.sourceId = sourceId;
        this.chainId = chainId;
        this.coinId = coinId;
        this.fiatAmount = fiatAmount;
        this.symbol = symbol;
        this.exchangeRate = exchangeRate;
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

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
