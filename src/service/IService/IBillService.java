/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.IService;

import java.util.List;
import model.Bill;

/**
 *
 * @author PC
 */
public interface IBillService {
    public Bill saveBill(Bill bill);
    public List<Bill> getAllBillRecordsByINC(String date);
    public List<Bill> getAllBillRecordsByDESC(String date);
    public List<Bill> getAllBillRecords();
    public Integer getNextBillId();
    public Double calculateMonthlyRevenue(Integer month, String year);
    public List<Double> getRevenue();
    public List<Bill> getAllBillByEmail(String email);
    public List<Bill> getAllBillByEmailOrderBy(String email, String date);
    public List<Bill> getAllBillByEmailOrderByDesc(String email, String date); 
}
