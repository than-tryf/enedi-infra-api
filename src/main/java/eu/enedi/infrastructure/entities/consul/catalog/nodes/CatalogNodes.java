package eu.enedi.infrastructure.entities.consul.catalog.nodes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatalogNodes {

    @SerializedName("value")
    @Expose
    private List<Value> value = null;

    @SerializedName("consulIndex")
    @Expose
    private Integer consulIndex;

    @SerializedName("consulKnownLeader")
    @Expose
    private Boolean consulKnownLeader;

    @SerializedName("consulLastContact")
    @Expose
    private Integer consulLastContact;


    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    public Integer getConsulIndex() {
        return consulIndex;
    }

    public void setConsulIndex(Integer consulIndex) {
        this.consulIndex = consulIndex;
    }

    public Boolean getConsulKnownLeader() {
        return consulKnownLeader;
    }

    public void setConsulKnownLeader(Boolean consulKnownLeader) {
        this.consulKnownLeader = consulKnownLeader;
    }

    public Integer getConsulLastContact() {
        return consulLastContact;
    }

    public void setConsulLastContact(Integer consulLastContact) {
        this.consulLastContact = consulLastContact;
    }
}
