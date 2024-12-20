package wmsdk.webhook;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class DepositCallback {
    @SerializedName("source_id")
    private String sourceId;
    @SerializedName("order_id")
    private String orderId;
    @SerializedName("fiat_amount")
    private BigDecimal fiatAmount;
    @SerializedName("exchange_rate")
    private BigDecimal exchangeRate;
    @SerializedName("symbol")
    private String symbol;
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

    public BigDecimal getFiatAmount() {
        return fiatAmount;
    }

    public void setFiatAmount(BigDecimal fiatAmount) {
        this.fiatAmount = fiatAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
