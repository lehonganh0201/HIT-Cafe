/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import java.util.List;
import model.Product;
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
public class ProductServiceImplTest {
    
    public ProductServiceImplTest() {
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
     * Test of saveProduct method, of class ProductServiceImpl.
     */
    @Test
    public void testSaveProduct() {
        System.out.println("saveProduct");
        Product request = null;
        ProductServiceImpl instance = null;
        Product expResult = null;
        Product result = instance.saveProduct(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecords method, of class ProductServiceImpl.
     */
    @Test
    public void testGetAllRecords() {
        System.out.println("getAllRecords");
        ProductServiceImpl instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.getAllRecords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProduct method, of class ProductServiceImpl.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        Product request = null;
        ProductServiceImpl instance = null;
        Product expResult = null;
        Product result = instance.updateProduct(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteById method, of class ProductServiceImpl.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Integer id = null;
        ProductServiceImpl instance = null;
        instance.deleteById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecordsByCategory method, of class ProductServiceImpl.
     */
    @Test
    public void testGetAllRecordsByCategory() {
        System.out.println("getAllRecordsByCategory");
        String category = "";
        ProductServiceImpl instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.getAllRecordsByCategory(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillterProductByName method, of class ProductServiceImpl.
     */
    @Test
    public void testFillterProductByName() {
        System.out.println("fillterProductByName");
        String name = "";
        String category = "";
        ProductServiceImpl instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.fillterProductByName(name, category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductByName method, of class ProductServiceImpl.
     */
    @Test
    public void testGetProductByName() {
        System.out.println("getProductByName");
        String name = "";
        ProductServiceImpl instance = null;
        Product expResult = null;
        Product result = instance.getProductByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
