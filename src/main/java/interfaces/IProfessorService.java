package interfaces;

import java.util.List;

import entities.Professor;
import exceptions.InvalidProfessorInformation;
import exceptions.ProfessorAlreadyExists;

public interface IProfessorService {

	List<Professor> getAllProfessors();

	void addProfessor(Professor dtProfessor) throws ProfessorAlreadyExists, InvalidProfessorInformation;
	
}
