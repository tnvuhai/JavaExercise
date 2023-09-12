/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mamto
 */
public class Bai3{
    int i;
    public synchronized void  runNumber() {
       for(int i =1; i<=10;i++){
           System.out.println("Thread 1: "+i);
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Lỗi luồng 1!");
            }
            notify();
       }
    }
    
    public synchronized void runText() {
        for(int i = 1; i <= 10;i++){
            if(i % 2 == 0){
                System.out.println("Chan");
            }
            else{
                System.out.println("Le");
            }
            notify();
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        final Bai3 t = new Bai3();
        Thread firstThread=new Thread(){
            public void run(){               
                t.runNumber();
            }
        };
        firstThread.start();
        Thread secondThread=new Thread(){
            public void run(){
                t.runText();
            }
        };        
        secondThread.start();
    }
}

