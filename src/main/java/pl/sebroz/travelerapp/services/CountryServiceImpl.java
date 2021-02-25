package pl.sebroz.travelerapp.services;

import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.model.Country;
import pl.sebroz.travelerapp.model.filters.CountryFilters;
import pl.sebroz.travelerapp.repositories.CountryRepository;

import java.util.List;
import java.util.NoSuchElementException;

import static pl.sebroz.travelerapp.specifications.CountrySpecification.*;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String EXCEPTION_MESSAGE = "No country with the given identity number.";
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll(CountryFilters countryFilters) {
        String name = countryFilters.getName();

        if (name != null) {
            return countryRepository.findAll(hasNameLike(name));
        }
        return countryRepository.findAll();
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new NoSuchElementException(EXCEPTION_MESSAGE));
    }

    @Override
    public void delete(Long id) {
        countryRepository.delete(countryRepository.findById(id).orElseThrow(() -> new NoSuchElementException(EXCEPTION_MESSAGE)));
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }
}
