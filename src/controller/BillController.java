
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.OpenPdf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.TableModel;
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
        this.billOrdersDetailView.reloadTable(billService.getAllBillRecords());
        this.billOrdersDetailView.addExitListener(new ReturnHomeListener());
        this.billOrdersDetailView.addComboBoxActionListener(new FilterComboBoxListener());
        this.billOrdersDetailView.addDateFilterListener(new DateFilterListener());
        this.billOrdersDetailView.addBillTableMouseListener(new BillTableMouseClick());
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
            if (status) {
                billOrdersDetailView.reloadTable(billService.getAllBillRecordsByINC(date));
            } else {
                billOrdersDetailView.reloadTable(billService.getAllBillRecordsByDESC(date));
            }
        }

    }

    private class FilterComboBoxListener implements ActionListener {

        public FilterComboBoxListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean status = billOrdersDetailView.getOrderStatus();
            if (status) {
                billOrdersDetailView.reloadTable(billService.getAllBillRecordsByINC(billOrdersDetailView.getDate()));
            } else {
                billOrdersDetailView.reloadTable(billService.getAllBillRecordsByDESC(billOrdersDetailView.getDate()));
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
