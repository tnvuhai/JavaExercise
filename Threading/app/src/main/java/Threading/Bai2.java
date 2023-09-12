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

class Thread1 implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            if(i % 2 == 0){
                System.out.println("Thread 1: "+i);
            }
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("Lỗi luồng 1!");
            }
        }
    }
}

class Thread2 implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            if(i % 2 != 0){
                System.out.println("Thread 2: "+i);
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                    System.out.println("Lỗi luồng 2!");
            }
        }
    }
}

public class Bai2{
    public static void main(String[] args) {
        Thread1 firstThread=new Thread1();
        Thread2 secondThread=new Thread2();
        Thread thread1=new Thread(firstThread);
        Thread thread2=new Thread(secondThread);
        
//        thread1.setPriority(Thread.MAX_PRIORITY);
//        thread2.setPriority(Thread.MIN_PRIORITY);
//        
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
        }
        thread2.start();
    }
}
