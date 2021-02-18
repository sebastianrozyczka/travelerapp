package pl.sebroz.travelerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebroz.travelerapp.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
