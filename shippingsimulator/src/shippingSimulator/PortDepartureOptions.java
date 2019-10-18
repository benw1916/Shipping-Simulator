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
