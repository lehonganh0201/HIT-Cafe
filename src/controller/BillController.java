
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.OpenPdf;
import contant.AccountContant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Bill;
import repository.BillRepositoryImpl;
import service.BillServiceImpl;
import service.IService.IBillService;
import view.Home;
import view.ViewBillsOrderPlaceDetails;

/**
 *
 * @author PC
 */
public class BillController {

    private final IBillService billService = new BillServiceImpl(new BillRepositoryImpl());
    private ViewBillsOrderPlaceDetails billOrdersDetailView;
    private String email = "";

    public BillController(ViewBillsOrderPlaceDetails viewBillsOrderPlaceDetails, String email) {
        this.email = email;
        this.billOrdersDetailView = viewBillsOrderPlaceDetails;
        this.billOrdersDetailView.reloadTable(filterByEmail());
        this.billOrdersDetailView.addExitListener(new ReturnHomeListener());
        this.billOrdersDetailView.addComboBoxActionListener(new FilterComboBoxListener());
        this.billOrdersDetailView.addDateFilterListener(new DateFilterListener());
        this.billOrdersDetailView.addBillTableMouseListener(new BillTableMouseClick());
    }

    public final List<Bill> filterByEmail() {
        if (email.equals(AccountContant.ADMIN)) {
            return billService.getAllBillRecords();
        }
        return billService.getAllBillByEmail(email);
    }

    void showBillsView() {
        billOrdersDetailView.setVisible(true);
    }

    private class BillTableMouseClick extends MouseAdapter {

        public BillTableMouseClick() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JTable jTable = billOrdersDetailView.getTable();
            int index = jTable.getSelectedRow();
            TableModel model = jTable.getModel();
            String id = model.getValueAt(index, 0).toString();
            OpenPdf.openById(id);
        }
    }

    private class DateFilterListener extends KeyAdapter {

        public DateFilterListener() {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            String date = billOrdersDetailView.getDate();
            boolean status = billOrdersDetailView.getOrderStatus();
            if (email.equals(AccountContant.ADMIN)) {
                if (status) {
                    billOrdersDetailView.reloadTable(billService.getAllBillRecordsByINC(date));
                } else {
                    billOrdersDetailView.reloadTable(billService.getAllBillRecordsByDESC(date));
                }
            } else {
                if (status) {
                    billOrdersDetailView.reloadTable(billService.getAllBillByEmailOrderBy(email, date));
                } else {
                    billOrdersDetailView.reloadTable(billService.getAllBillByEmailOrderByDesc(email, date));
                }
            }
        }

    }

    private class FilterComboBoxListener implements ActionListener {

        public FilterComboBoxListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Lấy ra ngày được nhập vào
            String date = billOrdersDetailView.getDate();
            //Lấy ra trạng thái muốn sắp xếp
            boolean status = billOrdersDetailView.getOrderStatus();
            //Nếu tài khoản thực hiện là admin
            if (email.equals(AccountContant.ADMIN)) {
                if (status) {
                    //Nếu trạng thái là true thì thực hiện sắp xếp tăng dần
                    billOrdersDetailView.reloadTable(billService.getAllBillRecordsByINC(date));
                } else {
                    //Ngược lại thì giảm dần
                    billOrdersDetailView.reloadTable(billService.getAllBillRecordsByDESC(date));
                }
                //Nếu tài khonar thực hiện không phải là user
            } else {
                if (status) {
                    //Chỉ lấy ra các bill do người dùng đó order
                    billOrdersDetailView.reloadTable(billService.getAllBillByEmailOrderBy(email, date));
                } else {
                    billOrdersDetailView.reloadTable(billService.getAllBillByEmailOrderByDesc(email, date));
                }
            }
        }
    }

    private class ReturnHomeListener implements ActionListener {

        public ReturnHomeListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (billOrdersDetailView != null) {
                billOrdersDetailView.setVisible(false);
            }

            Home homeView = new Home();
            HomeController homeController = new HomeController(email, homeView);
            homeController.showHomeView();
        }
    }
}
