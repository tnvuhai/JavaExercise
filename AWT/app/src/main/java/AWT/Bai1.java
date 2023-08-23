/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AWT;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author mamto
 */
public class Bai1 extends Frame{
    public static void main(String[] args) { // Khai báo và khởi tạo frame có tiêu đề
    Frame myFrame = new Frame("Frame has somes buttons!");
    myFrame.setSize(350, 200); // Định kích cỡ frame
    myFrame.setLayout(new FlowLayout());// Thiết lập cách trình bày
    // Khai báo và khởi tạo button
    String[] ColorArray = {"Red", "Blue", "Green"};
    for (int i = 0; i < 3; i++) {
        myFrame.add(new Button(""+ColorArray[i]));// Gắn vào frame
    }
    // 1. Khoi tao List
    List l=new List(5, true);
    l.setSize(350,150);
    // 2. Them cac gia tri cho list
    l.add("Mot");
    l.add("Hai");
    l.add("Ba");
    //l.setBackground(Color.blue);
    //3. Gan list vao Frame f
    myFrame.add(l);
    
    
    Checkbox PickMeCheck = new Checkbox("Pick me");
    myFrame.add(PickMeCheck);
    
    Label EnterLabel = new Label("Enter your name");
    myFrame.add(EnterLabel);
    TextField NameEnter = new TextField("Typing..");
    myFrame.add(NameEnter);
    // Phương thức bắt sự kiện click vào nút đóng frame
    myFrame.setVisible(true); // Hiển thị frame
    myFrame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
    }
}

