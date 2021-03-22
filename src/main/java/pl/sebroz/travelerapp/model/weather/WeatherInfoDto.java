package pl.sebroz.travelerapp.model.weather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherInfoDto {

    private String main;

    private String description;

    @JsonCreator
    public WeatherInfoDto(@JsonProperty("main") String main,
                          @JsonProperty("description") String description) {
        this.main = main;
        this.description = description;
    }
}
