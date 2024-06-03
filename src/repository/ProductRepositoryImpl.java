/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import FileConnector.FileEngine;
import java.io.File;
import java.util.List;
import java.util.Map;
import model.Product;
import repository.IRepository.IProductRepository;

/**
 *
 * @author PC
 */
public class ProductRepositoryImpl implements IProductRepository{
    private final File file = new File("./Products.dat");
    private final FileEngine engine = new FileEngine();
    private Map<Integer, Product> map;

    public ProductRepositoryImpl() {
        map = (Map<Integer, Product>) engine.readFile(file);
    }
    
    @Override
    public Product save(Product product) {
        product.setId(map.size() + 1);
        map.put(product.getId(), product);
        reloadFile();
        return map.get(product.getId());
    }

    @Override
    public List<Product> findAllProduct() {
        return map.values().stream().toList();
    }

    @Override
    public Product update(Product product) {
        map.replace(product.getId(), product);
        reloadFile();
        return map.get(product.getId());
    }

    @Override
    public void deleteById(Integer id) {
        map.remove(id);
        reloadFile();
    }

    @Override
    public List<Product> findAllByCategory(String category) {
        return map.values().stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @Override
    public List<Product> findAllByCategoryAndName(String name, String category) {
       return map.values().stream()
               .filter(product -> product.getName().contains(name) && product.getCategory().equalsIgnoreCase(category))
               .toList();
    }

    @Override
    public Product findByName(String name) {
        return map.values().stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
    
     private void reloadFile() {
        engine.writeToFile(map, file);
        map.clear();
        map = (Map<Integer, Product>) engine.readFile(file);
    }

    @Override
    public void clear() {
        map.clear();
        reloadFile();
    }
}
