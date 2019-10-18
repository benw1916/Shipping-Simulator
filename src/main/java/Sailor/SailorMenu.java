package main.java.Sailor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import main.java.AvailablePorts;
import main.java.MenuDisplays;
import main.java.Player.*;
import main.java.Abstract.*;
import main.java.Port.Port;
import main.java.Ship.Ship;
import main.java.WindowManager;

import javax.swing.*;

public class SailorMenu{
	ArrayList<Sailor> SailorsAboard = new ArrayList<Sailor>();
	boolean generatorStatus = false;
	Port currentPort;
	WindowManager windowManager;

	String hireChoice = "";
	boolean textReceived = false;

	public SailorMenu(Ship playerObject, AvailablePorts allPorts, WindowManager display){
		this.windowManager = display;
		this.currentPort = Abstract.ReturnCurrentPort(playerObject, allPorts);


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
				copyMembersFromPlayer(playerObject);
				hireOrFire(playerObject);
			}

		}).start();

	}
	
	private void copyMembersFromPlayer(Ship playerObject){
		if(playerObject.AnySailors()){
			this.SailorsAboard.addAll(playerObject.GetAllSailors());
		}
		/*	for(int i = 0; i < playerObject.GetSailorCount(); i++){
				this.SailorsAboard.add(playerObject.GetSailor(i));
			}
		}*/
	}
	
	private void displayPlayerSailors(Ship playerObject){
		windowManager.AppendUpdateTab("----- Your Hired Sailors -----");
		if(playerObject.AnySailors()){
			for(int x = 0; x < getSailorCount(); x++){
				playerObject.GetSailor(x).DisplaySailorVitals();// .DisplaySailorVitals(this.SailorsAboard.get(x));
				windowManager.AppendUpdateTab("Time in Contract: ");
				for(int i = 0; i < new Skillset().getSkillSize(); i++){
					windowManager.AppendUpdateTab(this.SailorsAboard.get(x).GetSkillTitle(i) + ": " + this.SailorsAboard.get(x).GetSkill(i) );
				}
			}
			System.out.println();
		} else {
			windowManager.AppendUpdateTab("\nYou don't have any crewmembers!\n");
		}
	}
	
	private int getSailorCount(){
		return this.SailorsAboard.size();
	}


	private void SubmitAction() {
		windowManager.AppendUpdateTab(this.windowManager.GetUserInput());
		hireChoice = this.windowManager.GetUserInput();
		//	display.GetUserInputBox().setText("");
		//System.out.println(userWord);//do whatever you want with the variable, I just printed it to the console
	}


	private void hireOrFire(Ship playerObject) {
		String userInput = "";
		do {
			windowManager.AppendUpdateTab(System.lineSeparator() + "Are you looking to add sailors, or make " + System.lineSeparator() + "changes to your current roster(Hire/fire/examine/totals/Back): ");
				userInput = requestInput();
				windowManager.AppendUpdateTab(userInput);
		} while (hireChoice.equalsIgnoreCase("Hire") || hireChoice.equalsIgnoreCase("h") || hireChoice.equalsIgnoreCase("1") || hireChoice.equalsIgnoreCase("examine") || hireChoice.equalsIgnoreCase("e") || hireChoice.equalsIgnoreCase("3") );
		if (hireChoice.equalsIgnoreCase("Hire") || hireChoice.equalsIgnoreCase("h") || hireChoice.equalsIgnoreCase("1")) {
			hireSailor(playerObject);
		}
		if (hireChoice.equalsIgnoreCase("examine") || hireChoice.equalsIgnoreCase("e") || hireChoice.equalsIgnoreCase("3")) {
			examineSailor(playerObject);
		}
	}


	private String requestInput() {
		JTextField textField = windowManager.GetUserInputBox();
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


	private void fireSailor(Ship playerObject){
		displayPlayerSailors(playerObject);
		fireDecision(playerObject);
	}
	
	private void examineSailor(Ship playerObject){
		if(playerObject.GetSailorCount() != 0){
			windowManager.AppendUpdateTab("\n----- Your Hired Sailors -----");
			for(int i = 0; i < playerObject.GetSailorCount(); i++){
				windowManager.AppendUpdateTab( (i+1) + ". " + playerObject.GetSailor(i).DisplayName());
			}
			windowManager.AppendUpdateTab("Which sailors would you like to examine?(1,2,3 | 0 to go back): ");
			int sailorExaminer = Abstract.ScannerInt();
			windowManager.AppendUpdateTab(System.lineSeparator());
			for(int i = 0; i < playerObject.GetSailorCount(); i++){
				windowManager.AppendUpdateTab((i + 1) + ". " + playerObject.GetSailor(i));
			}
			//playerObject.DisplaySailorVitals();//playerObject.GetSailor(sailorExaminer - 1));
			playerObject.GetSailor(sailorExaminer - 1).DisplaySkills();
			//Abstract.PressAnyKey();
		} else {
			windowManager.AppendUpdateTab("Failure.  You don't have any sailors.");
		}
	}
	
	private void hireSailor(Ship playerObject){
		displayPlayerSailors(playerObject);
		currentPort.DisplayAvailablePortCrew();
		hireCrewDecision(playerObject);
	}
	
	private void fireDecision(Ship playerObject){ // Function that goes through to fire a sailor you have hired.
		if(playerObject.GetSailorCount() > 0){
			windowManager.AppendUpdateTab("Choose which employee to let go (1,2,3... | 0 to quit): ");
			int fireChoice = Abstract.ScannerInt(); // User input for which employee to fire.
			if(fireChoice != 0) { 
				displayFiredSailor(playerObject);
				playerObject.RemoveSailor(fireChoice - 1);
			} else {
				;
			}
		} else {
			windowManager.AppendUpdateTab("\nFailure.  You don't have any sailors to fire.\n");
		}
	}
	
	public void displayFiredSailor(Ship playerObject){ // A simple message that a sailor has been fired.
		windowManager.AppendUpdateTab("\nYou have let go " + playerObject.GetSailor(playerObject.GetSailorCount() - 1).GetName() + ". \n");
	}
	
	public void displayNewSailor(Ship playerObject){ // A simple message that states that a sailor has been hired.
		windowManager.AppendUpdateTab("\nYou have hired " + playerObject.GetSailor(playerObject.GetSailorCount() - 1).GetName() + ". \n");
	}
	
	private void hireCrewDecision(Ship playerObject){
		windowManager.AppendUpdateTab("Which sailors would you like to hire?(1,2,3 | 0 to go back): ");
		int sailorChoice = Abstract.ScannerInt();
		if(sailorChoice != 0){
			playerObject.AddSailor(currentPort.GetSailor(sailorChoice - 1)); // This line adds the sailor to the player sailor array.
			displayNewSailor(playerObject);
			playerObject.DisplaySailorCount(); // A simple function that displays how many sailors you have aboard.
			currentPort.RemovePortSailor(sailorChoice - 1); // This removes the sailor you just hired from the port applicant pool.
	//		playerObject.setStartDate(); This hasn't been implemented yet; this will put the timestamp of when the sailor was hired.
		}
	}
	
	
}