package main.java.Graphics;

import main.java.Player.*;
import main.java.Ship.Ship;

public class MovementGraphics{
	DisplayCommands dc; //= new DisplayCommands();

	public MovementGraphics(int DistanceTraveled, int PortDistance){
		this.dc = new DisplayCommands();
		DisplayStaticAscii(dc);
		DisplayShipIconAscii(DistanceTraveled, PortDistance);
		dc.ChangeStatus(DisplayTopBottom.IconBottom);
		DisplayStaticAscii(dc);

		System.out.println();
	}
	
	private void DisplayMovementMap(){
		System.out.println( );
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void DisplayShoreSide(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	private void DisplayShipIconAscii(int DistanceTraveled, int PortDistance){
		final String PortIconCenter =   "|--|";
		final String waterIcon = ".";
		final String boatIcon = "=";
		
		System.out.print(PortIconCenter);		
		for(int i = 0; i <= 10; i++){
			double doubleValue = (((double)DistanceTraveled / (double)PortDistance) * 10);
			int percentageTraveled = (int)(doubleValue);

			//System.out.print(percentageTraveled);
			if(percentageTraveled == i){
				System.out.print(boatIcon);
			} else {
				System.out.print(waterIcon);
			}
		}
		System.out.println(PortIconCenter);
	}

	private void DisplayStaticAscii(DisplayCommands dc){
		final String PortIconTop = "/--\\";
		final String PortIconBottom= "\\--/";
		final String waterIcon = "~";
		
		if(dc.DisplayStatus() == DisplayTopBottom.IconTop){
			System.out.print(PortIconTop);
		}
		else if(dc.DisplayStatus() == DisplayTopBottom.IconBottom){
			System.out.print(PortIconBottom);
		}
		for(int i = 0; i <= 10; i++){
			System.out.print(waterIcon);
		}
		
		if(dc.DisplayStatus() == DisplayTopBottom.IconTop){
			System.out.println(PortIconTop);
		}
		else if(dc.DisplayStatus() == DisplayTopBottom.IconBottom){
			System.out.println(PortIconBottom);
		}
	}
	
	public static void shipZincGraphics(){
		System.out.println("  ___/=======|");
		System.out.println(" /   |       |");
		System.out.println("|    |  / \\  |");
		System.out.println("|    |  | |__|");
		System.out.println("|    | /     |");
		System.out.println("|    | \\   __|");
		System.out.println("|    |  | |  |");
		System.out.println(" \\___|  \\ /   \\_________________");
		System.out.println("                   V V     V V");
		System.out.println("____________________V_______V__");
	}
	
	
	public static String portDepartureGraphics(){
		return System.lineSeparator() +
				"_________          |_|_|/__ /__/  /  / " + System.lineSeparator()
				+ "_____   /| ~     ~ | | | | | | | /  /  " + System.lineSeparator()
				+ "----/  //|    ~   /|_|_|_|_|_|_|/  /   " + System.lineSeparator()
				+ " ~ /  //||  ~   ~ \\              _/    " + System.lineSeparator()
				+ "~ /  // ||   ~    \\0M0     0M0_/       " + System.lineSeparator()
				+ "_/  //| || ~    ~ |\\    ____/o      `~ " + System.lineSeparator()
				+ " _ //~| ||___      \\\\__/  o        `~ " + System.lineSeparator()
				+ "| |/  | ||   /|  ~   \\|     /   / ~`~   " + System.lineSeparator()
				+ "| ||  |_|/  /|        |  __/    /`~   ~  " + System.lineSeparator()
				+ "| ||       /|     ~   |        /~`  ~    " + System.lineSeparator()
				+ "| ||      /|  ~     `~/      ~`~`      ~ " + System.lineSeparator()
				+ "| ||     /| ~      `~/  / ~`~`     ~     " + System.lineSeparator()
				+ "|_|/    /|     ~ `~`|~`/`~`~     ~      ~" + System.lineSeparator()
				+ "       /| ~        `~`~`~`     ~    ~    " + System.lineSeparator()
				+ "_____ /|     ~  ~   `~`~`   ~         ~  " + System.lineSeparator()
				+ System.lineSeparator();
	}
	
	public static String ContainerGraphics(){
		return System.lineSeparator() +
				"     ______ " + System.lineSeparator()
				+ "    /     /|" + System.lineSeparator()
				+ "   /     /#|" + System.lineSeparator()
				+ "  /     /##|_____" + System.lineSeparator()
				+ " /     /###/####/|" + System.lineSeparator()
				+ "/_____/ ##/####/#|" + System.lineSeparator()
				+ "|  |  | #/### /##|" + System.lineSeparator()
				+ "|  |  |#/##  / ##/" + System.lineSeparator()
				+ "|__|__|/____/ ##/" + System.lineSeparator()
				+ "|  |  |  |  | #/" + System.lineSeparator()
				+ "|  |  |  |  | /"+ System.lineSeparator()
				+ "|__|__|__|__|/"+ System.lineSeparator()
				+ System.lineSeparator();
	}
	
	public static String MoneyGraphics(){
		return System.lineSeparator() +
				"      _________ " + System.lineSeparator()
				+ "     /        /|" + System.lineSeparator()
				+ "    /        / |" + System.lineSeparator()
				+ "  _|--------|  |" + System.lineSeparator()
				+ " //8 ------ |  |" + System.lineSeparator()
				+ "// ||&&&&&&||  |" + System.lineSeparator()
				+ "|| ||&&&&&&||  |" + System.lineSeparator()
				+ "|| 8|______|| /" + System.lineSeparator()
				+ "|| /|_______|/" + System.lineSeparator()
				+ "||/ " + System.lineSeparator()
				+ System.lineSeparator();
	}
	
	public static void LoadUnloadGraphics(){
		System.out.println("");
	}
	
	public static void displayFuelGauge(Ship playerObject){ // Displays a easily read fuel gauge.  '#' means available, and ' ' is blank.
		char fuelCharacter = '#';
		char emptyCharacter = ' ';
		System.out.print("E |");
		for(int i = 0; i < 11; i++){
			//System.out.println("║           ║");
			if(((playerObject.GetCurrentFuel() / playerObject.GetMaxFuel()) * 11) >= i){
				System.out.print(fuelCharacter);
			} else {
				System.out.print(emptyCharacter);
			}
		}
		System.out.println("| F");
		System.out.println("  |=====|=====|  ");
	}
	
}

enum DisplayTopBottom{
		IconTop,
		IconBottom;
	}

class DisplayCommands{
	DisplayTopBottom dtb;
		
	public DisplayCommands(){
		this.dtb = dtb.IconTop;
	}

	public void ChangeStatus(DisplayTopBottom passedDTB){
		this.dtb = passedDTB;
	}

	public boolean Compare(DisplayTopBottom passedDTB){
		String stringDTB = "" + this.dtb;
		String StringPassed = "" + passedDTB;
		if(stringDTB.equals(StringPassed) == true){
			return true;
		} else {
			return false;
		}
	}

	public DisplayTopBottom DisplayStatus(){
		return this.dtb;
	}
	
}