/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AWT;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author mamto
 */
public class Bai2 extends Frame{
    public static void main(String[] args) {
        Frame myFrame = new Frame("Frame has somes buttons!");
        myFrame.setSize(350, 200); // Định kích cỡ frame
        myFrame.setLayout(new GridBagLayout());// Thiết lập cách trình bày
        
        
        myFrame.setVisible(true); // Hiển thị frame
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
        }
    });
    }
}

