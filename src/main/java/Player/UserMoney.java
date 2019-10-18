package main.java.Player;


/*public interface UserMoney extends UserShip{
	public int getMoney();
	public void setMoney(int userPassedValue);
}*/

import main.java.Abstract.Abstract;

public class UserMoney extends UserLocation{
	private double shipPurse; // Variable that contains the money value.
	private final static double startingMoney = 5000.00; 
	private double containerPaymentPercentage;
	private final static double defaultContainerPayment = 0.10;
	
	public UserMoney(){ // Constructor that sets the player money to the default.
		this.shipPurse = startingMoney; 
		this.containerPaymentPercentage = defaultContainerPayment;
	}

	public void DisplayMoney(){ // Displays formatted version of the player money
		System.out.println("Ship Purse: $" + GetMoney() );
	}
	
	public double GetMoney(){ // Returns the ship purse value, with rounded values.
		return Double.parseDouble(Abstract.GetDoubleDecimal(this.shipPurse));
	}
	
	public void DeductMoney(int userPassedMoney){ // Deduct player money by passed value.  Integer is converted to double.
		//Abstract.DecreaseValue(this.shipPurse, (double)userPassedMoney);
		this.shipPurse -= (double)userPassedMoney;
	}
	
	public void DeductMoney(double userPassedMoney){ // Deduct player money by passed value.  
		//Abstract.DecreaseValue(this.shipPurse, userPassedMoney);
		this.shipPurse -= userPassedMoney;
	}
	
	public void AddMoney(int userPassedMoney){ // Add money to the player money, by passed integer value.
		//Abstract.IncreaseValue(this.shipPurse, (double)userPassedMoney);
		this.shipPurse += (double)userPassedMoney;
	}
	
	public void AddMoney(double userPassedMoney){ // Add money to the player money, by the passed double value.
		//Abstract.IncreaseValue(this.shipPurse, userPassedMoney);
		this.shipPurse += userPassedMoney;
	}

	public void increasePaymentPercentage(){ // Increases payment percentage by 10%
		this.containerPaymentPercentage += 0.10;
	}
	
	public double getContainerPaymentPercentage(){ // Returns the payment percentage
		return this.containerPaymentPercentage;
	}
	
	public void SetMoney(int userPassedValue){ // Set player money with passed value.  Integer is converted to double.
		this.shipPurse = (double)userPassedValue;
	}
	
	public void SetMoney(double userPassedValue){ // Set player money with passed value. 
		this.shipPurse =  userPassedValue;
	}
	
	public void displayMoneyIncrease(int passedContainerCount){ // 
	//	AddMoney(((double)passedContainerCount * passedValue) * getContainerPaymentPercentage()) * passedMoney);
		DisplayMoney();
	}
	
}