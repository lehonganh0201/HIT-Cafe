/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import java.util.List;
import model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class CategoryServiceImplTest {
    
    public CategoryServiceImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of saveCategory method, of class CategoryServiceImpl.
     */
    @Test
    public void testSaveCategory() {
        System.out.println("saveCategory");
        Category category = null;
        CategoryServiceImpl instance = null;
        Category expResult = null;
        Category result = instance.saveCategory(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCategoryRecords method, of class CategoryServiceImpl.
     */
    @Test
    public void testGetAllCategoryRecords() {
        System.out.println("getAllCategoryRecords");
        CategoryServiceImpl instance = null;
        List<Category> expResult = null;
        List<Category> result = instance.getAllCategoryRecords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCategoryById method, of class CategoryServiceImpl.
     */
    @Test
    public void testDeleteCategoryById() {
        System.out.println("deleteCategoryById");
        Integer id = null;
        CategoryServiceImpl instance = null;
        instance.deleteCategoryById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
