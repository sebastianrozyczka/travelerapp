package pl.sebroz.travelerapp.services;

import pl.sebroz.travelerapp.model.City;
import pl.sebroz.travelerapp.model.filters.CityFilters;

import java.util.List;

public interface CityService {
    List<City> findAll(CityFilters cityFilters);

    City findById(Long id);

    void delete(Long id);

    void save(City city);
}
