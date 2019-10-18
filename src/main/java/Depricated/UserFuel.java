package main.java.Depricated;/*package src.main.java.Player;
import src.main.java.*;
import java.lang.Math;

enum engineType {diesel, bunker, lowSulfur} // Not currently implemented; ship engines will require certain fuel, and fuel cost will differ.

public class UserFuel extends UserLocation{
	private double currentFuel; //Double value that holds the current amount of fuel aboard.
	private double maximumFuel; //Double value that holds the maximum fuel allowed aboard.
	//private double fuelConsumption; // double value that controls the fuel consumption.

	private final static int fuelPriceChange = 15; //I don't think this is completely implemented.
	
	public UserFuel(){ // Constructor that sets the current and maximum fuel to 140; this is sort of a placeholder.
		this.currentFuel = 140; 
		this.maximumFuel = 140;
	//	this.fuelPrice = 343;
		
		// Bunker fuel price per ton $343
		//Burns 1.2 tons per day
		//Max Fuel capacity 140 tons
	}

	public UserFuel(double userDefinedFuel){ // Constructor that sets both the maximum and current fuel to the same number; this is how this constuctor is generally used.
		this.currentFuel = userDefinedFuel;
		this.maximumFuel = userDefinedFuel;
	}
	
	public UserFuel(double userDefinedCurrentFuel, double userDefinedMaxFuel){//, double UserDefinedFuelPrice){ // Constructor that takes in two doubles, and sets current and maximum fuel amount.
		this.currentFuel = userDefinedCurrentFuel;
		this.maximumFuel = userDefinedMaxFuel;
	}

	public void DecreaseFuel(double fuelUsage){ // Decreases the fuel amount by the passed fuel usage value. 
		//Abstract.DecreaseValue(this.currentFuel, fuelUsage);
		this.currentFuel -= fuelUsage;
	}
	
	public void DecreaseFuel(){ // Decreases fuel amount by the standard fuel consumption value.
		//Abstract.DecreaseValue(this.currentFuel, this.fuelConsumption);
		this.currentFuel -= getFuelConsumption();
	}

	public void IncreaseFuel(int fuelUsage){ // Increase fuel amount by the passed fuel usage value. 
		//Abstract.IncreaseValue(this.currentFuel, fuelUsage);
		this.currentFuel += (double)fuelUsage;
	}
	
	public void IncreaseFuel(double fuelUsage){ // Increase fuel amount by the passed fuel usage value. 
		//Abstract.IncreaseValue(this.currentFuel, fuelUsage);
		this.currentFuel += fuelUsage;
	}
	
	public void IncreaseFuel(){ // Increase fuel amount by the standard fuel consumption value.
		//Abstract.IncreaseValue(this.currentFuel, this.fuelConsumption);
		this.currentFuel += getFuelConsumption();
	}
	
	public void SetCurrentFuel(int userDefinedFuel){ // Sets the current fuel value by a passed integer.  The integer is converted to a double.  
		this.currentFuel = (double)userDefinedFuel;
	}
	
	public void SetCurrentFuel(double passedUserFuel){ // Sets the current fuel value by a passed double.
		this.currentFuel = passedUserFuel;
	}

	/*public void SetFuelConsumption(double userDefinedConsumption){ // Sets the fuel consumption value by a passed double.
		this.fuelConsumption = userDefinedConsumption;
	}*/
	
	/*public void SetMaximumFuel(int userDefinedFuel){ // Sets the maximum fuel value by a passed integer.  The integer is converted to a double.
		this.maximumFuel = (double)userDefinedFuel;
	}
	
	public void SetMaximumFuel(double userDefinedFuel){ // Sets the maximum fuel value by a passed double.  
		this.maximumFuel = userDefinedFuel;
	}

	public double GetCurrentFuel(){ // Returns current fuel value; is a rounded value.  
		return Math.round(this.currentFuel);
	}

	public double GetMaximumFuel(){ // Returns maximum fuel value that's rounded.
		return Math.round(this.maximumFuel);
	}
	
	public double GetFuelConsumption(){ // Returns the fuel consumption value that has been rounded.
		return Math.round(getFuelConsumption());
	}
	
	public String GetFuelPercentage(){ // Returns a percentage value of the fuel available on the ship.
		return Math.round((((GetCurrentFuel() / GetMaximumFuel()) * 100) * 100d) / 100d) + "%";
	}
	
	public void DisplayFuelPercentage(){ // Returns the current fuel value over the maximum fuel value.
		System.out.println(GetCurrentFuel() + " / " + GetMaximumFuel());
	}
	
	public void DisplayFormattedFuelPercentage(){ // Displays the fuel percentage with formatting.  
		System.out.println("Fuel: " + GetFuelPercentage());
	}
	
	public void DisplayFuelConsumption(){ // Displays the fuel consumption value with formatting.
		System.out.println("Fuel Consumption: " + GetFuelConsumption());
	}

	public void DisplayMaximumFuel(){ // Displays the maximum fuel value with formatting.
		System.out.println("Maximum Fuel: " + GetMaximumFuel());
	}
	
	public void DisplayCurrentFuel(){ // Displays the current fuel value with formatting.
		System.out.println("Current Fuel: " + GetCurrentFuel());
	}
	
	public void DisplayFuelGauge(){ // Displays a easily read fuel gauge.  '#' means available, and ' ' is blank.
		char fuelCharacter = '#';
		char emptyCharacter = ' ';
		System.out.print("E |");
		for(int i = 0; i < 11; i++){
			//System.out.println("║           ║");
			if(((GetCurrentFuel() / GetMaximumFuel()) * 11) >= i){
				System.out.print(fuelCharacter);
			} else {
				System.out.print(emptyCharacter);
			}
		}
		System.out.println("| F");
		System.out.println("  |=====|=====|  ");
	}
		
	private double getVariedFuelConsumption(){ // Not sure this is implemented completely yet; This varies the amount of fuel consumed each run.
		//Abstract.IncreaseDecrease();
		if(Abstract.GetRandomValue(100, 0) > 51){
			return GetFuelConsumption() + (Abstract.GetRandomValue(20, 0) * .010);
		} else {
			return GetFuelConsumption() - (Abstract.GetRandomValue(20, 0) * .010);
		}
	}
	
	public void FuelMeasureAndConsumption(Boat playerObject){ // This is a sanity check, if OutOfFuel is true, then a random occurrence occurs, and if it's false, then fuel consumption is run.
		if(IsOutOfFuel() == false){
			DecreaseFuel(getVariedFuelConsumption());
		} else{
			new RandomEvent().noFuel(playerObject);
		}
	}

	private boolean FullFuelTank(){ // This is another sanity check, it checks whether the fuel tank is full.
		if(this.currentFuel >= this.maximumFuel){
			return true;
		}
		return false;
	}
	
	public boolean IsOutOfFuel(){ // Another sanity check, checks whether the fuel tanks are empty.
		if(this.currentFuel <= 0){
			this.currentFuel = 0;
			return true;
		}
		return false;*/
			/*System.out.println("Out of fuel");*/
//	}
	
/*	private void IncreaseDecreaseFuelPrice(){
		this.fuelPrice += Abstract.IncreaseDecrease(fuelPriceChange);
		/*int dailyUpDown = Abstract.GetRandomValue(100);
		if(dailyUpDown >= 51){
			this.fuelPrice += Abstract.GetRandomValue(fuelPriceChange);
		} else{
			this.fuelPrice -= Abstract.GetRandomValue(fuelPriceChange);
		}
	}*/

//}