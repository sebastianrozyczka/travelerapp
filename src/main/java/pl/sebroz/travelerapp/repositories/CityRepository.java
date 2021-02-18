package pl.sebroz.travelerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebroz.travelerapp.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
