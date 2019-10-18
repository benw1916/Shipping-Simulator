package main.java;

import main.java.Abstract.*;
import main.java.Containers.*;
import main.java.Containers.ContainerVariety;
import main.java.Port.Port;
import main.java.Sailor.Sailor;
import main.java.Sailor.*;

import java.util.ArrayList;

/*class Fuel{
	private double price;
	
	public Fuel(){
		this.price = Abstract.GetRandomDoubleValue(500.0, 40.0);
	}
	
	public Fuel(double passedPrice){
		this.price = passedPrice;
	}
	
	public double getFuel(){
		return this.price;
	}
	
	public void setFuel(double passedPrice){
		this.price = passedPrice;
	}
}*/

/*class Ports{

	private String portName;
	private LongitudeLatitude portLonLat;
	private ContainerVariety portPriceAndCount;
	private Fuel fuel;
	private Weather portWeather;
	private ArrayList<Sailor> SailorsInPort = new ArrayList<Sailor>();
	private DateDisplay DateDisplay;
	private ArrayList<Integer> sailorSet = new ArrayList<Integer>();
	private final static int displayCrewCount = 6;

	
	public Ports(String locationName, double longitude, double latitude){
		this.portName = locationName;
		this.portLonLat = new LongitudeLatitude.Builder().title(this.portName).longitude(longitude).latitude(latitude).build();
		initializer();
	}
	
		public Ports(String locationName, String longitude, String latitude){
		this.portName = locationName;
		this.portLonLat = new LongitudeLatitude.Builder().title(this.portName).longitude(Double.parseDouble(longitude)).latitude(Double.parseDouble(latitude)).build();
		initializer();
	}
	
/*	public Ports(String passedPortName){
		this.portName = passedPortName;
		//System.out.println(ParsePortToLon(passedPortName));		
		this.portLonLat = new LongitudeLatitude.Builder().title(this.portName).longitude(ParsePortToLon(this.portName)).latitude(ParsePortToLat(this.portName)).build();
		initializer();
	}
	
	private void initializer(){
	//	this.fuelPrice = Abstract.GetRandomDoubleValue(500.0, 40.0);
		this.portPriceAndCount = new ContainerVariety("port");
		this.portWeather = new Weather();
		this.fuel = new Fuel();
		setRandomSailors();
	}
	
	private void setRandomSailors(){
		int randomSailorCount = Abstract.GetRandomValue(100, 0);
		for(int i = 0; i < randomSailorCount; i++){
			this.SailorsInPort.add(i, new Sailor.Builder().Name().skills().Salary().Nationality().build());
		}
	}
	
	public String GetPortName(){
		return this.portName;
	}
	
	public double getFuelPrice(){
		return this.fuel.getFuel();
	}
	
	public double GetLatitude(){
		return this.portLonLat.GetLatitude();
	}
	
	public double GetLongitude(){
		return this.portLonLat.GetLongitude();
	}
	
	public void GetContainerCount(){
		//this.portPriceAndCount.displayNameAndQuantity();
		//return this.portPriceAndCount.GetQuantity();
	}
	
	public double getContainerPrice(int passedLocation){
		return this.portPriceAndCount.getPrice(passedLocation);
	}
	
	public void IncreaseQuantity(int passedPosition, int passedQuantity){
		this.portPriceAndCount.IncreaseQuantity(passedPosition, passedQuantity);
	}
	
	public void IncreaseQuantity(String passedName, int passedQuantity){
		this.portPriceAndCount.IncreaseQuantity(passedName, passedQuantity);
	}
	
	public void DecreaseQuantity(int passedPosition, int passedQuantity){
		this.portPriceAndCount.DecreaseQuantity(passedPosition, passedQuantity);
	}
	
	public void DecreaseQuantity(String passedName, int passedQuantity){
		this.portPriceAndCount.DecreaseQuantity(passedName, passedQuantity);
	}
	
	public void IncreasePrice(int passedPosition, double passedPrice){
		this.portPriceAndCount.IncreasePrice(passedPosition, passedPrice);
	}
	
	public void IncreasePrice(String passedName, double passedPrice){
		this.portPriceAndCount.IncreasePrice(passedName, passedPrice);
	}
	
	public void DecreasePrice(int passedPosition, double passedPrice){
		this.portPriceAndCount.DecreasePrice(passedPosition, passedPrice);
	}
	
	public void DecreasePrice(String passedName, double passedPrice){
		this.portPriceAndCount.DecreasePrice(passedName, passedPrice);
	}
	
	public int getQuantity(int passedPosition){
		return this.portPriceAndCount.getQuantity(passedPosition);
	}
	
	public int getQuantity(String passedName){
		return this.portPriceAndCount.getQuantity(passedName);
	}
	
	public String getName(int passedPosition){
		return this.portPriceAndCount.getName(passedPosition);
	}
	
	public double getPrice(int passedPosition){
		return this.portPriceAndCount.getPrice(passedPosition);
	}
	
	public double getPrice(String passedName){
		return this.portPriceAndCount.getPrice(passedName);
	}
	
	public void displayNameAndPrice(){
		this.portPriceAndCount.displayNameAndPrice();
	}
	
	public void displayNameAndQuantity(){
		this.portPriceAndCount.displayNameAndQuantity();
	}
	
	public void displayNameQuantityAndPrice(){
		this.portPriceAndCount.displayNameQuantityAndPrice();
	}
	
	public static int length(){
		return ContainerTypes.getContainerSize();
	}
	
	public int getTotalCount(){
		return this.portPriceAndCount.getTotalCount();
	}	

	private void generateDisplayCrewValues(){
		for(int i = 0 ; i < displayCrewCount; i++){
			this.sailorSet.add(Abstract.GetRandomValue(SailorsInPort.size(), 0));
		}
	}
	
	public void displayAvailableCrew(){
		generateDisplayCrewValues();
		System.out.println("----- Available Sailors for Hire -----");
		for(int i = 0; i < displayCrewCount; i++){
			SailorCalls.DisplaySailorVitals(this.SailorsInPort.get(this.sailorSet.get(i)));
			for(int x = 0; x < new Skillset().getSkillSize(); x++){
				System.out.println(this.SailorsInPort.get(this.sailorSet.get(i)).GetSkillTitle(x) + ": " + this.SailorsInPort.get(this.sailorSet.get(i)).GetSkill(x) );
			}
			System.out.println();
		}
	}
	
	public Sailor getSpecificSailor(int passedValue){
		return this.SailorsInPort.get(sailorSet.get(passedValue));
	}
	
	public void removeAvailableSailor(int chosenSailor){ // Removes the selected sailor from the value display array, and from the sailor in port array.
		try{
			this.sailorSet.remove(sailorSet.get(chosenSailor));
			this.SailorsInPort.remove(sailorSet.get(chosenSailor));
		}catch(IndexOutOfBoundsException oob){
			System.err.println("Out of bounds " + oob);
		}
	}

}*/

//*********************************************

public class AvailablePorts{
	ArrayList <Port> PortLocations = new ArrayList<Port>();
		
	/*public AvailablePorts(String[] portName, double[] portLongitude, double[] portLatitude){
		int nameLength = portName.length;
		int longLength = portLongitude.length;
		int latLength = portLatitude.length;
		if(((longLength == latLength) == false) && (nameLength == longLength) == false){
			System.err.println("\n\nSomething broke with the port loading\n\n");
		} else {
			for(int i = 0; i < portName.length; i++){
				this.PortLocations.add(new Ports(portName[i], portLongitude[i], portLatitude[i]));
				new AvailablePortNames().setPorts(portName[i]);
			}
		}
	}*/
	public AvailablePorts(String portName, String countryName, double portLongitude, double portLatitude){
		CreatePort(portName, countryName, portLongitude, portLatitude);
	}


	public AvailablePorts(ArrayList portName, ArrayList countryName, ArrayList portLongitude, ArrayList portLatitude, int length){
		int nameLength = portName.size();
		int longLength = portLongitude.size();
		int latLength = portLatitude.size();
		if(((longLength == latLength) == false) && (nameLength == longLength) == false){
			System.err.println("\n\nSomething broke with the port loading\n\n");
		} else {
			for(int i = 0; i < length; i++){
                CreatePort("" + portName.get(i), "" + countryName.get(i), Double.parseDouble("" + portLongitude.get(i)), Double.parseDouble("" + portLatitude.get(i)));

				//this.PortLocations.add(new Ports("" + portName.get(i), "" + portLongitude.get(i), "" + portLatitude.get(i)));
				//new AvailablePortNames().setPorts("" + portName.get(i));
			}
		}
	}

	public AvailablePorts(String[] portName, String[] countryName, double[] portLongitude, double[] portLatitude){
		for(int i = 0; i < portName.length; i++){
			CreatePort("" + portName[i], "" + countryName[i], Double.parseDouble("" + portLongitude[i]), Double.parseDouble("" + portLatitude[i]));

			//this.PortLocations.add(new Ports("" + portName.get(i), "" + portLongitude.get(i), "" + portLatitude.get(i)));
			//new AvailablePortNames().setPorts("" + portName.get(i));
		}
	}


/*	public AvailablePorts(String portName, double longitude, double latitude){ // Experimental; This will eventually allow the passage of custom ports
		this.PortLocations.add(new Ports(portName, longitude, latitude));
	}*/
	
	public void AddPort(String cityName, String countryName, double portLongitude, double portLatitude){
		this.PortLocations.add(new Port.Builder().City(cityName).Country(countryName).Containers().Coordinates(portLongitude, portLatitude).build());
	}
	
	public void AddPort(String[] cityName, String[] countryName, double[] portLongitude, double[] portLatitude){
		for(int i = 0; i < cityName.length; i++){
			this.PortLocations.add(new Port.Builder().City(cityName[i]).Country(countryName[i]).Containers().Coordinates(portLongitude[i], portLatitude[i]).build());
		}
	}
	
	public void RemovePort(String portToRemove){
		for(int i = 0; i < this.PortLocations.size(); i++){
			if(portToRemove.equals(this.PortLocations.get(i).GetCity())){
				this.PortLocations.remove(i);
			}
		}
	}
	
	private void CreatePort(String portName, String countryName, double longitude, double latitude){
		this.PortLocations.add(new Port.Builder().City(portName).Country(countryName).Coordinates(longitude, latitude).Containers().build());
		//new AvailablePortNames().setPorts(portName);
	}

	public Port GetPort(int position){
	    return this.PortLocations.get(position);
    }

    public ArrayList<String> GetPort(int startPosition, int endPosition){
		ArrayList<String> displayPort = new ArrayList<String>();
		for(int p = startPosition; p < endPosition; p++){
			displayPort.add(this.PortLocations.get(p).GetCity() + ", " + this.PortLocations.get(p).GetCountry());
		}
		return displayPort;
	}

    public Port GetPort(String passedPortCity){
        for(int i = 0; i < this.PortLocations.size(); i++){
            if(this.PortLocations.get(i).GetCity().contains(passedPortCity)){
                return this.PortLocations.get(i);
            }
        }
        return this.PortLocations.get(0);
    }

    public int GetSize(){
	    return this.PortLocations.size();
    }

    public String GetCityAndCountry(int position){
		return this.PortLocations.get(position).GetCity() + ", " + this.PortLocations.get(position).GetCountry();
	}

/*	public String getContainerName(int passedValue){ // Passes through the container name from the passed value.
		return this.PortLocations.get(passedValue).getName(passedValue);
	}
	
	public String getContainerName(int passedPosition, int passedValue){  // Returns the container name, requires the port value and the container type value.
		return this.PortLocations.get(passedPosition).getName(passedValue);
	}
	
	public int getContainerQuantity(int passedValue){
		return this.PortLocations.get(passedValue).getQuantity(passedValue);
	}
	
	public int getContainerQuantity(int passedPosition, int passedValue){
		return this.PortLocations.get(passedPosition).getQuantity(passedValue);
	}

	
	public double getContainerPrice(String passedPortName){
		try{
			for(int i = 0; i < this.PortLocations.size(); i++){
				if(this.PortLocations.get(i).GetPortName().contains(passedPortName)){
					return this.PortLocations.get(i).getContainerPrice(i);
				}
			}
		}catch(IndexOutOfBoundsException ee){
			System.err.println("Ooops, looks like the error was thrown here");
			return -1.0;
		}
		return -2.0;
	}
	
	public double getContainerPrice(String passedPortName, String passedContainerType){
		try{
			int containerValue = 0;
			for(int x = 0; x < ContainerTypes.getContainerSize(); x++){
				if(passedContainerType.contains(ContainerTypes.getContainerTypes(x))){
					containerValue = x;
				}
			}
			
			for(int i = 0; i < this.PortLocations.size(); i++){
				if(this.PortLocations.get(i).GetPortName().contains(passedPortName)){
					return this.PortLocations.get(i).getContainerPrice(containerValue);
				}
			}
		}catch(IndexOutOfBoundsException ee){
			System.err.println("Ooops, looks like the error was thrown here");
			return -1.0;
		}
		return -2.0;
	}
	
	public double getContainerPrice(int passedValue){
		return this.PortLocations.get(passedValue).getContainerPrice(passedValue);
	}
	
	public double getContainerPrice(int passedPosition, int passedValue){ // This function is being whack right now, for whatever reason it keeps thinking its a string. 
		double containerPrice = this.PortLocations.get(passedPosition).getContainerPrice(passedValue);
		return Math.round(containerPrice * 100d) / 100d;
	}
	
	public void removeAvailableSailor(String passedLocation, int passedSailor){
		int currentPort = getCurrentPort(passedLocation);
		this.PortLocations.get(currentPort).removeAvailableSailor(passedSailor);
	}
	
	public void removeAvailableSailor(int passedLocation, int passedSailor){
		this.PortLocations.get(passedLocation).removeAvailableSailor(passedSailor);
	}
	
	public String GetPortName(String passedName){
		for(int i = 0; i < this.PortLocations.size(); i++){
			if(passedName.equals(this.PortLocations.get(i).GetPortName())){
				return this.PortLocations.get(i).GetPortName();
			}
		}
		return "Error";
	}
	
	public Sailor getSpecificSailor(int passedLocation, int passedValue){
		return this.PortLocations.get(passedLocation).getSpecificSailor(passedValue);
	}
	
	public Sailor getSpecificSailor(String passedLocation, int passedValue){
		return this.PortLocations.get(getCurrentPort(passedLocation)).getSpecificSailor(passedValue);
	}
	
	public String GetPortName(int passedValue){
		return this.PortLocations.get(passedValue).GetPortName();
	}
	
	public double DisplayGoodAndPrice(int passedValue){
		return this.PortLocations.get(passedValue).getPrice(passedValue);
	}
	
	public int getCurrentPort(String passedPortName){
		for(int i = 0; i < this.PortLocations.size(); i++){
			if(this.PortLocations.get(i).GetPortName().equals(passedPortName)){
				return i;
			}
		}
		return -1;
	}
	
	public void decreaseQuantity(int passedPort, int passedType, int passedValue){
		this.PortLocations.get(passedPort).DecreaseQuantity(passedType, passedValue);
	}
	
	public void decreaseQuantity(String passedPort, int passedType, int passedValue){
		for(int i = 0; i < this.PortLocations.size(); i++){
			if(passedPort.equals(this.PortLocations.get(i).GetPortName())){
				this.PortLocations.get(i).DecreaseQuantity(passedType, passedValue);
			}
		}
	}
	
	public int GetPortCount(){ // Returns the amount of ports currently avaialable to you.
		return this.PortLocations.size();
	}
	
	public double GetFuelPrice(String passedName){ // Returns current price of fuel
		return Math.round(this.PortLocations.get(Abstract.convertArrayListToInt(passedName, AvailablePortNames.getPorts())).getFuelPrice() * 100d) /100d;
	}

	public void displayAvailableCrew(String passedName){ 
		this.PortLocations.get(Abstract.convertArrayListToInt(passedName, AvailablePortNames.getPorts())).displayAvailableCrew();
	}
	
	public void displayAvailableCrew(int passedValue){
		this.PortLocations.get(passedValue).displayAvailableCrew();
	}
	*/
}