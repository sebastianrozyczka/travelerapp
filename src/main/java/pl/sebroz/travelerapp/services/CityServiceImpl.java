package pl.sebroz.travelerapp.services;

import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.model.City;
import pl.sebroz.travelerapp.model.filters.CityFilters;
import pl.sebroz.travelerapp.repositories.CityRepository;

import java.util.List;

import static pl.sebroz.travelerapp.specifications.CitySpecification.*;

@Service
public class CityServiceImpl implements CityService {

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
        return cityRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(cityRepository.findById(id).orElseThrow());
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }
}
