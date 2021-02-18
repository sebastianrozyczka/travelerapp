package pl.sebroz.travelerapp.services;

import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.model.Region;
import pl.sebroz.travelerapp.repositories.RegionRepository;

import java.util.List;

@Service
public class RegionServiceImpl implements GenericService<Region> {

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region getOne(Long id) {
        return regionRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        regionRepository.delete(regionRepository.getOne(id));
    }

    @Override
    public void save(Region region) {
        regionRepository.save(region);
    }
}
