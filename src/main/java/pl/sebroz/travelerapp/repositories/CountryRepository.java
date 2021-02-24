package pl.sebroz.travelerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sebroz.travelerapp.model.Country;

public interface CountryRepository
        extends JpaRepository<Country, Long>, JpaSpecificationExecutor<Country> {
}
