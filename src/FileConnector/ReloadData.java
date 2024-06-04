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
        usersMap.put(1, new User(1, "Le Hong Anh", "hle646698@gmail.com", "0909123456", "123 Đường ABC", "$2a$12$ltu1SBawzXTQ4bXk5PC7/.mL7pX2PQdxEGWpi2gicJl.IcxKSnMla", "Tên thú cưng của bạn?", "Miu", "true"));
        usersMap.put(2, new User(2, "Vu Thi Hong Nhung", "vthn303@gmail.com", "0909876543", "456 Đường DEF", "$2a$12$aHkM.gRvvouPj2Vm1Mrdoecp.2HCA0qLX2Hg4SMBUM.1bPtjX5pDi", "Tên trường tiểu học của bạn?", "Trường XYZ", "true"));
        usersMap.put(3, new User(3, "Nguyen Huy Hoang", "hoangnh4204gmail.com", "0909876543", "456 Đường DEF", "$2a$12$8ughpexHAojttX5RaC4FQe3QQbwrbOWVj26HKGqMmGq4nJ.VlI.wi", "Tên trường tiểu học của bạn?", "Hehehe", "true"));
        usersMap.put(4, new User(4, "Khong xac dinh", "test@gmail.com", "0909876543", "456 Đường DEF", "test", "Tên trường tiểu học của bạn?", "Hehehe", "false"));
        usersMap.put(5, new User(5, "Admin","admin@gmail.com","0123456789","Ha Noi","$2a$12$xmbnSr6Di5FN3zrFqfNz3uw/.6lMhmJ77IKoLOkUdYOSEXT9jZrFa","Tên bạn là gì?","admin","true"));
        
        categoriesMap.put(1, new Category(1, "Cà phê"));
        categoriesMap.put(2, new Category(2, "Trà"));
        categoriesMap.put(3, new Category(3, "Sinh tố"));
        categoriesMap.put(4, new Category(4, "Sữa chua"));
        categoriesMap.put(5, new Category(5, "Nước ép trái cây"));

        productsMap.put(1, new Product(1, "Cà phê đen", "Cà phê", "50000"));
        productsMap.put(2, new Product(2, "Cà phê sữa", "Cà phê", "50000"));
        productsMap.put(3, new Product(3, "Cà phê sữa", "Cà phê", "60000"));
        productsMap.put(4, new Product(4, "Cà phê đá xay pha kem", "Cà phê", "60000"));
        productsMap.put(5, new Product(5, "Cà phê xay Chocolate", "Cà phê", "60000"));
        productsMap.put(6, new Product(6, "Cà phê xay hương muối", "Cà phê", "60000"));
        productsMap.put(7, new Product(7, "Cà phê xay và Orio", "Cà phê", "60000"));
        
        productsMap.put(8, new Product(8, "Nước Kiwi lô hội", "Nước ép trái cây", "30000"));
        productsMap.put(9, new Product(9, "Nước nho lô hội", "Nước ép trái cây", "45000"));
        productsMap.put(10, new Product(10, "Nước vải lô hội", "Nước ép trái cây", "35000"));
        productsMap.put(11, new Product(11, "Nước mật ong lô hội", "Nước ép trái cây", "35000"));
        productsMap.put(12, new Product(12, "Nước chanh mặn", "Nước ép trái cây", "35000"));
        productsMap.put(13, new Product(13, "Nước chanh mật ong", "Nước ép trái cây", "35000"));
        productsMap.put(14, new Product(14, "Nước bưởi", "Nước ép trái cây", "35000"));
        productsMap.put(15, new Product(15, "Nước ép thập cẩm", "Nước ép trái cây", "45000"));
        
        productsMap.put(16, new Product(16, "Sinh tố dừa", "Sinh tố", "36000"));
        productsMap.put(17, new Product(17, "Sinh tố tắc", "Sinh tố", "36000"));
        productsMap.put(18, new Product(18, "Sinh tố thơm", "Sinh tố", "36000"));
        productsMap.put(19, new Product(19, "Sinh tố cà chua", "Sinh tố", "36000"));
        productsMap.put(20, new Product(20, "Sinh tố cà rốt", "Sinh tố", "36000"));
        productsMap.put(21, new Product(21, "Sinh tố thập cẩm", "Sinh tố", "46000"));
        
        productsMap.put(22, new Product(22, "Sữa chua trà xanh", "Sữa chua", "46000"));
        productsMap.put(23, new Product(23, "Sữa chua vị Chanh", "Sữa chua", "46000"));
        productsMap.put(24, new Product(24, "Sữa chua vị Chanh leo", "Sữa chua", "46000"));
        productsMap.put(25, new Product(25, "Sữa chua vị Bưởi", "Sữa chua", "46000"));
        productsMap.put(26, new Product(26, "Sữa chua đá xay", "Sữa chua", "46000"));
        productsMap.put(27, new Product(27, "Sữa chua Dâu", "Sữa chua", "46000"));
        productsMap.put(28, new Product(28, "Sữa chua Nho", "Sữa chua", "46000"));
        
        productsMap.put(29, new Product(29, "Hồng trà sữa", "Trà", "39000"));
        productsMap.put(30, new Product(30, "Trà sữa vị hoa nhài", "Trà", "39000"));
        productsMap.put(31, new Product(31, "Trà xanh sữa", "Trà", "39000"));
        productsMap.put(32, new Product(32, "Trà sữa Ô long", "Trà", "39000"));
        productsMap.put(33, new Product(33, "Trà sữa khoai môn", "Trà", "39000"));
        productsMap.put(34, new Product(34, "Trà sữa mật ong", "Trà", "39000"));
        productsMap.put(35, new Product(35, "Trà sữa Trân châu", "Trà", "39000"));
        productsMap.put(36, new Product(36, "Trà sữa thạch rau câu", "Trà", "39000"));
        productsMap.put(37, new Product(37, "Trà sữa thạch dừa", "Trà", "39000"));
        productsMap.put(38, new Product(38, "Trà sữa lô hội", "Trà", "39000"));
        productsMap.put(39, new Product(39, "Trà sữa Hokkaido", "Trà", "39000"));
        productsMap.put(40, new Product(40, "Trà sữa đường đen", "Trà", "39000"));
        
        
        generateBill(100);
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
    }
    
    public static void generateBill(int count){
        Random random = new Random();
        String[] customerNames = {"Nguyen Van A", "Tran Thi B", "Le Van C", "Pham Thi D", "Hoang Van E"};
        String[] emails = {"nguyenvana@example.com", "tranthib@example.com", "levanc@example.com", "phamthid@example.com", "hoangvane@example.com"};
        String[] staffNames = {"hle646698@gmail.com", "vthn303@gmail.com", "hoangnh4204gmail.com", "admin@gmail.com"};
        
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