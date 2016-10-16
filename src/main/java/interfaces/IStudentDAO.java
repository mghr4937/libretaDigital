package interfaces;

import java.util.List;

import entities.Student;

public interface IStudentDAO extends IGenericDAO<Student>{
	
	List<Student> getAllStudents();
	
	Student getStudentByMail(final String email);
	
}
