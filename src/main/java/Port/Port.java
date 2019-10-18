package main.java.Port;

import main.java.Abstract.Abstract;
import main.java.Containers.Container;
import main.java.LongitudeLatitude;
import main.java.Sailor.Sailor;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

interface PortCalls {

    String GetCity();

    String GetCountry();

    String DisplayLocation();

    double GetLongitude();

    double GetLatitude();

    String GetOutputContainerName(int passedPosition);

    String DisplayOutputContainerName(int passedPosition);

    double GetOutputContainerCount(int passedPosition);

    String DisplayOutputContainerCount(int passedPosition);

    double GetOutputContainerPrice(int passedPosition);

    String DisplayOutputContainerPrice(int passedPosition);

    String GetPortSailorName(int passedPosition);

    String GetPortSailorVitals(int passedPosition);

    void RemovePortSailor(int passedPosition);

    Sailor GetSailor(int passedPosition);

    void DisplayAvailablePortCrew();

    double GetFuelPrice();

    String DisplayFuelPrice();

    void DecreaseOutgoingContainerCount(int passedContainerType, double passedCount);

    Container GetOutgoingContainer(int passedPosition);

    Container GetIncomingContainer(int passedPosition);

}

abstract class City{
    protected String cityName;
    protected String countryName;
    protected LongitudeLatitude coordinates;

    protected ArrayList<Container> incoming;

    protected ArrayList<Container> outgoing;

    protected ArrayList<Sailor> availableSailors;

    protected Fuel portFuel;
}

public class Port extends City implements PortCalls {

    private Port(){

    }

    public static class Builder{
        protected String cityName;
        protected String countryName;
        protected LongitudeLatitude coordinates;

        protected ArrayList<Container> incoming;

        protected ArrayList<Container> outgoing;

        protected ArrayList<Sailor> availableSailors;

        protected Fuel portFuel;

        public Builder(){
            City();
            Country();
            Fuel();
        }

        public Builder(String passedCity, String passedCountry){
            this.cityName = passedCity;
            this.countryName = passedCountry;
        }

        public Builder City(){
            Path cityProp = Paths.get("/src/main/java/Properties/Cities.properties");
            this.cityName = Abstract.GetItemFromList(System.getProperty("user.dir") + cityProp.toString());//"C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\Cities.properties");
            return this;
        }

        public Builder City(String passedCityName){
            this.cityName = passedCityName;
            return this;
        }

        public Builder Sailor(){
            int sailorCount = new Random().nextInt();
            for(int i = 0; i < sailorCount; i++){
                availableSailors.add(new Sailor.Builder().Name().Nationality().Salary().build());
            }
            return this;
        }

        public Builder Country(){
            Path nationProp = Paths.get("/src/main/java/Properties/NationList.properties");
            this.countryName = Abstract.GetItemFromList( System.getProperty("user.dir") + nationProp.toString()); //"C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\NationList.properties");
            return this;
        }

        public Builder Country(String passedCountryName){
            this.countryName = passedCountryName;
            return this;
        }

        public Builder Fuel(){
            this.portFuel = new Fuel();
            return this;
        }

        public Builder Fuel(double passedPrice){
            this.portFuel = new Fuel(passedPrice);
            return this;
        }

        public Builder Coordinates(){
            this.coordinates = new LongitudeLatitude();
            return this;
        }

        public Builder Coordinates(double passedLongitude, double passedLatitude){
            this.coordinates = new LongitudeLatitude(passedLongitude, passedLatitude);
            return this;
        }

        public Builder Containers(){
            this.outgoing = new ArrayList<Container>();
            this.incoming = new ArrayList<Container>();
            Path containerProp = Paths.get("/src/main/java/Properties/CargoTypes.properties");
            int containerCount = Abstract.GetListCount(System.getProperty("user.dir")+ containerProp.toString());
            DecimalFormat decimalPointTwo = new DecimalFormat("#.##");
            for(int i = 0; i < containerCount; i++){
             //   System.out.println("ITem: " + Abstract.GetItemFromList( System.getProperty("user.dir") + containerProp.toString(), i));
                this.outgoing.add(new Container.Builder().Title(Abstract.GetItemFromList( System.getProperty("user.dir") + containerProp.toString(), i)).Price((Math.random()* (400 - 1)+1) + 1).Quantity((double)new Random().nextInt(400 - 1)+1).build());
                this.incoming.add(new Container.Builder().Title(Abstract.GetItemFromList( System.getProperty("user.dir") + containerProp.toString(), i)).Price((Math.random()* (400 - 1)+1) + 1).Quantity((double)new Random().nextInt(400 - 1)+1).build());
            }

            return this;
        }

        public Port build() {
            return new Port(this);
        }

    }

    public Port(Builder builder){
        this.cityName = builder.cityName;
        this.countryName = builder.countryName;
        this.coordinates = builder.coordinates;
        this.incoming = builder.incoming;
        this.outgoing = builder.outgoing;
        this.availableSailors = builder.availableSailors;
        this.portFuel = builder.portFuel;
    }

    @Override
    public String GetCity() {
        return this.cityName;
    }

    @Override
    public String GetCountry() {
        return this.countryName;
    }

    @Override
    public String DisplayLocation() {
        return GetCity() + ", " + GetCountry();
    }

    @Override
    public double GetLongitude() {
        return this.coordinates.GetLongitude();
    }

    @Override
    public double GetLatitude() {
        return this.coordinates.GetLatitude();
    }

    @Override
    public String GetOutputContainerName(int passedPosition) {
        return this.outgoing.get(passedPosition).GetContainerName();
    }

    @Override
    public String DisplayOutputContainerName(int passedPosition) {
        return "Container Name: " + GetOutputContainerName(passedPosition);
    }

    @Override
    public Container GetOutgoingContainer(int passedPosition){
        System.out.println(this.outgoing.get(passedPosition).GetContainerName());
        return this.outgoing.get(passedPosition);
    }

    @Override
    public Container GetIncomingContainer(int passedPosition){
        return this.incoming.get(passedPosition);
    }

    @Override
    public double GetOutputContainerCount(int passedPosition) {
        return this.outgoing.get(passedPosition).GetContainerCount();
    }

    @Override
    public String DisplayOutputContainerCount(int passedPosition) {
        return "Outgoing Containers Available: " + GetOutputContainerCount(passedPosition);
    }

    @Override
    public double GetOutputContainerPrice(int passedPosition) {
        return this.outgoing.get(passedPosition).GetContainerPrice();
    }

    @Override
    public String DisplayOutputContainerPrice(int passedPosition) {
        return "$" + GetOutputContainerPrice(passedPosition);
    }

    @Override
    public String GetPortSailorName(int passedPosition){
        return this.availableSailors.get(passedPosition).GetName();
    }

    @Override
    public String GetPortSailorVitals(int passedPosition){
        return this.availableSailors.get(passedPosition).DisplaySailorVitals();
    }

    @Override
    public void RemovePortSailor(int passedPosition){
        this.availableSailors.remove(passedPosition);
    }

    @Override
    public Sailor GetSailor(int passedPosition) {
        return this.availableSailors.get(passedPosition);
    }

    @Override
    public void DisplayAvailablePortCrew(){
        int[] fiveRandomNumbers = new int[5];
        for(int p = 0; p < 5; p++){
            System.out.print(this.availableSailors.get(fiveRandomNumbers[p]).DisplaySailorVitals());
        }
    }

    @Override
    public void DecreaseOutgoingContainerCount(int passedContainerType, double passedCount){
        this.outgoing.get(passedContainerType).DecreaseContainerCount(passedCount);
    }

    @Override
    public double GetFuelPrice(){
        return this.portFuel.price;
    }

    @Override
    public String DisplayFuelPrice(){
        return "Fuel Price: $" + GetFuelPrice();
    }

}

class Fuel{
    public double price;

    public Fuel(){
        this.price = Abstract.GetRandomDoubleValue(500.0, 40.0);
    }

    public Fuel(double passedPrice){
        this.price = passedPrice;
    }

    public void SetPrice(double passedPrice){
        this.price = passedPrice;
    }
}