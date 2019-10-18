/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shippingsimulator.src.main.player;

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
public class PlayerShip extends PlayerShipPorts {

    private int shipSpeed;
    private int shipMaximumContainers;
    private int shipCurrentContainers;

    public PlayerShip() {
        this.shipSpeed = 12;
        this.shipCurrentContainers = 0;
        this.shipMaximumContainers = 100;
    }

    public int getShipCurrentContainers() {
        return this.shipCurrentContainers;
    }

    public int getShipSpeed() {
        return this.shipSpeed;
    }

    public int getShipMaximumContainers() {
        return this.shipMaximumContainers;
    }

    public void setShipSpeed(int userInputSpeed) {
        this.shipSpeed = userInputSpeed;
    }

    public void setShipMaximumContainers(int userInputMaxContainers) {
        this.shipMaximumContainers = userInputMaxContainers;
    }

    public void setShipCurrentContainers(int userInputCurrentContainers) {
        this.shipCurrentContainers = userInputCurrentContainers;
    }

    public void getShipStatistics() {
        System.out.println("Ship Speed: " + this.shipSpeed);
        System.out.println("Ship Max Containers: " + this.shipMaximumContainers);
        System.out.println("Ship Current Containers: " + this.shipCurrentContainers);
    }
}
