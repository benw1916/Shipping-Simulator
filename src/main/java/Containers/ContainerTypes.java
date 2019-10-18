package main.java.Containers;

public class ContainerTypes{
    private static final String[] containerTypes = {"standard", "volatile", "vehicle", "refrigeration", "oil", "grain", "gravel", "chemical"}; // Standard set of container types.
    private String[] additionalContainerTypes = {}; // Add additional container types here.

    public static String getContainerTypes(int passedValue){
        return containerTypes[passedValue];
    }

    public static String[] getAllContainerTypes(){
        return containerTypes;
    }

    public static int getContainerSize(){
        return containerTypes.length;
    }

}