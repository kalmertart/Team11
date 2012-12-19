package ee.itcollege.borderproject.setup;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ee.itcollege.borderproject.dao.BorderStationDao;
import ee.itcollege.borderproject.model.BorderStation;

@Component
public class BorderStationDataInserter {
	
	public static final String SYSTEM_USER = "system";
	
	@Resource
	BorderStationDao bsDao;
	

	public void insertBorderStations(){

		if (!hasTestDataBeenInserted()) {
			bsDao.save(testBs1());
			bsDao.save(testBs2());
			bsDao.save(testBs3());
			bsDao.save(testBs4());			
		}
	}
	
	private BorderStation testBs1(){
		BorderStation bs = new BorderStation();
		bs.setLatitude(57.874636);
		bs.setLongitude(24.361231);
		bs.setComment("Kena koht");
		bs.setCode("PP_IKL");
		bs.setElevation(5.04);
		bs.setName("Ikla piiripunkt");
		
		return bs;
	}
	
	private BorderStation testBs2(){
		BorderStation bs = new BorderStation();
		bs.setLatitude(57.581325);
		bs.setLongitude(27.046856);
		bs.setComment("Uus aed alles pandud");
		bs.setCode("PP_MRT");
		bs.setElevation(25.04);
		bs.setName("Murati piiripunkt");
		
		return bs;
	}
	
	private BorderStation testBs3(){
		BorderStation bs = new BorderStation();
		bs.setLatitude(58.078211);
		bs.setLongitude(25.190898);
		bs.setComment("Rekkad pumpavad rehve tihti");
		bs.setCode("PP_MKL");
		bs.setElevation(10.30);
		bs.setName("Mõisaküla piiripunkt");
		
		return bs;
	}
	
	private BorderStation testBs4(){
		BorderStation bs = new BorderStation();
		bs.setLatitude(59.376884);
		bs.setLongitude(28.204628);
		bs.setComment("Haiseb pesematuse järgi");
		bs.setCode("PP_NV1");
		bs.setElevation(1.87);
		bs.setName("Narva-1 piiripunkt");
		
		return bs;
	}
	
	private boolean hasTestDataBeenInserted() {
		for (BorderStation bs : bsDao.getAll()) {
			if (SYSTEM_USER.equals(bs.getCreator()))
				return true;
		}
		
		return false;
	}
}
