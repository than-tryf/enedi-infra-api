package eu.enedi.infrastructure.entities.enedi;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "enedi_server")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "serId"
)
public class EnediServer implements Serializable {

    @Id
    @GeneratedValue
    private UUID serId;

    private String serverName;

    private String ipAddress;

    private int numOfCores;

    private int ramInMB;

    private String operatingSystem;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    private EnediDatacenter enediDatacenter;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    private EnediRack enediRack;

    public EnediServer() {
    }

    public EnediServer(UUID serId, String serverName, String ipAddress) {
        this.serId = serId;
        this.serverName = serverName;
        this.ipAddress = ipAddress;
    }

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

    public EnediDatacenter getEnediDatacenter() {
        return enediDatacenter;
    }

    public void setEnediDatacenter(EnediDatacenter enediDatacenter) {
        this.enediDatacenter = enediDatacenter;
    }

    public EnediRack getEnediRack() {
        return enediRack;
    }

    public void setEnediRack(EnediRack enediRack) {
        this.enediRack = enediRack;
    }
}
