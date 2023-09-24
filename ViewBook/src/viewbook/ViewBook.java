/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viewbook;

import viewbook.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mamto
 */

// Mã Sinh viên: DTC195480201CLC0006
// Họ và tên: Nguyễn Vũ Hải

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ViewBook extends JFrame implements ActionListener{
    
    public JTable table;
    JButton addButton;
    public JButton editButton, saveButton, deleteButton;
    private JTextField maSoSachField, tenSachField, tacGiaField, namXuatBanField, nhaXuatBanField;
    
    public ViewBook() {
        Book BookClass = new Book();
        setTitle("Quản lý sách");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        

        
        table = new JTable(BookClass.getBookInfo());
        
        
        addButton = new JButton("Thêm mới sách");
        editButton = new JButton("Sửa thông tin sách");
        saveButton = new JButton("Ghi thông tin sách");
        deleteButton = new JButton("Xóa sách");

        maSoSachField = new JTextField(10);
        tenSachField = new JTextField(10);
        tacGiaField = new JTextField(10);
        namXuatBanField = new JTextField(10);
        nhaXuatBanField = new JTextField(10);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Mã số sách:"));
        inputPanel.add(maSoSachField);
        inputPanel.add(new JLabel("Tên sách:"));
        inputPanel.add(tenSachField);
        inputPanel.add(new JLabel("Tác giả:"));
        inputPanel.add(tacGiaField);
        inputPanel.add(new JLabel("Năm xuất bản:"));
        inputPanel.add(namXuatBanField);
        inputPanel.add(new JLabel("Nhà xuất bản:"));
        inputPanel.add(nhaXuatBanField);
        inputPanel.add(saveButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện thêm sách
                // Thêm thông tin sách vào cơ sở dữ liệu
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện sửa thông tin sách
                // Hiển thị thông tin sách đã chọn để sửa
            }
        });

//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Xử lý sự kiện ghi thông tin sách
//                // Ghi thông tin sách vào cơ sở dữ liệu
//            }
//        });

        
//        table.addActionListener(new ActionListener()){
//            int row = table.getSelectedRow();
//                if (row >= 0) {
//                    return table.getValueAt(row, 0);
//                }
//        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewBook viewBook = new ViewBook();
                Book BookClass = new Book();
                new ControllerBook(viewBook, BookClass);
                viewBook.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
