package src.main.java;

import java.awt.event.KeyEvent;

public class Main{
	public static void main(String[] args){
		dateDisplay.displayDate();
		User playerObject = new User("USS Enterprise", UpgradePath.getDefaultUserShip());
		playerObject.setSpeed(12);
		playerObject.getUserReadout();
		PortChoice portDecision = new PortChoice();
		Goods goods = new Goods();
		Movement move = new Movement();

		while(true){
			goods.iteration(playerObject);
			portDecision.iteration(playerObject);
			move.iteration(playerObject, portDecision);
		}		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_Q){
			System.out.println("Goodbye");
			System.exit(0);
		}
	}

}
