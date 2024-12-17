package sdk.model;

import com.google.gson.annotations.SerializedName;

public class DepositCancelOrderReq {
    @SerializedName("source_id")
    private String sourceId;

    public DepositCancelOrderReq(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}
