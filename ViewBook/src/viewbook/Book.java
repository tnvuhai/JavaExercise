/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewbook;
import java.util.Vector;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mamto
 */

// Mã Sinh viên: DTC195480201CLC0006
// Họ và tên: Nguyễn Vũ Hải

public class Book {
    String userName = "root";
    String pass = "";
    String dbURL = "jdbc:mysql://localhost:3306/sach";
    Connection conn;
    public DefaultTableModel tableModel;
    private Vector rowData;
    public Connection connectDB() {
        try {
            conn = DriverManager.getConnection(dbURL, userName, pass);
            System.out.println("Connect OK!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    // Constructor và các getter, setter cho các thuộc tính

    public DefaultTableModel getBookInfo() {
        // Kết nối cơ sở dữ liệu và lấy thông tin sách dựa trên bookID
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sach",userName,pass);
            String query = "SELECT * FROM sach";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1, bookID);
            ResultSet resultSet = preparedStatement.executeQuery();
            tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã số sách");
            tableModel.addColumn("Tên sách");
            tableModel.addColumn("Tác giả");
            tableModel.addColumn("Năm xuất bản");
            tableModel.addColumn("Nhà xuất bản");

            while (resultSet.next()) {
                rowData = new Vector();
                rowData.add(resultSet.getString(1));
                rowData.add(resultSet.getString(2));
                rowData.add(resultSet.getString(3));
                rowData.add(resultSet.getString(4));
                rowData.add(resultSet.getString(5));
                tableModel.addRow(rowData);
            }
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tableModel;
    }

    public void deleteBook(String bookID) {
       
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sach",userName,pass);
            String query = "DELETE FROM SACH WHERE MaSoSach=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookID);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
