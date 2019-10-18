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
