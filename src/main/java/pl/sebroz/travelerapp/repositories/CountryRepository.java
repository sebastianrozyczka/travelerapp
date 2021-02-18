package pl.sebroz.travelerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebroz.travelerapp.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
