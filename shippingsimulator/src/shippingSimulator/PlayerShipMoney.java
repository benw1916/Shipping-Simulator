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
