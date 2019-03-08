package eu.enedi.infrastructure.dto;

import java.io.Serializable;
import java.util.UUID;

public class EnediDatacenterDto implements Serializable {
    private UUID dcid;

    private String name;

    private String country;

    private String city;

    private double latitude;

    private double longtitude;

    private String dcPrefix;

    private String health;

    private double totalDcConsumption;

    private double totalDcCPU;

    private double totalDcMemory;

    private int totalNumOfServers;

    private int totalNumberOfDataloggers;

    public UUID getDcid() {
        return dcid;
    }

    public void setDcid(UUID dcid) {
        this.dcid = dcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getDcPrefix() {
        return dcPrefix;
    }

    public void setDcPrefix(String dcPrefix) {
        this.dcPrefix = dcPrefix;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public double getTotalDcConsumption() {
        return totalDcConsumption;
    }

    public void setTotalDcConsumption(double totalDcConsumption) {
        this.totalDcConsumption = totalDcConsumption;
    }

    public double getTotalDcCPU() {
        return totalDcCPU;
    }

    public void setTotalDcCPU(double totalDcCPU) {
        this.totalDcCPU = totalDcCPU;
    }

    public double getTotalDcMemory() {
        return totalDcMemory;
    }

    public void setTotalDcMemory(double totalDcMemory) {
        this.totalDcMemory = totalDcMemory;
    }

    public int getTotalNumOfServers() {
        return totalNumOfServers;
    }

    public void setTotalNumOfServers(int totalNumOfServers) {
        this.totalNumOfServers = totalNumOfServers;
    }

    public int getTotalNumberOfDataloggers() {
        return totalNumberOfDataloggers;
    }

    public void setTotalNumberOfDataloggers(int totalNumberOfDataloggers) {
        this.totalNumberOfDataloggers = totalNumberOfDataloggers;
    }
}
