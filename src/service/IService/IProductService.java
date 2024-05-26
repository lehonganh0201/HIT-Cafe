/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.IService;

import java.util.List;
import model.Product;

/**
 *
 * @author PC
 */
public interface IProductService {
    public Product saveProduct(Product product);
    public List<Product> getAllRecords();
    public Product updateProduct(Product product);
    public void deleteById(Integer id);
    public List<Product> getAllRecordsByCategory(String category);
    public List<Product> fillterProductByName(String name,String category);
    public Product getProductByName(String name);
}
