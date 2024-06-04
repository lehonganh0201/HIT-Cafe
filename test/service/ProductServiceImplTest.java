package service;

import FileConnector.ReloadData;
import java.util.List;
import model.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repository.IRepository.IProductRepository;
import repository.ProductRepositoryImpl;
import service.IService.IProductService;

public class ProductServiceImplTest {
    private final IProductRepository productRepository = new ProductRepositoryImpl();
    private final IProductService instance = new ProductServiceImpl(productRepository);
    
    public ProductServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass - Setup for all tests");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("AfterClass - Cleanup after all tests");
        ReloadData.main(null);
    }
    
    @Before
    public void setUp() {
        System.out.println("Before - Setup for each test");
        productRepository.clear();
        
        instance.saveProduct(new Product(1, "Espresso", "Coffee", "$2.50"));
        instance.saveProduct(new Product(2, "Latte", "Coffee", "$3.50"));
        instance.saveProduct(new Product(3, "Cappuccino", "Coffee", "$3.00"));
        instance.saveProduct(new Product(4, "Americano", "Coffee", "$2.00"));
        instance.saveProduct(new Product(5, "Mocha", "Coffee", "$4.00"));
        instance.saveProduct(new Product(6, "Macchiato", "Coffee", "$3.00"));
        instance.saveProduct(new Product(7, "Flat White", "Coffee", "$3.50"));
        instance.saveProduct(new Product(8, "Affogato", "Coffee", "$5.00"));
        instance.saveProduct(new Product(9, "Cortado", "Coffee", "$3.50"));
        instance.saveProduct(new Product(10, "Irish Coffee", "Coffee", "$6.00"));
    }
    
    @After
    public void tearDown() {
        System.out.println("After - Cleanup after each test");
        productRepository.clear();
    }

    @Test
    public void testSaveProduct() {
        System.out.println("saveProduct");
        Product request = new Product(11, "Coffee", "Coffee", "$10.00");
        Product expResult = new Product(11, "Coffee", "Coffee", "$10.00");
        Product result = instance.saveProduct(request);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getCategory(), result.getCategory());
        assertEquals(expResult.getPrice(), result.getPrice());
    }

    @Test
    public void testGetAllRecords() {
        System.out.println("getAllRecords");
        List<Product> expResult = productRepository.findAllProduct();
        List<Product> result = instance.getAllRecords();
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        Product request = new Product(1, "Updated Espresso", "Coffee", "$3.00");
        Product expResult = request;
        Product result = instance.updateProduct(request);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getCategory(), result.getCategory());
        assertEquals(expResult.getPrice(), result.getPrice());
    }

    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Integer id = 1;
        instance.deleteById(id);
        assertNull(instance.getAllRecords().stream().filter(product -> product.getId() == id).findFirst().orElse(null));
    }

    @Test
    public void testGetAllRecordsByCategory() {
        System.out.println("getAllRecordsByCategory");
        String category = "Coffee";
        List<Product> expResult = productRepository.findAllByCategory(category);
        List<Product> result = instance.getAllRecordsByCategory(category);
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult, result);
    }

    @Test
    public void testFillterProductByName() {
        System.out.println("fillterProductByName");
        String name = "Espresso";
        String category = "Coffee";
        List<Product> expResult = productRepository.findAllByCategoryAndName(name, category);
        List<Product> result = instance.fillterProductByName(name, category);
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult, result);
    }

    @Test
    public void testGetProductByName() {
        System.out.println("getProductByName");
        String name = "Espresso";
        Product expResult = new Product("Espresso", "Coffee", "$2.50");
        Product result = instance.getProductByName(name);
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getCategory(), result.getCategory());
        assertEquals(expResult.getPrice(), result.getPrice());
    }
}
