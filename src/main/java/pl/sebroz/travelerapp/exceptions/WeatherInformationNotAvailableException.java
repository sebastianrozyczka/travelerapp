package pl.sebroz.travelerapp.exceptions;

public class WeatherInformationNotAvailableException extends RuntimeException {
    public WeatherInformationNotAvailableException() {
        super("Weather for this city is not available.");
    }
}
