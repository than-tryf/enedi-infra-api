package eu.enedi.infrastructure.entities.enedi;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "enedi_datalogger")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "dlId"
)
public class EnediDataLogger {

    @Id
    @GeneratedValue
    private UUID dlId;

    private String dlName;

    private String dlIp;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Collection<EnediPV> enediPVS = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Collection<EnediSensor> enediSensors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private EnediDatacenter enediDatacenter;

    public EnediDataLogger() {
    }

    public EnediDataLogger(String dlName, String dlIp, Collection<EnediPV> enediPVS, Collection<EnediSensor> enediSensors) {
        this.dlName = dlName;
        this.dlIp = dlIp;
        this.enediPVS = enediPVS;
        this.enediSensors = enediSensors;
    }

    public UUID getDlId() {
        return dlId;
    }

    public void setDlId(UUID dlId) {
        this.dlId = dlId;
    }

    public String getDlName() {
        return dlName;
    }

    public void setDlName(String dlName) {
        this.dlName = dlName;
    }

    public String getDlIp() {
        return dlIp;
    }

    public void setDlIp(String dlIp) {
        this.dlIp = dlIp;
    }

    public Collection<EnediPV> getEnediPVS() {
        return enediPVS;
    }

    public void setEnediPVS(Collection<EnediPV> enediPVS) {
        this.enediPVS = enediPVS;
    }

    public Collection<EnediSensor> getEnediSensors() {
        return enediSensors;
    }

    public void setEnediSensors(Collection<EnediSensor> enediSensors) {
        this.enediSensors = enediSensors;
    }
}
