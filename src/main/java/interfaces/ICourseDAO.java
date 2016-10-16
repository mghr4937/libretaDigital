package interfaces;

import java.util.List;

import entities.Course;

public interface ICourseDAO extends IGenericDAO<Course>{
	
	List<Course> getAllCourses();
	
}
