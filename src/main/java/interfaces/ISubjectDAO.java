package interfaces;

import java.util.List;

import entities.Subject;

public interface ISubjectDAO extends IGenericDAO<Subject>{
	
	List<Subject> getAllSubjects();
	
	Subject getSubjectByName(String name);
	
}
