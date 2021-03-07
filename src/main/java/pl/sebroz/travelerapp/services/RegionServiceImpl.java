package pl.sebroz.travelerapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.model.Region;
import pl.sebroz.travelerapp.model.filters.RegionFilters;
import pl.sebroz.travelerapp.repositories.RegionRepository;

import java.util.List;
import java.util.NoSuchElementException;

import static pl.sebroz.travelerapp.specifications.RegionSpecification.*;

@Service
public class RegionServiceImpl implements RegionService {

    public static final String EXCEPTION_MESSAGE = "No region with the given identity number.";
    private final RegionRepository regionRepository;

    @Autowired
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
        return regionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(EXCEPTION_MESSAGE));
    }

    @Override
    public void delete(Long id) {
        regionRepository.delete(regionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(EXCEPTION_MESSAGE)));
    }

    @Override
    public void save(Region region) {
        regionRepository.save(region);
    }
}
