package airport;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Runway extends Thread{
    private Airport airport;
    private PriorityBlockingQueue <Plane> queue;
    
        public Runway(Airport airport){
            this.airport = airport;
            queue = new PriorityBlockingQueue<>(3,Comparator.comparingInt(Plane::getFuelLevel));
        }
        
    @Override
    public void run() {
        try{
            while(airport.isIsOperate()==true){
                if(!queue.isEmpty()){
                    Thread.sleep(1000);
                    Plane p = queue.poll();
                    System.out.println("Plane" + p.getID() + " with FuelLevel " +(p.getFuelLevel()*10)+ "% : Plane is granted permission to use runway");
                    p.setUsingRunway(true);
                    while(p.isUsingRunway()==true){
                        Thread.sleep(100);
                    }
                }
            }
            System.out.println("-----------------Queue Closed-------------------");
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void LandingQueue (Plane p) throws InterruptedException{
        p.getGate().s.acquire();
        queue.put(p);
        System.out.println("Plane" + p.getID() + " with FuelLevel " +(p.getFuelLevel()*10)+ "% : Plane has put into the use runway queue for landing");
    }
    
        public void TakeOffQueue (Plane p) throws InterruptedException{
        queue.put(p);
        System.out.println("Plane" + p.getID()+"：Plane has put into the use runway queue for take off");
    }
}
