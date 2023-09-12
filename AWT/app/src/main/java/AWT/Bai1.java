/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AWT;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author mamto
 */
public class Bai1 extends Frame implements ActionListener, ItemListener , TextListener{

    Button b1, b2, b3;
    Frame myFrame;
    List l;
    Label lbl;
    Checkbox PickMeCheck;
    TextField NameEnter;
    public Bai1() {
        
      //  myFrame = new Frame("Frame has somes buttons!");
        super("Demo frame");
        this.setSize(350, 200); // Định kích cỡ frame
        this.setLayout(new FlowLayout(FlowLayout.CENTER));// Thiết lập cách trình bày

        b1 = new Button("Blue");
        this.add(b1);
        b1.addActionListener(this);

        b2 = new Button("Red");
        this.add(b2);
        b2.addActionListener(this);

        b3 = new Button("Green");
        this.add(b3);
        b3.addActionListener(this);

        // 1. Khoi tao List
        l = new List(5, true);
        l.setSize(350, 150);
        // 2. Them cac gia tri cho list
        l.add("Mot");
        l.add("Hai");
        l.add("Ba");
        //l.setBackground(Color.blue);
        //3. Gan list vao Frame f
        this.add(l);
        l.addItemListener(this);
        
        PickMeCheck = new Checkbox("Pick me");
        this.add(PickMeCheck);
        PickMeCheck.addItemListener(this);
        
        Label EnterLabel = new Label("Enter your name");
        this.add(EnterLabel);
        NameEnter = new TextField("Typing..");
        this.add(NameEnter);
        NameEnter.addTextListener(this);

//        this.setVisible(true);

        lbl = new Label("                                                   "); // Khởi tạo nhãn
        lbl.setSize(350,150);
        lbl.setBackground(Color.RED);
        this.add(lbl); // Gắn vao vung footer cua frame
        // Phương thức bắt sự kiện click vào nút đóng frame
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent ie){
        if ((ie.getStateChange() == ItemEvent.SELECTED) || (ie.getStateChange() == ItemEvent.DESELECTED)) {
            String kq = "Bạn đã chọn các mầu: \n";
            String[] items = l.getSelectedItems();
            for (int i = 0; i < items.length; i++) {
                kq += items[i] + ", ";
            }
            lbl.setText(kq);
        }
        if (ie.getSource() == PickMeCheck && ie.getStateChange() == ItemEvent.SELECTED) {
            String kq = "Bạn đã tick chọn Tick me: \n";
            lbl.setText(kq);
        }
        else if(ie.getSource() == PickMeCheck && ie.getStateChange() == ItemEvent.DESELECTED){
            String kq = "Bạn đã bỏ tick chọn Tick me: \n";
            lbl.setText(kq);
        }
    }
    
    @Override
    public void textValueChanged(TextEvent e){
        if (NameEnter.getText().length() >= 25) {
            lbl.setText("Tên quá dài");
        } else {
            lbl.setText("Tên oke rồi");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            this.setBackground(Color.BLUE);
        }
        if (e.getSource() == b2) {
            this.setBackground(Color.RED);
        }
        if (e.getSource() == b3) {
            this.setBackground(Color.GREEN);
            //System.out.print(NameEnter.getText().length());
        }
        
        
        
    }

    public static void main(String[] args) {
        Bai1 f = new Bai1();
        f.setVisible(true);
        // f.setSize(500, 150);
        //f.setBackground(Color.lightGray);

    }

}
