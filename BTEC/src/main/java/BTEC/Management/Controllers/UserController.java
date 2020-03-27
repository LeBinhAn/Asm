package BTEC.Management.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BTEC.Management.Entities.AppUser;
import BTEC.Management.service.UserService;
import BTEC.Management.utils.WebUtils;

import java.security.Principal;
import java.util.List;
import java.util.Optional;  

@Controller  
public class UserController {  
  @Autowired private UserService userService;  

  @RequestMapping("/show-user")  
  public String index(Model model) {  
    List<AppUser> users = userService.getAllUser();  

    model.addAttribute("users", users);  

    return "show-user";  
  }  

  @RequestMapping(value = "/add-user", method = RequestMethod.GET)  
  public String addUser(Model model, Principal principal) {  
    model.addAttribute("user", new AppUser());  
    return "add-user";  
  }  
  
  @RequestMapping(value = "/edit", method = RequestMethod.GET)  
  public String editUser(@RequestParam("id") Long userId, Model model) {  
    Optional<AppUser> userEdit = userService.findUserById(userId);  
    userEdit.ifPresent(user -> model.addAttribute("user", user));  
    return "edit-user";  
  }  

  @RequestMapping(value = "/save", method = RequestMethod.POST)  
  public String save(AppUser user) {  
    userService.saveUser(user);  
    return "redirect:/";  
  }  

  @RequestMapping(value = "/delete", method = RequestMethod.GET)  
  public String deleteUser(@RequestParam("id") Long userId, Model model) {  
    userService.deleteUser(userId);  
    return "redirect:/";  
  }  
}