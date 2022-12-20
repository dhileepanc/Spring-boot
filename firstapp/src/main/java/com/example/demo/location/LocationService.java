package com.example.demo.location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

	 Location location1 = new Location(1, "Lagos");
	   Location location2 = new Location(2, "Asaba");
	   Location location3 = new Location(3, "Budapest");	
	   
	   List<Location> locations = new ArrayList<>(Arrays.asList(location1, location2, location3));
	   
	public List<Location> getAllLocations() {
		
		return locations;   
		   }
	public Location getLocation(Integer id) {
	    Location location = locations.stream()
		.filter(t -> id.equals(t.getId()))
		.findFirst()
		.orElse(null);
			
	    return location;
	}
	public void addLocation(Location location) {
locations.add(location);		
	}
	public void updateLocation(Integer id, Location location) {

		for(Integer i=0;i<locations.size();i++)
		{
			Location l=locations.get(i);
			if(l.getId().equals(id))
			{
				locations.set(i, location);
			}
		}
	}
	public void deleteLocation(Integer id) {
		locations.removeIf(l -> l.getId().equals(id));
	}
	
	
}
