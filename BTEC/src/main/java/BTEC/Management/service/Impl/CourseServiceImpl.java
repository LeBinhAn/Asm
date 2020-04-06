package BTEC.Management.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BTEC.Management.Entities.Course;
import BTEC.Management.Repository.CourseRepository;
import BTEC.Management.service.CourseService;

import java.util.List;
import java.util.Optional;  

@Service  
public class CourseServiceImpl implements CourseService {  
  @Autowired private CourseRepository courseRepository;  

  @Override  
  public List<Course> getAllCourse() {  
    return (List<Course>) courseRepository.findAll();  
  }  

  @Override  
  public void saveCourse(Course course) {  
    courseRepository.save(course);  
  }  

  @Override  
  public void deleteCourse(Long id) {  
    courseRepository.deleteById(id);  
  }  

  @Override  
  public Optional<Course> findCourseById(Long id) {  
    return courseRepository.findById(id);  
  }  
}