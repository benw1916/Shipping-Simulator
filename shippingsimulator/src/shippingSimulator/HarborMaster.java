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
public class HarborMaster {
    
    private final String[] harborDecisions = {"Request travel to additional ports", "Upgrade ship"};
    
    public String harborMasterIntroduction(){
        return "The harbormaster waves you into his office.";
    }
    
    public void harborBlock(){
        Abstract.standardGameMenu(harborDecisions);
    }

    
}
