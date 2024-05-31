package FileConnector;

import java.io.File;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
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
        usersMap.put(1, new User(1, "Le Hong Anh", "hle646698@gmail.com", "0909123456", "123 Đường ABC", "lehonganh", "Tên thú cưng của bạn?", "Miu", "true"));
        usersMap.put(2, new User(2, "Vu Thi Hong Nhung", "vthn303@gmail.com", "0909876543", "456 Đường DEF", "vuthihongnhung", "Tên trường tiểu học của bạn?", "Trường XYZ", "true"));
        usersMap.put(2, new User(2, "Nguyen Huy Hoang", "hoangnh4204gmail.com", "0909876543", "456 Đường DEF", "nguyenhuyhoang", "Tên trường tiểu học của bạn?", "Hehehe", "false"));
        usersMap.put(2, new User(2, "Khong xac dinh", "test@gmail.com", "0909876543", "456 Đường DEF", "test", "Tên trường tiểu học của bạn?", "Hehehe", "true"));
        usersMap.put(3, new User(3, "Admin","admin@gmail.com","0123456789","Ha Noi","admin123","Tên bạn là gì?","admin","true"));
        
        categoriesMap.put(1, new Category(1, "Coffee"));
        categoriesMap.put(2, new Category(2, "Tea"));
        categoriesMap.put(3, new Category(3, "Pastries"));

        productsMap.put(1, new Product(1, "Espresso", "Coffee", "50000"));
        productsMap.put(2, new Product(2, "Cappuccino", "Coffee", "60000"));
        productsMap.put(3, new Product(3, "Green Tea", "Tea", "40000"));
        productsMap.put(4, new Product(4, "Croissant", "Pastries", "30000"));
        productsMap.put(5, new Product(5, "Muffin", "Pastries", "35000"));

        generateBill(15);
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
    
    public static void generateBill(int count){
        Random random = new Random();
        String[] customerNames = {"Nguyen Van A", "Tran Thi B", "Le Van C", "Pham Thi D", "Hoang Van E"};
        String[] emails = {"nguyenvana@example.com", "tranthib@example.com", "levanc@example.com", "phamthid@example.com", "hoangvane@example.com"};
        String[] staffNames = {"lehonganh@gmail.com", "vuthihongnhung@gmail.com", "nguyenhuyhoang@gmail.com", "admin@gmail.com"};
        
        for (int i = 1; i <= count; i++) {
            String customerName = customerNames[random.nextInt(customerNames.length)];
            String phoneNumber = generatePhoneNumber();
            String email = emails[random.nextInt(emails.length)];
            String date = generateRandomDate();
            String total = String.valueOf(random.nextInt(500) * 1000 + 50000);
            String staffName = staffNames[random.nextInt(staffNames.length)];
            
            Bill bill = new Bill(i, customerName, phoneNumber, email, date, total, staffName);
            
            billsMap.put(i, bill);
        }
    }
    
    public static String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("09");
        for (int i = 0; i < 8; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }
    
    public static String generateRandomDate() {
        Random random = new Random();
        int day = random.nextInt(28) + 1;
        int month = random.nextInt(12) + 1; 
        return String.format("%02d-%02d-2024", day, month);
    }
}
