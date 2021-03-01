package pl.sebroz.travelerapp.services;

import pl.sebroz.travelerapp.model.Region;
import pl.sebroz.travelerapp.model.filters.RegionFilters;

import java.util.List;

public interface RegionService {
    List<Region> findAll(RegionFilters regionFilters);

    List<Region> findAll();

    Region findById(Long id);

    void delete(Long id);

    void save(Region region);
}
