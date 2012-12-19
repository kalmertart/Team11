package ee.itcollege.borderproject.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.itcollege.borderproject.common.CrudController;
import ee.itcollege.borderproject.dao.BorderStationDao;
import ee.itcollege.borderproject.model.BorderStation;

@Controller
@RequestMapping("/borderStation")
public class BorderStationController extends CrudController<BorderStation> {

	private static final String LIST_BORDERSTATIONS_VIEW = "borderStation/ListBorderStations";
	private static final String ADD_BORDERSTATION_VIEW = "borderStation/AddBorderStation";
	private static final String UPDATE_BORDERSTATION_VIEW = "borderStation/UpdateBorderStation";
	private static final String BORDERSTATIONS_ATTRIBUTE = "borderStations";
	
	@Resource
	private BorderStationDao borderStationDao;
	
	public BorderStationController() {
		super();
		super.setAddingView(ADD_BORDERSTATION_VIEW);
		super.setListingView(LIST_BORDERSTATIONS_VIEW);
		super.setUpdatingView(UPDATE_BORDERSTATION_VIEW);
		super.setListingAttribute(BORDERSTATIONS_ATTRIBUTE);
	}
	
	@Override
	protected void save(BorderStation entity) {
		borderStationDao.save(entity);
	}

	@Override
	protected void delete(Integer entityId) {
		borderStationDao.delete(entityId);
	}

	@Override
	protected List<BorderStation> getAll() {
		return borderStationDao.getAll();
	}

	@Override
	protected BorderStation find(Integer entityId) {
		return borderStationDao.find(entityId);
	}

	@Override
	protected void update(BorderStation entity) {
		borderStationDao.update(entity);
	}

}
