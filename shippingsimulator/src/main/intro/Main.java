/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shippingsimulator.src.main.intro;

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
public class Main {

    public static void main(String[] args) {
        PlayerShip ps = new PlayerShip();
        DestinationAndCurrentPort ip = new DestinationAndCurrentPort();
        Iteration iter = new Iteration();


        while (true) {
            iter.inPortIteration(ps);

            //    InPortMenu ipu = new InPortMenu();
            //   ipu.inPortMenuBlock(ps);
            PortDepartureOptions po = new PortDepartureOptions(ps.getCurrentShipPort());
            //  po.portArrivalMessage();
            //  String userDecision = po.userInput();
            String chosenPort = po.portDecisionParse();
            ip.portSanityCheck(chosenPort);

            SeaMovement ss = new SeaMovement(ps.getCurrentShipPort(), ps.getDestinationShipPort());
            ss.seaMovement(ps);

            //   ps.destinationArrival();
        }
    }
}
