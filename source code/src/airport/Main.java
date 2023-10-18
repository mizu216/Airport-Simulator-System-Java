package airport;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport();
        Runway runway = new Runway(airport);
        Gate gate = new Gate();
        FuelTruck fuelTruck = new FuelTruck();
        airport.start();
        runway.start();
        PlaneGenerator p = new PlaneGenerator(airport,runway,gate,fuelTruck);
        p.start();
    }
    
}
