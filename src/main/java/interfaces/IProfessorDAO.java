package interfaces;

import java.util.List;

import entities.Professor;

public interface IProfessorDAO extends IGenericDAO<Professor>{
	
	List<Professor> getAllProfessors();
	
	Professor getProfessorByMail(final String email);
	
}
