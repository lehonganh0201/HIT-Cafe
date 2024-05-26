/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import FileConnector.FileEngine;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import model.Bill;
import repository.IRepository.IBillRepository;

/**
 *
 * @author PC
 */
public class BillRepositoryImpl implements IBillRepository{
    private final File file = new File("./Bills.dat");
    private final FileEngine engine = new FileEngine();
    private Map<Integer,Bill> map;

    public BillRepositoryImpl() {
        map = (Map<Integer, Bill>) engine.readFile(file);
    }

    @Override
    public Bill save(Bill bill) {
        bill.setId(map.size() + 1);
       map.put(bill.getId(), bill);
       reloadFile();
       return map.get(bill.getId());
    }

    @Override
    public List<Bill> findByDate(String date) {
        return map.values().stream()
                .filter(bill -> bill.getDate().contains(date))
                .toList();
    }

    @Override
    public List<Bill> findByDateOrderByIdDesc(String date) {
       return map.values().stream()
               .sorted(Comparator.comparingInt(Bill::getId)
                       .reversed())
               .filter(bill -> bill.getDate().contains(date))
               .toList();
    }

    private void reloadFile() {
        engine.writeToFile(map, file);
        map.clear();
        map = (Map<Integer, Bill>) engine.readFile(file);
    }

    @Override
    public List<Bill> findAll() {
        return map.values().stream().toList();
    }
}
