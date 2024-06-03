/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import repository.IRepository.ICategoryRepository;
import service.IService.ICategoryService;

/**
 *
 * @author PC
 */
public class CategoryServiceImpl implements ICategoryService{
    private final ICategoryRepository categoryRepository;

    
    public CategoryServiceImpl(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategoryRecords() {
        List<Category> categorys = categoryRepository.findAllCategory();
        if(categorys.isEmpty()){
            return new ArrayList<>();
        }
        return categorys;
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }
}