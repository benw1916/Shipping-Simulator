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
public class PortDepartureOptions {

    private final String[] portLocations = {"LA", "HK", "SY"};
    private String currentPort;

    public PortDepartureOptions(String currentPort) {
        this.currentPort = currentPort;
    }

    public String getCurrentPort(){
        return this.currentPort;
    }

    public String portDecisionDisplay(){
        Abstract.standardGameMenu(portLocations);
        return portDecisionParse();
    }

    public String portDecisionParse() {
        int valueShift = Abstract.userStringToInt();
        return (portLocations[valueShift - 1]);
    }

}
