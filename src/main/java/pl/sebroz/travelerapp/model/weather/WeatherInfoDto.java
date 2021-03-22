package pl.sebroz.travelerapp.model.weather;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class WeatherInfoDto {
    private String main;
    private String description;
}
