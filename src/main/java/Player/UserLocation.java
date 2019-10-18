package main.java.Player;

import main.java.*;

enum areas{ // Not implemented yet.  The idea for this is that random occurrences will occur depending on where the player is located.  
//	east_china_sea,
//	philippine_sea,
//	south_china_sea,
//	sea_of_japan,
//	bay_of_bengal,
//	arabian_sea,
	indian_ocean,
	pacific_ocean,
	atlantic_ocean,
	arctic_ocean
//	gulf_of_mexico,
//	carribbean_sea,
//	bering_sea,
//	gulf_of_alaska
}

public class UserLocation extends UserEngine {

	//private String currentLocation;
	private LongitudeLatitude playerLocation; // Player location is stored in this object.
	private LongitudeLatitude playerDestination; // Player destination is stored in this object.
	private final static String defaultTitle = "Long Beach"; // Default title
	private final static double defaultLatitude = 33.754185; // Default latitude
	private final static double defaultLongitude = -118.216458; // Default longitude
	private areas oceanArea; // Initial implementation of area locale.
	
	public UserLocation(){ // Default constructor creates an two empty builder objects, LongitudeLatitude.  Also sets area location to default.
		this.playerLocation = new LongitudeLatitude.Builder().build(); 
		this.playerDestination = new LongitudeLatitude.Builder().build();
		this.oceanArea = areas.pacific_ocean;
	}
	
	public void SetCurrentLocation(String UserDefinedLocation){ // Sets the playerLocation to the passed String.  
		this.playerLocation.SetTitle(UserDefinedLocation);
	}
	
	public void SetDefaultLocation(){ //Sets the player location title, longitude and latitude to the default settings.
		this.playerLocation.SetTitle(defaultTitle);
		this.playerLocation.SetLatitude(defaultLatitude);
		this.playerLocation.SetLongitude(defaultLongitude);
	}
	
	public LongitudeLatitude GetCurrentCoordinates(){ // Returns the player current coordinates.
		return this.playerLocation;
	}
	
	public LongitudeLatitude GetDestinationCoordinates(){ // Returns the player destination coordinates.
		return this.playerDestination;
	}
	
	public void SetDestinationLocation(String passedTitle){ // Sets the player destination location, by passed string.
		this.playerDestination.SetTitle(passedTitle);
	}
	
	public void SetDestinationLocation(String passedTitle, double passedLongitude, double passedLatitude){ // Sets the destination location, by passing title, longitude and latitude.
		this.playerDestination.SetTitle(passedTitle);
		this.playerDestination.SetLongitude(passedLongitude);
		this.playerDestination.SetLatitude(passedLatitude);
	}
	
	public void SetLongitudeAndLatitude(double passedLongitude, double passedLatitude){ // Sets current location longitude and latitude.
		this.playerLocation.SetLongitude(passedLongitude);
		this.playerLocation.SetLatitude(passedLatitude);
	}
	
	public String getCurrentLocation(){ // Returns the current location name.
		return this.playerLocation.GetTitle();
	}

	public double GetCurrentLongitude(){ // Returns the current location longitude.
		return this.playerLocation.GetLongitude();
	}

	public double GetCurrentLatitude(){ // Returns the current location latitude.
		return this.playerLocation.GetLatitude();
	}

	public String GetDestinationName(){ // Returns the destination location name.
		return this.playerDestination.GetTitle();
	}
	
	public double GetDestinationLatitude(){ // Returns the destination latitude.
		return this.playerDestination.GetLatitude();
	}
	
	public double GetDestinationLongitude(){ // Returns the destination longitude.
		return this.playerDestination.GetLongitude();
	}
	
	public void DisplayCurrentTitle(){ // Displays a formatted version of the current location name.
		System.out.println("Current Location: " + this.playerLocation.GetTitle());
	}
	
	public void DisplayDestinationTitle(){ // Displays a formatted version of the destination location title.
		System.out.println("Destination Location: " + this.playerDestination.GetTitle());
	}
	
	public boolean ToSamePlace(String UserDefinedLocation){ // Sanity check that makes sure the player doesn't choose the same location.
		if(UserDefinedLocation.contains(this.playerLocation.GetTitle())){
			return true;
		} else {
			return false;
		}
	}
}