package eu.enedi.infrastructure.dto;

import java.io.Serializable;
import java.util.UUID;

public class EnediDatacentersDto implements Serializable {
    private UUID dcid;

    private String name;

    private String country;

    private String city;

    private double latitude;

    private double longtitude;

    private String dcPrefix;


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
}
