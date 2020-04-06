package BTEC.Management.Controllers;

import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import BTEC.Management.utils.WebUtils;
 
@Controller
public class MainController {
 
    @RequestMapping(value = { "/","/index"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
    	model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
       return "index";
    }   
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "login";
    }
     
    @RequestMapping(value = "/all-courses", method = RequestMethod.GET)
    public String coursePage(Model model, Principal principal) {
         
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
         
        return "all-courses";
    }
    @RequestMapping(value = "/all-professors", method = RequestMethod.GET)
    public String professorPage(Model model, Principal principal) {
         
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
         
        return "all-professors";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "404";
    }
 
}