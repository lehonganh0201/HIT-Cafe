/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.IRepository;

import java.util.List;
import model.Product;

/**
 *
 * @author PC
 */
public interface IProductRepository {
    public Product save(Product product);
    public List<Product> findAllProduct();
    public Product update(Product product);
    public void deleteById(Integer id);
    public List<Product> findAllByCategory(String category);
    public List<Product> findAllByCategoryAndName(String name,String category);
    public Product findByName(String name);
    public void clear();
}
