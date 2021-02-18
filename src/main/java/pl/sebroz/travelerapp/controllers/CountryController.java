package pl.sebroz.travelerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sebroz.travelerapp.model.City;
import pl.sebroz.travelerapp.model.Country;
import pl.sebroz.travelerapp.services.CountryServiceImpl;

import javax.websocket.server.PathParam;

@Controller
public class CountryController {

    private final CountryServiceImpl countryService;

    public CountryController(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String countries(Model model) {
        model.addAttribute("countries", countryService.findAll());

        return "countries";
    }

    @GetMapping("/country")
    public String country(Model model, @PathParam("id") Long id) {
        model.addAttribute("country", countryService.getOne(id));

        return "country";
    }

    @GetMapping("/country/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        countryService.delete(id);

        return "redirect:/countries";
    }

    @GetMapping("/country/edit/{id}")
    public String editCountry(Model model, @PathVariable("id") Long id) {
        Country country = countryService.getOne(id);
        model.addAttribute("country", country);

        return "edit-country";
    }

    @GetMapping("/country/new")
    public String createCountry(Model model) {
        Country country = new Country();
        model.addAttribute("country", country);

        return "new-country";
    }

    @PostMapping("/country/save")
    public String saveCountry(Country country) {
        countryService.save(country);

        return "redirect:/countries";
    }
}
