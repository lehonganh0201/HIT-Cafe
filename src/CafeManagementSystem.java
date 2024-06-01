
import controller.AuthController;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Login;

public class CafeManagementSystem {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try{
                String classname = UIManager.getSystemLookAndFeelClassName();
                UIManager.setLookAndFeel(classname);
            }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
                System.out.println(e);
            }
            
            Login loginView = new Login();
            AuthController authController = new AuthController(loginView);
            authController.showLoginView();
        });
    }
}
