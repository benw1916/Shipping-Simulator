/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shippingsimulator.src.main.utility;

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
import java.util.Random;
import java.util.Scanner;

public class Abstract {

    public static String getUserString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int userStringToInt() {
        String userString = getUserString();
        return Integer.parseInt(userString);
    }

    public static char userStringToChar() {
        String userString = getUserString();
        return userString.charAt(0);
    }

    public static void standardGameMenu(String[] menuOptions) {
        System.out.println("Available decisions: ");
        iterateThroughMenu(menuOptions);
        System.out.print("Make your selection: ");
    }

    private static void iterateThroughMenu(String[] menuOptions) {
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }
    }

    public static void sanityCheck() {

    }

    public int randomizedContainerValue() {
        // This will be modified to provide random values for everything.  Just moving it here.
        Random random = new Random();
        return random.nextInt(100);
    }

    public void choiceReaffirmation() {
        System.out.print("Are you ready? (Y/N): ");
        char departureSelection = userStringToChar();
        if (Character.toLowerCase(departureSelection) == 'n') {
            ;
        } else {

        }
    }

    public static int IntToNegativeNumber(int valueToNegative) {
        return valueToNegative *= -1;
    }

}
