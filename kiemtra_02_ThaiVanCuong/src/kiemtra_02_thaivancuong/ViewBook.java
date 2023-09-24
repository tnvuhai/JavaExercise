/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class ViewBook extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton addButton, editButton, saveButton, deleteButton;
    private JTextField maSoSachField, tenSachField, tacGiaField, namXuatBanField, nhaXuatBanField;
    private Book book;

    public ViewBook() {
        book = new Book();

        setTitle("Quản lý sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã số sách");
        tableModel.addColumn("Tên sách");
        tableModel.addColumn("Tác giả");
        tableModel.addColumn("Năm xuất bản");
        tableModel.addColumn("Nhà xuất bản");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        addButton = new JButton("Thêm mới");
        editButton = new JButton("Sửa thông tin");
        saveButton = new JButton("Ghi thông tin");
        deleteButton = new JButton("Xóa sách");

        maSoSachField = new JTextField(10);
        tenSachField = new JTextField(20);
        tacGiaField = new JTextField(20);
        namXuatBanField = new JTextField(10);
        nhaXuatBanField = new JTextField(20);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        refreshTable();
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addEditButtonListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void refreshTable() {
        // Xóa dữ liệu cũ
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        // Lấy dữ liệu mới từ cơ sở dữ liệu và hiển thị lên bảng
        Vector<Vector<Object>> data = book.getAllBooks();
        for (Vector<Object> row : data) {
            tableModel.addRow(row);
        }
    }
    public void showAddDialog() {
        JDialog addDialog = new JDialog(this, "Thêm mới sách", true);
        addDialog.setSize(400, 200);
        addDialog.setLayout(new GridLayout(5, 2));
        JLabel labelTenSach = new JLabel("Tên sách:");
        JTextField fieldTenSach = new JTextField();
        JLabel labelTacGia = new JLabel("Tác giả:");
        JTextField fieldTacGia = new JTextField();
        JLabel labelNamXuatBan = new JLabel("Năm xuất bản:");
        JTextField fieldNamXuatBan = new JTextField();
        JLabel labelNhaXuatBan = new JLabel("Nhà xuất bản:");
        JTextField fieldNhaXuatBan = new JTextField();

        JButton addButton = new JButton("Thêm");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tenSach = fieldTenSach.getText();
                String tacGia = fieldTacGia.getText();
                int namXuatBan = Integer.parseInt(fieldNamXuatBan.getText());
                String nhaXuatBan = fieldNhaXuatBan.getText();

                book.addBook(tenSach, tacGia, namXuatBan, nhaXuatBan);
                refreshTable();
                addDialog.dispose();
            }
        });

        addDialog.add(labelTenSach);
        addDialog.add(fieldTenSach);
        addDialog.add(labelTacGia);
        addDialog.add(fieldTacGia);
        addDialog.add(labelNamXuatBan);
        addDialog.add(fieldNamXuatBan);
        addDialog.add(labelNhaXuatBan);
        addDialog.add(fieldNhaXuatBan);
        addDialog.add(addButton);

        addDialog.setVisible(true);
    }

    public void showEditDialog() {
        int selectedRow = table.getSelectedRow();
        int maSoSach = (int) tableModel.getValueAt(selectedRow, 0);
        Vector<Object> bookData = book.getBookData(maSoSach);

        if (bookData != null) {
            String tenSach = (String) bookData.get(1);
            String tacGia = (String) bookData.get(2);
            int namXuatBan = (int) bookData.get(3);
            String nhaXuatBan = (String) bookData.get(4);

            // Tạo một cửa sổ dialog tùy chỉnh để sửa thông tin sách
            JDialog editDialog = new JDialog(this, "Sửa thông tin sách", true);
            editDialog.setSize(400, 200);
            editDialog.setLayout(new GridLayout(5, 2));

            JLabel labelTenSach = new JLabel("Tên sách:");
            JTextField fieldTenSach = new JTextField(tenSach);
            JLabel labelTacGia = new JLabel("Tác giả:");
            JTextField fieldTacGia = new JTextField(tacGia);
            JLabel labelNamXuatBan = new JLabel("Năm xuất bản:");
            JTextField fieldNamXuatBan = new JTextField(String.valueOf(namXuatBan));
            JLabel labelNhaXuatBan = new JLabel("Nhà xuất bản:");
            JTextField fieldNhaXuatBan = new JTextField(nhaXuatBan);

            JButton editButton = new JButton("Sửa");
            editButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String newTenSach = fieldTenSach.getText();
                    String newTacGia = fieldTacGia.getText();
                    int newNamXuatBan = Integer.parseInt(fieldNamXuatBan.getText());
                    String newNhaXuatBan = fieldNhaXuatBan.getText();

                    book.editBook(maSoSach, newTenSach, newTacGia, newNamXuatBan, newNhaXuatBan);
                    refreshTable();
                    editDialog.dispose();
                }
            });

            editDialog.add(labelTenSach);
            editDialog.add(fieldTenSach);
            editDialog.add(labelTacGia);
            editDialog.add(fieldTacGia);
            editDialog.add(labelNamXuatBan);
            editDialog.add(fieldNamXuatBan);
            editDialog.add(labelNhaXuatBan);
            editDialog.add(fieldNhaXuatBan);
            editDialog.add(editButton);

            editDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Không thể tìm thấy thông tin sách.");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ViewBook view = new ViewBook();
                Book model = new Book();
                new ControllerBook(view, model);  // Tạo một đối tượng ControllerBook
                view.setVisible(true);
            }
        });
    }
}
