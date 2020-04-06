package BTEC.Management.Controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BTEC.Management.Entities.AppUser;
import BTEC.Management.service.UserService;
import BTEC.Management.utils.WebUtils;

@Controller
public class TrainerController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/trainer-profile", method = RequestMethod.GET)
    public String trainerProfile(@RequestParam("id") Long userId, Model model) {
        Optional<AppUser> trainerProfile = userService.findUserById(userId);
        trainerProfile.ifPresent(user -> model.addAttribute("user", user));
        return "trainer-profile";
    }

}