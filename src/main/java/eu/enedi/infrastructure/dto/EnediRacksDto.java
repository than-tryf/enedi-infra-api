package eu.enedi.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import eu.enedi.infrastructure.entities.enedi.EnediServer;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "rackId"
)
public class EnediRacksDto implements Serializable {

    private UUID rackId;

    private String rackName;

    @JsonBackReference
    private Collection<EnediServer> enediServers;

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
