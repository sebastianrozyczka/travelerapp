package pl.sebroz.travelerapp.services;

import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.model.City;
import pl.sebroz.travelerapp.repositories.CityRepository;

import java.util.List;

@Service
public class CityServiceImpl implements GenericService<City> {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getOne(Long id) {
        return cityRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(cityRepository.getOne(id));
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }
}
