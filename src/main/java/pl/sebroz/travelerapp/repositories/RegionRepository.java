package pl.sebroz.travelerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sebroz.travelerapp.model.Region;

public interface RegionRepository
        extends JpaRepository<Region, Long>, JpaSpecificationExecutor<Region> {
}
