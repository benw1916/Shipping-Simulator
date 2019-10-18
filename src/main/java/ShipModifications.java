package main.java;
import main.java.Player.*;
import main.java.Abstract.*;
import main.java.Ship.Ship;

enum shipCategory{smallFeeder, feeder, feederMax, Panamax, Suezmax, chinamax, Seawaymax, specialty}

public class ShipModifications{

	public ShipModifications(Ship playerObject){
		modificationArea(playerObject);
	}

	public void modificationArea(Ship playerObject){
		int modificationChoice = 0;
		System.out.print("What area of the ship would you like to modify: ");
		do{
			Abstract.RotateOptionsWithEscapement(MenuDisplays.getShipAreas()); //"Hull", "Engine", "Exterior", "Loading Area", "Interior", "Ship upgrade"
			System.out.print(": ");
			modificationChoice = parseModificationMenu(playerObject, Abstract.ScannerInt());
		}while(modificationChoice >= 6);
	}

	private int parseModificationMenu(Ship playerObject, int userDecision){
	/*	Map<Integer, Runnable> modificationMenu = new HashMap<>();
		modificationMenu.put(1, () -> 
		modificationMenu.put(2, () ->
		modificationMenu.put(3, () -> 
		modificationMenu.put(4, () -> 
		modificationMenu.put(5, () -> ;
		//shoreMenu.put(4, () -> new GlobalContainerPrices()); // Jumps to Global Ports and prices.
		
		if(userDecision <= 6 && userDecision > 0){
			shoreMenu.get(userDecision).run();
		} 
		return userDecision;*/
		return -1;
	}

}