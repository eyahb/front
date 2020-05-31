package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Location;
import tn.esprit.spring.service.ILocationService;

@Scope(value = "session")
@Controller(value = "locationController")
@ELBeanName(value = "locationController")




public class LocationController {

	@Autowired
	ILocationService ils;

	

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-locations
	@GetMapping("/retrieve-all-locations")
	@ResponseBody
	public List<Location> getUsers() {
		List<Location> list = ils.retrieveAllLocations();
		return list;
	}

	// http://localhost:8081/SpringMVC/servlet/modify-Location
	@PutMapping("/modify-Location")
	@ResponseBody
	public Location updateLoc(@RequestBody Location loc) {
		return ils.updateLoc(loc);
	}

	public String moveToPage1() {
		return "/rent.xhtml";
	}

	public String addLocation1() {
		String navigateTo = "null";
		ils.addOrUpdateLocation(new Location(DateDepart, DateArrivee, nbPersonne));
		return navigateTo;
	}
	public void addLocation() {
		ils.addOrUpdateLocation(new Location(DateDepart, DateArrivee, nbPersonne));
		 FacesContext context = FacesContext.getCurrentInstance();
         
	        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );
	}
	public void updateLocation() {
		ils.addOrUpdateLocation(new Location(locationIdToBeUpdated, DateDepart, DateArrivee, nbPersonne));
		 FacesContext context = FacesContext.getCurrentInstance();
         
	        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );
	}
	public List<Location> getLocations() {
		locations =ils.getAllLocations();
		return locations;
	}
	public void removeLocation(String locationId) {
		ils.deleteLocationById(locationId);
		 FacesContext context = FacesContext.getCurrentInstance();
         
	        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );}
	
	
	public void displayLocation(Location empl) {
		this.setDateDepart(empl.getDateDepart());
		this.setDateArrivee(empl.getDateArrivee());
		this.setNbPersonne(empl.getNbPersonne());
		this.setLocationIdToBeUpdated(empl.getId());
		
	}

	@Temporal(TemporalType.DATE)
	public Date DateDepart;
	@Temporal(TemporalType.DATE)
	public Date DateArrivee;
	public int nbPersonne;
	private List<Location> locations;
	private long locationIdToBeUpdated;

	public ILocationService getIls() {
		return ils;
	}

	public void setIls(ILocationService ils) {
		this.ils = ils;
	}
	 private String message;
	 
	    public String getMessage() {
	        return message;
	    }
	 
	    public void setMessage(String message) {
	        this.message = message;
	    }
	

	

	public long getLocationIdToBeUpdated() {
		return locationIdToBeUpdated;
	}

	public void setLocationIdToBeUpdated(long locationIdToBeUpdated) {
		this.locationIdToBeUpdated = locationIdToBeUpdated;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Date getDateDepart() {
		return DateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.DateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return DateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.DateArrivee = dateArrivee;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

}
