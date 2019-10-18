package src.main.java;

public class ShoreSide{

	public ShoreSide(){
		int shoreSideChoice = 0;
		do{
			Abstract.rotatePorts(MenuDisplays.getShoreOptionMenu());
			System.out.print(": ");
			shoreSideChoice = parseShoreMenu(Abstract.scannerInt());
		}while(shoreSideChoice != 4);
	}

	private int parseShoreMenu(int userDecision){
		switch(userDecision){
			case 1:
				//Weather Report
				new SeaWeather().formattedWeatherAndTemperature(30);
				return 1;
				//break;
			case 2:
				//Ship Status
				System.out.println("Case 2");
				return 2;
				//break;
			case 3:
				//Container Prices at ports
				new GlobalContainerPrices();
				return 3;
				//break;
			case 4:
				//Exit
				return 4;
				//break;
		}
		return 0;
	}
}