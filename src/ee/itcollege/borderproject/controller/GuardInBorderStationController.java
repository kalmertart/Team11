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
import ee.itcollege.borderproject.dao.GuardDao;
import ee.itcollege.borderproject.dao.GuardInBorderStationDao;
import ee.itcollege.borderproject.model.GuardInBorderStation;

@Controller
@RequestMapping("/guardInBorderStation")
public class GuardInBorderStationController extends CrudController<GuardInBorderStation> {
	
	private static final String LIST_GUARD_IN_BORDERSTATION = "guardInBorderStation/ListGuardsInBorderStation";
	private static final String ADD_GUARD_IN_BORDERSTATION = "guardInBorderStation/AddGuardInBorderStation";
	private static final String UPDATE_GUARD_IN_BORDERSTATION = "guardInBorderStation/UpdateGuardInBorderStation";
	private static final String GUARD_IN_BORDERSTATION_ATTRIBUTE = "guardInBorderStation";
	private static final String GUARD_ATTRIBUTE = "guards";
	private static final String BORDERSTATION_ATTRIBUTE = "borderStations";
	
	public GuardInBorderStationController() {
		super();
		super.setAddingView(ADD_GUARD_IN_BORDERSTATION);
		super.setUpdatingView(UPDATE_GUARD_IN_BORDERSTATION);
		super.setListingView(LIST_GUARD_IN_BORDERSTATION);
		super.setListingAttribute(GUARD_IN_BORDERSTATION_ATTRIBUTE);
	}
	
	@Resource
	GuardInBorderStationDao guardInBorderStationDao;
	
	@Resource
	GuardDao guardDao;
	
	@Resource
	BorderStationDao borderStationDao;
	
	@Override
	protected void save(GuardInBorderStation entity) {
		guardInBorderStationDao.save( entity );
	}

	@Override
	protected void delete(Integer entityId) {
		guardInBorderStationDao.delete( entityId );
	}

	@Override
	protected List<GuardInBorderStation> getAll() {
		return guardInBorderStationDao.getAll();
	}

	@Override
	protected GuardInBorderStation find(Integer entityId) {
		return guardInBorderStationDao.find( entityId );
	}

	@Override
	protected void update(GuardInBorderStation entity) {
		guardInBorderStationDao.update( entity );
	}
	
	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public String add(Model model) {
		fillOptionSources( model );
		return super.add( model );
	}
	
	@RequestMapping(value = ADD, method = RequestMethod.POST)
	public String addReceive(Model model,
			@ModelAttribute @Valid GuardInBorderStation entity,
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
			@ModelAttribute @Valid GuardInBorderStation entity,
			BindingResult result)
	{
		fillOptionSources( model );
		return super.receiveUpdate( model, entity, result );
	}
	
	private void fillOptionSources(Model model) {
		model.addAttribute( GUARD_ATTRIBUTE, guardDao.getAll() );
		model.addAttribute( BORDERSTATION_ATTRIBUTE, borderStationDao.getAll() );
	}
}
