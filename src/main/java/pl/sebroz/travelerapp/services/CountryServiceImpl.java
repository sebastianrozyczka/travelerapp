package pl.sebroz.travelerapp.services;

import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.model.Country;
import pl.sebroz.travelerapp.repositories.CountryRepository;

import java.util.List;

@Service
public class CountryServiceImpl implements GenericService<Country> {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
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
