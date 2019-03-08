package eu.enedi.infrastructure.entities.enedi;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "enedi_pv")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pvid"
)
public class EnediPV implements Serializable {

    @Id
    @GeneratedValue
    private UUID pvid;

    private String name;

    private double pvCapacity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Collection<EnediSensor> enediSensors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private EnediDataLogger enediDataLogger;

    public EnediPV() {
    }

    public EnediPV(UUID pvid, String name, double pvCapacity, List<EnediSensor> enediSensors) {
        this.pvid = pvid;
        this.name = name;
        this.pvCapacity = pvCapacity;
        this.enediSensors = enediSensors;
    }

    public UUID getPvid() {
        return pvid;
    }

    public void setPvid(UUID pvid) {
        this.pvid = pvid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPvCapacity() {
        return pvCapacity;
    }

    public void setPvCapacity(double pvCapacity) {
        this.pvCapacity = pvCapacity;
    }

    public Collection<EnediSensor> getEnediSensors() {
        return enediSensors;
    }

    public void setEnediSensors(Collection<EnediSensor> enediSensors) {
        this.enediSensors = enediSensors;
    }

    public EnediDataLogger getEnediDataLogger() {
        return enediDataLogger;
    }

    public void setEnediDataLogger(EnediDataLogger enediDataLogger) {
        this.enediDataLogger = enediDataLogger;
    }
}
