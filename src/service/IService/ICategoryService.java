/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.IService;

import java.util.List;
import model.Category;

/**
 *
 * @author PC
 */
public interface ICategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAllCategoryRecords();
    public void deleteCategoryById(Integer id);
}
