package pl.sebroz.travelerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sebroz.travelerapp.model.City;
import pl.sebroz.travelerapp.model.filters.CityFilters;
import pl.sebroz.travelerapp.services.CityService;
import pl.sebroz.travelerapp.services.RegionService;

import javax.websocket.server.PathParam;

@Controller
public class CityController {

    private final CityService cityService;

    private final RegionService regionService;

    @Autowired
    public CityController(CityService cityService, RegionService regionService) {
        this.cityService = cityService;
        this.regionService = regionService;
    }

    @GetMapping("/cities")
    public String cities(Model model, CityFilters cityFilters) {
        model.addAttribute("cities", cityService.findAll(cityFilters));
        model.addAttribute("filters", cityFilters);

        return "cities";
    }

    @GetMapping("/city")
    public String city(Model model, @PathParam("id") Long id) {
        model.addAttribute("city", cityService.findById(id));

        return "city";
    }

    @GetMapping("/city/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        cityService.delete(id);

        return "redirect:/cities";
    }

    @GetMapping("/city/edit/{id}")
    public String editCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findById(id));
        model.addAttribute("regions", regionService.findAll());

        return "edit-city";
    }

    @GetMapping("/city/new")
    public String createCity(Model model) {
        City city = new City();
        model.addAttribute("city", city);

        return "new-city";
    }

    @PostMapping("/city/save")
    public String saveCity(City city) {
        cityService.save(city);

        return "redirect:/cities";
    }

    @GetMapping("/city/{id}/add/region")
    public String addRegionToCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findById(id));
        model.addAttribute("regions", regionService.findAll());

        return "add-region-to-city";
    }
}
