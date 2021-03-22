package pl.sebroz.travelerapp.services;

import pl.sebroz.travelerapp.model.City;
import pl.sebroz.travelerapp.model.filters.CityFilters;
import pl.sebroz.travelerapp.model.weather.CityWeather;
import pl.sebroz.travelerapp.model.weather.WeatherResponseDto;

import java.util.List;

public interface CityService {
    List<City> findAll(CityFilters cityFilters);

    City findById(Long id);

    void delete(Long id);

    void save(City city);

    CityWeather getCityWeather(String city);
}
