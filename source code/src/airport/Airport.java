/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport;
public class Airport extends Thread {
    private int time;
    private boolean isOperate;
    public Airport(){
        time=0;
        isOperate = true;
    }
    
    public void run(){
        try{
            while(isOperate == true){                
                System.out.println("-----------------Time seconds: "+time+"-------------------");
                Thread.sleep(1000);
                time++;
            }
            Thread.sleep(1000);
            System.out.println("--------------Airport Closed-----------------");
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isIsOperate() {
        return isOperate;
    }

    public void setIsOperate(boolean isOperate) {
        this.isOperate = isOperate;
    }
}
