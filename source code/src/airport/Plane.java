package airport;

import java.util.concurrent.TimeUnit;

public class Plane extends Thread {
    private int ID;
    private int fuelLevel;
    private Airport airport;
    private Runway runway;
    private boolean usingRunway;
    private Gate gate;
    private int gateNum;
    private FuelTruck fuelTruck;

    public Plane(int ID, int fuelLevel,Airport airport, Runway runway,Gate gate,FuelTruck fuelTruck) {
        this.ID = ID;
        this.fuelLevel = fuelLevel;
        this.airport = airport;
        this.runway = runway;
        this.usingRunway = false;
        this.gate = gate;
        this.gateNum=0;
        this.fuelTruck = fuelTruck;
    }
    
    @Override
    public void run() {
        try {
            runway.LandingQueue(this);
            while(this.isUsingRunway()!=true){
                Thread.sleep(100);
            }
            TimeUnit.SECONDS.sleep((long)(Math.random()*5));
            System.out.println("Plane" + this.ID + ": Plane has landed");
            gate.useGate(this);
            PassengerGenerator passenger = new PassengerGenerator(this);
            passenger.start();   
            fuelTruck.useFuelTruck(this);
            while(passenger.isDoneEmbark()!=true){
                Thread.sleep(100);
            }
            runway.TakeOffQueue(this);
            while(this.isUsingRunway()!=true){
                Thread.sleep(100);
            }
            gate.leftGate(this);
            System.out.println("Plane" + this.ID + ": Plane has take off");
            this.setUsingRunway(false);
            this.gate.s.release();
            if(this.ID>=6){
                airport.setIsOperate(false);
            }
        } 
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    
    public boolean isUsingRunway() {
        return usingRunway;
    }

    public void setUsingRunway(boolean usingRunway) {
        this.usingRunway = usingRunway;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    } 

    public int getGateNum() {
        return gateNum;
    }

    public void setGateNum(int gateNum) {
        this.gateNum = gateNum;
    }
    
    
}

