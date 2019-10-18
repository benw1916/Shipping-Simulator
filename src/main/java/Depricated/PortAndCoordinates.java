package main.java.Depricated;/*package src.main.java;

import src.main.java.Player.*;

public class PortAndCoordinates extends GlobalContainerPrices{
	
	private final static int maximumAmountOfContainersInPort = 2000;
	private final static int maximumContainerPriceInPort = 1000;
	private final static int maximumPriceForFuelInPort = 1000;
	
	private String PortName;
	private String ShortName;
	//private int containerCount;
	//private double containerPrice;
	private QuantityAndPrice ShoreQuantity;
	private double fuelPrice;
	private LongitudeLatitude portLongitudeAndLatitude;
	
	
	//private String[] nameContainer = {"LongBeach", "Sydney", "HongKong"};
	private final static String[] LongBeach = {"Long Beach", "LB", "33.754185", "-118.216458"};
	private final static String[] Sydney = {"Sydney", "SY","-33.858333", "151.233333"};
	private final static String[] HongKong = {"Hong Kong", "HK", "22.287753", "114.173619"};
	
	public PortAndCoordinates(String name){
		this.ShoreQuantity = new QuantityAndPrice();
		if(name.contains("Long")){
			this.PortName = LongBeach[0];
			this.ShortName = LongBeach[1];
			//this.latitude = Double.parseDouble(LongBeach[2]);
			//this.longitude = Double.parseDouble(LongBeach[3]);
			portLongitudeAndLatitude.SetLatitude(Double.parseDouble(LongBeach[2]));
			portLongitudeAndLatitude.SetLongitude(Double.parseDouble(LongBeach[3]));
		}
		else if(name.equals("Syd")){
			this.PortName = Sydney[0];
			this.ShortName = Sydney[1];
			//this.latitude = Double.parseDouble(Sydney[2]);
			//this.longitude = Double.parseDouble(Sydney[3]);
			portLongitudeAndLatitude.SetLatitude(Double.parseDouble(Sydney[2]));
			portLongitudeAndLatitude.SetLongitude(Double.parseDouble(Sydney[3]));
		}
		else if(name.equals("Hong")){
			this.PortName = HongKong[0];
			this.ShortName = HongKong[1];
			//this.latitude = Double.parseDouble(HongKong[2]);
			//this.longitude = Double.parseDouble(HongKong[3]);
			portLongitudeAndLatitude.SetLatitude(Double.parseDouble(HongKong[2]));
			portLongitudeAndLatitude.SetLongitude(Double.parseDouble(HongKong[3]));
		} 
		randomizedGeneration();
	}
	
	public PortAndCoordinates(String name, String shortName){
		this.PortName = name;
		this.ShortName = shortName;
	}
	
	private void randomizedGeneration(){
		//this.containerCount = Abstract.getRandomValue(maximumAmountOfContainersInPort, 0);
		//this.containerPrice = Abstract.getRandomValue(maximumContainerPriceInPort, 0);
		this.fuelPrice = Abstract.getRandomValue(maximumPriceForFuelInPort, 0);
	}

	public String getLongName(){
		return this.PortName;
	}
	
	public String getShortName(){
		return this.ShortName;
	}
	
	public double getLatitude(){
		return portLongitudeAndLatitude.GetLatitude();
	}
	
	public double getLongitude(){
		return portLongitudeAndLatitude.GetLongitude();
	}
	
	public int getContainersInPort(){
		return this.containerCount;
	}
	
	public double getContainerPriceInPort(){
		return this.containerPrice;
	}
	
	public double getFuelPrice(){
		return this.fuelPrice;
	}
	
	public void DisplayContainersInPort(){
		System.out.println("Containers in port: " + this.containerCount);
	}
	
	public void DisplayContainerPriceInPort(){
		System.out.println("Current container price: $" + this.containerPrice);
	}
	
	/*private void setOilPrice
		Abstract.
	}*/
		
		
	/*private void increaseDecreaseContainerAmount(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			increaseDecreaseContainerAmount();
			/*int dailyUpDown = Abstract.getRandomValue(100);
			if(dailyUpDown >= 51){
				this.availableContainers[0] += Abstract.getRandomValue(maximumValueOfContainersInOut);
			} else{
				this.availableContainers[0] -= Abstract.getRandomValue(maximumValueOfContainersInOut);
			}*/
	/*	dayCount++;
		}
	}
	
	private void increaseDecreaseContainerAmount(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.availableContainers[0] += Abstract.getRandomValue(maximumAmountOfContainersInOut);
		} else{
			this.availableContainers[0] -= Abstract.getRandomValue(maximumAmountOfContainersInOut);
		}
	}
	
	private void increaseDecreaseContainerPrice(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			increaseDecreaseContainerPrice();
			/*int dailyUpDown = Abstract.getRandomValue(100);
			if(dailyUpDown >= 51){
				this.availableContainers[1] += Abstract.getRandomValue(maximumValueOfContainersInOut);
			} else{
				this.availableContainers[1] -= Abstract.getRandomValue(maximumValueOfContainersInOut);
			}*/
	/*	dayCount++;
		}
	}
  
	private void increaseDecreaseContainerPrice(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.availableContainers[1] += Abstract.getRandomValue(maximumValueOfContainersInOut);
		} else{
			this.availableContainers[1] -= Abstract.getRandomValue(maximumValueOfContainersInOut);
		}
	}*/

//}