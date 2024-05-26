/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.IRepository;

import java.util.List;
import model.Category;

/**
 *
 * @author PC
 */
public interface ICategoryRepository {
    public Category save(Category category);
    public List<Category> findAllCategory();
    public void deleteById(Integer id);
}
