package pl.sebroz.travelerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sebroz.travelerapp.model.City;
import pl.sebroz.travelerapp.services.GenericService;

import javax.websocket.server.PathParam;

@Controller
public class CityController {
    private final GenericService<City> cityService;

    public CityController(GenericService<City> cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public String cities(Model model) {
        model.addAttribute("cities", cityService.findAll());

        return "cities";
    }

    @GetMapping("/city")
    public String countries(Model model, @PathParam("id") Long id) {
        model.addAttribute("city", cityService.getOne(id));

        return "city";
    }

    @GetMapping("/city/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        cityService.delete(id);

        return "redirect:/cities";
    }

    @GetMapping("/city/edit/{id}")
    public String editCity(Model model, @PathVariable("id") Long id) {
        City city = cityService.getOne(id);
        model.addAttribute("city", city);

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
}
