package BTEC.Management.Repository;

import BTEC.Management.Entities.Course;

import org.springframework.data.repository.CrudRepository;  
import org.springframework.stereotype.Repository;  

@Repository  
public interface CourseRepository extends CrudRepository<Course, Long> {}