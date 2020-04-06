package BTEC.Management.DataAccessObjects;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BTEC.Management.Entities.Course;

@Repository
@Transactional
public class CourseDAO {
 
    @Autowired
    private EntityManager entityManager;
 
    public Course findCourse(String courseName) {
        try {
            String sql = "Select e from " + Course.class.getName() + " e " //
                    + " Where e.course_name = :courseName ";
 
            Query query = entityManager.createQuery(sql, Course.class);
            query.setParameter("courseName", courseName);
 
            return (Course) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}