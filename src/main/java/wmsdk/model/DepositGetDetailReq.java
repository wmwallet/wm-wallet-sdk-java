package wmsdk.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class DepositGetDetailReq {
    @SerializedName("source_id")
    private String sourceId;

    public DepositGetDetailReq(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}
