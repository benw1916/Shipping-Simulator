package main.java.Save;

/*import main.java.Player.*;
import main.java.Abstract.*;
import java.io.*;
import java.util.HashMap;
import java.util.*;

public class SaveLoad{

	//public SaveLoad(Boat playerObject){
	//	SaveGame(playerObject);
	//}
	
	public SaveLoad(Boat playerObject, AvailablePorts ports){
		int SaveLoadChoice = 0;
		do{
			Abstract.RotateOptions(MenuDisplays.GetHotelOptions()); //"Meet with Team", "Spend One Day Ashore", "Save game", "Load Game"
			System.out.print(": ");
			SaveLoadChoice = parseSaveMenu(playerObject, Abstract.ScannerInt(), ports);

		}while(SaveLoadChoice >= 5);
	}
	
	private int parseSaveMenu(Boat playerObject, int userDecision, AvailablePorts ports){
		Map<Integer, Runnable> saveMenu = new HashMap<>();
		saveMenu.put(1, () ->  SailorMeet());// Meet with crew
		saveMenu.put(2, () -> passOneDay(playerObject));// One day forward
		saveMenu.put(3, () -> SaveGame(playerObject)); // Save Game
		saveMenu.put(4, () -> LoadGame(playerObject, ports)); // Load Game
		
		if(userDecision <= 4 && userDecision > 0){
			saveMenu.get(userDecision).run();
		} 
		return userDecision;
	}
	
	private void passOneDay(Boat playerObject){
		double hotelprice = 40.0;
		System.out.println("You put your crew up in a hotel near the seashore for the night");
		System.out.println("To put your crew up for the night, it costs you $" + ((playerObject.getSailorCount() + 1) * hotelprice));
		playerObject.DeductMoney((playerObject.getSailorCount()+ 1) * hotelprice);
		playerObject.increaseDay();
		Abstract.PressAnyKey();
	}
	
	private void SailorMeet(){
		System.out.println("Sailor meeting");
	}
	
	public void SaveGame(Boat playerObject){
		System.out.println("Saving");
		try {
			FileOutputStream fileCreator = new FileOutputStream("main/java/Save/Boat1.txt");
			ObjectOutputStream fileWriter = new ObjectOutputStream(fileCreator);
			fileWriter.writeObject("Date=" + playerObject.GetDate() + "\n");
			fileWriter.writeObject("ShipName=" + playerObject.getShipName() + "\n");
			fileWriter.writeObject("MaxContainers=" + playerObject.getMaximumContainers() + "\n");
			fileWriter.writeObject("CurrentFuel=" + playerObject.getCurrentFuel() + "\n");
			fileWriter.writeObject("MaxFuel=" + playerObject.getMaxFuel() + "\n");
			fileWriter.writeObject("Money=" + playerObject.GetMoney() + "\n");
			fileWriter.writeObject("CurrentLocation=" + playerObject.getCurrentLocation() + "\n");
		//	if(!(playerObject.isContainerSlipEmpty())){ // This is currently broken for some reason
		//		for(int i = 0; i < playerObject.getContainerSlipSize(); i++){
		//			fileWriter.writeObject("Container" + (i+1) + "=" + playerObject.getContainerSlip(i) + "\n");
		//		}
		//	} else {
		//		fileWriter.writeObject("Container1=");
		//	}
			fileWriter.close();
			fileCreator.close();
			System.out.println("Saved!");
			Abstract.PressAnyKey();
		}catch(IOException i){
			i.printStackTrace();
		}
		
	}
	
	public void LoadGame(Boat playerObject, AvailablePorts ports){
	//	Boat playerObject = null;
		try{
			FileInputStream fileFinder = new FileInputStream("main/java/Save/Boat1.txt");
			ObjectInputStream fileReader = new ObjectInputStream(fileFinder);
			playerObject = (Boat) fileReader.readObject();
			fileReader.close();
			fileFinder.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
			return;
		}catch(ClassNotFoundException cnfe){
			System.out.println("Not found");
			cnfe.printStackTrace();
			return;
		}
	}

}*/