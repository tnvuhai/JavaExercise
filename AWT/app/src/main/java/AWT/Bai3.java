/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AWT;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author mamto
 */
public class Bai3 extends Frame{
   
    public static void main(String[] args) {
        Frame myFrame = new Frame("Bai 3");
        myFrame.setSize(350, 200); // Định kích cỡ frame
        GridBagLayout layout = new GridBagLayout();
        myFrame.setLayout(layout);// Thiết lập cách trình bày
        
        GridBagConstraints cts = new GridBagConstraints();
        cts.fill = GridBagConstraints.BOTH;
        
        Label NameLabel = new Label("Họ tên: ");
        cts.gridx = 1;
        cts.gridy = 1;
        cts.gridheight = 1;
        cts.gridwidth = 1;
        //cts.weightx = 1;
        layout.setConstraints(NameLabel, cts);
        myFrame.add(NameLabel);
        
        TextField HoTenText = new TextField("");
        cts.gridx = 2;
        cts.gridy = 1;
        cts.gridheight = 1;
        cts.gridwidth = 2;
        cts.weightx = 1;
        layout.setConstraints(HoTenText, cts);
        myFrame.add(HoTenText);
        
        Label AdressLabel = new Label("Địa chỉ: ");
        cts.gridx = 1;
        cts.gridy = 2;
        cts.gridheight = 1;
        
        //cts.weightx = 1;
        layout.setConstraints(AdressLabel, cts);
        myFrame.add(AdressLabel);
        
        TextField AddressText = new TextField("");
        cts.gridx = 2;
        cts.gridy = 2;
        cts.gridheight = 1;
        //cts.gridwidth = 2;
        //cts.weightx = 1;
        layout.setConstraints(AddressText, cts);
        myFrame.add(AddressText);
        
        Label BirthLabel = new Label("Năm sinh: ");
        cts.gridx = 1;
        cts.gridy = 3;
        cts.gridheight = 1;
        cts.weightx = 1;
        layout.setConstraints(BirthLabel, cts);
        myFrame.add(BirthLabel);
        
        TextField BirthText = new TextField("");
        cts.gridx = 2;
        cts.gridy = 3;
        cts.gridheight = 1;
        //cts.gridwidth = 2;
        cts.weightx = 1;
        layout.setConstraints(BirthText, cts);
        myFrame.add(BirthText);
        
        
        cts.fill = GridBagConstraints.CENTER;
        Button Add = new Button("Thêm");
        cts.gridx = 1;
        cts.gridy = 5;
        cts.weighty = 1;
        cts.gridwidth = 1;
        layout.setConstraints(Add, cts);
        myFrame.add(Add);
        
        Button Fix = new Button("Sửa");
        cts.gridx = 2;
        cts.gridy = 5;
        cts.weighty = 1;
        layout.setConstraints(Fix, cts);
        myFrame.add(Fix);
        
        Button Delete = new Button("Xóa");
        cts.gridx = 3;
        cts.gridy = 5;
        cts.weighty = 1;
        layout.setConstraints(Delete, cts);
        myFrame.add(Delete);
        
        myFrame.setVisible(true); // Hiển thị frame
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
        }
    });
    }
}

