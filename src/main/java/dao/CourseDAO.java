package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import entities.Course;
import hibernate.GenericDAO;
import interfaces.ICourseDAO;

public class CourseDAO extends GenericDAO<Course> implements ICourseDAO{

	public List<Course> getAllCourses() {
		@SuppressWarnings({ "unchecked" })
		List<Course> colResult = (List<Course>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					public List<Course> doInHibernate(Session oSession) throws HibernateException {
						Criteria oCriteria = oSession.createCriteria(Course.class);
						return oCriteria.list();
					}
				});
		return colResult;
	}

}
