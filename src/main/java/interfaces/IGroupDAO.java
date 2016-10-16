package interfaces;

import java.util.List;

import entities.Group;

public interface IGroupDAO extends IGenericDAO<Group>{
	
	List<Group> getAllGroups();
	
	Group getGroupByNameAndYear(String name, int year);
	
}
