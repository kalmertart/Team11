package ee.itcollege.borderproject.setup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ee.itcollege.borderproject.dao.BorderStationDao;
import ee.itcollege.borderproject.dao.GuardDao;
import ee.itcollege.borderproject.dao.GuardInBorderStationDao;
import ee.itcollege.borderproject.model.BorderStation;
import ee.itcollege.borderproject.model.Guard;
import ee.itcollege.borderproject.model.GuardInBorderStation;

@Component
public class GuardInBorderStationDataInserter {
	
	public static final String SYSTEM_USER = "system";
	
	@Resource
	GuardDao guardDao;
	
	@Resource
	BorderStationDao borderStationDao;
	
	@Resource
	GuardInBorderStationDao guardInBorderStationDao;

	public void insertGuardsInBorderStation() {		
		if (!hasTestDataBeenInserted()) {
			guardInBorderStationDao.save(testGuardInBorderStation());
		}
	}
	
	public GuardInBorderStation testGuardInBorderStation(){
		GuardInBorderStation guardInBorderStation = new GuardInBorderStation();
		guardInBorderStation.setBorderStation(getFirstBorderStation());
		guardInBorderStation.setGuard(getFirstGuard());
		guardInBorderStation.setStart(asDate("19/12/2010"));
		guardInBorderStation.setEnd(asDate("19/12/2011"));
		guardInBorderStation.setWorkTime(1.0);
		
		return guardInBorderStation;
	}
	
	private Guard getFirstGuard() {
		return guardDao.getAll().get(0);
	}
	
	private BorderStation getFirstBorderStation() {
		return borderStationDao.getAll().get(0);
	}
	
	private boolean hasTestDataBeenInserted() {
		for (GuardInBorderStation guardInBorderStation : guardInBorderStationDao.getWithDeleted()) {
			if (SYSTEM_USER.equals(guardInBorderStation.getCreator()))
				return true;
		}
		
		return false;
	}
	
	public static Date asDate(String date) {
            try {
				return new SimpleDateFormat("dd/MM/yyyy").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
	}
}
