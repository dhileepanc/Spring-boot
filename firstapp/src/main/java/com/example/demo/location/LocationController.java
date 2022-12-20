package com.example.demo.location;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
	@Autowired
	private LocationService locationserv;
	@RequestMapping("locations")
	
public List<Location> getAllLocations() {
		
		return locationserv.getAllLocations();   
		   }
	
	@RequestMapping(value = "/locations/{id}")
	public Location getLocation(@PathVariable Integer id) {
		return locationserv.getLocation(id);
	}
	
	@RequestMapping( value="/locations",method=RequestMethod.POST)
	public void addLocation(@RequestBody Location location) {
		 locationserv.addLocation(location);
	}
	
	@RequestMapping(value = "/locations/{id}",method=RequestMethod.PUT)
	public void updateLocation(@RequestBody Location location,@PathVariable Integer id)
	{
		locationserv.updateLocation(id,location);
	}
	
	@RequestMapping(value = "/locations/{id}",method=RequestMethod.DELETE)
	public void deleteLocation(@PathVariable Integer id)
	{
		locationserv.deleteLocation(id);
	}
	
}
