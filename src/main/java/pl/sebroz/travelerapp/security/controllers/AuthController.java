package pl.sebroz.travelerapp.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.sebroz.travelerapp.security.model.User;
import pl.sebroz.travelerapp.security.services.UserService;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String error,
                        @ModelAttribute(name = "successMessage") String successMessage) {
        boolean showErrorMessage = false;

        if (error != null) {
            showErrorMessage = true;
        }
        model.addAttribute("showErrorMessage", showErrorMessage);

        return "login";
    }

    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String register(RedirectAttributes redirectAttributes, User user) {
        userService.register(user.getUsername(), user.getPassword());

        redirectAttributes.addFlashAttribute("successMessage", "Account created!");

        return "redirect:/login";
    }

    @GetMapping("/settings/{id}")
    public String settings(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findById(id));

        return "settings";
    }

    @PostMapping("/settings/save")
    public String saveSettings(User user) {
        userService.saveSettings(user);

        return "redirect:/";
    }

    @GetMapping("/settings/{id}/password")
    public String changePasswordForm(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findById(id));

        return "change-password";
    }

    @PostMapping("/settings/password/change")
    public String changePassword(@RequestParam String password, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername());
        userService.changePassword(user.getId(), password);

        return "redirect:/";
    }
}
