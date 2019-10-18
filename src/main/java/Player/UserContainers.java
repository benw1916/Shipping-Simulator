package main.java.Player;

import main.java.Abstract.Abstract;

import java.util.ArrayList;

class ContainerSlip{
	private String port;
	private String type;
	private int count;
	private double price;

// ******** Container Initializer **********
	public ContainerSlip(String passedPort, String passedType, int passedCount, double passedPrice){
		setPort(passedPort);
		setType(passedType);
		setCount(passedCount);
		setPrice(passedPrice);
	}
// ****** Data setters ************
	public void setPort(String passedPort){
		this.port = passedPort;
	}
	
	public void setType(String passedType){
		this.type = passedType;
	}
	
	public void setCount(int passedCount){
		this.count = passedCount;
	}
		
	public void setPrice(double passedDouble){
		this.price = passedDouble;
	}

// ********* Data returns ***********
	public String getPort(){
		return this.port;
	}

	public String getType(){
		return this.type;
	}

	public int getCount(){
		return this.count;
	}

	public double getPrice(){
		return this.price;
	}

// ******* Increase / Decrease Count *******
	public void increaseCount(int passedCount){
		this.count += passedCount;
	}
	
	public void decreaseCount(int passedCount){
		increaseCount((-1) * passedCount);
	}
	
// ******** Display price ************
	public String displayPrice(){
		String roundPrice = "" + Abstract.roundValue(this.price);
		return "$" + roundPrice;
	}	
}

class Refrigeration{ // This controls whether the user has refrigeration functionality.
	private boolean state;
	
// ******* Initializer ************
	public Refrigeration(){
		this.state = false;
	}
	
	public Refrigeration(boolean passedState){
		setRefrigeration(passedState);
	}
	
// ******* Getter and Setter *******
	public void setRefrigeration(boolean passedState){
		this.state = passedState;
	}
	
	public boolean getRefrigeration(){
		return this.state;
	}
}

class Crane{ // Not yet initialized 
	private int count; // Number of cranes on your ship
	
// ******* Initializer ************
	public Crane(){
		this.count = 0;
	}
	
	public Crane(int passedValue){
		setCount(passedValue);
	}

// ****** Getter and Setter *******
	public int getCount(){
		return this.count;
	}
	
	public void setCount(int passedValue){
		this.count = passedValue;
	}

// ***** Increase or Empty Functions ************
	public void increaseCrane(){
		this.count++;
	}
	
	public void emptyCraneCount(){
		this.count = 0;
	}
}

enum HaulerType{containers, bulk, refrigeration, dredger, tug, heavyLift}

public class UserContainers extends UserSailors{ // Class controls the containers on the ship.  I don't know if it's the way I daisy-chained the classes together is correct, but it works.
	private int maximumContainers; // Controls the maximum containers you can load on the ship.
	private Refrigeration refrigeration = new Refrigeration();// Does your ship have the equipment needed for refrigeration? // I should probably put an additional fuel cost involed with refrigeration usage.  
	private Crane crane = new Crane(); // Feature not implemented yet, cranes will either make you more money, or speed up loading/unloading.
	private ArrayList <ContainerSlip> containerSlip = new ArrayList<ContainerSlip>(); // Improved method that holds the user's containers
	private HaulerType haulerType;
	
	public UserContainers(){
		this.haulerType = HaulerType.containers;
	}
	
	public void SetMaximumContainers(int userDefinedMaxContainers){ // Sets the maximum containers to the passed value.
		this.maximumContainers = userDefinedMaxContainers;
	}
	
	public void IncreaseSpecificContainerCount(int passedContainerType, int passedContainerCount){
		this.containerSlip.get(passedContainerType).setCount(this.containerSlip.get(passedContainerType).getCount() + passedContainerCount);
	}

	public void DecreaseSpecificContainerCount(int passedContainerType, int passedContainerCount){ 
		this.containerSlip.get(passedContainerType).setCount(this.containerSlip.get(passedContainerType).getCount() - passedContainerCount);
	}

// ***** Container Slip Modifiers ***********
// *** Setters ****
	public void setContainerSlip(String passedPort, String passedType, int passedCount, double passedPrice){
		this.containerSlip.add(new ContainerSlip(passedPort, passedType, passedCount, passedPrice));
	}
	
// *** Getters ****
	public String getContainerPort(int passedValue){
		return this.containerSlip.get(passedValue).getPort();
	}
	
	public String getContainerType(int passedValue){
		return this.containerSlip.get(passedValue).getType();
	}
	
	public int getContainerCount(int passedValue){
		return this.containerSlip.get(passedValue).getCount();
	}

	public double getContainerPrice(int passedValue){
		return this.containerSlip.get(passedValue).getPrice();
	}

	public int getContainerSlipSize(){
		return this.containerSlip.size();
	}
	
	/*public ContainerSlip getContainerSlip(int passedValue){
		return this.containerSlip.get(passedValue);
	}*/

// *********** Container Boolean Sanity Checks ***************	
	private boolean isContainerSlipEmpty(){
		if (this.containerSlip.size() == 0){
			return true;
		} else {
			return false;
		}
	}

	public void decreaseContainerSlips(int containerType, int containerCount){
		if(isContainerSlipEmpty()){
			System.out.println("\nFailure.  You do not have any containers to remove.\n");
		} 
		if(containerType > this.containerSlip.size()){
			System.out.println("\nYou have entered an invalid choice.\n");
		}else {
			this.containerSlip.get(containerType).decreaseCount(containerCount);
			//displayMoneyIncrease(containerCount, getContainerPrice(containerType));
		}
	}
	
	public boolean IsEmptyShip(){ // Returns true if the containers are empty, and false if there are containers on the ship
		if(getContainerCount() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFullShip(){ // Returns true if the player ship is full.  
		if(getContainerCount() == this.maximumContainers){
			return true;
		} else {
			return false;
		}
	}
	
	private boolean moreThanAllowedContainers(int passedCount){
		int totalCount = 0;
		if(this.containerSlip.size() == 0){
			return false;
		}
		for(int i = 0; i < this.containerSlip.size(); i++){
			totalCount += this.containerSlip.get(i).getCount();
		}
		totalCount += passedCount;
		if(totalCount > this.maximumContainers){
			return true;
		} else{
			return false;
		}
	}

// ************* Container Slip Formatting Functions ****************
	public void displaySingleContainerSlipQuantity(int passedValue){
		System.out.println(Abstract.addPadding((passedValue + 1) + ". - " + this.containerSlip.get(passedValue).getType(), 1, 4) + " -- " + Abstract.addPadding(this.containerSlip.get(passedValue).getPort(), 2, 2) + " -- " + Abstract.addPadding("" + this.containerSlip.get(passedValue).getCount(), 3, 5) + " -- " + Abstract.addPadding(this.containerSlip.get(passedValue).displayPrice(), 5, 2));
	}	
	
	public void DisplayContainerOverview(){ // Displays the maximum containers allowed on board, and the container count on the ship currently.
		displayMaximumContainers();
		DisplayCurrentContainers();
	}
	
	public void DisplayCurrentContainers(){ // Displays a presentable version showing the current container count.
		System.out.println("Current container load: " + getContainerCount());
	}
	
	public int getContainerCount(){ // Returns the total container count aboard the ship.
		int containerCount = 0;
		for(int i = 0; i < this.containerSlip.size(); i++){
			containerCount += this.containerSlip.get(i).getCount();
		}
		return containerCount;
	}
	
// ************* Container Slip Heavier Functions *****************
	public void checkContainerSlips(String passedPort, String passedType, int passedCount, double passedPrice){ 
		boolean portCompare = false;
		boolean typeCompare = false;
		if(moreThanAllowedContainers(passedCount)){
			System.out.println("Failure.  You are attempting to load more than your ship can handle.");
		}
		if(isContainerSlipEmpty()){
			setContainerSlip(passedPort, passedType, passedCount, passedPrice);
		} else {
			for(int i = 0; i < this.containerSlip.size(); i++){
				if(this.containerSlip.get(i).getPort().equals(passedPort)){
					portCompare = true;
				}
				if(this.containerSlip.get(i).getType().equals(passedType)){
					typeCompare = true;
				}
			}
			if(portCompare == true && typeCompare == true){
				for(int x = 0; x < this.containerSlip.size(); x++){
					if(this.containerSlip.get(x).getPort().equals(passedPort) && this.containerSlip.get(x).getType().equals(passedType)){
						this.containerSlip.get(x).increaseCount(passedCount);
					}
				}
			} else {
				setContainerSlip(passedPort, passedType, passedCount, passedPrice);
			}
		}
	}
	
	public void removeEmptySlip(){ // Checks for empty containerslips, and will remove them from the ship.
		for(int i = 0; i < this.containerSlip.size(); i++){
			if(this.containerSlip.get(i).getCount() == 0){
				this.containerSlip.remove(i);
			}
		}
	}
	
	public void displayContainerSlipQuantity(){ // An iterative loop that displays all the container types that can be aboard.  
		System.out.println(Abstract.addPadding("--- Containers Aboard ---", 18, 0));
		System.out.println(Abstract.addPadding("# - Container Type --    Port    -- Container Count -- Price Per Container", 1, 0));
		if(this.containerSlip.size() == 0){
			System.out.println(Abstract.addPadding("You do not have any containers loaded.", 10, 0));
		}
		else if(this.containerSlip.size() >= 1){
			for(int i = 0; i < this.containerSlip.size(); i++){
		//		System.out.println(this.containerSlip.get(i).getType() + " -- " + this.containerSlip.get(i).getPort() + " -- " + this.containerSlip.get(i).getCount() + "" +" -- " + this.containerSlip.get(i).displayPrice());
				displaySingleContainerSlipQuantity(i);
			}
		//for(int i = 0 ; i < this.userQuantities.length(); i++){
		//	System.out.println(" " + UserContainers.ModifyContainerLength(this.userQuantities.getName(i)) + "    --    " + this.userQuantities.getQuantity(i));
		}
		System.out.println("\n");
	}
	
	
// *********** Hauler Type ****************
	public void setHaulerType(String passedType){
		if(passedType.equals("containers")){
			this.haulerType = HaulerType.containers;
		}
		if(passedType.equals("bulk")){
			this.haulerType = HaulerType.bulk;
		}
		if(passedType.equals("refrigeration")){
			this.haulerType = HaulerType.refrigeration;
		}
		if(passedType.equals("dredger")){
			this.haulerType = HaulerType.dredger;
		}
		if(passedType.equals("tug")){
			this.haulerType = HaulerType.tug;
		}
		if(passedType.equals("heavyLift")){
			this.haulerType = HaulerType.heavyLift;
		}
	}
	
	public String getHaulerType(){
		return "" + this.haulerType;
	}
	
// ******** Refrigeration Functions *************
	public void setRefrigeration(boolean passedState){ // When this function is run, refrigeration is either toggled on or off.
		this.refrigeration.setRefrigeration(passedState);
	}

	public boolean getRefrigeration(){ // Returns whether the ship can move refrigeration containers.
		return this.refrigeration.getRefrigeration();
	}
	
// ******* Crane Functions ****************
// ***** Crane Getter ******
	public int getCraneCount(){ // Returns the count of cranes you have aboard.
		return this.crane.getCount();
	}

	public void increaseCraneCount(){ // If the player decides to install a crane, this increases the count by one.
		this.crane.increaseCrane();
	}

// **************** Maximum Containers *************
// ***** Container Getter ***********
	public int getMaximumContainers(){ // Returns the maximum container value.
		return this.maximumContainers;
	}
	
	public void displayMaximumContainers(){ // Displays a presentable version showing the maximum containers allowed.
		System.out.println("Max Containers: " + this.maximumContainers);
	}
	
//	public String DisplayContainerCount(){ // Displays the container count in a more presentable form.
//		return "Total containers: " + GetContainerCount();
//	}
	
//	public void DisplayContainerQuantityAndPrice(){ // Passes the displayname and price from userQuantities.
//		this.userQuantities.displayNameAndPrice();
//	}
}