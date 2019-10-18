package main.java.Player;
import main.java.*;
import main.java.Abstract.Abstract;

class Fuel{
	private double fuel;
	
	public Fuel(double passedFuel){
		setFuel(passedFuel);
	}
	
	public double getFuel(){
		return this.fuel;
	}
	
	public void setFuel(double passedFuel){
		this.fuel = passedFuel;
	}
	
	public void increaseFuel(double passedFuel){
		this.fuel += passedFuel;
	}
	
	public void decreaseFuel(double passedFuel){
		//this.fuel -= passedFuel;
		increaseFuel((-1) * passedFuel);
	}
	
}

enum FuelType {diesel, bunker, lowSulfur}

public class UserEngine extends UserContainers{
	private String engineName;
	private FuelType fuelType;
	private Fuel maxFuel;
	private Fuel currentFuel;
	private double fuelConsumption;
	private double highKnots;
	private double lowKnots;

// **************  Initializers *****************
	public void initalizeEngine(String passedName, String passedFuelType, double passedHighKnots, double passedLowKnots, double passedMaxFuel, double passedCurrentFuel, double passedFuelConsumption){
		setEngineName(passedName);
		setFuelType(passedFuelType);
		setHighKnots(passedHighKnots);
		setLowKnots(passedLowKnots);
		this.maxFuel = new Fuel(passedMaxFuel);
		this.currentFuel = new Fuel(passedCurrentFuel);
		setFuelConsumption(passedFuelConsumption);
	}
	
	public void initalizeEngine(String passedName, String passedFuelType, double passedHighKnots, double passedLowKnots, double passedMaxFuel, double passedFuelConsumption){
		setEngineName(passedName);
		setFuelType(passedFuelType);
		setHighKnots(passedHighKnots);
		setLowKnots(passedLowKnots);
		this.maxFuel = new Fuel(passedMaxFuel);
		this.currentFuel = new Fuel(passedMaxFuel);
		setFuelConsumption(passedFuelConsumption);
	}
	
// ************* Data setters ****************
	public void setEngineName(String passedName){
		this.engineName = passedName;
	}
	
	public void setFuelType(String passedType){ // Set fuel type.
		if(passedType.equals("diesel")){
			this.fuelType = FuelType.diesel;
		}
		if(passedType.equals("bunker")){
			this.fuelType = FuelType.bunker;
		}
		if(passedType.equals("lowSulfur")){
			this.fuelType = FuelType.lowSulfur;
		}
	}

	public void setMaxFuel(String passedFuel){
		setMaxFuel(Double.parseDouble(passedFuel));
	}
	
	public void setMaxFuel(double passedFuel){
		this.maxFuel.setFuel(passedFuel);
	}
	
	public void setCurrentFuel(String passedFuel){
		setCurrentFuel(Double.parseDouble(passedFuel));
	}
	
	public void setCurrentFuel(double passedFuel){
		this.currentFuel.setFuel(passedFuel);
	}
	
	public void setFuelConsumption(double passedValue){ // Set fuel consumption value, through double.
		this.fuelConsumption = passedValue;
	}
	
	public void setFuelConsumption(String passedString){ // Set fuel consumption Value, through String.
		this.fuelConsumption = Double.parseDouble(passedString);
	}
	
	public void setHighKnots(double passedValue){ // Set high knot value, through double.
		this.highKnots = passedValue;
	}

	public void setHighKnots(String passedString){ // Set high knot value, through string.
		this.highKnots = Double.parseDouble(passedString);
	}

	public void setLowKnots(double passedValue){ // Set low knots value, through double.
		this.lowKnots = passedValue;
	}

	public void setLowKnots(String passedString){ // Set low knots value, through string.
		this.lowKnots = Double.parseDouble(passedString);
	}

// ***********   Data grabbers ***************
	public String getEngineName(){ // Return engine name.
		return this.engineName;
	}
	
	public String getFuelType(){ // Return fuel type.
		return "" + this.fuelType;
	}

	public double getMaxFuel(){
		return this.maxFuel.getFuel();
	}
	
	public double getCurrentFuel(){
		return this.currentFuel.getFuel();
	}
	
	public double getFuelConsumption(){
		return this.fuelConsumption;
	}
	
	public double getKnots(){
		return Abstract.roundValue(Abstract.GetRandomDoubleValue(getHighKnots(), getLowKnots()));
	}
	
	public double getHighKnots(){
		return this.highKnots;
	}
	
	public double getLowKnots(){
		return this.lowKnots;
	}
	
	public double getAverageKnots(){
		return Abstract.roundValue((getHighKnots() + getLowKnots()) / 2);
	}

// *************   Data decreasers *************
	public void decreaseFuel(double passedFuel){
		this.currentFuel.increaseFuel((-1) * passedFuel);
	}
	
	public void decreaseFuel(int passedFuel){
		decreaseFuel((double)passedFuel);
	}
	
// **************  Data Increasers ************
	public void increaseFuel(double passedFuel){
		this.currentFuel.increaseFuel(passedFuel);
	}
	
	public void increaseFuel(int passedFuel){
		increaseFuel((double)passedFuel);
	}

	public String getFuelPercentage(){ // Returns a percentage value of the fuel available on the ship.
		return Abstract.roundValue((getCurrentFuel() / getMaxFuel()) * 100) + "%";
	}

	private double getVariedFuelConsumption(){ // Not sure this is implemented completely yet; This varies the amount of fuel consumed each run.
		if(Abstract.GetRandomValue(100, 0) > 51){
			return getFuelConsumption() + (Abstract.GetRandomValue(20, 0) * .010);
		} else {
			return getFuelConsumption() - (Abstract.GetRandomValue(20, 0) * .010);
		}
	}

	public void FuelMeasureAndConsumption(Boat playerObject){ // This is a sanity check, if OutOfFuel is true, then a random occurrence occurs, and if it's false, then fuel consumption is run.
		if(IsOutOfFuel() == false){
			decreaseFuel(getVariedFuelConsumption());
		} else{
		//	new RandomEvent().noFuel(playerObject);
		}
	}

// ***********   Boolean Sanity Checks **************
	private boolean FullFuelTank(){ // This is another sanity check, it checks whether the fuel tank is full.
		if(getCurrentFuel() >= getMaxFuel()){
			return true;
		}
		return false;
	}
	
	public boolean IsOutOfFuel(){ // Another sanity check, checks whether the fuel tanks are empty.
		if(getCurrentFuel() <= 0.0){
			setCurrentFuel(0.0);
			return true;
		}
		return false;
	}
	
// ******  Upgrade data parse **********
	public void upgradeEngine(String[] engineData){
		if(engineData.length != 7){
			System.out.println("Failure.  Engine data is not correct size.");
		} else {
			setEngineName(engineData[0]);
			setFuelType(engineData[1]);
			setMaxFuel(engineData[2]);
			setCurrentFuel(engineData[3]);
			setFuelConsumption(engineData[4]);
			setHighKnots(engineData[5]);
			setLowKnots(engineData[6]);
		}
	}
	
// ********   Formatted Data ***********
	public void displayMaxFuel(){ // Displays the maximum fuel value with formatting.
		System.out.println("Maximum Fuel: " + getMaxFuel());
	}
	
	public void displayCurrentFuel(){ // Displays the current fuel value with formatting.
		System.out.println("Current Fuel: " + getCurrentFuel());
	}
	
	public void displayFuelConsumption(){ // Displays the fuel consumption value with formatting.
		System.out.println("Fuel Consumption: " + getFuelConsumption());
	}
	
	public String displayFuelPercentage(){
		return "Fuel Percentage: " + getFuelPercentage();
	}
	
	public void DisplayFormattedFuelPercentage(){ // Displays the fuel percentage with formatting.  
		System.out.println("Fuel: " + getFuelPercentage());
	}
	
	public void displayAverageKnots(){ // Displays average speed in knots.
		System.out.println("Average knots: " + getAverageKnots() + " knots");
	}	
}