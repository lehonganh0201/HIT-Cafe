package controller;

import common.SendMail;
import exception.ExistUserException;
import exception.NotFoundUserException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.User;
import repository.UserRepositoryImpl;
import request.LoginRequest;
import request.UserRequest;
import response.UserResponse;
import service.IService.IUserService;
import service.UserServiceImpl;
import view.ForgotPassword;
import view.Home;
import view.IntermediateView;
import view.Login;
import view.MailPassword;
import view.Signup;

public class AuthController {

    private final IUserService userService = new UserServiceImpl(new UserRepositoryImpl());
    private Login loginView;
    private IntermediateView intermediateView;
    private Signup signUpView;
    private String otp = "";

    public AuthController(Login login) {
        this.loginView = login;
        initLoginListeners();
    }

    public AuthController(Signup signUpView) {
        this.signUpView = signUpView;
        initSignUpListeners();
    }

    public AuthController(IntermediateView intermediateView) {
        this.intermediateView = intermediateView;
        initIntermediateListeners();
    }

    private void initLoginListeners() {
        if (loginView != null) {
            //Lắng nghe các sự kiện khi thực hiện
            //đăng nhập, chuyển sang màn hình đăng ký, quên mật khẩu hoặc thoát chương trình
            this.loginView.addLoginListener(new LoginListener());
            this.loginView.addSignUpListener(new SignUpListener());
            this.loginView.addForgotPasswordListener(new ForgotPasswordListener());
            this.loginView.addExitListener(new ExitListener());
        }
    }

    private void initSignUpListeners() {
        if (signUpView != null) {
            //Lắng nghe các sự kiện như thoát chương trình, chuyển màn hình sang login hoặc quên mật khẩu,
            //gửi mã otp và lưu tài khoản
            this.signUpView.addExitListener(new ExitListener());
            this.signUpView.addSaveListener(new SaveListener());
            this.signUpView.addLoginListener(new ShowLoginListener());
            this.signUpView.addForgotPasswordListener(new ForgotPasswordListener());
            this.signUpView.addSendListener(new SendMailListener());
        }
    }

    public void showSignUpView() {
        if (signUpView != null) {
            signUpView.setVisible(true);
        }
    }

    public void showLoginView() {
        if (loginView != null) {
            loginView.setVisible(true);
        }
    }

    public void showIntermediateView() {
        if (intermediateView != null) {
            intermediateView.setVisible(true);
        }
    }

    public static String generateRandomNumbers(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }

    private void initIntermediateListeners() {
        if (intermediateView != null) {
            intermediateView.addBackLoginListener(new ShowLoginListener());
            intermediateView.addQuestionListener(new ForgotQuestionListener());
            intermediateView.addMailListener(new MailOTPListener());
        }
    }

    private class SendMailListener implements ActionListener {

        public SendMailListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            User user = userService.getUserByEmail(signUpView.getEmail());
            if (user != null) {
                JOptionPane.showMessageDialog(null, "<html><b style=\"color:red\">Your account already existing</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
            } else {
                String confirmCode = generateRandomNumbers(6);
                otp = confirmCode;
                SendMail send = new SendMail(signUpView.getEmail());
                send.setOtp(confirmCode);
                send.sendMail(signUpView.getEmail());
                
                signUpView.getTxtEmail().setEnabled(false);
            }

        }
    }

    private class ForgotQuestionListener implements ActionListener {

        public ForgotQuestionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ForgotPassword forgotPassword = new ForgotPassword();
            UserController userController = new UserController(forgotPassword);
            userController.showForgotPassword();
            if (intermediateView != null) {
                intermediateView.setVisible(false);
            }
        }
    }

    private class MailOTPListener implements ActionListener {

        public MailOTPListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MailPassword forgotPassword = new MailPassword();
            UserController userController = new UserController(forgotPassword);
            userController.showMailPassword();
            if (intermediateView != null) {
                intermediateView.setVisible(false);
            }
        }
    }

    private class ShowLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Login login = new Login();
            AuthController authController = new AuthController(login);
            authController.showLoginView();
            if (signUpView != null) {
                signUpView.setVisible(false);
            }
            if (intermediateView != null) {
                intermediateView.setVisible(false);
            }
        }
    }

    private class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (signUpView != null) {
                // Lấy mã Otp được người dùng nhập vào và so sánh với mã được gen ra
                if (signUpView.getOtp().equals(otp)) {
                    try {
                        //Lấy request từ phía client
                        UserRequest request = signUpView.getUserRequest();
                        //Thực hiện lưu trữ dữ liệu
                        userService.save(request);
                        signUpView.clear();
                        //Thông báo thành công
                        JOptionPane.showMessageDialog(null, "<html><b style=\"color: green\">Registration successfully!</b></html>", "Message", JOptionPane.DEFAULT_OPTION);
                    } catch (ExistUserException ex) {
                        //Bắt lỗi người dùng với email đã tồn tại
                        JOptionPane.showMessageDialog(null, "<html><b style=\"color: red\">" + ex.getMessage() + "</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        //Bắt lỗi chưa xác định
                        JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    //Gửi thông báo đến Client xem mã otp được nhập vào có đúng không?
                    JOptionPane.showMessageDialog(null, "<html><b style=\"color: red\">Your one-time Password not correct</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }

    private class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(null, "Do you really want to close the application?", "Select", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    private class SignUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (loginView != null) {
                loginView.setVisible(false);
                Signup signUpView = new Signup();
                AuthController auth = new AuthController(signUpView);
                auth.showSignUpView();
            }
        }
    }

    private class ForgotPasswordListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            IntermediateView intermediateView = new IntermediateView();
            AuthController authController = new AuthController(intermediateView);
            authController.showIntermediateView();

            if (loginView != null) {
                loginView.setVisible(false);
            }
            if (signUpView != null) {
                signUpView.setVisible(false);
            }
        }
    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (loginView != null) {
                try {
                    //Lấy request được nhập từ màn hình
                    LoginRequest request = loginView.getLoginRequest();
                    //Thực hiện đăng nhập cho người dùng
                    UserResponse user = userService.login(request);

                    if (user != null) {
                        //Kiểm tra xem user có được phân quyền truy cập không?
                        if (user.getStatus().equals("false")) {
                            ImageIcon icon = new ImageIcon("src/popupicon/wait.png");
                            //Thông báo đến cho người dùng nếu đăng nhập không thành công
                            JOptionPane.showMessageDialog(null, "<html><b>Wait for Admin Approval</b></html>", "Message", JOptionPane.INFORMATION_MESSAGE, icon);
                            loginView.clear();
                        } else if (user.getStatus().equals("true")) {
                            //Chuyển đổi người dùng đăng nhập thành công sang màn hình home
                            loginView.setVisible(false);
                            Home homeView = new Home();
                            HomeController homeController = new HomeController(user.getEmail(), homeView);
                            homeController.showHomeView();
                        }
                    }
                    //Bắt lỗi nếu không tìm được người dùng với request nhận vào
                } catch (NotFoundUserException ex) {
                    JOptionPane.showMessageDialog(null, "<html><b style=\"color: red\">Incorrect Username or Password</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    //Bắt các lỗi chưa xác định
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
