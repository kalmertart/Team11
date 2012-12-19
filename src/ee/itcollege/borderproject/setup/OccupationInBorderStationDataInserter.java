package ee.itcollege.borderproject.setup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ee.itcollege.borderproject.dao.BorderStationDao;
import ee.itcollege.borderproject.dao.OccupationDao;
import ee.itcollege.borderproject.dao.OccupationInBorderStationDao;
import ee.itcollege.borderproject.model.BorderStation;
import ee.itcollege.borderproject.model.Occupation;
import ee.itcollege.borderproject.model.OccupationInBorderStation;

@Component
public class OccupationInBorderStationDataInserter {

	public static final String SYSTEM_USER = "system";

	@Resource
	OccupationDao occupationDao;

	@Resource
	BorderStationDao borderStationDao;

	@Resource
	OccupationInBorderStationDao occupationInBorderStationDao;

	public void insertOccupationsInBorderStations() {
		if (!hasTestDataBeenInserted()) {
			occupationInBorderStationDao.save(testOccupationInBorderStation1());
		}
	}

	public OccupationInBorderStation testOccupationInBorderStation1() {
		OccupationInBorderStation occupationInBorderStation = new OccupationInBorderStation();
		occupationInBorderStation.setBorderStation(getFirstBorderStation());
		occupationInBorderStation.setOccupation(getFirstOccupation());
		occupationInBorderStation.setStart(asDate("01/05/2011"));
		occupationInBorderStation.setEnd(asDate("01/06/2011"));

		return occupationInBorderStation;
	}

	private Occupation getFirstOccupation() {
		return occupationDao.getAll().get(0);
	}

	private BorderStation getFirstBorderStation() {
		return borderStationDao.getAll().get(0);
	}

	private boolean hasTestDataBeenInserted() {
		for (OccupationInBorderStation occupationInBorderStation : occupationInBorderStationDao
				.getAll()) {
			if (SYSTEM_USER.equals(occupationInBorderStation.getCreator()))
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
