package main.java;

import main.java.Player.*;
import main.java.Abstract.*;
import main.java.Port.Port;
import main.java.Sailor.SailorMenu;
import main.java.Ship.Ship;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.*;

public class ShoreSide{

	Port currentPort;
	WindowManager display;
	String shoreChoice = "";
	boolean textReceived = false;

	public ShoreSide(Ship playerObject, AvailablePorts allPorts, WindowManager windowManager) {
		this.display = windowManager;

		JTextField jtf = display.GetUserInputBox();
		jtf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textReceived = true;
				synchronized (jtf) {
					// notify game loop thread which is waiting on this event
					jtf.notifyAll();
				}
			}
		});
		new Thread(new Runnable() {
			@Override
			public void run() {
				ShoreOpener(playerObject, allPorts);
				System.out.println("Yeet");
			}

		}).start();

	}


	public void ShoreOpener(Ship playerObject, AvailablePorts allPorts){
		int userInput = 0;
		display.AppendUpdateTab(System.lineSeparator() + System.lineSeparator() + "You and your crew step ashore." + System.lineSeparator());
		do {
			display.AppendUpdateTab(ShoreMenu());
			display.AppendUpdateTab(": ");
			userInput = Integer.parseInt(requestInput());
			this.display.AppendUpdateTab(userInput);
		} while (userInput != 1 && userInput != 2 && userInput != 3 && userInput != 4 && userInput != 5);
		ParseShoreMenu(playerObject, userInput, allPorts);
	}



	private String requestInput() {
		JTextField textField = display.GetUserInputBox();
		textField.setEnabled(true);
		textField.requestFocus();
		// wait on text field till UI thread signals a user input event
		synchronized (textField) {
			while (!textReceived) {
				try {
					textField.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		String input = textField.getText();
		textField.setText("");
		textField.setEnabled(false);
		textReceived = false;
		return input;
	}



	/*	currentPort = Abstract.ReturnCurrentPort(playerObject, allPorts);
		int shoreSideChoice = 0;
		display.AppendUpdateTab("\nYou and your crew step ashore.");
	//	do{
			//Abstract.RotateOptions(MenuDisplays.GetShoreOptionMenu()); //"Check Weather Report", "Manage crewmembers", "Check Ship Status", "Refuel Ship", "Check Port Prices", "Hotel Visit" ,"Go Back"
			display.AppendUpdateTab(ShoreMenu());
			display.AppendUpdateTab(": ");

			JButton buttonReader = this.display.GetReturnButton();
			buttonReader.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SubmitAction();
					//	ButtonPress();
					//	ParseGoodsMenu(goodsChoice, playerObject);
					//	display.GetUserInputBox().setText("");
				}
			});

			shoreSideChoice = parseShoreMenu(playerObject, shoreChoice, allPorts);*/

/***************************************/
	
//		do{
		//	Abstract.rotateOptions(MenuDisplays.getShoreOptionMenu());
		//	System.out.print("blerp: ");
		//	shoreSideChoice = parseShoreMenu(playerObject, Abstract.scannerInt());
	//	}while(shoreSideChoice >= MenuDisplays.GetShoreOptionMenu().length);
	//}


	private void SubmitAction() {
		display.AppendUpdateTab(this.display.GetUserInput());
		shoreChoice = this.display.GetUserInput();
		//	display.GetUserInputBox().setText("");
		//System.out.println(userWord);//do whatever you want with the variable, I just printed it to the console
	}

	private String ShoreMenu(){
		StringBuilder shoreMenuDisplay = new StringBuilder();
		for(int iterativeCount = 0; iterativeCount < MenuDisplays.GetShoreOptionMenu().length; iterativeCount++){
			shoreMenuDisplay.append((iterativeCount + 1) +  ". " + MenuDisplays.GetShoreOptionMenu()[iterativeCount] + System.lineSeparator());
		}
		return shoreMenuDisplay.toString();
		//display.AppendUpdateTab(Abstract.RotateOptions(MenuDisplays.GetGoodsMenu())); //"Load / Unload Containers", "Step Ashore" ,"Depart Port"
		//System.out.print(": ");
	}

	public void PriceDisplay(Ship playerObject){
		System.out.println();
	//	playerObject.DisplayContainerQuantityAndPrice();
//		System.out.println(playerObject.DisplayCurrentContainers() + "\n"); // This is currently broken
	}
	
	private int ParseShoreMenu(Ship playerObject, int userDecision, AvailablePorts allPorts){
		System.out.println("Shore Parser");
		System.out.println(userDecision);
		Map<Integer, Runnable> shoreMenu = new HashMap<>();
		shoreMenu.put(1, () -> new Weather().FormattedWeatherAndTemperature(5)); //"Check Weather Report"
		shoreMenu.put(2, () -> new SailorMenu(playerObject, allPorts, display)); //"Manage crewmembers"
		shoreMenu.put(3, () -> ShipStatusSubmenu(playerObject, currentPort)); // Jumps to Checking ship Status.  Will eventually revamp this.
		shoreMenu.put(4, () -> shipFuel(playerObject, currentPort));//"Refuel Ship" // Jumps to refueling the ship.  Will eventually revamp this.
		shoreMenu.put(5, () -> PriceDisplay(playerObject)); //"Check Port Prices"
		//shoreMenu.put(6, () ->); // new SaveLoad(playerObject, ports)); //"Hotel Visit"
		//shoreMenu.put(4, () -> new GlobalContainerPrices()); // Jumps to Global Ports and prices.
		
		if(userDecision <= 6 && userDecision > 0){
			shoreMenu.get(userDecision).run();
		} 
		return userDecision;
	}
	
/*	 private void ContainerPrices(){
		for(int i = 0; i < MenuDisplays.GetPortNameLength(); i++){
			System.out.println("\n\n\t\t  --" + MenuDisplays.GetPortName(i) + "-- ");
			System.out.println("Container Type -- Container Count -- Price Per Container");
			for(int x = 0; x < 8; x++){
				System.out.print(" " + Abstract.ModifyContainerLength(MenuDisplays.GetPortName(i), 13));
				System.out.print(" --    " + Abstract.ModifyContainerLength("" + this.travelPorts.get(i).getQuantity(x), 4));
				System.out.print("    --    $" + this.travelPorts.get(i).getPrice(x) + "\n");
			}
		}
		System.out.println("\n");
	}*/
	
	public void ShipStatusSubmenu(Ship playerObject, Port currentPort){
		int subMenuChoice = 0;
		do{
			Abstract.RotateOptions(MenuDisplays.GetShoreSubMenu()); //"Check for Damage", "Refit Storage", "Upgrade Ship", "Go Back"
			System.out.print(": ");
			//subMenuChoice = parseSubShoreMenu(playerObject, Abstract.ScannerInt());
		}while(subMenuChoice >= MenuDisplays.GetShoreSubMenu().length);
	}
	
	private int parseSubShoreMenu(Ship playerObject, Port currentPort, int userDecision){
		Map<Integer, Runnable> shoreMenu = new HashMap<>();
		shoreMenu.put(1, () -> new Weather().FormattedWeatherAndTemperature());//Weather
		shoreMenu.put(2, () -> new ShipModifications(playerObject));// Jumps to Checking ship Status.  Will eventually revamp this.
		shoreMenu.put(3, () -> shipFuel(playerObject, currentPort)); // Refuels the ship.
		shoreMenu.put(4, () -> PriceDisplay(playerObject));
	//	shoreMenu.put(5, () -> new SaveLoad(playerObject, ports));
		//shoreMenu.put(4, () -> new GlobalContainerPrices()); // Jumps to Global Ports and prices.
		
		if(userDecision <= 5 && userDecision > 0){
			shoreMenu.get(userDecision).run();
		} 
		return userDecision;
	}
	
	private void DamageCheck(Boat playerObject){
		System.out.println();//"Engine", "Zincs", "Hull damage"); 
		
	}
	
	public void UpgradeShip(Boat playerObject){
		/*String[] upgradeOneShip = {"225", "0", "15"};//, "2.1"};
		System.out.println("Current ship features: ");
		playerObject.GetUpgradeReadout();
		System.out.println("Available ship: ");
		UpgradePath.DisplayAvailableShips(upgradeOneShip);
		System.out.print("Would you like to upgrade for $ " + " : ");
		Abstract.ScannerString();*/

		
	}
	
	public void installCrane(Ship playerObject, Port currentPort){
		System.out.println("Your ship currently has " + playerObject.GetCraneCount() + " cranes installed.");
		System.out.println("Crane installation will cost $");
		System.out.println("It will take two weeks to install the crane.");
		System.out.print(": ");
		char craneInstall = Abstract.ScannerChar();
		if(craneInstall == 'y' || craneInstall == 'Y'){
			;
		} else {
			;
		}
	}
	
	public void shipFuel(Ship playerObject, Port currentPort){
		double fuelPrice = currentPort.GetFuelPrice();
		System.out.println("You pull your ship up to the fuel port.");
		double fuelToFill = (playerObject.GetMaxFuel() - playerObject.GetCurrentFuel());
		double fuelToFillPrice = fuelToFill * fuelPrice;
		playerObject.DisplayCurrentFuel();
		playerObject.DisplayMaxFuel();
		playerObject.GetFuelPercentage();
		System.out.println("Fuel to fill: " + fuelToFill + " tons ");
		playerObject.DisplayMoney();
		System.out.println("Current fuel price per ton: $" + fuelPrice);
		System.out.println("Price to fill ship: $" + fuelToFillPrice);
		if(fuelToFill == 0){
			System.out.println("Your ship fuel tanks are full.\n");
			Abstract.PressAnyKey();
		} else {
			if(playerObject.GetMoney() < fuelToFillPrice){
				System.out.println("\n\nSorry, you do not have enough funds to completely fill your ship.\n");
				System.out.print("How many gallons would you like to fill?: ");
				int gallonRequest = Abstract.ScannerInt();
				if(gallonRequest <= fuelToFill && playerObject.GetMoney() >= (gallonRequest * fuelPrice)){
					playerObject.SetFuelCurrent(gallonRequest);
					playerObject.DeductMoney((gallonRequest * fuelPrice));
				}
			} else {
				System.out.print("Would you like to fill up your ship? : ");
				char fuelYN = Abstract.ScannerChar();
				if(fuelYN == 'Y' || fuelYN == 'y'){
					playerObject.SetFuelCurrent(playerObject.GetMaxFuel());
					playerObject.DeductMoney(fuelToFill);
				}
			}
		}
		
		//System.out.print(" : ");
		//char leave = Abstract.ScannerChar();
	}
	
	
}