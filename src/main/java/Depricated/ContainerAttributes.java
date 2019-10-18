package main.java.Depricated;/*package src.main.java;

import src.main.java.Abstract.*;

class Quantity{ // Quantity class; nested inside Container attributes.
	private int quantity; // Quantity of containers available.
	private final static int defaultQuantity = 0;

	public Quantity(){ //Default Quantity set to 0, if nothing is passed to it.
		this.quantity = defaultQuantity;
	}

	public void SetQuantity(int passedQuantity){ // Sets the quantity available to the passed value.
		this.quantity = passedQuantity;
	}

	public void IncreaseQuantity(int passedQuantity){ // Increases the quantity of available containers by the passed value.
		Abstract.IncreaseValue(this.quantity, passedQuantity);
	}

	public void DecreaseQuantity(int passedQuantity){ // Decreases the quantity of available containers by the passed value.
		Abstract.DecreaseValue(this.quantity, passedQuantity);
	}

	public int GetQuantity(){ // Returns the available quantity of containers.
		return this.quantity;
	}

}

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

class Price{ // Price class; this is what controls the price of container type.
	private double price; // Self-explanitory, price is stored in a double.
	private final static double defaultPrice = 0.0;

	public Price(){ // Constructor that sets the price of goods to $0.0
		this.price = defaultPrice;
	}

	public double GetPrice(){ // Provides the set price.
		return this.price;
	}

	public void IncreasePrice(double passedPrice){ // Increases the quantity of available containers by the passed value.
		Abstract.IncreaseValue(this.price, passedPrice);
	}

	public void SetPrice(double passedPrice){ // Sets the price to a provided value.
		this.price = passedPrice;
	}

	public void DecreasePrice(double passedPrice){ // Increases the quantity of available containers by the passed value.
		Abstract.DecreaseValue(this.price, passedPrice);
	}

}

enum GoodType{Container, Bulk} // Enum that sets goods to either containers or bulk setting.  This can be expanded on.


public class ContainerAttributes{
	private String title;

	private Price price;
	private Quantity quantity;
	private Weight weight;
	private Refrigeration refrigeration;
	private GoodType GoodType;

	public static class Builder{
		private String title;

		private Price price = new Price();
		private Quantity quantity = new Quantity();
		private Weight weight = new Weight();
		private Refrigeration refrigeration = new Refrigeration();
		private GoodType GoodType;

		public Builder title(String passedTitle){
			this.title = passedTitle;
			return this;
		}

		public Builder price(double passedPrice){
			this.price.SetPrice(passedPrice);
			return this;
		}

		public Builder GoodType(){
			this.GoodType = GoodType.Container;
			return this;
		}

		public Builder GoodType(String type){
			if(type.equalsIgnoreCase("Container")){
				this.GoodType = GoodType.Container;
			} else{
				this.GoodType = GoodType.Bulk;
			}
			return this;
		}

		public Builder GoodType(boolean state){
			if(state == false){
				this.GoodType = GoodType.Container;
			} else {
				this.GoodType = GoodType.Bulk;
			}
			return this;
		}

		public Builder refrigeration(){
			this.refrigeration(false);
			return this;
		}

		public Builder refrigeration(boolean state){
			this.refrigeration(state);
			return this;
		}

		public Builder quantity(int passedQuantity){
			this.quantity.SetQuantity(passedQuantity);
			return this;
		}

		public Builder weight(int passedWeight){
			this.weight.SetWeight(passedWeight);
			return this;
		}

		public ContainerAttributes build(){
			return new ContainerAttributes(this);
		}
	}

	private ContainerAttributes(Builder builder){
		this.title = builder.title;
		this.price = builder.price;
	}

	public void IncreaseQuantity(int passedQuantity){
		this.quantity.IncreaseQuantity(passedQuantity);
	}

	public void IncreasePrice(double passedPrice){
		this.price.IncreasePrice(passedPrice);
	}

	public int GetQuantity(){
		return this.quantity.GetQuantity();
	}

	public String getName(){
		return this.title;
	}

	public double GetPrice(){
		return this.price.GetPrice();
	}

	public void SetPrice(double passedPrice){
		this.price.SetPrice(passedPrice);
	}

	public boolean GetRefrigeration(){
		return this.refrigeration.GetRefrigeration();
	}

	public String GetGoodType(){
		return "" + this.GoodType;
	}

	public void SetRefrigeration(boolean state){
		this.refrigeration.SetRefrigeration(state);
	}

	public void SetQuantity(int passedQuantity){
		this.quantity.SetQuantity(passedQuantity);
	}

	public void DecreaseQuantity(int passedQuantity){
		this.quantity.DecreaseQuantity(passedQuantity);
		//IncreaseQuantity((-1)*passedQuantity);
	}

	public void DecreasePrice(double passedPrice){
	//	Abstract.DecreaseValue(this.Value.GetPrice(), passedPrice);
		//IncreasePrice((-1)*passedPrice);
		this.price.DecreasePrice(passedPrice);
	}


	public void IncreaseQuantity(int passedQuantity){
		this.quantity.IncreaseQuantity(passedQuantity);
	}

	public void IncreasePrice(double passedPrice){
		this.price.IncreasePrice(passedPrice);
	}

	public int GetQuantity(){
		return this.quantity.GetQuantity();
	}

	public String getName(){
		return this.title;
	}

	public void setRefrigerationStatus(boolean setRefrigerationStatus){
		this.refrigeration.setRefrigerationStatus(setRefrigerationStatus);
	}

	public boolean getRefrigerationStatus(){
		return this.refrigeration.getRefrigerationStatus();
	}

	public double GetPrice(){
		return this.price.GetPrice();
	}

	public void SetPrice(double passedPrice){
		this.price.SetPrice(passedPrice);
	}

	public void SetQuantity(int passedQuantity){
		this.quantity.SetQuantity(passedQuantity);
	}

	public void DecreaseQuantity(int passedQuantity){
		this.quantity.DecreaseQuantity(passedQuantity);
		//IncreaseQuantity((-1)*passedQuantity);
	}

	public void DecreasePrice(double passedPrice){
	//	Abstract.DecreaseValue(this.Value.GetPrice(), passedPrice);
		//IncreasePrice((-1)*passedPrice);
		this.price.DecreasePrice(passedPrice);
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
