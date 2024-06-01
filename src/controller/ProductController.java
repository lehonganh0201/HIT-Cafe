/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Category;
import model.Product;
import repository.CategoryRepositoryImpl;
import repository.ProductRepositoryImpl;
import service.CategoryServiceImpl;
import service.IService.ICategoryService;
import service.IService.IProductService;
import service.ProductServiceImpl;
import view.AddNewProduct;
import view.Home;
import view.ViewEditDeleteProduct;

/**
 *
 * @author PC
 */
public class ProductController {

    private final String email = "admin@gmail.com";
    private final IProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
    private final ICategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
    private AddNewProduct newProductView;
    private ViewEditDeleteProduct editAndDeleteProductView;
    private List<Category> categorys = categoryService.getAllCategoryRecords();

    public ProductController(AddNewProduct newProductView) {
        this.newProductView = newProductView;
        categorys.forEach(cate -> newProductView.getCcb().addItem(cate.getName()));
        this.newProductView.addExitListener(new ReturnHomeListener());
        this.newProductView.addSaveProduct(new SaveProductListener());
    }

    public ProductController(ViewEditDeleteProduct editAndDeleteProductView) {
        this.editAndDeleteProductView = editAndDeleteProductView;
        categorys.forEach(cate -> editAndDeleteProductView.getCategory().addItem(cate.getName()));
        this.editAndDeleteProductView.reloadTable(productService.getAllRecords());
        this.editAndDeleteProductView.addExitListener(new ReturnHomeListener());
        this.editAndDeleteProductView.addUpdatedListener(new UpdatedProductListener());
        this.editAndDeleteProductView.addDeleteListener(new DeleteProductListener());
        this.editAndDeleteProductView.addMouseClickerListner(new MouseClickTableListener());
    }

    void showViewEditProduct() {
        this.editAndDeleteProductView.setVisible(true);
    }

    void showAddNewProductView() {
        this.newProductView.setVisible(true);
    }

    private class MouseClickTableListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            JTable jTable = editAndDeleteProductView.getProTable();
            int index = jTable.getSelectedRow();
            if (index != -1) {
                TableModel model = jTable.getModel();
                String id = model.getValueAt(index, 0).toString();
                editAndDeleteProductView.getLblId().setText(id);
                String name = model.getValueAt(index, 1).toString();
                editAndDeleteProductView.getTxtName().setText(name);
                String category = model.getValueAt(index, 2).toString();
                String price = model.getValueAt(index, 3).toString();
                editAndDeleteProductView.getTxtPrice().setText(price);
                editAndDeleteProductView.getBtnUpdate().setEnabled(true);
                editAndDeleteProductView.getBtnDelete().setEnabled(true);
                editAndDeleteProductView.getCategory().removeAllItems();
                editAndDeleteProductView.getCategory().addItem(category);
                for (Category category1 : categorys) {
                    if (!category1.getName().equals(category)) {
                        editAndDeleteProductView.getCategory().addItem(category1.getName());
                    }
                }
            }
        }
    }

    private class DeleteProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer id = editAndDeleteProductView.getId();
            int a = JOptionPane.showConfirmDialog(null, "Do you want to delete this product", "Select", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                productService.deleteById(id);
                editAndDeleteProductView.reloadTable(productService.getAllRecords());
                editAndDeleteProductView.clear();
            }
        }
    }

    private class UpdatedProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer id = editAndDeleteProductView.getId();
            String name = editAndDeleteProductView.getNameProduct();
            String category = editAndDeleteProductView.getStringCategory();
            String price = editAndDeleteProductView.getPrice();
            Product product = new Product(id, name, category, price);
            productService.updateProduct(product);
            editAndDeleteProductView.reloadTable(productService.getAllRecords());
        }
    }

    private class SaveProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Product product = new Product(
                    newProductView.getName(),
                    newProductView.getSelectedItem(),
                    newProductView.getPrice()
            );

            productService.saveProduct(product);
            newProductView.clear();
        }
    }

    private class ReturnHomeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (newProductView != null) {
                newProductView.setVisible(false);
            }
            if (editAndDeleteProductView != null) {
                editAndDeleteProductView.setVisible(false);
            }
            Home homeView = new Home();
            HomeController homeController = new HomeController(email, homeView);
            homeController.showHomeView();
        }
    }
}