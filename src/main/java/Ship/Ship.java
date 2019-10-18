package main.java.Ship;

import main.java.Abstract.Abstract;
import main.java.DateDisplay;
import main.java.LongitudeLatitude;
import main.java.RandomEvent;
import main.java.Sailor.Person;
import main.java.Sailor.Sailor;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.*;

interface BoatCalls{

    String GetName();// (Ship ship){       return ship.name;    }

    String DisplayName();//Ship ship){        return "Name: " + GetName(ship);    }

    void SetName(String passedName);/*Ship ship, String passedName){
        ship.name = passedName;
    }*/

    double GetLength();//Ship ship){return ship.length;}

    String DisplayLength();/*Ship ship){return "Length: " + GetLength(ship);}*/

    int GetIMO();/*Ship ship){return ship.imo;}*/

    String DisplayIMO();/*Ship ship){return "IMO Number: " + GetIMO(ship);}*/

    void SetIMO(int passedIMO);/*Ship ship, int passedIMO){ship.imo = passedIMO;}*/

    String GetCargoType();/*Ship ship){return ship.shipCargo.cargoType;}*/

    String DisplayCargoType();/*Ship ship){return "Primary Cargo Type: " + GetCargoType(ship);}*/

    void SetCargoType(String passedCargoType);/*Ship ship, String passedCargoType){ship.shipCargo.cargoType = passedCargoType;}*/

    double GetCurrentLoad();/*Ship ship){return ship.currentCount;}*/

    String DisplayCurrentLoad();/*Ship ship){return "Current Load: " + GetCurrentLoad(ship);}*/

    void SetCurrentLoad(double passedCurrent);/*Ship ship, double passedCurrent){ship.currentCount = passedCurrent;}*/

    double GetMaxLoad();/*Ship ship){return ship.maxCount;}*/

    String DisplayMaxLoad();//Ship ship){//    return "Maximum Load: " + GetMaxLoad(ship);//}

    void SetMaxLoad(double passedMax);//Ship ship, double passedMax){ship.maxCount = passedMax;}

    String GetSize();//Ship ship){return ship.sizeDesignation;}

    String DisplaySize();/*Ship ship){return "Size: " + GetSize(ship);}*/

    String GetShipType();/*Ship ship){return ship.shipType;}*/

    String DisplayShipType();/*Ship ship){return "Ship type: " + GetShipType(ship);}*/

    int GetCraneCount();/*Ship ship){return}*/

    String GetDestination();//Ship ship){return ship.playerDestination.GetTitle();}

    String GetLocation();//Ship ship){return ship.playerLocation.GetTitle();}

    void SetDestination(String passedTitle);//Ship ship, String passedTitle){ship.playerDestination.SetTitle(passedTitle);}

    void SetLocation(String passedTitle);//Ship ship, String passedTitle){ship.playerLocation.SetTitle(passedTitle);}

    String GetShortUserReadout();//Ship ship){ // Returns formatted date and current location.return "yeet";//DisplayDate(ship) + "\n";// + DisplayCurrentTitle();}

    ArrayList<Sailor> GetAllSailors();

    void AddSailor(Sailor newSailor);

    void RemoveSailor(int positionToRemove);

    int GetSailorCount();//Ship ship){return ship.sailors.size();}

    String DisplaySailorCount();

    boolean AnySailors();//Ship ship){if(ship.sailors.size() > 0) {return true;}return false;}

    Sailor GetSailor(int locationCount);//Ship ship, int locationCount){return ship.sailors.get(locationCount);}

    double GetCurrentFuel();//Ship ship){return ship.engine.fuelCurrent;}

    String DisplayCurrentFuel();//Ship ship){return "Current Fuel: " + GetCurrentFuel(ship) + " tons";}

    double GetMaxFuel();//Ship ship){return ship.engine.fuelMax;}

    String DisplayMaxFuel();//Ship ship){return "Maximum Fuel: " + GetMaxFuel(ship) + " tons";}

    boolean IsShipFull();

    boolean IsShipEmpty();

    String GetFuelPercentage();

    void SetFuelCurrent(double passedCurrent);

    public double GetMoney();

    public String DisplayMoney();

    public void DeductMoney(int passedMoney);

    public void DeductMoney(double passedMoney);

    public LongitudeLatitude GetCurrentCoordinates();

    public LongitudeLatitude GetDestinationCoordinates();

    public double GetKnots();

    public String DisplayContainerSlipQuantity();

    String GetShipStatistics();

    String DisplayKnots();

}


abstract class Waterfaring{
    String name;
    double length;
    String shipType;
    int imo;
    //String cargoType;
    double currentCount;
    double maxCount;
    String sizeDesignation;
    boolean craneCapable;
    LongitudeLatitude playerLocation; // Ship location is stored in this object.
    LongitudeLatitude playerDestination; // Ship destination is stored in this object.

}

public class Ship extends Waterfaring implements BoatCalls {
    Engine engine;
    Money shipMoney;
    ArrayList<Sailor> sailors;
    Cargo shipCargo;

    private Ship(){

    }

    public static class Builder {
        String name;
        double length;
        String shipType;
        int imo;

        double currentCount;
        double maxCount;
        boolean craneCapable;
        int craneCount;
        Engine engine;
        Money shipMoney;
        Cargo shipCargo;
        LongitudeLatitude playerLocation; // Ship location is stored in this object.
        LongitudeLatitude playerDestination; // Ship destination is stored in this object.
        ArrayList<Sailor> sailors;


        public Builder() {
        //    Type();
            this.playerLocation = new LongitudeLatitude();
            this.playerDestination = new LongitudeLatitude();
            String[] shipPrefixes = {"AE", "AFS", "AHT", "AHTS", "AO", "AOG", "AOR", "AOT", "ATB", "CRV", "C/F", "CS", "DB", "DEPV", "DLB", "DCV", "DSV", "DV", "ERRV", "FPSO", "FPV", "FPV", "FT", "FV", "GTS", "HLV", "HMT",	"HMHS",	"HSC",	"HSF", "HTV", "IRV", "ITB",	"LB", "LNG/C", "LPG/C", "MF", "MFV", "MS", "M/S", "MSV", "MSY", "MT", "MTS", "MV", "M/V", "MY", "M/Y", "NB", "NRV", "NS", "OSV", "PS", "PSV", "QSMV", "QTEV", "RMS", "RNLB", "RRS", "RV", "RSV", "SB", "SS", "S/S", "SSCV", "SSS", "SSV", "ST", "STS", "STV", "SV ", "SY", "TB", "TEV", "TIV", "TrSS", "TS", "Tr.SMV", "TSMV", "TSS", "TST",	"TV", "YD", "YW", "YOS"};
            Random random = new Random();
            int prefixAppend = random.nextInt(shipPrefixes.length + 100);
            if(prefixAppend > shipPrefixes.length){
                this.name = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\ShipNames.properties");
            } else {
                this.name = shipPrefixes[prefixAppend] + " " + Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\ShipNames.properties");
            }
        }

        public Builder(String passedType, String passedName) {
           // Type(passedType);
            this.playerLocation = new LongitudeLatitude();
            this.playerDestination = new LongitudeLatitude();
            this.name = passedName;
            this.craneCapable = false;
        }

        public Builder(String passedName) {
            //Type();
            this.playerLocation = new LongitudeLatitude();
            this.playerDestination = new LongitudeLatitude();
            this.name = passedName;
            this.craneCapable = false;
        }

        public Builder Type(){
            this.shipType = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\ShipTypes.properties");
            return this;
        }

        public Builder Type(String passedType){
            String line;
            try (
                    InputStream fis = new FileInputStream("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\ShipTypes.properties");
                    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                    BufferedReader br = new BufferedReader(isr);
            ) {
                while ((line = br.readLine()) != null) {
                    if(line.toLowerCase().contains(passedType.toLowerCase())){
                        this.shipType = line;
                    }
                }
            }catch (FileNotFoundException fnfe){

            }catch(IOException ioe){

            }
            return this;
        }

        public Builder IMO() {
            Random random = new Random();
            this.imo = random.nextInt(Integer.MAX_VALUE);
            return this;
        }

        public Builder IMO(int passedIMO) {
            this.imo = passedIMO;
            return this;
        }

        public Builder Length(double passedLength) {
            this.length = passedLength;
            return this;
        }

        public Builder Engine(String passedType){
            this.engine = new Engine(passedType);
            return this;
        }

        public Builder Engine(){
            this.engine = new Engine();
            return this;
        }

        public Builder Crane(){
            this.craneCapable = true;
            return this;
        }

        public Builder Crane(int passedCount){
            this.craneCapable = true;
            this.craneCount = passedCount;
            return this;
        }

        public Builder Money(){
            this.shipMoney = new Money();
            return this;
        }

        public Builder Money(double passedMoney){
            this.shipMoney = new Money(passedMoney);
            return this;
        }

        public Builder Containers() {
         //   this.cargoType = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\CargoTypes.properties");
            this.shipCargo = new Cargo();
            Random random = new Random();
            this.maxCount = random.nextDouble();
            this.currentCount = random.nextDouble();
            return this;
        }

        public Builder Containers(String passedType){
         //   this.cargoType = passedType;
            return this;
        }

        public Builder Containers(double passedMax, double passedCurrent) {
            this.maxCount = passedMax;
            this.currentCount = passedCurrent;
            return this;
        }

        public Builder MaxContainers() {
            Random random = new Random();
            this.maxCount = random.nextDouble();
            return this;
        }

        public Builder MaxContainers(double passedMax) {
            this.maxCount = passedMax;
            return this;
        }

        public Builder CurrentContainers() {
            this.currentCount = 0.0;
            return this;
        }

        public Builder Sailors(){
            this.sailors = new ArrayList<Sailor>();
            return this;
        }

        public Builder CurrentContainers(double passedCurrent) {
            this.currentCount = passedCurrent;
            return this;
        }

        public Builder Location(String startLocation){

            return this;
        }

  /*      public Builder Location(String startLocation, String endLocation){
            this.playerLocation;
            return this;
        }*/

        public Builder Location(double passedStartLongitude, double passedStartLatitude){
            this.playerLocation.SetLongitude(passedStartLongitude);
            this.playerLocation.SetLatitude(passedStartLatitude);
            return this;
        }

        public Ship build() {
            return new Ship(this);
        }

    }

    public Ship (Builder builder){
        this.name = builder.name;
        this.length = builder.length;
        this.shipType = builder.shipType;
        this.maxCount = builder.maxCount;
        this.currentCount = builder.currentCount;
        this.imo = builder.imo;
        this.engine = builder.engine;
        this.playerDestination = builder.playerDestination;
        this.playerLocation = builder.playerLocation;
        this.sailors = builder.sailors;
        this.shipMoney = builder.shipMoney;
        this.shipCargo = builder.shipCargo;
    }

    @Override
    public String GetName(){
        return this.name;
    }

    @Override
    public String DisplayName() {
        return "Ship name: " + GetName();
    }

    @Override
    public void SetName(String passedName){
        this.name = passedName;
    }

    @Override
    public double GetLength() {
        return this.length;
    }

    @Override
    public String DisplayLength() {
        return "Ship length: " + GetLength();
    }

    @Override
    public int GetIMO() {
        return this.imo;
    }

    @Override
    public String DisplayIMO() {
        return "IMO: " + GetIMO();
    }

    @Override
    public void SetIMO(int passedIMO) {
        this.imo = passedIMO;
    }

    @Override
    public String GetCargoType(){
        return this.shipCargo.cargoType;
    }

    @Override
    public String DisplayCargoType() {
        return "Cargo Type: " + GetCargoType();
    }

    @Override
    public void SetCargoType(String passedCargoType) {
        this.shipCargo.SetCargo(passedCargoType);
    }

    @Override
    public double GetCurrentLoad() { // Not implemented yet.
        return 0;
    }

    @Override
    public String DisplayCurrentLoad() { // Not implemented yet.
        return null;
    }

    @Override
    public void SetCurrentLoad(double passedCurrent) { // Not implemented yet.

    }

    @Override
    public double GetMaxLoad() { // Not implemented yet.
    return 0.0;
    }

    @Override
    public String DisplayMaxLoad(){ // Not implemented yet.
       return "Maximum Load: " + GetMaxLoad() + " tons";
    }

    @Override
    public void SetMaxLoad(double passedMax) { // Not implemented yet.

    }

    @Override
    public String GetSize() { // Not implemented yet.
        return null;
    }

    @Override
    public String DisplaySize() { // Not implemented yet.
        return null;
    }

    @Override
    public String GetShipType() {
        return this.shipType;
    }

    @Override
    public String DisplayShipType() {
        return "Ship type: " + GetShipType();
    }

    @Override
    public int GetCraneCount() {
        return 0;
    }

    @Override
    public String GetDestination() {
        return playerDestination.GetTitle();
    }

    @Override
    public String GetLocation() {
        try {
            return playerLocation.GetTitle();
        }catch(NullPointerException nps){
            return "Ooops, the player location was not defined.";
        }
    }

    @Override
    public void SetDestination(String passedCity) {
        this.playerDestination.SetTitle(passedCity);
    }

    @Override
    public void SetLocation(String passedCity) {
        this.playerLocation.SetTitle(passedCity);
    }

    @Override
    public String GetShortUserReadout() { // Not implemented yet.
        return null;
    }

    @Override
    public ArrayList<Sailor> GetAllSailors() {
        return this.sailors;
    }

    @Override
    public int GetSailorCount() {
        return this.sailors.size();
    }

    @Override
    public String DisplaySailorCount(){
        return "Sailors aboard: " + GetSailorCount();
    }

    @Override
    public void RemoveSailor(int positionToRemove){
        this.sailors.remove(positionToRemove);
    }

    @Override
    public void AddSailor(Sailor sailorToAdd){
        this.sailors.add(sailorToAdd);
    }

    @Override
    public boolean AnySailors() {
        if(this.sailors.size() == 0){
            return false;
        }
         return true;
    }

    @Override
    public Sailor GetSailor(int locationCount) {
        return this.sailors.get(locationCount);
    }

    @Override
    public double GetCurrentFuel() {
        return this.engine.fuelCurrent;
    }

    @Override
    public String DisplayCurrentFuel() {
        return "Current Fuel: " + GetCurrentFuel();
    }

    @Override
    public double GetMaxFuel() {
        return this.engine.fuelMax;
    }

    @Override
    public String DisplayMaxFuel() {
        return "Maximum Fuel: " + GetMaxFuel() + " tons";
    }

    @Override
    public boolean IsShipFull(){
        return this.shipCargo.IsShipFull();
    }

    @Override
    public boolean IsShipEmpty(){
        return this.shipCargo.IsShipEmpty();
    }

    @Override
    public String GetFuelPercentage(){ // Returns a percentage value of the fuel available on the ship.
        return Abstract.roundValue((this.engine.fuelCurrent / this.engine.fuelMax) * 100) + "%";
    }

    @Override
    public void SetFuelCurrent(double passedCurrent){
        this.engine.SetFuelCurrent(passedCurrent);
    }

    @Override
    public double GetMoney(){
        return Double.parseDouble(Abstract.GetDoubleDecimal(this.shipMoney.shipPurse));
    }

    @Override
    public String DisplayMoney(){
        return "Ship Purse: $" + GetMoney();
    }

    @Override
    public void DeductMoney(double passedMoney){
        this.shipMoney.DeductMoney(passedMoney);
    }

    @Override
    public void DeductMoney(int passedMoney){
        this.shipMoney.DeductMoney(passedMoney);
    }

    @Override
    public LongitudeLatitude GetCurrentCoordinates(){
        return this.playerLocation;
    }

    @Override
    public LongitudeLatitude GetDestinationCoordinates(){
        return this.playerDestination;
    }

    @Override
    public double GetKnots(){
        return this.engine.knots;
    }

    @Override
    public String DisplayKnots(){
        return "Knots:" + this.engine.knots;
    }

    @Override
    public String DisplayContainerSlipQuantity(){

        return this.shipCargo.DisplayCargoAboard();
    }

    @Override
    public String GetShipStatistics(){
        return this.DisplayName() + "\n" +
               this.DisplayKnots() + "\n" +
               this.DisplayCurrentFuel() + "\n" +
               this.DisplayMaxFuel() + "\n" +
               this.DisplaySailorCount() + "\n" +
               this.DisplayShipType();
    }

}

class Money{
    double shipPurse; // Variable that contains the money value.
    private final static double startingMoney = 5000.00;
    private double containerPaymentPercentage;
    private final static double defaultContainerPayment = 0.10;

    public Money(){ // Constructor that sets the player money to the default.
        this.shipPurse = startingMoney;
        this.containerPaymentPercentage = defaultContainerPayment;
    }

    public Money(double passedMoney){
        this.shipPurse = passedMoney;
        this.containerPaymentPercentage = defaultContainerPayment;
    }

    public void DeductMoney(int userPassedMoney){ // Deduct player money by passed value.  Integer is converted to double.
        //Abstract.DecreaseValue(this.shipPurse, (double)userPassedMoney);
        this.shipPurse -= (double)userPassedMoney;
    }

    public void DeductMoney(double userPassedMoney){ // Deduct player money by passed value.
        //Abstract.DecreaseValue(this.shipPurse, userPassedMoney);
        this.shipPurse -= userPassedMoney;
    }

    public void AddMoney(int userPassedMoney){ // Add money to the player money, by passed integer value.
        //Abstract.IncreaseValue(this.shipPurse, (double)userPassedMoney);
        this.shipPurse += (double)userPassedMoney;
    }

    public void AddMoney(double userPassedMoney){ // Add money to the player money, by the passed double value.
        //Abstract.IncreaseValue(this.shipPurse, userPassedMoney);
        this.shipPurse += userPassedMoney;
    }

    public void increasePaymentPercentage(){ // Increases payment percentage by 10%
        this.containerPaymentPercentage += 0.10;
    }

    public double getContainerPaymentPercentage(){ // Returns the payment percentage
        return this.containerPaymentPercentage;
    }

    public void SetMoney(int userPassedValue){ // Set player money with passed value.  Integer is converted to double.
        this.shipPurse = (double)userPassedValue;
    }

    public void SetMoney(double userPassedValue){ // Set player money with passed value.
        this.shipPurse =  userPassedValue;
    }

/*    public void displayMoneyIncrease(int passedContainerCount){ //
        //	AddMoney(((double)passedContainerCount * passedValue) * getContainerPaymentPercentage()) * passedMoney);
        DisplayMoney();
    }*/

}

class Engine{
    String fuelType;
    String engine;
    double fuelMax;
    double fuelCurrent;
    double fuelConsumption;
    double knots;

    public Engine(String passedEngineType){

    }

    public Engine(){
        this.knots = 20;
        this.fuelMax = 200;
        this.fuelCurrent = 200;
        this.fuelConsumption = 2.0;
    }

    public void SetFuelType(String passedType){
        this.fuelType = passedType;
    }

    public void SetEngine(String passedEngine){
        this.engine = passedEngine;
    }

    public void SetFuelMax(double passedMax){
        this.fuelMax = passedMax;
    }

    public void SetKnots(double passedKnots){
        this.knots = passedKnots;
    }

    public void SetFuelCurrent(double passedCurrent){
        this.fuelCurrent = passedCurrent;
    }

    public void modifyFuelCurrent(double passedFuel){
        this.fuelCurrent += passedFuel;
    }

    private double getVariedFuelConsumption(){ // Not sure this is implemented completely yet; This varies the amount of fuel consumed each run.
        if(Abstract.GetRandomValue(100, 0) > 51){
            return fuelConsumption + (Abstract.GetRandomValue(20, 0) * .010);
        } else {
            return fuelConsumption - (Abstract.GetRandomValue(20, 0) * .010);
        }
    }

    public void FuelMeasureAndConsumption(){ // This is a sanity check, if OutOfFuel is true, then a random occurrence occurs, and if it's false, then fuel consumption is run.
        if(IsOutOfFuel() == false){
            modifyFuelCurrent(-1 * getVariedFuelConsumption());
        } else{
            //new RandomEvent().noFuel(playerObject);
        }
    }

    public boolean IsOutOfFuel(){ // Another sanity check, checks whether the fuel tanks are empty.
        if(this.fuelCurrent <= 0.0){
            this.fuelCurrent = 0.0;
            return true;
        }
        return false;
    }

}

class Cranes{
    boolean capable;
    int count;

    public Cranes(){

    }

    public void SetCraneCapability(boolean passedCapable){
        this.capable = passedCapable;
    }
}

class Cargo{
    String cargoType;
    int maxLoad;
    protected ArrayList<String> allowedTypes = new ArrayList<String>();
    Map<String, Double> TypeAndCount = new HashMap<>();

    public Cargo(){
        InitializeAllowedTypes();
        InitializeTypeAndCount();
    }

    public Cargo(String passedType){
        InitializeAllowedTypes(passedType);
    }

    public void SetCargo(String passedType){

    }

    public String DisplayCargoAboard(){
        StringBuilder cargoList = new StringBuilder();
        Collection<String> containerNames = TypeAndCount.keySet();
        Collection<Double> containerCount = TypeAndCount.values();
        String[] properContainerNames = containerNames.toArray(new String[containerNames.size()]);
        Double[] properContainerCounts = containerCount.toArray(new Double[containerCount.size()]);

        cargoList.append("Containers aboard" + System.lineSeparator());
        for(int i = 0; i < properContainerCounts.length; i++){
            cargoList.append(properContainerNames[i] + " -- " + properContainerCounts[i] + System.lineSeparator());
        }
        return cargoList.toString();
    }

    public boolean IsShipFull(){
        Collection<Double> containerCount = TypeAndCount.values();
        Double[] values = containerCount.toArray(new Double[containerCount.size()]);
        double containerCombination = 0.0;
        for(int i = 0; i < values.length; i++){
            containerCombination += values[i];
        }
        if(containerCombination > maxLoad){
            return true;
        } else {
            return false;
        }
    }

    public boolean IsShipEmpty(){
        Collection<Double> containerCount = TypeAndCount.values();
        Double[] values = containerCount.toArray(new Double[containerCount.size()]);
        double containerCombination = 0.0;
        for(int i = 0; i < values.length; i++){
            containerCombination += values[i];
        }
        if(containerCombination == 0){
            return true;
        } else {
            return false;
        }
    }

    private void InitializeTypeAndCount(){
        for(int p = 0; p < this.allowedTypes.size(); p++){
            this.TypeAndCount.put(this.allowedTypes.get(p), 0.0);
        }
    }

    private void VoidAllowedTypes(){
        allowedTypes.clear();
    }

    private void InitializeAllowedTypes(){
        allowedTypes.add("general");
        allowedTypes.add("container");
    }

    private void InitializeAllowedTypes(String passedType){

        if(passedType.toLowerCase().contains("cargo")){
            allowedTypes.add("general");
            allowedTypes.add("container");
            allowedTypes.add("refrigerated");
        }
        if(passedType.toLowerCase().contains("tank")){
            allowedTypes.add("tanker");
        }
        if(passedType.toLowerCase().contains("live")){
            allowedTypes.add("livestock");
        }
        if(passedType.toLowerCase().contains("refrig")){
            allowedTypes.add("refrigerated");
        }
        if(passedType.toLowerCase().contains("bulk")){
            allowedTypes.add("drybulk");
        }
    }

}