package eu.enedi.infrastructure.entities.consul.kv;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConsulKVValues {

    @SerializedName("createIndex")
    @Expose
    private Integer createIndex;
    @SerializedName("modifyIndex")
    @Expose
    private Integer modifyIndex;
    @SerializedName("lockIndex")
    @Expose
    private Integer lockIndex;
    @SerializedName("flags")
    @Expose
    private Integer flags;
    @SerializedName("session")
    @Expose
    private Object session;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("decodedValue")
    @Expose
    private String decodedValue;

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

    public Integer getLockIndex() {
        return lockIndex;
    }

    public void setLockIndex(Integer lockIndex) {
        this.lockIndex = lockIndex;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    public Object getSession() {
        return session;
    }

    public void setSession(Object session) {
        this.session = session;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDecodedValue() {
        return decodedValue;
    }

    public void setDecodedValue(String decodedValue) {
        this.decodedValue = decodedValue;
    }
}
