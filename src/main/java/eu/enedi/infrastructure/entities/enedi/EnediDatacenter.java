package eu.enedi.infrastructure.entities.enedi;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;


/**
 * Data is coming from the KV-Store of the master ENEDI Consul
 */



@Entity
@Table(name = "enedi_datacenter")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "dcid"
)
public class EnediDatacenter implements Serializable {

    @Id
    @GeneratedValue
    private UUID dcid;

    private String name;

    private String country;

    private String city;

    private double latitude;

    private double longtitude;

    private String dcPrefix;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn
    private Collection<EnediServer> enediServers = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn
    private Collection<EnediDataLogger> enediDataLoggers = new ArrayList<>();

    public String getDcPrefix() {
        return dcPrefix;
    }

    public void setDcPrefix(String dcPrefix) {
        this.dcPrefix = dcPrefix;
    }

    public EnediDatacenter() {
    }

    public EnediDatacenter(String name, String country, String city, double latitude, double longtitude) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

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

    public Collection<EnediServer> getEnediServers() {
        return enediServers;
    }

    public void setEnediServers(Collection<EnediServer> enediServers) {
        this.enediServers = enediServers;
    }

    public Collection<EnediDataLogger> getEnediDataLoggers() {
        return enediDataLoggers;
    }

    public void setEnediDataLoggers(Collection<EnediDataLogger> enediDataLoggers) {
        this.enediDataLoggers = enediDataLoggers;
    }
}
