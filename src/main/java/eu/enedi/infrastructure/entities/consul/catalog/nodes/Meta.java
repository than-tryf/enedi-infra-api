package eu.enedi.infrastructure.entities.consul.catalog.nodes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("somekey")
    @Expose
    private String somekey;

    @SerializedName("consul-network-segment")
    @Expose
    private String consulNetworkSegment;

    public String getSomekey() {
        return somekey;
    }

    public void setSomekey(String somekey) {
        this.somekey = somekey;
    }

    public String getConsulNetworkSegment() {
        return consulNetworkSegment;
    }

    public void setConsulNetworkSegment(String consulNetworkSegment) {
        this.consulNetworkSegment = consulNetworkSegment;
    }
}
