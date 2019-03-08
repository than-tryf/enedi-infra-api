package eu.enedi.infrastructure.entities.consul.catalog.nodes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CNodes {

    @SerializedName("ID")
    @Expose
    private String Id;
    @SerializedName("Node")
    @Expose
    private String node;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Datacenter")
    @Expose
    private String datacenter;
    @SerializedName("TaggedAddresses")
    @Expose
    private TaggedAddresses taggedAddresses;
    @SerializedName("Meta")
    @Expose
    private Map<String, String> meta;
    @SerializedName("CreateIndex")
    @Expose
    private Integer createIndex;
    @SerializedName("ModifyIndex")
    @Expose
    private Integer modifyIndex;


    public String getiD() {
        return Id;
    }

    public void setiD(String iD) {
        this.Id = iD;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDatacenter() {
        return datacenter;
    }

    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    public TaggedAddresses getTaggedAddresses() {
        return taggedAddresses;
    }

    public void setTaggedAddresses(TaggedAddresses taggedAddresses) {
        this.taggedAddresses = taggedAddresses;
    }

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    public Integer getCreateIndex() {
        return createIndex;
    }

    public void setCreateIndex(Integer createIndex) {
        this.createIndex = createIndex;
    }

    public Integer getModifyIndex() {
        return modifyIndex;
    }

    public void setModifyIndex(Integer modifyIndex) {
        this.modifyIndex = modifyIndex;
    }
}
