package src.main.java;

public class User{
	private String userName;
	private int speed;
	private int maximumContainers;
	private int currentContainers;
	
	private int shipPurse;
	// Bunker fuel price per ton $343
	private int dateValue;

	public User(String userDefinedName){
		this.userName = userDefinedName;
		this.maximumContainers = 100;
		this.currentContainers = 0;
		this.shipPurse = 5000;
	}

	public User(int[] getDefaultUserShip){
		this.maximumContainers = getDefaultUserShip[0];
		this.currentContainers = getDefaultUserShip[1];
		this.speed = getDefaultUserShip[2];
		//this.userName = setUserNameFormatted();
		this.userName = "Blerp";
		this.shipPurse = 5000;
	}
	
	public User(String userDefinedName, int[] getDefaultUserShip){
		this.userName = userDefinedName;
		this.maximumContainers = getDefaultUserShip[0];
		this.currentContainers = getDefaultUserShip[1];
		this.speed = getDefaultUserShip[2];
		this.shipPurse = 5000;
	}
	
	public User(String userDefinedName, int userDefinedMaxContainers, int userDefinedCurrentContainers){
		this.userName = userDefinedName;
		this.maximumContainers = userDefinedMaxContainers;
		this.currentContainers = userDefinedCurrentContainers;
		this.shipPurse = 5000;
	}

	public User(String userDefinedName, int userDefinedMaxContainers){
		this.userName = userDefinedName;
		this.maximumContainers = userDefinedMaxContainers;
		this.currentContainers = 0;
		this.shipPurse = 5000;
	}

	public void setUserName(String userDefinedName){
		this.userName = userDefinedName;
	}

	/*** This function is broken for some reason. ***/
	public void setUserNameFormatted(){
		//System.out.print("Enter your chosen name: ");
		//String userDefinedName = ;
		setUserName(Abstract.scannerString());
	}
	
	public String getUserName(){
		return this.userName;
	}

	public void setSpeed(int userDefinedSpeed){
		this.speed = userDefinedSpeed;
	}

	public int getSpeed(){
		return this.speed;
	}

	public int getMoney(){
		return this.shipPurse;
	}
	
	public void setMoney(int userPassedValue){
		this.shipPurse = userPassedValue;
	}
	
	public void setMaximumContainers(int userDefinedMaxContainers){
		this.maximumContainers = userDefinedMaxContainers;
	}
	
	public int getMaximumContainers(){
		return this.maximumContainers;
	}
	
	public void setCurrentContainers(int userDefinedCurrentContainers){
		this.currentContainers = userDefinedCurrentContainers;
	}
	
	public int getCurrentContainers(){
		return this.currentContainers;
	}

	public boolean isEmptyShip(){
		if(this.currentContainers == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFullShip(){
		if(this.currentContainers == this.maximumContainers){
			return true;
		} else {
			return false;
		}
	}
	
	public void upgradeUserShip(){
	}
	
	public void getContainerReadout(){
		System.out.println("Maximum Containers: " + this.maximumContainers);
		System.out.println("Current Containers: " + this.currentContainers + "\n\n");
	}
	
	public void getShipName(){
		System.out.println("Name: " + this.userName);
	}
	
	public void getShipSpeed(){
		System.out.println("Speed: " + this.speed + " knots");
	}
	
	public void getUserReadout(){
		getShipName();
		getShipSpeed();
		getContainerReadout();
	}

}
