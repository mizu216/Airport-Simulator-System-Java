package airport;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Gate {
Semaphore s;
int gate;

public Gate()
	{
		s=new Semaphore(3);
                gate = 3;
	}

public void useGate(Plane p) throws InterruptedException
	{   
            int dockgate = 0;
            if (gate==3||gate==2){
                dockgate=2;
            }
            else if (gate==1){
                dockgate=1;
            }
            else if (gate==0){
                dockgate=0;
            }
            gate=gate-dockgate;
            p.setGateNum(dockgate);
            System.out.println("Plane" + p.getID()+ ": Plane is coaching to gate" + (dockgate+1) + " and has left runway");
            p.setUsingRunway(false);
            TimeUnit.SECONDS.sleep((long)(Math.random()*5));
            System.out.println("Plane" + p.getID()+ ": Plane has docked to gate" + (dockgate+1));
	}

public void leftGate(Plane p) throws InterruptedException
	{
            gate = gate+ p.getGateNum();
            System.out.println("Plane" + p.getID()+ ": Plane is coaching to runway");
            TimeUnit.SECONDS.sleep((long)(Math.random()*5));
            System.out.println("Plane" + p.getID()+ ": Plane has docked to runway");
	}
}