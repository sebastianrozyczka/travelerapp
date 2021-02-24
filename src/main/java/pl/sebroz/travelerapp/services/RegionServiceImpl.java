package pl.sebroz.travelerapp.services;

import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.model.Region;
import pl.sebroz.travelerapp.model.filters.RegionFilters;
import pl.sebroz.travelerapp.repositories.RegionRepository;

import java.util.List;

import static pl.sebroz.travelerapp.specifications.RegionSpecification.*;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> findAll(RegionFilters regionFilters) {
        String name = regionFilters.getName();

        if(name != null) {
            return regionRepository.findAll(hasNameLike(name));
        }
        return regionRepository.findAll();
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region findById(Long id) {
        return regionRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        regionRepository.delete(regionRepository.findById(id).orElseThrow());
    }

    @Override
    public void save(Region region) {
        regionRepository.save(region);
    }
}
