

import java.util.Date;

/**
 * I pretty much duplicated the CentralAC since is very similar to it.
 * then changed a few variables to WaterHeater.
 */
public class WaterHeater extends ServiceCall{

    private String ageOfWaterHtr;
    //Created this line below for the service charge imposed by the city.
    protected final static double servCharge = 20.00;


    public WaterHeater(String serviceAddress, String problemDescription, Date date, String model) {
        super(serviceAddress, problemDescription, date);
        this.ageOfWaterHtr = model;
    }

    public String getModel() {
        return ageOfWaterHtr;
    }

    public void setModel(String model) {
        this.ageOfWaterHtr = model;
    }


    @Override
    public String toString() {

        //These statements use the Java ternary operator
        //This says "if resolvedDate == null, then set resolvedDate to "Unresolved". Otherwise, set resolvedDate to resolvedDate.toString()
        //Same logic as an if-else statment, but more consise if the condition is simple and the if statment's task is 
        //to set the value of a variable based on a condition being true or false. 
        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = (this.resolution == null) ? "Unresolved" : this.resolution;
        //I added the service charge to the this code line below.
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "The total including the service charge of $" + servCharge + " is $" + (fee + servCharge);
        //+ Double.toString(fee) + " add a service charge of " + Double.toString(servCharge);


        return "WaterHeater Unit Service Call " + "\n" +
                "Service Address= " + serviceAddress + "\n" +
                "Problem Description = " + problemDescription  + "\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Fee = " + feeString;

    }
}

/*
 Example
 List of resolved calls:
 WaterHeater Unit Service Call
 Service Address= 100 Main Street
 Problem Description = Bad heating element
 Reported Date = Thu Mar 17 20:46:09 CDT 2016
 Resolved Date = Thu Mar 17 20:46:25 CDT 2016
 Resolution =
 Fee = The total including the service charge of $20.0 is $145.0
 */
