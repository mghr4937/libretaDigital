package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import dao.ProfessorDAO;
import entities.Professor;
import fileupload.FileUploadType;
import interfaces.FileUploadService;

public class FileUploadServiceImpl implements FileUploadService {

	ProfessorDAO professorDAO;
	String cvsSplitBy = ",";
	String csvFile = "/files/docentes_cvs.csv";

	@Override
	public void fileUpload(String tomcatAdress, String fileName, String userName, String selectedUploadType) {
		
		if(selectedUploadType.equals(FileUploadType.PROFESSORS.getValue()))
			addProfessors();
		else if(selectedUploadType.equals(FileUploadType.STUDENTS.getValue()))
			addStudents();
		else if(selectedUploadType.equals(FileUploadType.GROUPS.getValue()))
			addGroups();
		else if(selectedUploadType.equals(FileUploadType.PROGRAM.getValue()))
			addPrograms();
	}
	
	private void addProfessors(){
		
		String line = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {

				String[] professorLine = line.split(cvsSplitBy);
				Professor professor = new Professor(professorLine[0], professorLine[1]);
				professorDAO.save(professor);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addStudents(){
			
	}
	
	private void addGroups(){
		
	}
	
	private void addPrograms(){
		
	}

	public ProfessorDAO getProfessorDAO() {
		return professorDAO;
	}

	public void setProfessorDAO(ProfessorDAO professorDAO) {
		this.professorDAO = professorDAO;
	}
}