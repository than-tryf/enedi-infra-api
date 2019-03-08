package eu.enedi.infrastructure.entities.enedi;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;


@Entity
@Table(name = "enedi_rack")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "rackId"
)
public class EnediRack implements Serializable {

    @Id
    @GeneratedValue
    private UUID rackId;

    private String rackName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn
    private Collection<EnediServer> enediServers;

    public EnediRack() {
    }

    public EnediRack(String rackName, Collection<EnediServer> enediServers) {
        this.rackName = rackName;
        this.enediServers = enediServers;
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

    public Collection<EnediServer> getEnediServers() {
        return enediServers;
    }

    public void setEnediServers(Collection<EnediServer> enediServers) {
        this.enediServers = enediServers;
    }
}
