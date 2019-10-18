package src.main.java;

public class PlayerShip{

  private int shipSpeed;
  private int maxContainers;
  private int containersOnShip;
  private String currentPort;


  public PlayerShip(){
    /*** Initialize the ship, should only be run once ***/
    this.shipSpeed = 12;
    this.maxContainers = 100;
    this.containersOnShip = 0;
    this.currentPort = "LA";
  }

  public int getContainersOnShip(){
    return this.containersOnShip;
  }

  public int getMaxContainers(){
    return this.maxContainers;
  }

  public int getShipSpeed(){
    return this.shipSpeed;
  }

  public String getCurrentPort(){
    return this.currentPort;
  }

  public void setContainersOnShip(int userContainerValue){
    this.containersOnShip = userContainerValue;
  }

  public void setMaxContainers(int userMaxContainers){
    this.maxContainers = userMaxContainers;
  }

  public void setShipSpeed(int userShipSpeed){
    this.shipSpeed = userShipSpeed;
  }

  public void setCurrentPort(String userCurrentPort){
    this.currentPort = userCurrentPort;
  }
}
