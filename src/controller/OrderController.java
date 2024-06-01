/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Bill;
import model.Category;
import model.Product;
import repository.BillRepositoryImpl;
import repository.CategoryRepositoryImpl;
import repository.ProductRepositoryImpl;
import service.BillServiceImpl;
import service.CategoryServiceImpl;
import service.IService.IBillService;
import service.IService.ICategoryService;
import service.IService.IProductService;
import service.ProductServiceImpl;
import view.Home;
import view.PlaceOrder;
import common.OpenPdf;
import exception.NotFoundException;
import javax.swing.JOptionPane;
import view.RevenueView;

/**
 *
 * @author PC
 */
public class OrderController {
    private final IProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
    private final IBillService billService = new BillServiceImpl(new BillRepositoryImpl());
    private final ICategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
    private PlaceOrder orderView;
    private RevenueView revenueView;
    private String email;
    
    public OrderController(RevenueView revenueView, String email) {
        this.revenueView = revenueView;
        this.email = email;
        this.revenueView.addExitListener(new ReturnHomeListener());
        this.revenueView.setRevenue(billService.getRevenue());
    }

    public OrderController(PlaceOrder orderView, String email) {
        this.email = email;
        this.orderView = orderView;
        String nextBillId = billService.getNextBillId().toString();
        List<Category> allCategories = categoryService.getAllCategoryRecords();
        List<Product> allProducts = productService.getAllRecords();
        this.orderView.initShow(nextBillId, allCategories, allProducts);
        this.orderView.addExitListener(new ReturnHomeListener());
        this.orderView.addKeyReleasedListener(new SearchListener());
        this.orderView.addMouseClickedListener(new ClickerTableListener());
        this.orderView.addChangeSelected(new BoxChangeSelectedListener());
        this.orderView.addGenaratedBillListener(new GenaratedBillListener());
    }
    
    
    
    void showOrderView() {
        orderView.setVisible(true);
    }
    
    void showRevenueView(){
        revenueView.setVisible(true);
    }

    public List<Product> fillterProductByName(String name, String category) {
        return productService.fillterProductByName(name, category);
    }

    public List<Product> getProductsByCategory(String category) {
        return productService.getAllRecordsByCategory(category);
    }

    public void createPdf(String customerName, Integer billId, String grandTotal) {
        String path = "D:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + billId + ".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                       HIT COFFEE");
            doc.add(cafeName);
            Paragraph starLine = new Paragraph("----------------------------------------------------------------------------------------------------------------------------------");
            doc.add(starLine);
            Paragraph para3 = new Paragraph("Bill ID: " + billId + "\nCustomer Name: " + customerName + "\nTotal Paid: " + grandTotal);
            doc.add(para3);
            doc.add(starLine);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for (int i = 0; i < orderView.getjTable2().getRowCount(); i++) {
                String n = orderView.getjTable2().getValueAt(i, 0).toString();
                String d = orderView.getjTable2().getValueAt(i, 1).toString();
                String r = orderView.getjTable2().getValueAt(i, 2).toString();
                String q = orderView.getjTable2().getValueAt(i, 3).toString();
                tb1.addCell(n);
                tb1.addCell(d);
                tb1.addCell(r);
                tb1.addCell(q);
            }
            doc.add(tb1);
            doc.add(starLine);
            Paragraph thanksMess = new Paragraph("Thank your very much! Please visit again.");
            doc.add(thanksMess);
            OpenPdf.openById(String.valueOf(billId));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        doc.close();
    }

    private class GenaratedBillListener implements ActionListener {

        public GenaratedBillListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String customerName = orderView.getTxtCusName().getText();
            String customerPhoneNumber = orderView.getTxtCusPhoneNumber().getText();
            String customerEmail = orderView.getTxtCusEmail().getText();
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            String todaydate = dFormat.format(date);
            String total = String.valueOf(orderView.getGrandTotal());
            Bill bill = new Bill();
            bill.setId(billService.getNextBillId());
            bill.setName(customerName);
            bill.setPhoneNumber(customerPhoneNumber);
            bill.setEmail(customerEmail);
            bill.setDate(todaydate);
            bill.setTotal(total);
            bill.setCreateBy(email);
            billService.saveBill(bill);

            createPdf(customerName, orderView.getBillId(), total);
            orderView.clearProductFields();
        }
    }

    private class BoxChangeSelectedListener implements ActionListener {

        public BoxChangeSelectedListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String category = orderView.getCBBSelectedItem();
            orderView.productNameByCategory(getProductsByCategory(category));
        }
    }

    private class ClickerTableListener extends MouseAdapter {

        public ClickerTableListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JTable jTable = orderView.getjTable1();
            int index = orderView.getTable1SelectedRow();
            TableModel model = jTable.getModel();
            String productName = model.getValueAt(index, 0).toString();
            try {
                Product product = productService.getProductByName(productName);
                orderView.getTxtProName().setText(product.getName());
                orderView.getTxtProPrice().setText(product.getPrice());
                orderView.getjSpinner1().setValue(1);
                orderView.getTxtProTotal().setText(product.getPrice());
                orderView.setProductPrice(Integer.parseInt(product.getPrice()));
                orderView.setProductTotal(Integer.parseInt(product.getPrice()));
                orderView.getBtnAddToCart().setEnabled(true);
            } catch (NotFoundException ex) {
                JOptionPane.showMessageDialog(null, "<html><b style=\"color:red\">" + ex.getMessage() + "</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><b style=\"color:red\">" + ex.getMessage() + "</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private class SearchListener extends KeyAdapter {

        public SearchListener() {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            String name = orderView.getNameText();
            String category = orderView.getCBBSelectedItem();
            if (name.trim().isEmpty()) {
                orderView.fillterProductByName(productService.getAllRecords());
            } else {
                orderView.fillterProductByName(fillterProductByName(name, category));
            }
        }
    }

    private class ReturnHomeListener implements ActionListener {

        public ReturnHomeListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (orderView != null) {
                orderView.setVisible(false);
            }
            if(revenueView != null){
                revenueView.setVisible(false);
            }
            Home homeView = new Home();
            HomeController homeController = new HomeController(email, homeView);
            homeController.showHomeView();
        }
    }
}