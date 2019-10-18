package main.java;

import main.java.Containers.LoadUnloadContainers;
import main.java.Player.*;
import main.java.Properties.PropertiesReader;
import main.java.Ship.Ship;

import javax.swing.*;
import java.util.ArrayList;

public class PrimaryLoop{

	Ship playerObject;
	LoadUnloadContainers shoreContainers;
	Movement move;
	//AvailablePorts ports;
	GameMap gameBoard;
	AvailablePorts allPorts;
	WindowManager displayWindow;
	
	public PrimaryLoop(WindowManager mainWindow){
		this.displayWindow = mainWindow;
		InitializePlayer();
		this.gameBoard = new GameMap();
		this.allPorts = gameBoard.portLocations;
		this.playerObject.SetLocation(allPorts.GetPort(0).GetCity());
		//InitializePorts();
		IterativeFunction();

	}

	public void IterativeFunction(){
		//System.out.print(this.playerObject.GetLocation());

		//.while(true){
			this.shoreContainers = new LoadUnloadContainers(playerObject, allPorts, gameBoard, displayWindow);
			this.move = new Movement(this.allPorts);
			displayWindow.OverwriteStatPanelText(this.playerObject.GetShipStatistics());

			displayWindow.UpdateDateText(this.gameBoard.GetDate());
			displayWindow.AppendArrayToMap(this.gameBoard.gameboard);
		//	this.shoreContainers.Iteration(this.playerObject, displayWindow);
		//	this.move.currentLocationAndDestination(this.playerObject, displayWindow);
			//this.portDecision.iteration(this.playerObject);
		//	this.move.iteration(this.playerObject); // , portDecision*/);
		System.out.println("Fell out");
		//}
	}
		
	public void InitializePlayer(){
		//this.playerObject = new Boat("USS Enterprise");
		this.playerObject = new Ship.Builder("USS Enterprise").Containers().IMO().Engine().Sailors().build();
		displayWindow.AppendUpdateTab("Player ship created!" + System.lineSeparator());
	}
	
/*	public void InitializePorts(){
		final int intialPortsAvailable = 3;
		ArrayList<String> portLongitudes = new PropertiesReader().readProperties("src/main/java/Properties/PortLongitude.properties", intialPortsAvailable);
		ArrayList<String> portLatitudes = new PropertiesReader().readProperties("src/main/java/Properties/PortLatitude.properties", intialPortsAvailable);
		ArrayList<String> portNames = new PropertiesReader().readProperties("src/main/java/Properties/PortNames.properties", intialPortsAvailable);
		this.ports = new AvailablePorts(portNames, portLongitudes, portLatitudes, intialPortsAvailable);
	}*/
}