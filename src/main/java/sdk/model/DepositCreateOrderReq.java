package sdk.model;

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

    public DepositCreateOrderReq(String sourceId, int chainId, int coinId, BigDecimal fiatAmount, String symbol) {
        this.sourceId = sourceId;
        this.chainId = chainId;
        this.coinId = coinId;
        this.fiatAmount = fiatAmount;
        this.symbol = symbol;
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
}
