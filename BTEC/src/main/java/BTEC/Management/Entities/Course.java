package BTEC.Management.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Course", //
        uniqueConstraints = { //
                @UniqueConstraint(columnNames = "course_id") })
public class Course{

    @Id
    @GeneratedValue
    @Column(name = "course_id", nullable = false)
    private Long courseId;
 
    @Column(name = "course_name", length = 45)
    private String courseName;
 
    @Column(name = "course_description", length = 45)
    private String courseDescription;

    public Long getCourseId() {
        return courseId;
    }
 
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
 
    public String getCourseName() {
        return courseName;
    }
 
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseDescription() {
    	return courseDescription;
    }
    public void setCourseDescription(String courseDescription) {
    	this.courseDescription = courseDescription;
    }
    
}