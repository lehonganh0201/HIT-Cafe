package FileConnector;

import java.io.File;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import model.Bill;
import model.Category;
import model.Product;
import model.User;

public class ReloadData implements Serializable {
    private static final long serialVersionUID = 1L;

    static Map<Integer, Bill> billsMap = new LinkedHashMap<>();
    static Map<Integer, Category> categoriesMap = new LinkedHashMap<>();
    static Map<Integer, Product> productsMap = new LinkedHashMap<>();
    static Map<Integer, User> usersMap = new LinkedHashMap<>();

    public static void fakeData() {
        usersMap.put(1, new User(1, "Nguyen Van A", "nguyenvana@gmail.com", "0909123456", "123 Đường ABC", "password123", "Tên thú cưng của bạn?", "Miu", "false"));
        usersMap.put(2, new User(2, "Tran Thi B", "tranthib@gmail.com", "0909876543", "456 Đường DEF", "password456", "Tên trường tiểu học của bạn?", "Trường XYZ", "true"));
        usersMap.put(3, new User(3, "Admin","admin@gmail.com","0123456789","Ha Noi","admin123","Tên bạn là gì?","admin","true"));
        
        categoriesMap.put(1, new Category(1, "Coffee"));
        categoriesMap.put(2, new Category(2, "Tea"));
        categoriesMap.put(3, new Category(3, "Pastries"));

        productsMap.put(1, new Product(1, "Espresso", "Coffee", "50000"));
        productsMap.put(2, new Product(2, "Cappuccino", "Coffee", "60000"));
        productsMap.put(3, new Product(3, "Green Tea", "Tea", "40000"));
        productsMap.put(4, new Product(4, "Croissant", "Pastries", "30000"));
        productsMap.put(5, new Product(5, "Muffin", "Pastries", "35000"));

        billsMap.put(1, new Bill(1, "Nguyen Van A", "0909123456", "nguyenvana@example.com", "2023-05-01", "85000", "Nguyen Van A"));
        billsMap.put(2, new Bill(2, "Tran Thi B", "0909876543", "tranthib@example.com", "2023-05-02", "75000", "Tran Thi B"));
    }

    public static void main(String[] args) {
        fakeData();
        FileEngine fileEngine = new FileEngine();

        File billFile = new File("./Bills.dat");
        File categoryFile = new File("./Categories.dat");
        File productFile = new File("./Products.dat");
        File userFile = new File("./Users.dat");

        fileEngine.writeToFile(billsMap, billFile);
        fileEngine.writeToFile(categoriesMap, categoryFile);
        fileEngine.writeToFile(productsMap, productFile);
        fileEngine.writeToFile(usersMap, userFile);

        Map<Integer, Bill> loadedBillsMap = (Map<Integer, Bill>) fileEngine.readFile(billFile);
        Map<Integer, Category> loadedCategoriesMap = (Map<Integer, Category>) fileEngine.readFile(categoryFile);
        Map<Integer, Product> loadedProductsMap = (Map<Integer, Product>) fileEngine.readFile(productFile);
        Map<Integer, User> loadedUsersMap = (Map<Integer, User>) fileEngine.readFile(userFile);

        System.out.println("Loaded Bills: " + loadedBillsMap);
        System.out.println("Loaded Categories: " + loadedCategoriesMap);
        System.out.println("Loaded Products: " + loadedProductsMap);
        System.out.println("Loaded Users: " + loadedUsersMap);
    }
}
