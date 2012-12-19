package ee.itcollege.borderproject.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.itcollege.borderproject.common.CrudController;
import ee.itcollege.borderproject.dao.GuardDao;
import ee.itcollege.borderproject.model.Guard;

@Controller
@RequestMapping("/guard")
public class GuardController extends CrudController<Guard> {

	@Resource
	private GuardDao guardDao;

	private static final String LIST_GUARDS_VIEW = "guard/ListGuards";
	private static final String ADD_GUARD_VIEW = "guard/AddGuard";
	private static final String UPDATE_GUARD_VIEW = "guard/UpdateGuard";
	private static final String GUARDS_ATTRIBUTE = "guards";

	public GuardController() {
		super();
		super.setAddingView(ADD_GUARD_VIEW);
		super.setListingView(LIST_GUARDS_VIEW);
		super.setUpdatingView(UPDATE_GUARD_VIEW);
		super.setListingAttribute(GUARDS_ATTRIBUTE);
	}

	@Override
	protected void save(Guard entity) {
		guardDao.save(entity);
	}

	@Override
	protected void delete(Integer entityId) {
		guardDao.delete(entityId);
	}

	@Override
	protected List<Guard> getAll() {
		return guardDao.getAll();
	}

	@Override
	protected Guard find(Integer entityId) {
		return guardDao.find(entityId);
	}

	@Override
	protected void update(Guard entity) {
		guardDao.update(entity);
	}

}
