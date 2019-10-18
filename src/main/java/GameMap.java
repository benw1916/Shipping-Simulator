package main.java;

import main.java.Abstract.Abstract;
import main.java.DateDisplay;
import main.java.Port.Port;
import main.java.Properties.PropertiesReader;
import main.java.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

interface GameCalls{
    void IncreaseDay();
    String GetDate();
    String DisplayDate();
    String GetAndIncreaseDate();
}

public class GameMap implements GameCalls{
    private int height = 30;
    private int width = 60;
    String[][] gameboard = new String[width][height];
    AvailablePorts portLocations;
    DateDisplay worldTime;

    public GameMap(){
        this.worldTime = new DateDisplay();
        InitializeMap();
        InitializePorts();
    }

    @Override
    public void IncreaseDay(){ // A passthrough to increase the date.
        this.worldTime.IncreaseDay();
    }

    public String GetDate(){ // A passthrough that returns the date.
        return this.worldTime.GetDate();
    }

    public String DisplayDate(){ //Still a passthrough, but displays the date.
        return "Date: " + this.worldTime.GetDate();
    }

    /*public ArrayList<String> GetPorts(){
        ArrayList<String> portLocations = new ArrayList<String>();
        portLocations.add("New Jersey");
        portLocations.add("Long island");
        return portLocations;
    }*/

    public String GetAndIncreaseDate(){ // A passthrough that increases the date and returns the date.
        this.worldTime.IncreaseDay();
        return this.worldTime.GetDate();
    }

    public void InitializePorts(){
        final int intialPortsAvailable = 5;
        double[] randomLongitude = new double[intialPortsAvailable];
        double[] randomLatitude = new double[intialPortsAvailable];
        String[] randomCity = new String[intialPortsAvailable];
        String[] countryNames = new String[intialPortsAvailable];
        Path citiesProp = Paths.get("/src/main/java/Properties/Cities.properties");
        Path countryProp = Paths.get("/src/main/java/Properties/CountryNames.properties");
        for(int u = 0; u < intialPortsAvailable; u++){
            randomLongitude[u] = new Random().nextDouble();//ArrayList<String> portLongitudes.add(Abstract.GetItemFromList("src/main/java/Properties/PortLongitude.properties"));
            randomLatitude[u] = new Random().nextDouble();//ArrayList<String> portLatitudes.add(Abstract.GetItemFromList("src/main/java/Properties/PortLatitude.properties"));
            randomCity[u] = Abstract.GetItemFromList(System.getProperty("user.dir") + citiesProp);
            countryNames[u] = Abstract.GetItemFromList(System.getProperty("user.dir") + countryProp);
        }
        this.portLocations = new AvailablePorts(randomCity, countryNames, randomLongitude, randomLatitude);
    }

    public double[][] GenerateWhiteNoise(int width, int height) {
        Random random = new Random(0); //Seed to 0 for testing
        double[][] noise = new double[width][height];

        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                noise[i][j] = random.nextDouble() % 1;
            }
        }

        return noise;
    }

    public void DisplayMap(){
        for(int i = 0; i < width; i++){
            for(int p = 0; p < height; p++){
                System.out.print(gameboard[i][p]);
            }
               System.out.println("\u001B[37m");
        }
        System.out.print("\u001B[0m");
    }

    public void InitializeMap(){
        for(int i = 0; i < width; i++){
            for(int p = 0; p < height; p++){
                OpenSimplexNoise osn = new OpenSimplexNoise(new Random().nextLong());
                gameboard[i][p] = OutputChar(Math.abs(osn.eval(width, height)));
            }
        }

        //   System.out.println("Output");
        /*for(int i = 0; i < width; i++){
            for(int p = 0; p < height; p++){
                System.out.print(outputMap[i][p]);
            }
         //   System.out.println();
        }*/

    }

        public static String OutputChar(double passedDouble){
            if (passedDouble < 0.1) return "\u001B[40m" + "\u001B[33mB"; //'B'; // BEACH;
            else if (passedDouble < 0.15) return "\u001B[40m" + "\u001B[32mF"; //'F'; //FOREST;
            else if (passedDouble < 0.2) return "\u001B[40m" + "\u001B[32mJ"; //'J'; //JUNGLE;
            else if (passedDouble < 0.25) return "\u001B[40m" + "\u001B[33mS";//'S';// SAVANNAH;
                //else if (passedDouble < 0.3) return "\u001B[33mD";//'D'; //DESERT;
            else if (passedDouble < 0.3) return "\u001B[40m" + "\u001B[37mP"; //'P'; //SNOW;
            else return "\u001B[40m" + "\u001B[34m~";//'O'; // Ocean

        }


  }






