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
public class Iteration {

    public void inPortIteration(PlayerShip ps) {
        InPortMenu ipu = new InPortMenu();
        ipu.inPortMenuBlock(ps);
    }

    public void mainGameIteration(PlayerShip ps) {
        PortDepartureOptions pdo = new PortDepartureOptions(ps.getCurrentShipPort());
        System.out.println(ps.displayCurrentPortMessage());
        String userChosenPort = pdo.portDecisionDisplay();
        ps.portSanityCheck(userChosenPort);
        SeaMovement sm = new SeaMovement(ps.getCurrentShipPort(), ps.getDestinationShipPort());
        sm.seaMovement(ps);
        System.out.println(ps.displayCurrentPortMessage());
        inPortIteration(ps);
    }

    public void containerLoaderIteration(PlayerShip ps){
        ContainerLoadUnload clu = new ContainerLoadUnload(ps);
        clu.containerIntroduction();
        clu.getContainerSpaceUsedAndAvailable();
        Abstract.standardGameMenu(clu.getContainerMenu());
        int userSelection = Abstract.userStringToInt();
        clu.craneDecisionParser(userSelection, ps);
    }

    public void harborMasterItration(PlayerShip ps){
        HarborMaster hm = new HarborMaster();
        hm.harborMasterIntroduction();
    }

}
