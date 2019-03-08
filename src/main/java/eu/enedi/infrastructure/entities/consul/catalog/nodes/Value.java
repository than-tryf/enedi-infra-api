package eu.enedi.infrastructure.entities.consul.catalog.nodes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Value {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("node")
    @Expose
    private String node;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("datacenter")
    @Expose
    private String datacenter;

    @SerializedName("taggedAddresses")
    @Expose
    private TaggedAddresses taggedAddresses;

    @SerializedName("meta")
    @Expose
    private List<String> meta;

    @SerializedName("createIndex")
    @Expose
    private Integer createIndex;

    @SerializedName("modifyIndex")
    @Expose
    private Integer modifyIndex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getMeta() {
        return meta;
    }

    public void setMeta(List<String> meta) {
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

