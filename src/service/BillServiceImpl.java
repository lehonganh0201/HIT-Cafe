/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import model.Bill;
import repository.IRepository.IBillRepository;
import service.IService.IBillService;

/**
 *
 * @author PC
 */
public class BillServiceImpl implements IBillService {

    private final IBillRepository billRepository;

    public BillServiceImpl(IBillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBillRecordsByINC(String date) {
        List<Bill> list = billRepository.findByDate(date);
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        return list;
    }

    @Override
    public List<Bill> getAllBillRecordsByDESC(String date) {
        List<Bill> list = billRepository.findByDateOrderByIdDesc(date);
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        return list;
    }

    @Override
    public List<Bill> getAllBillRecords() {
        return billRepository.findAll();
    }

    @Override
    public Integer getNextBillId() {
        return billRepository.findAll().size() + 1;
    }

    @Override
    public Double calculateMonthlyRevenue(Integer month, String year) {
        String formattedMonth = String.format("%02d", month);

        return getAllBillRecords().stream()
                .filter(bill -> {
                    String billDate = bill.getDate();
                    return billDate.length() >= 10
                            && billDate.substring(3, 5).equals(formattedMonth)
                            && billDate.substring(6, 10).equals(year);
                })
                .mapToDouble(bill -> {
                    try {
                        return Double.parseDouble(bill.getTotal());
                    } catch (NumberFormatException e) {
                        return 0.0;
                    }catch(Exception e){
                        return 0.0;
                    }
                })
                .sum();
    }

    @Override
    public List<Double> getRevenue() {
        String year = Year.now().toString();
        List<Double> list = new ArrayList<>();
        for(int i = 1;i<=12;i++){
            list.add(calculateMonthlyRevenue(i, year));
        }
        return list;
    }
}