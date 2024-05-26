package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import repository.UserRepositoryImpl;
import request.LoginRequest;
import request.UserRequest;
import response.UserResponse;
import service.IService.IUserService;
import service.UserServiceImpl;
import view.ForgotPassword;
import view.Home;
import view.Login;
import view.Signup;

public class AuthController {
    private final IUserService userService = new UserServiceImpl(new UserRepositoryImpl());
    private Login loginView;
    private Signup signUpView;

    public AuthController(Login login) {
        this.loginView = login;
        initLoginListeners();
    }

    public AuthController(Signup signUpView) {
        this.signUpView = signUpView;
        initSignUpListeners();
    }

    private void initLoginListeners() {
        if (loginView != null) {
            this.loginView.addLoginListener(new LoginListener());
            this.loginView.addSignUpListener(new SignUpListener());
            this.loginView.addForgotPasswordListener(new ForgotPasswordListener());
            this.loginView.addExitListener(new ExitListener());
        }
    }

    private void initSignUpListeners() {
        if (signUpView != null) {
            this.signUpView.addExitListener(new ExitListener());
            this.signUpView.addSaveListener(new SaveListener());
            this.signUpView.addLoginListener(new ShowLoginListener());
            this.signUpView.addForgotPasswordListener(new ForgotPasswordListener());
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

    private class ShowLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (signUpView != null) {
                Login login = new Login();
                AuthController authController = new AuthController(login);
                authController.showLoginView();
                signUpView.setVisible(false);
            }
        }
    }

    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (signUpView != null) {
                UserRequest request = signUpView.getUserRequest();
                userService.save(request);
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
            ForgotPassword forgotPassword = new ForgotPassword();
            UserController userController = new UserController(forgotPassword);
            userController.showForgotPassword();

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
                LoginRequest request = loginView.getLoginRequest();
                UserResponse user = userService.login(request);

                if (user == null) {
                    JOptionPane.showMessageDialog(null, "<html><b style=\"color: red\">Incorrect Username or Password</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (user.getStatus().equals("false")) {
                        ImageIcon icon = new ImageIcon("src/popupicon/wait.png");
                        JOptionPane.showMessageDialog(null, "<html><b>Wait for Admin Approval</b></html>", "Message", JOptionPane.INFORMATION_MESSAGE, icon);
                        loginView.clear();
                    } else if (user.getStatus().equals("true")) {
                        loginView.setVisible(false);
                        Home homeView = new Home();
                        HomeController homeController = new HomeController(user.getEmail(), homeView);
                        homeController.showHomeView();
                    }
                }
            }
        }
    }
}
