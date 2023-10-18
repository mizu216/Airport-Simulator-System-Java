package airport;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PlaneGenerator extends Thread {
    private Airport airport;
    private Runway runway;
    private Gate gate;
    private FuelTruck fuelTruck;
    Random random = new Random();
    
    public PlaneGenerator(Airport airport,Runway runway,Gate gate,FuelTruck fuelTruck){
        this.airport = airport;
        this.runway = runway;
        this.gate = gate;
        this.fuelTruck = fuelTruck;
    }
    
    public void run(){
        try{
            int i =1;
            while(i<=6){
                if(gate.s.availablePermits()>=0){
                    Plane p =new Plane(i, random.nextInt(7)+1,airport,runway,gate,fuelTruck);
                    System.out.println("Plane" + p.getID()+ " : Plane is waiting to put into use runway queue");
                    p.start();
                    i++;
                    TimeUnit.SECONDS.sleep((long)(Math.random()*5));
                }
            }
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
