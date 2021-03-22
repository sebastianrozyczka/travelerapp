package pl.sebroz.travelerapp.model.weather;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CityWeather {
    private String main;
    private String description;
}
