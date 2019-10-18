/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shippingSimulator;

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
