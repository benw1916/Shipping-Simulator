package src.main.java;

public class GlobalContainerPrices{

	public GlobalContainerPrices(){
		containerPriceHeader();
		displayPrices();
	}

	public void containerPriceHeader(){
		System.out.println("Global Price List:");
	}
	
	public void displayPrices(){
		for(int i = 1 ; i < MenuDisplays.getAvailablePortsSize() + 1; i++){
			System.out.println(MenuDisplays.getAvailablePorts(i) + " -- $" + Abstract.getRandomValue(500, 20) + " per container");
		}
		Abstract.pressAnyKey();
	}
	
}