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
public class CourseController {  
  @Autowired private UserService userService;  

  @RequestMapping("/list-course")  
  public String viewCourse(Model model) {  
    List<AppUser> users = userService.getAllUser();  

    model.addAttribute("users", users);  

    return "list-course";  
  }  
}