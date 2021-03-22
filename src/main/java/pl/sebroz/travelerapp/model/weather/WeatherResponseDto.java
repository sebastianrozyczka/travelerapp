package pl.sebroz.travelerapp.model.weather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherResponseDto {

    private List<WeatherInfoDto> weather;

    @JsonCreator
    public WeatherResponseDto(@JsonProperty("weather") List<WeatherInfoDto> weather) {
        this.weather = weather;
    }
}
