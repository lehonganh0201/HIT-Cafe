/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import contant.AccountContant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Category;
import repository.CategoryRepositoryImpl;
import service.CategoryServiceImpl;
import service.IService.ICategoryService;
import view.Home;
import view.ManageCategory;

/**
 *
 * @author PC
 */
public class CategoryController {
    private final ICategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
    private ManageCategory manageCategoryView;

    public CategoryController(ManageCategory manageCategoryView) {
        this.manageCategoryView = manageCategoryView;
        //Thực hiện lắng nghe sự kiện lưu trữ và xóa danh mục
        this.manageCategoryView.reloadTable(categoryService.getAllCategoryRecords());
        this.manageCategoryView.addCategoryTableMouseListener(new CategoryTableMouseListener());
        this.manageCategoryView.addExitListener(new ReturnLoginListener());
        this.manageCategoryView.addSaveListener(new SaveCategoryListener());
        
    }

    void showCategoryView() {
        manageCategoryView.setVisible(true);
    }

    private class SaveCategoryListener implements ActionListener {

        public SaveCategoryListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Category category = new Category(manageCategoryView.getCategoryName());
            categoryService.saveCategory(category);
            manageCategoryView.clear();
            manageCategoryView.reloadTable(categoryService.getAllCategoryRecords());
        }
    }

    private class ReturnLoginListener implements ActionListener {

        public ReturnLoginListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(manageCategoryView != null){
                manageCategoryView.setVisible(false);
            }
            Home view = new Home();
            HomeController homeController = new HomeController(AccountContant.ADMIN, view);
            homeController.showHomeView();
        }
    }

    private class CategoryTableMouseListener extends MouseAdapter {

        public CategoryTableMouseListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JTable categoryTable = manageCategoryView.getCategoryTable();
            //Lấy ra dòng được chọn
            int index = categoryTable.getSelectedRow();
            TableModel model = categoryTable.getModel();
            Integer id = (Integer) model.getValueAt(index, 0);
            String name = model.getValueAt(index, 1).toString();
            //Gửi thông báo đến Client xác nhận muốn xóa không?
            int a = JOptionPane.showConfirmDialog(null, "Do you want to Delete " + name + " Category", "Select", JOptionPane.YES_NO_OPTION);
            //Nếu đồng ý thì thực hiện xóa category khỏi bảng và cập nhật lại danh sách
            if (a == 0) {
                categoryService.deleteCategoryById(id);
                manageCategoryView.reloadTable(categoryService.getAllCategoryRecords());
            }
        }   
    }
}