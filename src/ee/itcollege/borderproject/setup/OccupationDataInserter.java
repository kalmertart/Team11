package ee.itcollege.borderproject.setup;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ee.itcollege.borderproject.dao.OccupationDao;
import ee.itcollege.borderproject.model.Occupation;

@Component
public class OccupationDataInserter {
	
	public static final String SYSTEM_USER = "system";

	@Resource
	OccupationDao occupationDao;
	
	public void insertOccupations(){
		if (!hasTestDataBeenInserted()) {
			occupationDao.save(testOccupation1());
			occupationDao.save(testOccupation2());
			occupationDao.save(testOccupation3());
		}
	}
	
	private Occupation testOccupation1(){
		Occupation occupation = new Occupation();
		occupation.setIscoCode("ISCO-3351");
		occupation.setComment("Valvab piiri ja kontrollib dokumente");
		occupation.setName("Piirivalvur");
		
		return occupation;
	}
	
	private Occupation testOccupation2(){
		Occupation occupation = new Occupation();
		occupation.setIscoCode("ISCO-91");
		occupation.setComment("Koristab ja pläkutab tihtipeale");
		occupation.setName("Koristaja");
		
		return occupation;
	}
	
	private Occupation testOccupation3(){
		Occupation occupation = new Occupation();
		occupation.setIscoCode("ISCO-0110");
		occupation.setComment("Valvab ja tulistab");
		occupation.setName("Relvastatud piirivalvur");
		
		return occupation;
	}
	
	private boolean hasTestDataBeenInserted() {
		for (Occupation occupation : occupationDao.getAll()) {
			if (SYSTEM_USER.equals(occupation.getCreator()))
				return true;
		}
		
		return false;
	}

}
