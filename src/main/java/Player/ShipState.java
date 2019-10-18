package main.java.Player;

import java.util.ArrayList;

class Health{
	private String title;
	private int currentHealth;
	private int maximumHealth;
	
	public Health(String passedName){
		this.title = passedName;
		this.currentHealth = 100;
		this.maximumHealth = 100;
	}
	
	public Health(String passedName, int passedMaximumHealth){
		this.title = passedName;
		this.currentHealth = passedMaximumHealth;
		this.maximumHealth = passedMaximumHealth;
	}
	
	public Health(String passedName, int passedMaximumHealth, int passedCurrentHealth){
		this.title = passedName;
		this.currentHealth = passedCurrentHealth;
		this.maximumHealth = passedMaximumHealth;
	}
	
	public void setTitle(String passedTitle){
		this.title = passedTitle;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setMaximumHealth(int passedValue){
		this.maximumHealth = passedValue;
	}
	
	public void decreaseCurrentHealth(){
		this.currentHealth -= 10;
	}
	
	public void decreaseCurrentHealth(int passedValue){
		this.currentHealth -= passedValue;
	}
	
	public int getMaximumHealth(){
		return this.maximumHealth;
	}
	
	public void setCurrentHealth(int passedValue){
		this.currentHealth = passedValue;
	}
	
	public int getCurrentHealth(){
		return this.currentHealth;
	}
	
}

public class ShipState{
	private ArrayList<Health> objectHealth = new ArrayList<Health>();
	private static final String[] shipParts = {"Bridge", "Engine", "Hull", "Crew Quarters", "Fuel Tank"};
	private static final String[] portPortions = {"Crane", "Dock", "Fuel Tanks", "Management Office", "Train services", "Semi truck services"};
	private String[] additionalParts = {}; // Add additional parts here.
	
	public ShipState(String passedObject){
		if(passedObject == "ship"){ // Used a factory for this portion, if ship, it uses the ship parts.
			for(int i = 0; i < this.shipParts.length; i++){
				this.objectHealth.add(new Health(this.shipParts[i]));
			}
		}
		if(passedObject == "port"){
			for(int i = 0; i < this.portPortions.length; i++){
				this.objectHealth.add(new Health(this.portPortions[i]));
			}
		}
	}
	
	public ShipState(){ // This defaults to ship.
		for(int i = 0; i < this.shipParts.length; i++){
			this.objectHealth.add(new Health(this.shipParts[i]));
		}

	}
	
	public String getSectionName(int passedValue){
		return this.objectHealth.get(passedValue).getTitle();
	}
	
	public int getSectionMaximumHealth(String passedName){
		for(int i = 0; i < shipParts.length; i++){
			if(passedName == this.shipParts[i]){
				getSectionMaximumHealth(i);
			}
			
		}
		return -1;
	}
	
	public void decreaseCurrentHealth(int passedValue){ // Decreases health of a specific piece, by 10. 
		this.objectHealth.get(passedValue).decreaseCurrentHealth();
	}
	
	public void decreaseCurrentHealth(int passedValue, int passedHealth){ // Decreases health value of a specific piece by second passed value.  
		this.objectHealth.get(passedValue).decreaseCurrentHealth(passedHealth);
	}
	
	public int getSectionMaximumHealth(int passedValue){ // Returns the maximum health for requested section.
		return this.objectHealth.get(passedValue).getMaximumHealth();
	}
	
	public int getSectionCurrentHealth(String passedName){
		for(int i = 0; i < this.shipParts.length; i++){
			if(passedName == this.shipParts[i]){
				getSectionCurrentHealth(i);
			}
			
		}
		return -1;
	}
	
	public int getSectionCurrentHealth(int passedValue){ // Returns the current health value of your requested piece.
		return this.objectHealth.get(passedValue).getCurrentHealth();
	}
	
	public String displayHealthPercentage(int passedValue){ //Performs simple division and presents the data as a percentage.
		return ((this.objectHealth.get(passedValue).getCurrentHealth() / this.objectHealth.get(passedValue).getMaximumHealth()) * 100) + "%";
	}
	
	public void displayHealthGauge(int passedValue){ // An experimental health gauge design.
		int portionCurrentHealth = getSectionCurrentHealth(passedValue);
		int portionMaximumHealth = getSectionMaximumHealth(passedValue);
		int healthValue = (portionCurrentHealth / portionMaximumHealth) * 10;
		System.out.println("__");
		//System.out.print(  "|");
		int iterative = 0;
		for(int x = 0; x < 10; x++){
			for(int i = 0; i < 2; i++){
				System.out.print("|");
					if(healthValue >= iterative){
						System.out.println("#");
					} else{
						System.out.println(" ");
					}
				}
			}
		System.out.println("__");
	}
	
	
	public boolean isHealthAvailable(int passedValue){ // Pass one piece through this boolean gate, and it will return true or false.  
		if(getSectionCurrentHealth(passedValue) <= 0){
			return false;
		} else {
			return true;
		}
	}
	
	public boolean shipHealthCheck(){ // This checks all things with health in the array whether the health has hit zero.
		for(int i = 0; i < shipParts.length; i++){
			isHealthAvailable(i);
		}
		return false;
	}
	
}