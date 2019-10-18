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

import java.util.Random;

public class randomOccurrence {
    
    
    public void randomContainer(PlayerShip ps){
        possibleIssue();
    }
    
    
    public void possibleIssue(){
        Random ran = new Random();
        if(ran.nextInt(100) < 5){
            System.out.println("Oh no, something bad happened.");
        }
    }
      
    
}
