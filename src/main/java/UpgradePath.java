package main.java;

public class UpgradePath{


	private static final String[] defaultShip = {"150", "0", "12"};//, "1.2"};
	/*** Maximum Container Load --> Containers on Ship --> Ship Speed --> Fuel consumption ***/
	private static final String[] upgradeOneShip = {"225", "0", "15"};//, "2.1"};
	private static final String[] upgradeTwoShip = {"300", "0", "20"};//, "2.8"};
	private static final String[] displayPrefix = {"Maximum Containers", "Current Containers", "Ship Speed"};

	public static int getDefaultUserShip(int integerValue){
		return Integer.parseInt(defaultShip[integerValue]);
	}

	public static int[] getDefaultUserShip(){
		int[] shipAttributes = new int[2];
		for(int i = 0; i < defaultShip.length -1; i++){
			shipAttributes[i] = Integer.parseInt(defaultShip[i]);
		}
		return shipAttributes;
	}

	public static <E> void DisplayAvailableShips(E[] inputArray){
		for(int i = 0; i< inputArray.length; i++){
			System.out.println(displayPrefix[i] +" : " + inputArray[i]);
		}
	}
	
/*	public static int getUpgradeOneShip(int integerValue){
		return Integer.parseInt(upgradeOneShip(integerValue));
	}

	public static int getUpgradeTwoShip(int integerValue){
		return Integer.parseInt(upgradeTwoShip(integerValue));
	}*/
	
}