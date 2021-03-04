package pl.sebroz.travelerapp.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sebroz.travelerapp.security.model.User;
import pl.sebroz.travelerapp.security.model.UserRole;
import pl.sebroz.travelerapp.security.services.UserRoleService;
import pl.sebroz.travelerapp.security.services.UserService;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final UserService userService;
    private final UserRoleService userRoleService;

    @Autowired
    public AdminController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @GetMapping
    public String adminPanel(Model model) {
        model.addAttribute("users", userService.findAllWithoutCurrentUser());

        return "admin";
    }

    @GetMapping("/change/{id}")
    public String changeRole(Model model, @PathVariable Long id) {
        model.addAttribute("userRole", userRoleService.findByUser(userService.findById(id)));

        return "change-role";
    }

    @PostMapping("/save")
    public String saveUser(UserRole userRole) {
        userRoleService.save(userRole);

        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

}
