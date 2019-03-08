package eu.enedi.infrastructure.repositories;

import eu.enedi.infrastructure.entities.enedi.EnediDatacenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnediDatacenterRepository extends PagingAndSortingRepository<EnediDatacenter, UUID>, JpaRepository<EnediDatacenter, UUID>, CrudRepository<EnediDatacenter, UUID> {
    Page<EnediDatacenter> findAllByNameContainsIgnoreCase(String name, Pageable p);
    Page<EnediDatacenter> findAllByCityContainsIgnoreCaseOrCountryContainsIgnoreCase(String city, String country, Pageable p);
    EnediDatacenter findEnediDatacenterByDcid(UUID dcid);
}
