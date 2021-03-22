package pl.sebroz.travelerapp.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sebroz.travelerapp.exceptions.WeatherInformationNotAvailableException;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(WeatherInformationNotAvailableException.class)
    public String handleException() {
        return "nodata";
    }
}