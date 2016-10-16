package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import entities.Group;
import hibernate.GenericDAO;
import interfaces.IGroupDAO;

public class GroupDAO extends GenericDAO<Group> implements IGroupDAO{

	public List<Group> getAllGroups() {
		@SuppressWarnings({ "unchecked" })
		List<Group> colResult = (List<Group>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					public List<Group> doInHibernate(Session oSession) throws HibernateException {
						Criteria oCriteria = oSession.createCriteria(Group.class);
						return oCriteria.list();
					}
				});
		return colResult;
	}

	@Override
	public Group getGroupByNameAndYear(final String name, final int year) {
		Group group = null;
		@SuppressWarnings("unchecked")
		List<Group> colResult = (List<Group>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					public List<Group> doInHibernate(Session oSession) throws HibernateException {
						Criteria oCriteria = oSession.createCriteria(Group.class);
						oCriteria.add(Restrictions.eq("name", name));
						oCriteria.add(Restrictions.eq("year", year));
						return oCriteria.list();
					}
				});
		if (colResult.size() > 0)
			group = colResult.get(0);
		
		return group;
	}

}
