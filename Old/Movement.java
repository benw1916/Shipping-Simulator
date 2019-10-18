package src.main.java;

import java.lang.Math;
import java.util.Hashtable;

public class Movement{

	private String DeparturePort;
	private double[] DeparturePortCoordinates = new double[2];
	private String ArrivalPort;
	private double[] ArrivalPortCoordinates = new double[2];
	private int PortDistance;
	/*** This isn't optimal at all, but I still haven't implemented geotagging ***/
	private double[] portLatitude = {33.754185, -33.858333,  22.287753};
	private double[] portLongitude = {-118.216458, 151.233333, 114.173619};
	private int UserSpeed;
	
	private double getPortLatitude(int userDefinedLocation){
		return portLatitude[userDefinedLocation];
	}
	
	private double getPortLongitude(int userDefinedLocation){
		return portLongitude[userDefinedLocation];
	}
	
	public void iteration(User playerObject, PortChoice pc){
		this.DeparturePort = pc.getCurrentPort();
		this.ArrivalPort = pc.getDestinationPort();
		//System.out.println(this.DeparturePort);
		//System.out.println(pc.getDestinationPort());
		convertPortNameToCoordinates();
		this.PortDistance = DistanceCalculation(this.DeparturePortCoordinates[1], this.DeparturePortCoordinates[0], this.ArrivalPortCoordinates[1], this.ArrivalPortCoordinates[0] );
		this.UserSpeed = playerObject.getSpeed();
		seaTravel();
		pc.changeCurrentAndDestination();
	}
	
	private void convertPortNameToCoordinates(){
		for(int i = 0; i < MenuDisplays.getAvailablePortsSize(); i++){
			if(this.DeparturePort.contains(MenuDisplays.getAvailablePortsNoOffset(i))){
				this.DeparturePortCoordinates[0] = this.getPortLatitude(i);
				this.DeparturePortCoordinates[1] = this.getPortLongitude(i);
			}
		}
		for(int i = 0; i < MenuDisplays.getAvailablePortsSize(); i++){
			if(this.ArrivalPort.contains(MenuDisplays.getAvailablePortsNoOffset(i))){
				this.ArrivalPortCoordinates[0] = this.getPortLatitude(i);
				this.ArrivalPortCoordinates[1] = this.getPortLongitude(i);
			}
	/*** I'll need to put in a Google Geotagging API here ***/
	/** Long beach: 33.754185, -118.216458
	Sydney: -33.858333, 151.233333
	Hong Kong: 22.287753, 114.173619 **/
		}
	}
	
	private double degreesToRadians(double degrees) {
		return degrees * Math.PI / 180;
	}
	
	private int getDistancePerDay(){
		return this.UserSpeed * 24;
	}
	
	private int getRandomizedDistancePerDay(){
		return Abstract.getRandomValue(this.UserSpeed, (this.UserSpeed / 2) )* 24;
	}
	
	private int DistanceCalculation(double originLon, double originLat, double destLon, double destLat){
	  double earthRadiusKm = 6371;

	  double dLat = degreesToRadians(destLat - originLat);
	  double dLon = degreesToRadians(destLon - originLon);

	  double lat1 = degreesToRadians(originLat);
	  double lat2 = degreesToRadians(destLat);

	  double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
			  Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
	  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
	  return (int)((earthRadiusKm * c) * 0.62137);
	}
	
	
	
	private void seaTravel(){
		int DistanceTraveled = 0;
		int dayCount = 0;
		while(this.PortDistance >= DistanceTraveled){
			DistanceTraveled += getRandomizedDistancePerDay();
			System.out.print("Day " + dayCount + ". You have traveled " + DistanceTraveled + " miles.\n");
			dayCount++;
		}
		System.out.println("\n\n\n");
	}
}