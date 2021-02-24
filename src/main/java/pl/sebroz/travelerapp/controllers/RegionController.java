package pl.sebroz.travelerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sebroz.travelerapp.model.Region;
import pl.sebroz.travelerapp.model.filters.RegionFilters;
import pl.sebroz.travelerapp.services.CountryService;
import pl.sebroz.travelerapp.services.RegionService;

import javax.websocket.server.PathParam;

@Controller
public class RegionController {

    private final RegionService regionService;

    private final CountryService countryService;

    public RegionController(RegionService regionService, CountryService countryService) {
        this.regionService = regionService;
        this.countryService = countryService;
    }

    @GetMapping("/regions")
    public String regions(Model model, RegionFilters regionFilters) {
        model.addAttribute("regions", regionService.findAll(regionFilters));
        model.addAttribute("filters", regionFilters);

        return "regions";
    }

    @GetMapping("/region")
    public String region(Model model, @PathParam("id") Long id) {
        model.addAttribute("region", regionService.findById(id));

        return "region";
    }

    @GetMapping("/region/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        regionService.delete(id);

        return "redirect:/regions";
    }

    @GetMapping("/region/edit/{id}")
    public String editRegion(Model model, @PathVariable("id") Long id) {
        Region region = regionService.findById(id);
        model.addAttribute("region", region);

        return "edit-region";
    }

    @GetMapping("/region/new")
    public String createRegion(Model model) {
        Region region = new Region();
        model.addAttribute("region", region);

        return "new-region";
    }

    @PostMapping("/region/save")
    public String saveRegion(Region region) {
        regionService.save(region);

        return "redirect:/regions";
    }


    @GetMapping("/region/{id}/add/country")
    public String addCountryToRegion(Model model, @PathVariable("id") Long id) {
        model.addAttribute("region", regionService.findById(id));
        model.addAttribute("countries", countryService.findAll());

        return "add-country-to-region";
    }
}
