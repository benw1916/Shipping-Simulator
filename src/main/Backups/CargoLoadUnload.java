package src.main.java;

public class CargoLoadUnload{

  int maximumContainers;
  int currentContainers;
  String cargoPortOptions[] = {"Load/Unload Ship", "Leave Port"};

  public CargoLoadUnload(PlayerShip ps){
    this.maximumContainers = ps.getMaxContainers();
    this.currentContainers = ps.getContainersOnShip();
  }

  public void CargoLoadIteration(PlayerShip ps){
    inPortMessage();
    getContainerReadout();
    Abstract.standardGameMenu(cargoPortOptions);
    char userDefinedCargoDecision = Abstract.userStringToChar();
    loadYNMenuParse(userDefinedCargoDecision);
  }

  private void cargoMainMenu(){
    inPortMessage();
    getContainerReadout();
    Abstract.standardGameMenu(cargoPortOptions);
    int userDefinedCargoDecision = Abstract.userStringToInt();
    loadYNMenuParse(userDefinedCargoDecision);
  }

  private void inPortMessage(){
    System.out.println("Welcome.  You are currently docked and the crane is ready.");
  }

  private void loadMenu(){
    String loadUnloadOptions[] = {"Load Containers", "Unload Containers", "Back"};
    Abstract.standardGameMenu(cargoPortOptions);
    int userDefinedLoadMenu = Abstract.userStringToInt();
    loadUnloadMenuParse(userDefinedLoadMenu);
  }

  private void loadContainers(){

  }

  private void unloadContainers(){

  }

  private void getContainerReadout(){
    System.out.println("You currently have " + this.currentContainers + " containers aboard.");
    System.out.println("You can load a maximum of " + this.maximumContainers + " aboard.");
  }

  private void getLoadYN(){
    System.out.println("Would you like to add or remove containers?");
  }

  private void loadUnloadMenuParse(int userDefinedLoadMenu){
    switch(userDefinedLoadMenu){
      case 1:
        loadContainers();
      case 2:
        unloadContainers();
      case 3:
        cargoMainMenu();
    }
  }

  private void loadYNMenuParse(int userDefinedPortDecision){
    switch (userDefinedPortDecision) {
      case 1:
        loadMenu();
    }
  }

}
