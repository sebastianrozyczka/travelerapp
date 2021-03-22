package pl.sebroz.travelerapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sebroz.travelerapp.exceptions.WeatherInformationNotAvailableException;
import pl.sebroz.travelerapp.model.City;
import pl.sebroz.travelerapp.model.filters.CityFilters;
import pl.sebroz.travelerapp.model.weather.CityWeather;
import pl.sebroz.travelerapp.model.weather.WeatherInfoDto;
import pl.sebroz.travelerapp.model.weather.WeatherResponseDto;
import pl.sebroz.travelerapp.repositories.CityRepository;

import java.util.List;
import java.util.NoSuchElementException;

import static pl.sebroz.travelerapp.specifications.CitySpecification.*;

@Service
public class CityServiceImpl implements CityService {

    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={appId}";
    private static final String APP_ID = "e4da98874a028b59a81f94b46238ee16";
    private static final String EXCEPTION_MESSAGE = "No city with the given identity number";
    private final CityRepository cityRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
        restTemplate = new RestTemplate();
    }

    @Override
    public List<City> findAll(CityFilters cityFilters) {
        String name = cityFilters.getName();

        if (name != null) {
            return cityRepository.findAll(hasNameLike(name));
        }
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(EXCEPTION_MESSAGE));
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(cityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(EXCEPTION_MESSAGE)));
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public CityWeather getCityWeather(String city) {
        try {
            WeatherResponseDto response = restTemplate.getForObject(URL, WeatherResponseDto.class, city, APP_ID);
            String main = response.getWeather().stream()
                    .map(WeatherInfoDto::getMain).findFirst().orElseThrow(WeatherInformationNotAvailableException::new);
            String description = response.getWeather().stream()
                    .map(WeatherInfoDto::getDescription).findFirst().orElseThrow(WeatherInformationNotAvailableException::new);

            return new CityWeather(main, description);
        } catch (Exception e) {
            throw new WeatherInformationNotAvailableException();
        }
    }
}
