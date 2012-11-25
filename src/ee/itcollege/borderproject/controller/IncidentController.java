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

import ee.itcollege.borderproject.dao.IncidentDao;
import ee.itcollege.borderproject.model.Incident;
import ee.itcollege.borderproject.service.IncidentService;

@Controller
@RequestMapping("/incident")
public class IncidentController {
	
	private static final String INCIDENT_ATTRIBUTE = "incidents";
	private static final String INCIDENT_LIST_VIEW = "ListIncidents";
	private static final String INCIDENT_LIST_VIEW_REDIRECT =  "redirect:/incident/view";
	private static final String INCIDENT_ADD_VIEW = "AddIncident";
	private static final String INCIDENT_UPDATE_VIEW = "UpdateIncident";
	
	@Resource
	private IncidentService incidentService;
	
	@Resource
	private IncidentDao incidentDao;
	
	@RequestMapping(value = "/unresolved", method = RequestMethod.GET)
	public String unresolvedIncidents(Model model) {
		List<Incident> incidentList = incidentService.getUnresolvedIncidents();
		model.addAttribute(INCIDENT_ATTRIBUTE, incidentList);
		return INCIDENT_LIST_VIEW;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String listAllIncidents(Model model) {
		List<Incident> incidentList = incidentDao.getIncidents();
		model.addAttribute(INCIDENT_ATTRIBUTE, incidentList);
		return INCIDENT_LIST_VIEW;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String reportIncident(Model model) {
		model.addAttribute(new Incident());
		return INCIDENT_ADD_VIEW;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String receiveReportIncident(
			@ModelAttribute @Valid Incident incident,
			Model model,
			BindingResult result) 
	{
		if(result.hasErrors()) {
			return INCIDENT_ADD_VIEW;
		}
		
		incidentDao.saveIncident( incident );
		return INCIDENT_LIST_VIEW_REDIRECT;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateIncident(
			Model model,
			@RequestParam(required=true, value="id") Integer incidentId)
	{		
		Incident incident = incidentDao.searchIncident( incidentId );
		
		if (incident == null) {
			return INCIDENT_LIST_VIEW_REDIRECT;
		}
		
		model.addAttribute(incident);
		return INCIDENT_UPDATE_VIEW;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String receiveUpdatedIncident(
			Model model,
			@ModelAttribute @Valid Incident incident,
			BindingResult result )
	{
		if(result.hasErrors()) {
			return INCIDENT_UPDATE_VIEW;
		}
		
		incidentDao.updateIncident( incident );
		return INCIDENT_LIST_VIEW_REDIRECT;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteIncident(
			@RequestParam(required=true, value="id") Integer incidentId,
			Model model )
	{		
		incidentDao.deleteIncident( incidentId );	
		return INCIDENT_LIST_VIEW_REDIRECT;
	}
}
