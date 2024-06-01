/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import exception.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import repository.IRepository.IProductRepository;
import service.IService.IProductService;

/**
 *
 * @author PC
 */
public class ProductServiceImpl implements IProductService{
    private final IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product request) {
        return productRepository.save(request);
    }

    @Override
    public List<Product> getAllRecords() {
        List<Product> products = productRepository.findAllProduct();
        if(products.isEmpty()){
            return new ArrayList<>();
        }
        return products;
    }

    @Override
    public Product updateProduct(Product request) {
        return productRepository.update(request);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllRecordsByCategory(String category) {
       List<Product> list = productRepository.findAllByCategory(category);
       if(list.isEmpty()){
           return new ArrayList<>();
       }
       return list;
    }

    @Override
    public List<Product> fillterProductByName(String name, String category) {
       List<Product> list = productRepository.findAllByCategoryAndName(name, category);
       if(list.isEmpty()){
           return new ArrayList<>();
       }
       return list;
    }

    @Override
    public Product getProductByName(String name) {
        Product pd = productRepository.findByName(name);
        if(pd!=null){
            return pd;
        }
        throw new NotFoundException("Cannot found any product with " + name);
    }
}