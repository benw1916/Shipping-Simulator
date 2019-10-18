package main.java.Depricated;

public class PortChoice{
/*	private String currentPort;
	private String destinationPort;
	//private int portDecision;
	private int portDistance;

	public PortChoice(){
		this.currentPort = MenuDisplays.GetAvailablePorts(1);
	}

	public void iteration(Boat playerObject){
		int portChoice = 0;
		do{
			System.out.println("Current Port: " + playerObject.DisplayCurrentTitle());
			Abstract.RotateOptionsWithEscapement(MenuDisplays.GetAvailablePorts());
			System.out.print(": ");
			portChoice = Abstract.ScannerInt();
		}while((portChoice-1) >= 3);
			SetDestinationAndCurrentPort(portChoice);
		
	}
		
	public String getDestinationPort(){
		return this.destinationPort;
	}

/*	private void SetDestinationAndCurrentPort(int destinationPort){
		this.currentPort = this.destinationPort;
		this.destinationPort = MenuDisplays.GetPortName(destinationPort - 1);
	}
	
	public void changeCurrentAndDestination(Boat playerObject){
		this.currentPort = this.destinationPort;
		playerObject.SetCurrentLocation(this.destinationPort);
		this.destinationPort = null;
	}*/
}
