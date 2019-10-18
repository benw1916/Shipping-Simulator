/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shippingsimulator.src.main.player;

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
public class PlayerShipMoney  {

    private int playerMoney;

    public PlayerShipMoney() {
        this.playerMoney = 5000;
    }

    public void setPlayerMoney(int inputPlayerMoney) {
        this.playerMoney = inputPlayerMoney;
    }

    public int getPlayerMoney() {
        return this.playerMoney;
    }

    public void increasePlayerMoney(int userInputIncreaseAmount) {
        this.playerMoney = (this.playerMoney + userInputIncreaseAmount);
    }

    public void decreasePlayerMoney(int userInputDecreaseAmount) {
        this.playerMoney = (this.playerMoney - userInputDecreaseAmount);
    }

    public String toString() {
        return "" + this.playerMoney;
    }
}
