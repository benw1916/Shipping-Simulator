package main.java.Containers;

import com.sun.javaws.WinOperaSupport;
import main.java.*;
import main.java.Graphics.MovementGraphics;
import main.java.Player.*;
import main.java.Abstract.*;
import main.java.AvailablePorts;
import main.java.Port.Port;
import main.java.Ship.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.*;

public class LoadUnloadContainers {

	WindowManager display;
	GameMap userMap;

	boolean textReceived = false;
	boolean ExitCode = false;
//	String value = "";
	AvailablePorts allPorts;

	boolean loadedContainersHere = false;

	public LoadUnloadContainers(Ship playerObject, AvailablePorts passedAllPorts, GameMap gameMap, WindowManager wm) {
		InitializeWindowManager(wm);
		userMap = gameMap;
		allPorts = passedAllPorts;
		JTextField jtf = display.GetUserInputBox();
		jtf.addActionListener(new ActionListener() {
			@Override
			// user pressed 'enter' key,
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
				do {
					DisplayMainMenu(playerObject);
					System.out.println("Yeet");
				}while(ExitCode == false);
			}

		}).start();
	}

	public void DisplayMainMenu(Ship playerObject) {
		int userInput = 0;
		do {
			this.display.AppendUpdateTab(System.lineSeparator() + GoodsMenu(MenuDisplays.GetGoodsMenu()));
			this.display.AppendUpdateTab("Your choice: ");
			userInput = Integer.parseInt(requestInput());
			this.display.AppendUpdateTab(userInput);
		} while (userInput != 1 && userInput != 2 && userInput != 3);
		ParseGoodsMenu(userInput, playerObject);
	}

	private void InitializeWindowManager(WindowManager wm) {
		this.display = wm;
	}

	private String GoodsMenu(String[] menuDisplay) {
		StringBuilder goodsMenuDisplay = new StringBuilder();
		for (int iterativeCount = 0; iterativeCount < menuDisplay.length; iterativeCount++) {
			goodsMenuDisplay.append((iterativeCount + 1) + ". " + menuDisplay[iterativeCount] + System.lineSeparator());
		}
		return goodsMenuDisplay.toString();
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

	private int ParseGoodsMenu(int userInputGoodsMenuDecision, Ship playerObject){
		Map<Integer, Runnable> goodsMenu = new HashMap<>();
		goodsMenu.put(1, () -> ContainerMenu(playerObject));//"Load / Unload Containers"
		goodsMenu.put(2, () -> new ShoreSide(playerObject, allPorts, display));//"Step Ashore"
		//goodsMenu.put(3, () -> return 3); //,"Depart Port"
		if(userInputGoodsMenuDecision == 3){
			ExitCode = true;
		}
		if(userInputGoodsMenuDecision == 2 || userInputGoodsMenuDecision == 1){
			goodsMenu.get(userInputGoodsMenuDecision).run();
		}
		return userInputGoodsMenuDecision;
	}

	// 130 - 150 meter -- 12 crew 
	// 200 meter -- 20 crew
/*	private boolean CrewMemberCount(Ship playerObject){
		if(playerObject.GetSailorCount() < 2){
			display.AppendUpdateTab("Notice: You have less than 2 sailors aboard.");
			return false;
		} else{
			return true;
		}
	}

	private void SubmitContainerAction() {
		display.AppendUpdateTab(this.display.GetUserInput());
		containerAction = this.display.GetUserInput();
		//	display.GetUserInputBox().setText("");
		//System.out.println(userWord);//do whatever you want with the variable, I just printed it to the console
	}*/
	
	private void ContainerMenu(Ship playerObject) {//, AvailablePorts ports){

		int userInput = 0;
		do {
			display.AppendUpdateTab(System.lineSeparator() + "Load or Unload" + System.lineSeparator());
			display.AppendUpdateTab(GoodsMenu(MenuDisplays.GetContainerMenu()));
			display.AppendUpdateTab(": ");
			userInput = Integer.parseInt(requestInput());
			this.display.AppendUpdateTab(userInput);
		} while (userInput != 1 && userInput != 2 && userInput != 3 && userInput != 4 && userInput != 5 && userInput != 6);
		ContainerParser(userInput, playerObject, allPorts);
	}

	private int ContainerParser(int userDecision, Ship playerObject, AvailablePorts ports){
		System.out.println("Container Parser");
		Map<Integer, Runnable> loadUnloadMenu = new HashMap<>();
		System.out.println("user Decision:" + userDecision);
		loadUnloadMenu.put(1, () -> new ContainerReports().DisplayGlobalContainerPrices(allPorts, display));  //"Check Container Prices"
		loadUnloadMenu.put(2, () -> display.AppendUpdateTab(playerObject.DisplayContainerSlipQuantity()));//Display Loaded Containers
		loadUnloadMenu.put(3, () -> LoadContainers(playerObject, ports)); //"Load Containers"
		loadUnloadMenu.put(4, () -> UnloadContainers(playerObject, ports)); //"Unload Containers"
		loadUnloadMenu.put(5, () -> new ContainerReports().ExamineContainers(playerObject, allPorts)); //"Examine Containers"
		loadUnloadMenu.put(6, () -> DisplayMainMenu(playerObject)); //"Examine Containers"
		if(userDecision >= 1 && userDecision <= 6){
			System.out.println("Inside the Container Parser");

			loadUnloadMenu.get(userDecision).run();
		}
		return userDecision;
	}
	

	private void LoadContainers(Ship playerObject, AvailablePorts ports){ // Load containers from the port onto the ship.
		MovementGraphics.LoadUnloadGraphics();
		Port currentPort = ports.GetPort(playerObject.GetLocation());
		if(playerObject.IsShipFull()){
			display.AppendUpdateTab("Your ship already has a full load!");
		} else {
			new ContainerReports().ContainerTypeReadout(currentPort);
	//		playerObject.DisplayContainerSlipQuantity();
		//	port.DisplayContainerReadout();
		//	ContainersInPort(playerObject);
			display.AppendUpdateTab("What type of containers would you like to load: (1,2,3... | 0 for back): ");
			int loadContainerType = Abstract.ScannerInt();
			if(loadContainerType != 0){
				display.AppendUpdateTab("What quantity of containers would you like to load: ");
				int containerCount = Abstract.ScannerInt();
				if((currentPort.GetOutputContainerCount((loadContainerType - 1) - containerCount) >= 0)){
					String containerType = ContainerTypes.getContainerTypes(loadContainerType - 1);
					currentPort.DecreaseOutgoingContainerCount(loadContainerType, containerCount);
					//ports.decreaseQuantity(ports.GetPortName(), (loadContainerType - 1), containerCount);
				//if((containerCount - playerObject.GetContainerCount()) >= 0){
		//			playerObject.CheckContainerSlips(playerObject.GetLocation(), containerType, containerCount, ports.getContainerPrice(playerObject.GetLocation(), containerType));
					System.out.println("\nSuccess. " + containerCount + " containers have been loaded on your ship.\n");
				}
				this.loadedContainersHere = true;
			}
		}
	//	playerObject.IncreaseDay(playerObject);
	}

	private boolean AreContainersLoadedHere(){
		return this.loadedContainersHere;
	}

	private void UnloadContainers(Ship playerObject, AvailablePorts ports){ // Unload containers that are currently onboard the ship.
		MovementGraphics.LoadUnloadGraphics();
		display.AppendUpdateTab(playerObject.GetLocation());// );println(this.loadContainerPort);
		if(playerObject.IsShipEmpty()){
			display.AppendUpdateTab("Your ship is empty. ");
		}
		else if(AreContainersLoadedHere()){
			display.AppendUpdateTab("You loaded your ship in this port.  You can't unload the containers.");
		} else{
			playerObject.DisplayContainerSlipQuantity();
			//ContainersInPort(playerObject);
			display.AppendUpdateTab("What container set would you like to unload: ");
			int containerSet = Abstract.ScannerInt();
			display.AppendUpdateTab("How many containers would you like to unload: ");
			int unloadRequest = Abstract.ScannerInt();
			if(unloadRequest > 0 && unloadRequest <= playerObject.GetMaxLoad()){
			//	playerObject.DecreaseContainerSlips((containerSet - 1), unloadRequest);
			//	playerObject.displayMoneyIncrease(containerSet, playerObject.getContainerPrice(containerSet));
				display.AppendUpdateTab("\nSuccess. " + unloadRequest + " containers have been unloaded on your ship.\n");
			//	playerObject.RemoveEmptySlip();
			}

		}
		userMap.IncreaseDay();
		display.UpdateDateText(userMap.GetDate());
	}

}