package pl.sebroz.travelerapp.services;

import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.model.Country;
import pl.sebroz.travelerapp.model.filters.CountryFilters;
import pl.sebroz.travelerapp.repositories.CountryRepository;

import java.util.List;

import static pl.sebroz.travelerapp.specifications.CountrySpecification.*;

@Service
public class CountryServiceImpl implements CountryService {

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
    public Country getOne(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        countryRepository.delete(countryRepository.getOne(id));
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }
}
