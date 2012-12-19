package ee.itcollege.borderproject.setup;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class TestDataInserter {
	
	@Resource
	GuardDataInserter guardDataInserter;
	
	@Resource
	OccupationDataInserter occupationDataInserter;
	
	@Resource
	BorderStationDataInserter borderStationDataInserter;
	
	@Resource
	OccupationInBorderStationDataInserter occupationInBorderStationDataInserter;
	
	@Resource
	GuardInBorderStationDataInserter guardInBorderStationDataInserter;
	
	@PostConstruct
	public void insertTestData() {		
		guardDataInserter.insertGuards();
		occupationDataInserter.insertOccupations();
		borderStationDataInserter.insertBorderStations();
		occupationInBorderStationDataInserter.insertOccupationsInBorderStations();
		guardInBorderStationDataInserter.insertGuardsInBorderStation();
		
	}

}
