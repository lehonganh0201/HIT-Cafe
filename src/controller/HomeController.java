/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import repository.BillRepositoryImpl;
import service.BillServiceImpl;
import service.IService.IBillService;
import view.AddNewProduct;
import view.ChangePassword;
import view.ChangeSecurityQuestion;
import view.Home;
import view.Login;
import view.ManageCategory;
import view.PlaceOrder;
import view.RevenueView;
import view.VetifyUsers;
import view.ViewBillsOrderPlaceDetails;
import view.ViewEditDeleteProduct;

/**
 *
 * @author PC
 */
public class HomeController {
    private final IBillService billService = new BillServiceImpl(new BillRepositoryImpl());
    private String email = "";
    private final Home homeView;

    public HomeController(String email, Home view) {
        this.email = email;
        this.homeView = view;
        homeView.showAdminPermisstion(email);
        homeView.addViewProductListener(new ViewProductListener());
        homeView.addCategoryListener(new CategoryListener());
        homeView.addVerifyUserListener(new VerifyUserListener());
        homeView.addNewProductListener(new NewProductListener());
        homeView.addViewBillListener(new ViewBillListener());
        homeView.addChangeQuestionListener(new ChangeQuestionListener());
        homeView.addChangePasswordListener(new ChangePasswordListener());
        homeView.addOrderListener(new OrderListener());
        homeView.addExitListener(new ExitListener());
        homeView.addLogoutListener(new LogoutListener());
        homeView.addToStatisticsListener(new StatisticsListener());
    }

    public void showHomeView() {
        homeView.setVisible(true);
    }

    private class StatisticsListener implements ActionListener {

        public StatisticsListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.setVisible(false);
            RevenueView revenueView = new RevenueView();
            OrderController orderController = new OrderController(revenueView, email);
            orderController.showRevenueView();
        }
    }

    private class NewProductListener implements ActionListener {

        public NewProductListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.setVisible(false);
            AddNewProduct productView = new AddNewProduct();
            ProductController productController = new ProductController(productView);
            productController.showAddNewProductView();
        }
    }

    private class ViewBillListener implements ActionListener {

        public ViewBillListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.setVisible(false);
            ViewBillsOrderPlaceDetails bill = new ViewBillsOrderPlaceDetails();
            BillController billController = new BillController(bill, email);
            billController.showBillsView();
        }
    }

    private class VerifyUserListener implements ActionListener {

        public VerifyUserListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.setVisible(false);
            VetifyUsers vetifyUsers = new VetifyUsers();
            UserController userController = new UserController(vetifyUsers, email);
            userController.showVetifyPage();
        }
    }

    private class ChangeQuestionListener implements ActionListener {

        public ChangeQuestionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.setVisible(false);
            ChangeSecurityQuestion changeQuestion = new ChangeSecurityQuestion();
            UserController userController = new UserController(changeQuestion, email);
            userController.showChangeQuestionView();
        }
    }

    private class ChangePasswordListener implements ActionListener {

        public ChangePasswordListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.setVisible(false);
            ChangePassword changePasswordView = new ChangePassword();
            UserController userController = new UserController(changePasswordView, email);
            userController.showChangePasswordView();
        }
    }

    private class OrderListener implements ActionListener {

        public OrderListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.setVisible(false);
            PlaceOrder orderView = new PlaceOrder();
            OrderController orderController = new OrderController(orderView,email);
            orderController.showOrderView();
        }
    }

    private class ExitListener implements ActionListener {

        public ExitListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int a = JOptionPane.showConfirmDialog(null, "Do you really want to close Application?", "Select", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                System.exit(0);
            }
        }
    }

    private class LogoutListener implements ActionListener {

        public LogoutListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout?", "Select", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                homeView.setVisible(false);
                Login loginView = new Login();
                AuthController authController = new AuthController(loginView);
                authController.showLoginView();
                email = "";
            }
        }
    }

    private class CategoryListener implements ActionListener {

        public CategoryListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.setVisible(false);
            ManageCategory manageCategory = new ManageCategory();
            CategoryController categoryController = new CategoryController(manageCategory);
            categoryController.showCategoryView();
        }
    }

    private class ViewProductListener implements ActionListener {

        public ViewProductListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.setVisible(false);
            ViewEditDeleteProduct editAndDeleteView = new ViewEditDeleteProduct();
            ProductController productController = new ProductController(editAndDeleteView);
            productController.showViewEditProduct();
        }
    }
}