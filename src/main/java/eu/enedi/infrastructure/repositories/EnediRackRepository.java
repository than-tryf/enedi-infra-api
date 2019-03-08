package eu.enedi.infrastructure.repositories;

import eu.enedi.infrastructure.entities.enedi.EnediRack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnediRackRepository extends PagingAndSortingRepository<EnediRack, UUID>, JpaRepository<EnediRack, UUID>, CrudRepository<EnediRack, UUID> {
    EnediRack getEnediRackByRackId(UUID rackid);
}
