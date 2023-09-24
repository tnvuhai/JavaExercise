/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewbook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import viewbook.*;
/**
 *
 * @author mamto
 */
// Mã Sinh viên: DTC195480201CLC0006
// Họ và tên: Nguyễn Vũ Hải

public class ControllerBook {
    private ViewBook view;
    private Book book;
    
    
    public ControllerBook(ViewBook view, Book book){
        this.view = view;
        this.book = book;
        
        this.view.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 // Xử lý sự kiện khi nút "Xóa sách" được nhấn
                int selectedRow = view.table.getSelectedRow();
                if (selectedRow >= 0) {
                    
                    String bookID = (String) view.table.getValueAt(selectedRow, 0);
                    System.out.println(bookID);
                    book.deleteBook(bookID);
                    // Cập nhật lại bảng sau khi xóa
                    view.table.removeAll();
                    view.table.setModel(book.getBookInfo());
                }
            }
        });
   
    }
}
