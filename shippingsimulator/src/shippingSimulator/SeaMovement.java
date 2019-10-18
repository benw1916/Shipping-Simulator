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
import java.util.Scanner;

public class SeaMovement {
    
    private String homePort;
    private String destinationPort;
    
    public SeaMovement(String originPort, String destinationPort) {
        this.homePort = originPort;
        this.destinationPort = destinationPort;
    }
    
    public int nauticalMileDistance() {
        if ((this.homePort.contains("LA")) && (this.destinationPort.contains("HK")) || (this.homePort.contains("HK")) && (this.destinationPort.contains("LA"))) {
            return 6475;
        }
        if (this.homePort.contains("LA") && (this.destinationPort.contains("SY")) || (this.homePort.contains("SY")) && (this.destinationPort.contains("LA"))) {
            return 6564;
        }
        if (this.homePort.contains("HK") && (this.destinationPort.contains("SY")) || (this.homePort.contains("SY")) && (this.destinationPort.contains("HK"))) {
            return 4539;
        }
        return 0;
    }
    
    public void resetVariables(PlayerShip ps) {
        this.homePort = this.destinationPort;
        ps.setCurrentPort(this.homePort);
        this.destinationPort = "";
        ps.setDestinationPort("");
    }

    // LA to HK -- 6475nm
    // LA to SY -- 6564nm
    // HK to SY -- 4539nm
    public void seaMovement(PlayerShip ps) {
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
        
    }
    
}
