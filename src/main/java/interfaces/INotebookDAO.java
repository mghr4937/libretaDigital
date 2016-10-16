package interfaces;

import java.util.List;

import entities.Group;

public interface INotebookDAO extends IGenericDAO<Group>{
	
	List<Group> getAllGroups();
	
	Group getGroupByNameAndYear(String name, int year);
	
}
