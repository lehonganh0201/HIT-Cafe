/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.IRepository;

import java.util.List;
import java.util.Map;
import model.Bill;

/**
 *
 * @author PC
 */
public interface IBillRepository {
    public Bill save(Bill bill);
    public List<Bill> findAll();
    public List<Bill> findByDate(String date);
    public List<Bill> findByDateOrderByIdDesc(String date);
}
