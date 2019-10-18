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
public class PlayerShipPorts extends PlayerShipMoney {

    private String currentPort;
    private String destinationPort;

    public PlayerShipPorts() {
        this.currentPort = "LA";
        this.destinationPort = "";
    }

    public String getCurrentShipPort() {
        return this.currentPort;
    }

    public String getDestinationShipPort() {
        return this.destinationPort;
    }

    public void setCurrentPort(String userInputShipPort) {
        this.currentPort = userInputShipPort;
    }

    public void setDestinationPort(String portAssignment) {
        this.destinationPort = portAssignment;
    }

    public void portSanityCheck(String userDefinedPort) {
        if (userDefinedPort.equals(this.destinationPort)) {
            System.out.println("Sorry, you are already in " + this.currentPort + ". ");
        } else {
            this.destinationPort = userDefinedPort;
        }
    }

    public String displayDestinationPortMessage() {
        return "You are currently heading towards " + this.destinationPort + ". ";
    }

    public String displayCurrentPortMessage() {
        return "You are currently docked in " + this.currentPort + ". ";
    }

}
