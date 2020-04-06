package BTEC.Management.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BTEC.Management.Entities.Course;
import BTEC.Management.service.CourseService;
import java.security.Principal;
import java.util.List;
import java.util.Optional;  

@Controller  
public class CourseController {  
  @Autowired private CourseService courseService;  

  @RequestMapping("/show-all-course")  
  public String viewAllCourse(Model model) {  
    List<Course> courses = courseService.getAllCourse();  

    model.addAttribute("courses", courses);  

    return "show-all-course";  
  } 
  @RequestMapping(value = "/add-new-course", method = RequestMethod.GET)  
  public String addNewCourse(Model model, Principal principal) {  
    model.addAttribute("course", new Course());  
    return "add-new-course";  
  }  
  
  @RequestMapping(value = "/edit-course", method = RequestMethod.GET)  
  public String editCourse(@RequestParam("id") Long courseId, Model model) {  
    Optional<Course> userEdit = courseService.findCourseById(courseId);  
    userEdit.ifPresent(course -> model.addAttribute("course", course));  
    return "edit-course";  
  }  

  @RequestMapping(value = "/save-course", method = RequestMethod.POST)  
  public String save(Course course) {  
    courseService.saveCourse(course);  
    return "redirect:/show-all-course";  
  }  

  @RequestMapping(value = "/delete-course", method = RequestMethod.GET)  
  public String deleteCourse(@RequestParam("id") Long courseId, Model model) {  
    courseService.deleteCourse(courseId);  
    return "redirect:/show-all-course";  
  }   
}