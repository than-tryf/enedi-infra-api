package eu.enedi.infrastructure.dto;

import java.io.Serializable;
import java.util.UUID;

public class EnediServersDto implements Serializable {

    private UUID serId;

    private String serverName;

    private String ipAddress;

    private int numOfCores;

    private int ramInMB;

    private String operatingSystem;

    private UUID dcId;

    private String dcName;

    private UUID rackId;

    private String rackName;

    private String serverHealth;

    public UUID getSerId() {
        return serId;
    }

    public void setSerId(UUID serId) {
        this.serId = serId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getNumOfCores() {
        return numOfCores;
    }

    public void setNumOfCores(int numOfCores) {
        this.numOfCores = numOfCores;
    }

    public int getRamInMB() {
        return ramInMB;
    }

    public void setRamInMB(int ramInMB) {
        this.ramInMB = ramInMB;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public UUID getDcId() {
        return dcId;
    }

    public void setDcId(UUID dcId) {
        this.dcId = dcId;
    }

    public String getDcName() {
        return dcName;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public String getRackName() {
        return rackName;
    }

    public void setRackName(String rackName) {
        this.rackName = rackName;
    }

    public String getServerHealth() {
        return serverHealth;
    }

    public void setServerHealth(String serverHealth) {
        this.serverHealth = serverHealth;
    }
}
