/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class FuelTruck {
    Lock l;
    public FuelTruck()
	{
		l=new ReentrantLock();
	}

    public void useFuelTruck (Plane p) throws InterruptedException{
        l.lock();
        System.out.println("Plane" + p.getID() + ": Plane is granted permission to use fuelTruck");
        Thread.sleep(6000);
        System.out.println("Plane" + p.getID() + ": Plane is finish using fuelTruck");
        p.setFuelLevel(10);
        l.unlock();
    }
}
