package eu.enedi.infrastructure.repositories;

import eu.enedi.infrastructure.entities.enedi.EnediDatacenter;
import eu.enedi.infrastructure.entities.enedi.EnediRack;
import eu.enedi.infrastructure.entities.enedi.EnediServer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnediServersRepository extends PagingAndSortingRepository<EnediServer, UUID>, JpaRepository<EnediServer, UUID>, CrudRepository<EnediServer, UUID> {
    EnediServer findEnediServerBySerId(UUID serid);
    Page<EnediServer> findAllByEnediDatacenter(EnediDatacenter dcid, Pageable p);
    Page<EnediServer>  findAllByEnediRack(EnediRack rackId, Pageable p);
}
