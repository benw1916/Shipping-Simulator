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
public class InPortMenu {

    private final String[] inPortMenu = {"Depart for the next port", "Load Containers", "Speak with Harbormaster", "Retire"};

    public InPortMenu() {
    }

    public void inPortDecisionParser(PlayerShip ps) {
        int menuDecision = Abstract.userStringToInt();
        switch (menuDecision) {
            case 1:
                Iteration it = new Iteration();
                it.mainGameIteration(ps);
            case 2:
                Iteration it2 = new Iteration();
                it2.containerLoaderIteration(ps);

            case 3:
                Iteration it3 = new Iteration();
                it3.harborMasterItration(ps);
            case 4:
                System.out.println("Thank you for playing.");
                System.exit(0);
            default:
                System.out.println("Sorry, that's not an appropriate response.");
                inPortDecisionParser(ps);
        }
    }

    public void inPortMenuBlock(PlayerShip ps) {
        // inPortPrimaryMenu();
        Abstract.standardGameMenu(inPortMenu);
        inPortDecisionParser(ps);
    }

}
