package main.java;

import java.lang.NullPointerException;

public class DistanceCalculation{
	private LongitudeLatitude originLocation;
	private LongitudeLatitude destinationLocation;

	public DistanceCalculation(){
		this.originLocation = new LongitudeLatitude.Builder().build();
		this.destinationLocation = new LongitudeLatitude.Builder().build();
	}
	
	public DistanceCalculation(LongitudeLatitude passedOriginCoordinates, LongitudeLatitude passedDestinationCoordinates){
		this.originLocation = new LongitudeLatitude.Builder()
			.longitude(passedOriginCoordinates.GetLongitude())
			.latitude(passedOriginCoordinates.GetLatitude())
			.build();
		this.destinationLocation = new LongitudeLatitude.Builder()
			.longitude(passedDestinationCoordinates.GetLongitude())
			.latitude(passedDestinationCoordinates.GetLatitude())
			.build();
		//this.destinationLocation = new LongitudeLatitude();
/*		this.originLocation.SetLongitude(passedOriginCoordinates.GetLongitude());
		this.originLocation.SetLatitude(passedOriginCoordinates.GetLatitude());
		this.destinationLocation.SetLongitude(passedDestinationCoordinates.GetLongitude());
		this.destinationLocation.SetLatitude(passedDestinationCoordinates.GetLatitude());*/
	}
	
	public void SetOriginLongitude(double passedOriginLongitude){
		this.originLocation.SetLongitude(passedOriginLongitude);
	}
	
	public void SetOriginLatitude(double passedOriginLatitude){
		this.originLocation.SetLatitude(passedOriginLatitude);
	}
	
	public void SetOriginLongitudeAndLatitude(double passedOriginLongitude, double passedOriginLatitude){
		this.originLocation.SetLongitude(passedOriginLongitude);
		this.originLocation.SetLatitude(passedOriginLatitude);
	}
	
	public void SetDestinationLongitude(double passedDestinationLongitude){
		this.destinationLocation.SetLongitude(passedDestinationLongitude);
	}
	
	public void SetDestinationLatitude(double passedDestinationLatitude){
		this.destinationLocation.SetLatitude(passedDestinationLatitude);
	}
	
	public void SetDestinationLongitudeAndLatitude(double passedDestinationLongitude, double passedDestinationLatitude){
		this.destinationLocation.SetLongitude(passedDestinationLongitude);
		this.destinationLocation.SetLatitude(passedDestinationLatitude);
	}
	
	public void SetOriginAndDestinationLongitudeAndLatitude(LongitudeLatitude passedOriginCoordinates, LongitudeLatitude passedDestinationCoordinates){
		this.originLocation.SetLongitude(passedOriginCoordinates.GetLongitude());
		this.originLocation.SetLatitude(passedOriginCoordinates.GetLatitude());
		
		this.destinationLocation.SetLongitude(passedDestinationCoordinates.GetLongitude());
		this.destinationLocation.SetLatitude(passedDestinationCoordinates.GetLatitude());
	}
	
	public double GetOriginLongitude(){ // Returns the origin longitude
		return this.originLocation.GetLongitude();
	}
	
	public double GetOriginLatitude(){ // Returns the origin latitude
		return this.originLocation.GetLatitude();
	}
	
	public double GetDestinationLongitude(){ // Returns the destination longitude
		return this.destinationLocation.GetLongitude();
	}
	
	public double GetDestinationLatitude(){ // Returns the destination latitude.
		return this.destinationLocation.GetLatitude();
	}
	
	public int GetDistanceCalculation(){ // Returns the distance calculation, bundled in a try-catch.  Will return an error if it doesn't work.
		try{
			return DistanceCalculation();
		}catch(NullPointerException npe){
			System.err.println("Uh oh, looks like a variable wasn't set: " + npe);
		}
		return 0;
	}
	
	private double degreesToRadians(double degrees) { // Converts degrees to radians
		return degrees * Math.PI / 180;
	}

	private int DistanceCalculation(){ //Returns the distance in maybe? miles?
		final double earthRadiusKm = 6371;

		/*double dLat = degreesToRadians(destLat - originLat);
		double dLon = degreesToRadians(destLon - originLon);

		double lat1 = degreesToRadians(originLat);
		double lat2 = degreesToRadians(destLat);*/
		
		double dLat = degreesToRadians(GetDestinationLatitude() - GetOriginLatitude());
		double dLon = degreesToRadians(GetDestinationLongitude() - GetOriginLongitude());

		double lat1 = degreesToRadians(GetOriginLatitude());
		double lat2 = degreesToRadians(GetDestinationLatitude());

		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		return (int)((earthRadiusKm * c) * 0.62137);
	}

}