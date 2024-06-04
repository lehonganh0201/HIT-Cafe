package service;

import FileConnector.ReloadData;
import java.util.List;
import model.Category;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repository.CategoryRepositoryImpl;
import repository.IRepository.ICategoryRepository;
import service.IService.ICategoryService;

public class CategoryServiceImplTest {
    private final ICategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private final ICategoryService instance = new CategoryServiceImpl(categoryRepository);

    public CategoryServiceImplTest() {
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
        categoryRepository.clear();

        instance.saveCategory(new Category(1, "Espresso"));
        instance.saveCategory(new Category(2, "Latte"));
        instance.saveCategory(new Category(3, "Cappuccino"));
        instance.saveCategory(new Category(4, "Americano"));
        instance.saveCategory(new Category(5, "Mocha"));
        instance.saveCategory(new Category(6, "Macchiato"));
        instance.saveCategory(new Category(7, "Flat White"));
        instance.saveCategory(new Category(8, "Affogato"));
        instance.saveCategory(new Category(9, "Cortado"));
        instance.saveCategory(new Category(10, "Irish Coffee"));
    }

    @After
    public void tearDown() {
        System.out.println("After - Cleanup after each test");
        categoryRepository.clear();
    }

    @Test
    public void testSaveCategory() {
        System.out.println("saveCategory");
        Category category = new Category(11, "Cafe");
        Category result = instance.saveCategory(category);
        assertNotNull(result);
        assertEquals(11, result.getId());
        assertEquals("Cafe", result.getName());
    }

    @Test
    public void testGetAllCategoryRecords() {
        System.out.println("getAllCategoryRecords");
        List<Category> result = instance.getAllCategoryRecords();
        assertEquals(10, result.size());

        String[] expectedNames = {
            "Espresso", "Latte", "Cappuccino", "Americano", "Mocha",
            "Macchiato", "Flat White", "Affogato", "Cortado", "Irish Coffee"
        };

        for (int i = 0; i < 10; i++) {
            assertEquals(expectedNames[i], result.get(i).getName());
        }
    }

    @Test
    public void testDeleteCategoryById() {
        System.out.println("deleteCategoryById");
        Integer id = 1;
        instance.deleteCategoryById(id);
        List<Category> result = instance.getAllCategoryRecords();
        assertEquals(9, result.size());
        assertFalse(result.stream().anyMatch(c -> c.getId() == 1));
    }
}
