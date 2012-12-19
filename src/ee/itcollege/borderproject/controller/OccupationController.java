package ee.itcollege.borderproject.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.itcollege.borderproject.common.CrudController;
import ee.itcollege.borderproject.dao.OccupationDao;
import ee.itcollege.borderproject.model.Occupation;

@Controller
@RequestMapping("/occupation")
public class OccupationController extends CrudController<Occupation>{
	
	@Resource
	private OccupationDao occupationDao;

	private static final String LIST_OCCUPATIONS_VIEW = "occupation/ListOccupations";
	private static final String ADD_OCCUPATION_VIEW = "occupation/AddOccupation";
	private static final String UPDATE_OCCUPATION_VIEW = "occupation/UpdateOccupation";
	private static final String OCCUPATIONS_ATTRIBUTE = "occupations";

	public OccupationController() {
		super();
		super.setAddingView(ADD_OCCUPATION_VIEW);
		super.setListingView(LIST_OCCUPATIONS_VIEW);
		super.setUpdatingView(UPDATE_OCCUPATION_VIEW);
		super.setListingAttribute(OCCUPATIONS_ATTRIBUTE);
	}

	@Override
	protected void save(Occupation entity) {
		occupationDao.save(entity);
	}

	@Override
	protected void delete(Integer entityId) {
		occupationDao.delete(entityId);
	}

	@Override
	protected List<Occupation> getAll() {
		return occupationDao.getAll();
	}

	@Override
	protected Occupation find(Integer entityId) {
		return occupationDao.find(entityId);
	}

	@Override
	protected void update(Occupation entity) {
		occupationDao.update(entity);
	}


}
