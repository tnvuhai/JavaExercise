/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewbook;
import java.sql.*;
import java.util.Vector;

public class Book {
    private Connection connection;
    public Book() {
        try {
            // Kết nối đến cơ sở dữ liệu MySQL
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sach", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Vector<Vector<Object>> getAllBooks() {
        Vector<Vector<Object>> data = new Vector<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SACH");
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("MaSoSach"));
                row.add(resultSet.getString("TenSach"));
                row.add(resultSet.getString("TacGia"));
                row.add(resultSet.getInt("NamXuatBan"));
                row.add(resultSet.getString("NhaXuatBan"));
                data.add(row);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    public void addBook(String tenSach, String tacGia, int namXuatBan, String nhaXuatBan) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO SACH (TenSach, TacGia, NamXuatBan, NhaXuatBan) VALUES (?, ?, ?, ?)"
            );
            preparedStatement.setString(1, tenSach);
            preparedStatement.setString(2, tacGia);
            preparedStatement.setInt(3, namXuatBan);
            preparedStatement.setString(4, nhaXuatBan);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editBook(int maSoSach, String tenSach, String tacGia, int namXuatBan, String nhaXuatBan) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE SACH SET TenSach = ?, TacGia = ?, NamXuatBan = ?, NhaXuatBan = ? WHERE MaSoSach = ?"
            );
            preparedStatement.setString(1, tenSach);
            preparedStatement.setString(2, tacGia);
            preparedStatement.setInt(3, namXuatBan);
            preparedStatement.setString(4, nhaXuatBan);
            preparedStatement.setInt(5, maSoSach);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Vector<Object> getBookData(int maSoSach) {
        Vector<Object> bookData = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SACH WHERE MaSoSach = ?");
            preparedStatement.setInt(1, maSoSach);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bookData = new Vector<>();
                bookData.add(resultSet.getInt("MaSoSach"));
                bookData.add(resultSet.getString("TenSach"));
                bookData.add(resultSet.getString("TacGia"));
                bookData.add(resultSet.getInt("NamXuatBan"));
                bookData.add(resultSet.getString("NhaXuatBan"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookData;
    }
    public void deleteBook(int maSoSach) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM SACH WHERE MaSoSach = ?");
            preparedStatement.setInt(1, maSoSach);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

