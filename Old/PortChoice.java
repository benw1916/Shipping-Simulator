package src.main.java;

public class PortChoice{
	private String currentPort;
	private String destinationPort;
	private int portDistance;

	public PortChoice(){
		this.currentPort = MenuDisplays.getAvailablePorts(1);
	}

	public void iteration(User playerObject){
		int portChoice = 0;
//		do{
			System.out.println("Current Port: " + getCurrentPort());
			Abstract.rotatePorts(MenuDisplays.getAvailablePorts());
			System.out.print(": ");
			portChoice = setDestinationPort(Abstract.scannerInt());
	//	}while(portChoice <= 3);
	//	changeCurrentAndDestination();
	}

	public String getCurrentPort(){
		return this.currentPort;
	}
	
	public String getDestinationPort(){
		return this.destinationPort;
	}

	private void setCurrentPort(int userValueChosenPort){
		this.currentPort = MenuDisplays.getAvailablePorts(userValueChosenPort);
	}

	private void setCurrentPort(String userPortText){
		for(int i = 0; i < MenuDisplays.getAvailablePortsSize(); i++){
			if(userPortText.contains(MenuDisplays.getAvailablePorts(i))){
				this.currentPort = MenuDisplays.getAvailablePorts(i);
			}
		}
	}

	public void changeCurrentAndDestination(){
		this.currentPort = this.destinationPort;
		this.destinationPort = null;
	}

	private int setDestinationPort(int userValueChosenPort){
		this.destinationPort = MenuDisplays.getAvailablePorts(userValueChosenPort);
		return userValueChosenPort;
	}

	private int setDestinationPort(String userPortText){
		for(int i = 0; i < MenuDisplays.getAvailablePortsSize(); i++){
			if(userPortText.contains(MenuDisplays.getAvailablePorts(i))){
				this.destinationPort = MenuDisplays.getAvailablePorts(i);
				return i;
			}
		}
		return 0;
	}

}
