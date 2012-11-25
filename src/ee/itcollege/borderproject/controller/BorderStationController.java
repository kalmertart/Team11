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

import ee.itcollege.borderproject.dao.BorderStationDao;
import ee.itcollege.borderproject.model.BorderStation;

@Controller
@RequestMapping("/borderStation")
public class BorderStationController {
	
	private static final String BORDERSTATION_ATTRIBUTE = "borderStations";
	private static final String BORDERSTATION_LIST_VIEW = "ListBorderStations";
	private static final String BORDERSTATION_LIST_VIEW_REDIRECT = "redirect:/borderStation/view";
	private static final String BORDERSTATION_ADD_VIEW = "AddBorderStation";
	private static final String BORDERSTATION_UPDATE_VIEW = "UpdateBorderStation";
	
	@Resource
	private BorderStationDao borderStationDao;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String listAllBorderStations(Model model){
		List<BorderStation> borderStationList = borderStationDao.getBorderStations();
		model.addAttribute(BORDERSTATION_ATTRIBUTE, borderStationList);
		return BORDERSTATION_LIST_VIEW;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBorderStation(Model model){
		model.addAttribute(new BorderStation());
		return BORDERSTATION_ADD_VIEW;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String receiveAddBorderStation(
					@ModelAttribute @Valid BorderStation borderStation,
					Model model,
					BindingResult result)
	{
		if(result.hasErrors()) {
			return BORDERSTATION_ADD_VIEW;
		}
	
		borderStationDao.saveBorderStation( borderStation );
		return BORDERSTATION_LIST_VIEW_REDIRECT;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateBorderStation(
					Model model,
					@RequestParam(required=true, value="id") Integer borderStationId)
	{
		BorderStation borderStation = borderStationDao.searchborderStation(borderStationId);
		
		if(borderStation == null){
			return BORDERSTATION_LIST_VIEW_REDIRECT;
		}
		
		model.addAttribute(borderStation);
		return BORDERSTATION_UPDATE_VIEW;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String receiveUpdatedBorderStation(
					Model model,
					@ModelAttribute @Valid BorderStation borderStation,
					BindingResult result)
	{
		if(result.hasErrors()){
			return BORDERSTATION_UPDATE_VIEW;
		}
		
		borderStationDao.updateBorderStation(borderStation);
		return BORDERSTATION_LIST_VIEW_REDIRECT;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteBorderStation(
					@RequestParam(required=true, value="id") Integer borderStationId)
	{
		borderStationDao.deleteBorderStation(borderStationId);
		return BORDERSTATION_LIST_VIEW_REDIRECT;
	}
	
	

}
