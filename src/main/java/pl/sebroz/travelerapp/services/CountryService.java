package pl.sebroz.travelerapp.services;

import pl.sebroz.travelerapp.model.Country;
import pl.sebroz.travelerapp.model.filters.CountryFilters;

import java.util.List;

public interface CountryService {
    List<Country> findAll(CountryFilters countryFilters);

    List<Country> findAll();

    Country getOne(Long id);

    void delete(Long id);

    void save(Country country);
}
