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
public class HarborMaster {

    private final String[] harborDecisions = {"Request travel to additional ports", "Upgrade ship"};

    public String harborMasterIntroduction(){
        return "The harbormaster waves you into his office.";
    }

    public void harborBlock(){
        Abstract.standardGameMenu(harborDecisions);
    }


}
