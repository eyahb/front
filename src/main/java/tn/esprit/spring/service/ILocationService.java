package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Location;


public interface ILocationService {

	public Long addLoc(Location loc);

	public void deleteLoc(String id);

	public List<Location> retrieveAllLocations();
	
	Location updateLoc(Location loc);

}
