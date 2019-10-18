/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shippingsimulator.src.main.inport;

import shippingsimulator.src.main.atsea.SeaMovement;
import shippingsimulator.src.main.inport.ContainerLoadUnload;
import shippingsimulator.src.main.inport.DestinationAndCurrentPort;
import shippingsimulator.src.main.inport.HarborMaster;
import shippingsimulator.src.main.inport.InPortMenu;
import shippingsimulator.src.main.inport.PortDepartureOptions;
import shippingsimulator.src.main.intro.Main;
import shippingsimulator.src.main.player.PlayerShip;
import shippingsimulator.src.main.player.PlayerShipMoney;
import shippingsimulator.src.main.player.PlayerShipPorts;
import shippingsimulator.src.main.utility.Abstract;
import shippingsimulator.src.main.utility.Gui;
import shippingsimulator.src.main.utility.Iteration;
import shippingsimulator.src.main.utility.randomOccurrence;

/**
 *
 * @author benja
 */
public class ContainerLoadUnload {

    private int containersOnShip;
    private int spaceAvailableOnShip;
    private String[] containerMenu = {"Load Ship", "Unload Ship", "Exit"};
    private String[] loadUnload = {"load", "unload"};

    public ContainerLoadUnload(PlayerShip ps) {
        this.containersOnShip = ps.getShipCurrentContainers();
        this.spaceAvailableOnShip = ps.getShipMaximumContainers();
    }

    public String[] getContainerMenu() {
        return this.containerMenu;
    }

    public String getContainerAmountOnShip() {
        return "Your ship currently has " + this.containersOnShip + " containers aboard.";
    }

    public String getContainerSpaceAvailableOnShip() {
        return "Your ship currently has " + this.spaceAvailableOnShip + " spaces available for containers.";
    }

    public void getContainerSpaceUsedAndAvailable() {
        System.out.println(getContainerAmountOnShip());
        System.out.println(getContainerSpaceAvailableOnShip());
    }

    public String containerPrice(PlayerShip ps) {
        //Not complete yet, I'll be adding in a monetary system soon.
        return "Containers in " + ps.getCurrentShipPort() + " are currently valued at $" + ". ";
    }

    public int requestedContainersOnShip(int value) {
        System.out.print("How many containers would you like to " + loadUnload[value] + ": ");
        //      int userDefinedLoadAddition = Abstract.userStringToInt();
        //      return userDefinedLoadAddition;
        return Abstract.userStringToInt();
    }

    // public int requestedLoadContainersOnShip() {
    //    System.out.print("How many containers would you like to load: ");
    //   int userDefinedLoadAddition = Abstract.getUserInt();
    //  return userDefinedLoadAddition;
    // }
    //public int requestedUnloadContainersOnShip() {
    //   System.out.print("How many containers would you like to unload: ");
    //  int userDefinedloadSubtraction = Abstract.getUserInt();
    // return userDefinedloadSubtraction;
    //}
    //public void additionSanityCheck(int requestedIncreaseInContainers) {
    //  if ((requestedIncreaseInContainers + this.containersOnShip) > (this.containersOnShip + this.spaceAvailableOnShip) || this.containersOnShip >= this.spaceAvailableOnShip) {
    //      System.out.println("Sorry, you already have " + this.containersOnShip + " containers loaded.");
    //     requestedLoadContainersOnShip();
    //  }
    //}
    // public void subtractionSanityCheck(int requestedDecreaseInContainers) {
    //    if ((requestedDecreaseInContainers - this.containersOnShip) < 0 || this.containersOnShip == 0) {
    //       System.out.println("Sorry, you only have " + this.containersOnShip + " containers loaded.");
    //      requestedUnloadContainersOnShip();
    //  }
    //}
    public void loaderSanityCheck(int containerAmount, PlayerShip ps) {
        if (containerAmount > 0) {

            if (containerAmount > this.spaceAvailableOnShip) {
                System.out.println("Sorry, you already have " + this.containersOnShip + " containers loaded.");
                Iteration itr = new Iteration();
                //     itr.containerLoaderIteration(ps);
                itr.mainGameIteration(ps);
            }

        } else {
            if (containerAmount > this.containersOnShip) {
                System.out.println("Sorry, you only have " + this.containersOnShip + " containers loaded.");
                Iteration itr = new Iteration();
                itr.mainGameIteration(ps);
                //itr.containerLoaderIteration(ps);
            }
        }
    }

    public void containerIntroduction() {
        System.out.println("Welcome to the container crane load / unload system.");
    }

    public void craneDecisionParser(int userInput, PlayerShip ps) {
        Iteration itr = new Iteration();
        switch (userInput) {
            case 1:
                int loadValue = requestedContainersOnShip(userInput);
                loaderSanityCheck(loadValue, ps);
                ps.setShipCurrentContainers(this.containersOnShip + loadValue);
                itr.inPortIteration(ps);
            case 2:
                int loaderValue = requestedContainersOnShip(userInput);
                loaderValue = Abstract.IntToNegativeNumber(loaderValue);
                loaderSanityCheck(loaderValue, ps);
                ps.setShipCurrentContainers(loaderValue - this.containersOnShip);
                itr.inPortIteration(ps);
            case 3:
                itr.inPortIteration(ps);
            default:
            ;

        }
    }

}
