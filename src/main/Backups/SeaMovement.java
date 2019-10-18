package src.main.java;

public class SeaMovement{

  String destinationPort;
  String currentPort;
  int destinationDistance;
  int shipSpeed;

  public SeaMovement(PlayerShip ps, DestinationSettings ds){
    this.destinationPort = ds.getDestinationPort();
    this.currentPort = ps.getCurrentPort();
    this.destinationDistance = ds.getDestinationDistance();
    this.shipSpeed = ps.getShipSpeed();

    seaMovement();
    resetDestinations(ps, ds);
  }

/*  public void seaMovementIteration(PlayerShip ps, DestinationSettings ds){
    this.destinationPort = ds.getDestinationPort();
    this.currentPort = ps.getCurrentPort();
    this.destinationDistance = ds.getDestinationDistance();
    this.shipSpeed = ps.getShipSpeed();

    seaMovement();
  //  resetDestinations(ps, ds);
}*/

  private void seaMovement() {
  //  Scanner scanner = new Scanner(System.in);
  //  randomOccurrence oc = new randomOccurrence();
    //int speed = ps.getShipSpeed();
//    int destinationDistance = nauticalMileDistance();
    int traveledDistance = 0;
    int dayCounter = 0;

    while (traveledDistance < this.destinationDistance) {
      System.out.println("Day " + (dayCounter + 1) + ". You have traveled " + traveledDistance + " miles of " + this.destinationDistance + " miles.");
  //    oc.randomContainer(ps);
      traveledDistance = traveledDistance + (this.shipSpeed * 24);
      dayCounter++;
  //            scanner.nextLine();
    }
//    resetVariables(ps);

  }

  private void resetDestinations(PlayerShip ps, DestinationSettings ds){
    ds.setCurrentPort(ds.getDestinationPort());
    ps.setCurrentPort(ds.getDestinationPort());
    ds.setDestinationPort(null);
  }


}
