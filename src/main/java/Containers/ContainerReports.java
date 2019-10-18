package main.java.Containers;

import javafx.beans.WeakInvalidationListener;
import main.java.Abstract.Abstract;
import main.java.AvailablePorts;
import main.java.Port.Port;
import main.java.Ship.Ship;
import main.java.WindowManager;

public class ContainerReports {

    WindowManager windowManager;

    public void DisplayGlobalContainerPrices(AvailablePorts allPorts, WindowManager wm){ // Displays container prices for all available ports.
        windowManager = wm;
        System.out.println(allPorts.GetSize());
        for(int q = 0; q < allPorts.GetSize(); q++){
            //if(currentPort.GetPortName(q).contains(passedCurrentPort)){
            ContainerTypeReadout(allPorts.GetPort(q));
            //}
        }
    }



    public void ContainerTypeReadout(Port passedPort){
        windowManager.AppendUpdateTab(System.lineSeparator() + "\t  -- " + passedPort.DisplayLocation() + " -- " + System.lineSeparator());
        windowManager.AppendUpdateTab("Container Type -- Container Count -- Price Per Container" + System.lineSeparator());
        for(int x = 0; x < ContainerTypes.getContainerSize() - 1 ; x++){
            windowManager.AppendUpdateTab(" " + Abstract.ModifyContainerLength(passedPort.GetOutputContainerName(x), 13));
            windowManager.AppendUpdateTab(" --    " + Abstract.ModifyContainerLength("" + passedPort.GetOutputContainerCount(x), 9));
            windowManager.AppendUpdateTab("    --    $" + passedPort.GetOutputContainerPrice(x) + "\n");
        }
        windowManager.AppendUpdateTab(System.lineSeparator());
    }

    public void ExamineContainers(Ship playerObject, AvailablePorts allPorts){ // Displays a simple description of each type of container.
        Port currentPort = Abstract.ReturnCurrentPort(playerObject, allPorts);
        String[] examineContainerDescription = {"Standard containers are the most known 40' containers.  In a variety of colors, and condition, these containers are easily moved on ships, trains and trucks.  These are carry a wide variety of items; tee shirts, to pots and pans, and everything in between.", "Volatile containers have similar dimensions as standard containers, but these containers are usually used to move chemicals and compounds that require a bit more care than standard containers.  ", "Vehicle containers are relatively self explanitory; this is a method of loading vehicles into containers and moving them across the ocean via cargo ship.", "Refrigeration containers are slightly larger than standard containers, but these require special equipment to keep the contents chilled.", "Oil bulk is moved", "grain bulk", "gravel bulk", "chemical bulk" };
        windowManager.AppendUpdateTab("What containers would you like to examine: ");
        Abstract.RotateOptions(ContainerTypes.getAllContainerTypes());
        int examineChoice = Abstract.ScannerInt();
        System.out.println(examineContainerDescription[examineChoice - 1]);
        Abstract.PressAnyKey();
        windowManager.AppendUpdateTab("\nPrice of the container in your available ports: ");
      // for(int i = 0; i < .GetPortCount(); i++){
            System.out.println(currentPort.DisplayLocation()/*.GetPortName(i) */+ " -- " + currentPort.GetOutputContainerName(examineChoice) + currentPort.GetOutputContainerPrice(examineChoice));
        //}
        System.out.println();
    }


}
