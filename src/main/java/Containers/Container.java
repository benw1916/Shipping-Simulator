package main.java.Containers;

import main.java.Abstract.*;

interface ContainerCalls{
	String GetContainerName();

	double GetContainerPrice();

	double GetContainerCount();

	void IncreaseContainerCount(double passedCount);

	void IncreaseContainerPrice(double passedPrice);

	void DecreaseContainerCount(double passedCount);

	void DecreaseContainerPrice(double passedPrice);

	void SetContainerPrice(double passedPrice);

	void SetContainerCount(double passedCount);



}

enum ContainersOrBulk{Container, Bulk} // Enum that sets goods to either containers or bulk setting.  This can be expanded on.  

public class Container implements ContainerCalls{ // Primary class that contains all the classes above.
	private String title; // Holds the name of the good you're working with.
	
	private double price;
	private double quantity;
	private Weight weight;
	private Refrigeration refrigeration;
	private ContainersOrBulk GoodStatus;
	
	public static class Builder{ // Builder class that allows quick construction of container types.
		private String title;

		private double price;
		private double quantity;
		private Weight weight = new Weight();
		private Refrigeration refrigeration = new Refrigeration();
		private ContainersOrBulk GoodStatus = ContainersOrBulk.Container;
	
		public Builder Title(String passedTitle){
			this.title = passedTitle;
			return this;
		}
	
		public Builder Price(double passedPrice){
			this.price = passedPrice;
			return this;
		}
		
		public Builder Quantity(double passedQuantity){
			this.quantity = passedQuantity;
			return this;
		}
		
		public Builder GoodStatus(boolean goodStatus){
			if(goodStatus == true){
				this.GoodStatus = ContainersOrBulk.Bulk;
			} else {
				this.GoodStatus = ContainersOrBulk.Container;
			}
			return this;
			
		}
		
		public Builder GoodStatus(String goodStatus){
			if(goodStatus.equals("bulk")){
				this.GoodStatus = ContainersOrBulk.Bulk;
			} else {
				this.GoodStatus = ContainersOrBulk.Container;
			}
			return this;
		}
		
		public Builder Weight(int passedWeight){
			this.weight.SetWeight(passedWeight);
			return this;
		}
		
		public Builder Refrigeration(boolean refrigerationStatus){
			this.refrigeration.setRefrigerationStatus(refrigerationStatus);
			return this;
		}
		
		public Container build(){
			return new Container(this);
		}
	}
	
	private Container(Builder builder){
		title = builder.title;
		
		price 		  = builder.price;
		quantity   	  = builder.quantity;
		weight 		  = builder.weight;
		refrigeration = builder.refrigeration;
		GoodStatus	  = builder.GoodStatus;
	}

	@Override
	public void IncreaseContainerCount(double passedQuantity){
		this.quantity += passedQuantity;
	}

	@Override
	public void IncreaseContainerPrice(double passedPrice){
		this.price += passedPrice;
	}

	@Override
	public double GetContainerCount(){
		return this.quantity;
	}

	@Override
	public String GetContainerName(){
		return this.title;
	}
	
	public void setRefrigerationStatus(boolean setRefrigerationStatus){
		this.refrigeration.setRefrigerationStatus(setRefrigerationStatus);
	}

	public boolean getRefrigerationStatus(){
		return this.refrigeration.getRefrigerationStatus();
	}

	@Override
	public double GetContainerPrice(){
		return this.price;
	}

	@Override
	public void SetContainerPrice(double passedPrice){
		this.price = passedPrice;
	}

	@Override
	public void SetContainerCount(double passedQuantity){
		this.quantity = passedQuantity;
	}

	@Override
	public void DecreaseContainerCount(double passedQuantity){
		IncreaseContainerCount(-1 * passedQuantity);
	}

	@Override
	public void DecreaseContainerPrice(double passedPrice){
	//	Abstract.DecreaseValue(this.Value.GetPrice(), passedPrice);
		//IncreasePrice((-1)*passedPrice);
		IncreaseContainerPrice(-1 * passedPrice);
	}
	
}
	
/*	private ContainersOrBulk DetermineGoodType(String passedType){ //containers, oil, chemical, bulk, refrigeration, heavyLift
		if(passedType.equalsIgnoreCase("containers") || passedType.equalsIgnoreCase("refrigeration") || passedType.equalsIgnoreCase("vehicle") || passedType.equalsIgnoreCase("volatile")){
			return ContainersOrBulk.Container;
		}
		if(passedType.equalsIgnoreCase("oil") || passedType.equalsIgnoreCase("gravel") || passedType.equalsIgnoreCase("chemical") || passedType.equalsIgnoreCase("gravel")){
			return ContainersOrBulk.Bulk;
		}
		return ContainersOrBulk.Container;
	}	
}*/

class Refrigeration{ // Refrigeration status; this also hasn't been implemented yet, but will eventually.  This is a boolean check value.
	private boolean refrigerationStatus;

	public Refrigeration(){ //When initialized without arguments, refrigeration status is set to false.
		this.refrigerationStatus = false;
	}

	public Refrigeration(boolean passedStatus){ // Constructor where if you pass true, refrigeration status is true!
		setRefrigerationStatus(passedStatus);
	}

	public boolean getRefrigerationStatus(){ // Returns the state of refrigeration.
		return this.refrigerationStatus;
	}

	public void setRefrigerationStatus(boolean passedStatus){  // Similar to the constructor above, allows you to set the status.
		this.refrigerationStatus = passedStatus;
	}

}

class Weight{ // Weight class; This hasn't been implemented yet, but will eventually!  This will affect the amount of containers a ship can carry.
	private int weight; //Weight is using int, rather than double, since we are talking about thousands of pounds.


	public Weight(){ // When weight is initialized, weight is randomly set anywhere between 9K and 70K.
		this.weight = Abstract.GetRandomValue(70000, 9000);
	}

	public void SetWeight(int passedWeight){ // Manually set the weight of the container type.
		this.weight = passedWeight;
	}

	public int GetWeight(){ // Returns the weight value.
		return this.weight;
	}

}