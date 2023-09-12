/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threading;

/**
 *
 * @author mamto
 */

class FirstThread implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.println("Message tu First Thread:"+i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("Lỗi luồng 1!");
            }
        }
    }
}

class SecondThread implements Runnable{
    @Override
    public void run() {
        for(int i=50;i<=100;i=i+10){
            System.out.println("Message tu Second Thread:"+i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                    System.out.println("Lỗi luồng 2!");
            }
        }
    }
}

public class Bai1{
    public static void main(String[] args) {
        FirstThread firstThread=new FirstThread();
        SecondThread secondThread=new SecondThread();
        Thread thread1=new Thread(firstThread);
        Thread thread2=new Thread(secondThread);
        
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        
        thread1.start();
        thread2.start();
    }
}
