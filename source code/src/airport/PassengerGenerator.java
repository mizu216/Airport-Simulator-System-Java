package airport;

import java.util.concurrent.TimeUnit;


public class PassengerGenerator extends Thread {
    private Plane plane;
    private boolean doneEmbark;

    public PassengerGenerator(Plane plane) {
        this.plane = plane;
        this.doneEmbark = false;
    }
    
    public void run(){
        try{
            disembark(plane);
            System.out.println("Plane" + plane.getID() + ": Plane is cleaning and refilling supply");
            Thread.sleep(4000);
            System.out.println("Plane" + plane.getID() + ": Plane has done cleaning and refilling supply");
            embark(plane);
            doneEmbark = true;
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    
    public void embark(Plane p) throws InterruptedException{
        System.out.println("Plane" + p.getID() + ": Passenger is embarking");
        TimeUnit.SECONDS.sleep((long)(Math.random()*7));
        System.out.println("Plane" + p.getID() + ": All passenger Embarked");       
    }    
 
    
    public void disembark(Plane p) throws InterruptedException{
        System.out.println("Plane" + p.getID() + ": Passenger is disembarking");
        TimeUnit.SECONDS.sleep((long)(Math.random()*7));
        System.out.println("Plane" + p.getID() + ": All passenger disembarked");
    }   

    public boolean isDoneEmbark() {
        return doneEmbark;
    }

    public void setDoneDisembark(boolean doneDisembark) {
        this.doneEmbark = doneDisembark;
    }
    
    
}
