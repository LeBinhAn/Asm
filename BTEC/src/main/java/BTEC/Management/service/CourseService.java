package BTEC.Management.service;

import BTEC.Management.Entities.Course;

import java.util.List;  
import java.util.Optional;  

public interface CourseService {  
  List<Course> getAllCourse();  

  void saveCourse(Course course);  

  void deleteCourse(Long id);  

  Optional<Course> findCourseById(Long id);  
}