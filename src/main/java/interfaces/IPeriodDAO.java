package interfaces;

import java.util.Date;
import java.util.List;

import entities.Period;

public interface IPeriodDAO extends IGenericDAO<Period>{
	
	List<Period> getAllPeriods();
	
	Period getPeriodByDates(Date start, Date end);
	
}
