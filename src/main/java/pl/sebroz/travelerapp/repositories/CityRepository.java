package pl.sebroz.travelerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sebroz.travelerapp.model.City;

public interface CityRepository
        extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {
}
