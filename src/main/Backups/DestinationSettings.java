package src.main.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package src.main.java.atsea;

/**
 *
 * @author benja
 */
import java.util.Scanner;

public class DestinationSettings {

  private final String[] availablePortLocations = {"LA", "HK", "SY"};
  private PlayerShip userShip;
  private String currentPort;
  private int destinationDistance;
  private String destinationPort;

  public DestinationSettings(PlayerShip userPassedShip) {
    this.userShip = userPassedShip;
    this.currentPort = userPassedShip.getCurrentPort();

    //System.out.println(getDestinationDistance());
        //this.homePort = originPort;
        //this.destinationPort = destinationPort;
  }

  public void destinationIterationMenu(PlayerShip ps){
    portOptionDisplay();
    Abstract.standardGameMenu(availablePortLocations);
    int portChoice = Abstract.userStringToInt() - 1;
    portLogicCheck(portChoice);
    nauticalMileDistance();
  }

  private void destinationIterationMenu(){
    portOptionDisplay();
    Abstract.standardGameMenu(availablePortLocations);
    int portChoice = Abstract.userStringToInt() - 1;
    portLogicCheck(portChoice);
    nauticalMileDistance();
  }

  private void portLogicCheck(int portChoice){
    String chosenPort = availablePortLocations[portChoice];
    if(chosenPort.equals(this.currentPort)){
      System.out.println("Sorry, you are docked in this port.  Choose a different port.");
      destinationIterationMenu();
    }
    setDestinationPort(chosenPort);
  }

  private void nauticalMileDistance() {
    if ((this.currentPort.contains("LA")) && (this.destinationPort.contains("HK")) || (this.currentPort.contains("HK")) && (this.destinationPort.contains("LA"))) {
      setDestinationDistance(6475);
    }
    if (this.currentPort.contains("LA") && (this.destinationPort.contains("SY")) || (this.currentPort.contains("SY")) && (this.destinationPort.contains("LA"))) {
      setDestinationDistance(6564);
    }
    if (this.currentPort.contains("HK") && (this.destinationPort.contains("SY")) || (this.currentPort.contains("SY")) && (this.destinationPort.contains("HK"))) {
      setDestinationDistance(4539);
    }
  }

  public void portOptionDisplay(){
    System.out.println("\nYou are currently docked in " + this.currentPort);
  }

  public void setCurrentPort(String userDefinedCurrentPort){
    this.currentPort = userDefinedCurrentPort;
  }

  public String getDestinationPort(){
    return this.destinationPort;
  }

  public void setDestinationPort(String userDefinedDestinationPort){
    this.destinationPort = userDefinedDestinationPort;
  }

  public void setDestinationDistance(int definedDestinationDistance){
    this.destinationDistance = definedDestinationDistance;
  }

  public int getDestinationDistance(){
    return this.destinationDistance;
  }

/*    public void resetVariables(PlayerShip ps) {
        this.homePort = this.destinationPort;
        ps.setCurrentPort(this.homePort);
        this.destinationPort = "";
        ps.setDestinationPort("");
    }*/

    // LA to HK -- 6475nm
    // LA to SY -- 6564nm
    // HK to SY -- 4539nm
/*    public void seaMovement(PlayerShip ps) {
        Scanner scanner = new Scanner(System.in);
        randomOccurrence oc = new randomOccurrence();
        int speed = ps.getShipSpeed();
        int destinationDistance = nauticalMileDistance();
        int traveledDistance = 0;
        int dayCounter = 0;

        while (traveledDistance < destinationDistance) {
            System.out.println("Day " + (dayCounter + 1) + ". You have traveled " + traveledDistance + " miles of " + destinationDistance + " miles.");
            oc.randomContainer(ps);
            traveledDistance = traveledDistance + (speed * 24);
            dayCounter++;
//            scanner.nextLine();
        }
        resetVariables(ps);

    }*/

}
