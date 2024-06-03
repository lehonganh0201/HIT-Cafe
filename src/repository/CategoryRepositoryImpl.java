/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import FileConnector.FileEngine;
import java.io.File;
import java.util.List;
import java.util.Map;
import model.Category;
import repository.IRepository.ICategoryRepository;

/**
 *
 * @author PC
 */
public class CategoryRepositoryImpl implements ICategoryRepository{
    private final File file = new File("./Categories.dat");
    private final FileEngine engine = new FileEngine();
    private Map<Integer,Category> map;

    public CategoryRepositoryImpl() {
        map = (Map<Integer, Category>) engine.readFile(file);
    }
    
    @Override
    public Category save(Category category) {
        category.setId(map.size() + 1);
        map.put(category.getId(), category);
        reloadFile();
        return map.get(category.getId());
    }

    @Override
    public List<Category> findAllCategory() {
       return map.values().stream().toList();
    }

    @Override
    public void deleteById(Integer id) {
        map.remove(id);
        reloadFile();
    }

    private void reloadFile() {
        engine.writeToFile(map, file);
        map.clear();
        map = (Map<Integer, Category>) engine.readFile(file);
    }

    @Override
    public void clear() {
        map.clear();
        reloadFile();
    }
}
