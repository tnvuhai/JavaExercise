/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewbook;

/**
 *
 * @author mamt
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ControllerBook {

    private ViewBook view;
    private Book model;

    public ControllerBook(ViewBook view, Book model) {
        this.view = view;
        this.model = model;

        this.view.addAddButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showAddDialog();
            }
        });

        this.view.addEditButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow >= 0) {
                    view.showEditDialog();
                } else {
                    JOptionPane.showMessageDialog(view, "Vui lòng chọn một cuốn sách để sửa.");
                }
            }
        });

        this.view.addDeleteButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow >= 0) {
                    int maSoSach = (int) view.getTableModel().getValueAt(selectedRow, 0);
                    model.deleteBook(maSoSach);
                    view.refreshTable();
                } else {
                    JOptionPane.showMessageDialog(view, "Vui lòng chọn một cuốn sách để xóa.");
                }
            }
        });
    }
}
