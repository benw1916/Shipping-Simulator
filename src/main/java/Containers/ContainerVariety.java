package main.java.Containers;

import java.util.ArrayList;

import main.java.Abstract.*;

class Cooling{
	private static final boolean[] refrigerationRequired = {false, false, false, true, false, false, false, true};
	
	public static boolean getCooling(int passedValue){
		return refrigerationRequired[passedValue];
	}
}

class Cranes{
	private static final boolean[] craneRequired = {false, false, false, false, false, true, true, false};
	
	public static boolean getCraneRequirements(int passedValue){
		return craneRequired[passedValue];
	}
}

class Tanker{
	private static final boolean[] tankerRequired = {false, false, false, false, true, true, true, true};
	
	public static boolean getTankerRequirements(int passedValue){
		return tankerRequired[passedValue];
	}
}

public class ContainerVariety{	
	private ArrayList <Container> containers = new ArrayList<Container>();//containerNames.length];
	
	private static final int maximumWeight = 70000;
	private static final int minimumWeight = 9000;
	
	public ContainerVariety(String portOrShip){
		if(portOrShip.equalsIgnoreCase("port")){
			for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
				this.containers.add(new Container.Builder()
					.Title(ContainerTypes.getContainerTypes(i))
					.Price(priceModifier(ContainerTypes.getContainerTypes(i)))
					.Weight(generateContainerWeight())
					.Quantity(quantityCounts(ContainerTypes.getContainerTypes(i)))
					.Refrigeration(Cooling.getCooling(i))
					.GoodStatus(Tanker.getTankerRequirements(i))
				.build());
			}
			
		} else{
			for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
				this.containers.add( new Container.Builder()
					.Title(ContainerTypes.getContainerTypes(i))
				//	.price(generateRandomDouble())
					.Weight(generateContainerWeight())
					.Quantity(0)
					.build());
			}
		}
		
	}
	
	private int generateContainerWeight(){
		return Abstract.GetRandomValue(maximumWeight, minimumWeight);
	}
	
	private int quantityCounts(String passedType){
		final String[] types = {"standard", "volatile", "vehicle", "refrigeration", "oil", "grain", "gravel", "chemical"};
		final int[] maximumQuantity = {1000, 100, 2000, 500, 1000, 1000, 1000, 250};
		final int[] minimumQuantity = {250, 0, 25, 0, 0, 0, 0, 0};
		
		for(int i = 0; i <= types.length; i++){
			if(passedType.equalsIgnoreCase(types[i])){
				return Abstract.GetRandomValue(maximumQuantity[i], minimumQuantity[i]);
			}
		}
			return 0;
	}
	
	private double priceModifier(String passedType){
		final String[] types = {"standard", "volatile", "vehicle", "refrigeration", "oil", "grain", "gravel", "chemical"};
		final int[] maximumPrice = {100, 400, 200, 150, 500, 100, 80, 500};
		final int[] minimumPrice = {5, 40, 80, 40, 5, 20, 40, 100};
		
		for(int i = 0; i <= types.length; i++){
			if(passedType.equalsIgnoreCase(types[i])){
				return Abstract.GetRandomDoubleValue(maximumPrice[i], minimumPrice[i]);
			}
		}
			return -999.99;
	}
	
	public void IncreaseQuantity(int passedPosition, int passedPrice){ // Increase quantity by passed value.
		this.containers.get(passedPosition).IncreaseContainerCount(passedPrice);
	}
	
	public void IncreaseQuantity(String passedName, int passedPrice){
		IncreaseQuantity(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedPrice);
	}
	
	public void DecreaseQuantity(int passedPosition, int passedQuantity){
		this.containers.get(passedPosition).DecreaseContainerCount(passedQuantity);
	}
	
	public void DecreaseQuantity(String passedName, int passedQuantity){
		DecreaseQuantity(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedQuantity);
	}
	
	public void IncreasePrice(int passedPosition, double passedPrice){
		this.containers.get(passedPosition).IncreaseContainerPrice(passedPrice);
	}
	
	public void IncreasePrice(String passedName, double passedPrice){ // Increase price by passed value.
		IncreasePrice(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedPrice);
	}
	
	public void DecreasePrice(int passedPosition, double passedPrice){ // Decrease price by passed value.
		this.containers.get(passedPosition).DecreaseContainerPrice(passedPrice);
	}
	
	public void DecreasePrice(String passedName, double passedPrice){ // Decreases price by passed value.  Converts string to numeric value.
		DecreasePrice(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedPrice);
	}
	
	public void SetCount(int passedPosition, int passedQuantity){ // Sets container quantity.
		this.containers.get(passedPosition).SetContainerCount(passedQuantity);
	}
	
	public void SetCount(String passedName, int passedQuantity){ // Sets container quantity.  Converts string to numeric value.
		SetCount(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedQuantity);
	}
	
	public double GetQuantity(int passedPosition){ // Returns the quantity of a container type.
		return this.containers.get(passedPosition).GetContainerCount();
	}
	
	public double GetQuantity(String passedName){ // Returns the quantity of a container type. Converts string to numeric value.
		return GetQuantity(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()));
	}
	
	public String GetName(int passedPosition){ // Returns the name of the container.
		return this.containers.get(passedPosition).GetContainerName();
	}
	
	public void SetPrice(int passedPosition, double passedPrice){ // Sets the price of the container.  Uses int to specify the location.
		this.containers.get(passedPosition).SetContainerPrice(passedPrice);
	}
	
	public void SetPrice(String passedName, double passedPrice){ //Sets the price of the container, will convert string to its numeric value.
		SetPrice(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedPrice);
	}
	
	public double GetPrice(int passedPosition){ // Returns the price of the container.
		return this.containers.get(passedPosition).GetContainerPrice();
	}
	
	public double GetPrice(String passedName){ // Returns the price of a container.  Converts string to its numeric value.
		return GetPrice(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()));
	}
	
	public void setRefrigerationStatus(int passedPosition, boolean passedState){
		this.containers.get(passedPosition).setRefrigerationStatus(passedState);
	}
	
	/*public void SetRefrigerationStatus(String passedName, boolean passedState){
		SetRefrigerationStatus(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedState);
	}
	
	public boolean GetRefrigerationStatus(String passedName){
		return GetRefrigerationStatus(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()));
	}*/
	
	/*public boolean GetRefrigerationStatus(int passedPosition){
		return this.containers.get(passedPosition).GetRefrigerationStatus();
	}
	
	public void DisplayRefrigerationStatus(int passedPosition){
		System.out.println("Requires refrigeration: " + GetRefrigerationStatus(passedPosition));
	}*/
	
	public String GetContainerName(int passedPosition){
		return this.containers.get(passedPosition).GetContainerName();
	}
	
	public void DisplayNameAndPrice(){
		for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
			System.out.println(GetName(i) + " -- $" + Math.round(GetPrice(i)));
		}
	}
	
	public void DisplayNameAndQuantity(){
		for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
			System.out.println(Abstract.ModifyContainerLength(GetName(i), 13) + " -- " + GetQuantity(i));
		}
	}
	
	public void DisplayNameQuantityAndPrice(){
		for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
			System.out.println(Abstract.ModifyContainerLength(GetName(i), 13) + " -- $" + GetQuantity(i) + " -- $" + GetPrice(i));
		}
	}
	
	public int getTotalCount(){
		int totalCount = 0;
		for(int i = 0; i <= ContainerTypes.getContainerSize(); i++){
			totalCount += GetQuantity(i);
		}
		return totalCount;
	}
}