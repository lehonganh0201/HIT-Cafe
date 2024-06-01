/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
    private final String email = "admin@gmail.com";
    private final ICategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
    private ManageCategory manageCategoryView;

    public CategoryController(ManageCategory manageCategoryView) {
        this.manageCategoryView = manageCategoryView;
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
            HomeController homeController = new HomeController(email, view);
            homeController.showHomeView();
        }
    }

    private class CategoryTableMouseListener extends MouseAdapter {

        public CategoryTableMouseListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JTable categoryTable = manageCategoryView.getCategoryTable();
            int index = categoryTable.getSelectedRow();
            TableModel model = categoryTable.getModel();
            Integer id = (Integer) model.getValueAt(index, 0);
            String name = model.getValueAt(index, 1).toString();
            int a = JOptionPane.showConfirmDialog(null, "Do you want to Delete " + name + " Category", "Select", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                categoryService.deleteCategoryById(id);
                manageCategoryView.reloadTable(categoryService.getAllCategoryRecords());
            }
        }   
    }
}