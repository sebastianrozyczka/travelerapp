package pl.sebroz.travelerapp.services;

import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.model.City;
import pl.sebroz.travelerapp.model.filters.CityFilters;
import pl.sebroz.travelerapp.repositories.CityRepository;

import java.util.List;
import java.util.NoSuchElementException;

import static pl.sebroz.travelerapp.specifications.CitySpecification.*;

@Service
public class CityServiceImpl implements CityService {

    private static final String EXCEPTION_MESSAGE = "No city with the given identity number";
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findAll(CityFilters cityFilters) {
        String name = cityFilters.getName();

        if(name != null) {
            return cityRepository.findAll(hasNameLike(name));
        }
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new NoSuchElementException(EXCEPTION_MESSAGE));
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(cityRepository.findById(id).orElseThrow(() -> new NoSuchElementException(EXCEPTION_MESSAGE)));
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }
}
