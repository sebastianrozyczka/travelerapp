package pl.sebroz.travelerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sebroz.travelerapp.model.Country;
import pl.sebroz.travelerapp.model.filters.CountryFilters;
import pl.sebroz.travelerapp.services.CountryService;

import javax.websocket.server.PathParam;

@Controller
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String countries(Model model, CountryFilters countryFilters) {
        model.addAttribute("countries", countryService.findAll(countryFilters));
        model.addAttribute("filters", countryFilters);

        return "countries";
    }

    @GetMapping("/country")
    public String country(Model model, @PathParam("id") Long id) {
        model.addAttribute("country", countryService.findById(id));

        return "country";
    }

    @GetMapping("/country/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        countryService.delete(id);

        return "redirect:/countries";
    }

    @GetMapping("/country/edit/{id}")
    public String editCountry(Model model, @PathVariable("id") Long id) {
        Country country = countryService.findById(id);
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
