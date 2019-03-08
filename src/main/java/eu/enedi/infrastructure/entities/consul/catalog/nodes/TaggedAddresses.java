package eu.enedi.infrastructure.entities.consul.catalog.nodes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaggedAddresses {

    @SerializedName("lan")
    @Expose
    private String lan;

    @SerializedName("wan")
    @Expose
    private String wan;


    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getWan() {
        return wan;
    }

    public void setWan(String wan) {
        this.wan = wan;
    }
}
