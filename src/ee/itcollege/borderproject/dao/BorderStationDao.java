package ee.itcollege.borderproject.dao;

import java.util.List;

import ee.itcollege.borderproject.model.BorderStation;

public interface BorderStationDao {
	
	List<BorderStation> getBorderStations();

	void saveBorderStation(BorderStation borderStation) ;
	
	void saveBorderStations(List<BorderStation> borderStations);
	
	BorderStation searchborderStation(Integer id);
	
	void updateBorderStation(BorderStation borderStation);
	
	void deleteBorderStation(Integer id);
}
