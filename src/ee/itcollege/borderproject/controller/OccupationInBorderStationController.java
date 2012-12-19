package ee.itcollege.borderproject.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.borderproject.common.CrudController;
import ee.itcollege.borderproject.dao.BorderStationDao;
import ee.itcollege.borderproject.dao.OccupationDao;
import ee.itcollege.borderproject.dao.OccupationInBorderStationDao;
import ee.itcollege.borderproject.model.OccupationInBorderStation;

@Controller
@RequestMapping("/occupationInBorderStation")
public class OccupationInBorderStationController extends CrudController<OccupationInBorderStation> {
	
	private static final String LIST_OCCUAPTION_IN_BORDER_STATION = "occupationInBorderStation/ListOccupationsInBorderStation";
	private static final String ADD_OCCUPATION_IN_BORDER_STATION = "occupationInBorderStation/AddOccupationInBorderStation";
	private static final String UPDATE_OCCUPATION_IN_BORDR_STATION = "occupationInBorderStation/UpdateOccupationInBorderStation";
	private static final String OCCUPATION_IN_BORDER_STATION_ATTRIBUTE = "occupationInBorderStation";
	private static final String BORDERSTATION_ATTRIBUTE = "borderStations";
	private static final String OCCUPATION_ATTRIBUTE = "occupations";
	
	public OccupationInBorderStationController() {
		super();
		super.setAddingView(ADD_OCCUPATION_IN_BORDER_STATION);
		super.setListingView(LIST_OCCUAPTION_IN_BORDER_STATION);
		super.setUpdatingView(UPDATE_OCCUPATION_IN_BORDR_STATION);
		super.setListingAttribute(OCCUPATION_IN_BORDER_STATION_ATTRIBUTE);
	}
	
	@Resource
	OccupationInBorderStationDao occupationInBorderStationDao;
	
	@Resource
	OccupationDao occupationDao;
	
	@Resource
	BorderStationDao borderStationDao;
	
	@Override
	protected void save(OccupationInBorderStation entity) {
		occupationInBorderStationDao.save( entity );
	}

	@Override
	protected void delete(Integer entityId) {
		occupationInBorderStationDao.delete( entityId );
	}

	@Override
	protected List<OccupationInBorderStation> getAll() {
		return occupationInBorderStationDao.getAll();
	}

	@Override
	protected OccupationInBorderStation find(Integer entityId) {
		return occupationInBorderStationDao.find( entityId );
	}

	@Override
	protected void update(OccupationInBorderStation entity) {
		occupationInBorderStationDao.update( entity );
	}
	
	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public String add(Model model) {
		fillOptionSources( model );
		return super.add( model );
	}
	
	@RequestMapping(value = ADD, method = RequestMethod.POST)
	public String addReceive(Model model,
			@ModelAttribute @Valid OccupationInBorderStation entity,
			BindingResult result)
	{
		fillOptionSources( model );
		return super.addReceive( model, entity, result );
	}
	
	@RequestMapping(value = UPDATE, method = RequestMethod.GET)
	public String update(Model model,
			@RequestParam(required=true, value = ID) Integer entityId)
	{
		fillOptionSources( model );
		return super.update( model, entityId );
	}
	
	@RequestMapping(value = UPDATE, method = RequestMethod.POST)
	public String receiveUpdate(Model model,
			@ModelAttribute @Valid OccupationInBorderStation entity,
			BindingResult result)
	{
		fillOptionSources( model );
		return super.receiveUpdate( model, entity, result );
	}
	
	private void fillOptionSources(Model model) {
		model.addAttribute( OCCUPATION_ATTRIBUTE, occupationDao.getAll() );
		model.addAttribute( BORDERSTATION_ATTRIBUTE, borderStationDao.getAll() );
	}
}
