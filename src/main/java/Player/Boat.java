package main.java.Player;
import main.java.*;

// Boat -> UserMoney -> UserLocation -> UserEngine -> UserContainers -> UserSailor -> UserDamage -> ShipState

enum HullMaterial{SingleSteel, DoubleSteel, fiberglas}

public class Boat extends UserMoney {
	private String userName;
	//private DateDisplay userDate; //I don't completely like that the date is in the player object, I may move it to the port objects.
	private ShipState sc;
	private HullMaterial hullmaterial;
	
	public Boat(String userDefinedName){ // Creates the player's ship.
		//this.userDate = new DateDisplay();
		this.sc = new ShipState("Boat");
		SetShipName(userDefinedName);
		SetMaximumContainers(UpgradePath.getDefaultUserShip(0));

		initalizeEngine("Samsung 1000HP", "diesel", 12.0, 6.0, 140, 1.5);
		SetDefaultLocation(); // Located on UserLocation
		GetUserReadout();
	}
	
	/*public Boat(String userDefinedName){ // Constructor; If the application uses this constructor, something has broken.  Disabled because it may not have a use
		this.userName = userDefinedName;
		System.err.println("\n\n Uh oh, something broke. \n\n\n");
	}*/
	
	public String getHullMaterial(){
		return "" + this.hullmaterial;
	}
	
	public void SetShipName(String userDefinedName){ // Takes user input for ship name. This really isn't modified by the user, but can be.  
		this.userName = userDefinedName;
	}
	
	/*public void increaseDay(){ // A passthrough to increase the date.
		this.userDate.increaseDay();
	}

	public String GetDate(){ // A passthrough that returns the date.
		return this.userDate.getDate();
	}*/
	
/*	public LocalDate returnDate(){
		return this.userDate.returnDate();
	}
	
	public void setStartDate(int passedValue){ 
		this.PlayerSailors.get(passedValue).setStartDate(GetDate());
	}
	
	public void DisplayDate(){ //Still a passthrough, but displays the date.
		System.out.print(this.userDate.getDate());
	}
	
	public void DisplayFormattedDate(){ // A passthrough that displays the date in a formatted manner.
		System.out.println("Date: " + this.userDate.getDate());
	}
	
	public String GetAndIncreaseDate(){ // A passthrough that increases the date and returns the date.
		this.userDate.increaseDay();
		return this.userDate.getDate();
	}*/

	public String getShipName(){ // Returns the ship name
		return this.userName;
	}

	public void displayShipName(){ // Displays the ship name in a more presentable format.  
		System.out.println("Name: " + getShipName());
	}
	
	public void GetUpgradeReadout(){ // Displays ship speed and container quantity in a presentable format.  
		displayAverageKnots();
		displayMaximumContainers();
	}
	
	public void GetShortUserReadout(){ // Returns formatted date and current location.
		//DisplayFormattedDate();
		DisplayCurrentTitle();
	}

	public void GetUserReadout(){ // Returns a myriad of ship statistics.
		//DisplayFormattedDate();
		displayShipName();
		displayAverageKnots();
		displayMaximumContainers();
		DisplayMoney();
		System.out.println();
	}

}
