package main.java;

import main.java.Graphics.MovementGraphics;
import main.java.Player.*;
import main.java.Abstract.*;
import main.java.Containers.*;
import main.java.Ship.Ship;

public class Movement{
	private DistanceCalculation MovementDistanceCalculation;
	AvailablePorts portChoices;
	private int PortDistance;
	WindowManager window;

	public Movement(AvailablePorts allPorts){
		this.portChoices = allPorts;
	}

	//*****************************************************
	public void currentLocationAndDestination(Ship playerObject, WindowManager wm){
		this.window = wm;
		int portChoice = 0;
		do{
		//	playerObject.DisplayCurrentTitle();
			//Abstract.RotateArrayList(portChoices.GetPort(0, 5));
			StringBuilder locationList = new StringBuilder();
			for(int iterativeCount = 0; iterativeCount < portChoices.GetPort(0, 5).size(); iterativeCount++){
				locationList.append((iterativeCount + 1) +  ". " + portChoices.GetPort(iterativeCount) + System.lineSeparator());
			}
			wm.AppendUpdateTab(locationList + ":");
			//System.out.print(": ");
			portChoice = Abstract.ScannerInt();
		}while((portChoice-1) >= portChoices.GetSize() - 1);
		//	SetDestinationAndCurrentPort(portChoice);
		changeCurrentAndDestination(playerObject, portChoice - 1);
		
	}
	
	//private void SetDestinationAndCurrentPort(int destinationPort){
	//	playerObject.GetCurrentName();
	//	playerObject
		//this.currentPort = this.destinationPort;
		//this.destinationPort = MenuDisplays.GetPortName(destinationPort - 1);
	//}
	
/*	public void changeCurrentAndDestination(Boat playerObject){
		this.currentPort = this.destinationPort;
		playerObject.SetCurrentLocation(this.destinationPort);
		this.destinationPort = null;
	}*/
		
	//*****************************************************
	
	public void iteration(Ship playerObject/*, PortChoice pc*/){
		//this.DeparturePort = null;
		//this.ArrivalPort = null;
		//this.DeparturePort = new LongitudeLatitude(playerObject.GetCurrentLocationLongitude(), playerObject.GetCurrentLocationLatitude());
//		this.DeparturePort = new LongitudeLatitude.Builder()
	//		.longitude(playerObject.GetCurrentLongitude())
//			.latitude(playerObject.GetCurrentLatitude())
//			.build();
		//this.ArrivalPort = new LongitudeLatitude(pc.getDestinationPort());
//		this.ArrivalPort =  new LongitudeLatitude.Builder()
//			.longitude(Abstract.compareStringToTableToDouble(/*pc.getDestinationPort(),*/playerObject.GetDestinationName(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLongitude()))
//			.latitude(Abstract.compareStringToTableToDouble(/*pc.getDestinationPort(),*/ playerObject.GetDestinationName(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLatitude()))
//			.build();
		//this.ArrivalPort =  new LongitudeLatitude(Abstract.compareStringToTableToDouble(pc.getDestinationPort(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLatitude()), Abstract.compareStringToTableToDouble(pc.getDestinationPort(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLongitude()));
		
		this.MovementDistanceCalculation = new DistanceCalculation(playerObject.GetCurrentCoordinates(), playerObject.GetDestinationCoordinates());
		this.PortDistance = this.MovementDistanceCalculation.GetDistanceCalculation();
		//this.UserSpeed = playerObject.GetShipSpeed();
		seaTravel(playerObject);
		changeCurrentAndDestination(playerObject);
	}
	
	private void changeCurrentAndDestination(Ship playerObject, int portChoice){
		playerObject.SetLocation(playerObject.GetDestination());
		//playerObject.SetCurrentLocation(this.destinationPort);
		//this.destinationPort = null;
	//	playerObject.SetDestination(AvailablePortNames.getPortName());//MenuDisplays.GetPortName(portChoice));
	}
	
	private void changeCurrentAndDestination(Ship playerObject){
		playerObject.SetLocation(playerObject.GetDestination());
		playerObject.SetDestination(null);
	}

	private static String DisplayDayAtSeaAndDate(Ship playerObject, int dayCount, int DistanceTraveled){
		return System.lineSeparator() + "Day " + (dayCount + 1) + ". " + DisplayDistanceTraveled(DistanceTraveled);
		// +  playerObject.GetAndIncreaseDate() + ". ");

	}

	private static String DisplayDistanceTraveled(int DistanceTraveled){
		return "You have traveled " + DistanceTraveled + " miles." + System.lineSeparator();
	}

	private void seaTravel(Ship playerObject){ //This is the core of the class, this controls movement.
		int DistanceTraveled = 0;
		int dayCount = 0;
		while(this.PortDistance >= DistanceTraveled){
			new RandomEvent().RandomOccurrence(playerObject);
			DistanceTraveled += Abstract.GetRandomizedDistancePerDay(playerObject.GetKnots()); // I want to change this to be affected by temperature and weather.
			DisplayDayAtSeaAndDate(playerObject, dayCount, DistanceTraveled);
		//	playerObject.FuelMeasureAndConsumption();
			new MovementGraphics(DistanceTraveled, this.PortDistance);
			//playerObject.DisplayFormattedFuelPercentage();
			MovementGraphics.displayFuelGauge(playerObject);
			dayCount++;
		}
		System.lineSeparator();
		System.lineSeparator();
		System.lineSeparator();
	}
}