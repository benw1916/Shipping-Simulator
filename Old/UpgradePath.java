package src.main.java;

public class UpgradePath{


	private static final int[] defaultShip = {150, 0, 12};
	/*** Total Containers --> Containers on Ship --> Ship Speed ***/
	private static final int[] upgradeOneShip = {225, 0, 15};
	


	public static int[] getDefaultUserShip(){
		return defaultShip;
	}
	
	public static int[] getUpgradeOneShip(){
		return upgradeOneShip;
	}
	
}