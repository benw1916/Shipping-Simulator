/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipping-simulator.src.main.intro;

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
