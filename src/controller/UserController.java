/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.User;
import repository.UserRepositoryImpl;
import response.UserResponse;
import service.IService.IUserService;
import service.UserServiceImpl;
import view.ChangePassword;
import view.ChangeSecurityQuestion;
import view.ForgotPassword;
import view.Home;
import view.Login;
import view.Signup;
import view.VetifyUsers;

/**
 *
 * @author PC
 */
public class UserController {
    private final IUserService userService = new UserServiceImpl(new UserRepositoryImpl());
    private VetifyUsers vetiryUsersView;
    private ChangePassword changePasswordView;
    private ChangeSecurityQuestion changeSecurityQuestionView;
    private ForgotPassword forgotPassword;
    private String accountAnswer = "";
    private String email = "";

    public UserController(ForgotPassword forgotPassword) {
        this.forgotPassword = forgotPassword;
        this.forgotPassword.addExitListener(new ExitListener());
        this.forgotPassword.addSearchListener(new SearchListener());
        this.forgotPassword.addUpdatedListener(new UpdatedListener());
        this.forgotPassword.addLoginListener(new LoginListener());
        this.forgotPassword.addSignUpListener(new SignUpListener());
    }

    public UserController(VetifyUsers vetiryUsersView, String email) {
        this.email = email;
        this.vetiryUsersView = vetiryUsersView;
        this.vetiryUsersView.reloadTable(userService.getAllUsersExceptAdmin());
        this.vetiryUsersView.addUserTableMouseListener(new UserTableMouseListener());
        this.vetiryUsersView.addEmailKeyListener(new EmailKeyListener());
        this.vetiryUsersView.addExitListener(new ReturnHomeListener());
    }

    public UserController(ChangePassword changePasswordView, String email) {
        this.email = email;
        this.changePasswordView = changePasswordView;
        this.changePasswordView.addUpdateListener(new UpdatedPasswordListener());
        this.changePasswordView.addExitListener(new ReturnHomeListener());
    }

    public UserController(ChangeSecurityQuestion changeSecurityQuestionView, String email) {
        this.email = email;
        this.changeSecurityQuestionView = changeSecurityQuestionView;
        User user = userService.getUserByEmail(email);
        this.changeSecurityQuestionView.setOldPasswordText(user.getSecurityQuestion());
        this.changeSecurityQuestionView.addExitListener(new ReturnHomeListener());
        this.changeSecurityQuestionView.addUpdatedSecurityQuest(new UpdatedSecurity());
    }

    public void showForgotPassword() {
        forgotPassword.setVisible(true);
    }

    public void showVetifyPage() {
        vetiryUsersView.setVisible(true);
    }

    public void showChangePasswordView() {
        changePasswordView.setVisible(true);
    }

    public void showChangeQuestionView() {
        changeSecurityQuestionView.setVisible(true);
    }

    private class UpdatedSecurity implements ActionListener {

        public UpdatedSecurity() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String password = changeSecurityQuestionView.getPassword();
            String question = changeSecurityQuestionView.getSecurityQuest();
            String answer = changeSecurityQuestionView.getNewAnswer();
            userService.changeSecurityQuestion(email,password , question, answer);
            changeSecurityQuestionView.clear();
        }
    }

    private class UpdatedPasswordListener implements ActionListener {

        public UpdatedPasswordListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String oldPassword = changePasswordView.getOldPassword();
            User user = userService.getUserByEmail(email);
            if(user!=null){
                if(!user.getPassword().equals(oldPassword)){
                    JOptionPane.showMessageDialog(null, "<html><b style=\"color:red\">Your old password not correct</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String newPassword = changePasswordView.getNewPassword();
                    userService.changePassword(email, oldPassword, newPassword);
                    changePasswordView.clear();
                }
            }
        }
    }

    private class ReturnHomeListener implements ActionListener {

        public ReturnHomeListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           if(vetiryUsersView != null){
               vetiryUsersView.setVisible(false);
           }
           if(changePasswordView != null){
               changePasswordView.setVisible(false);
           }
           if(changeSecurityQuestionView != null){
               changeSecurityQuestionView.setVisible(false);
           }
           Home homeView = new Home();
           HomeController homeController = new HomeController(email, homeView);
           homeController.showHomeView();
        }
    }

    private class EmailKeyListener extends KeyAdapter {

        public EmailKeyListener() {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            String email = vetiryUsersView.getEmail();
            List<UserResponse> usersData = userService
                    .getAllUsersExceptAdmin().stream()
                    .filter(user -> user.getEmail().contains(email))
                    .toList();
            
            vetiryUsersView.reloadTable(usersData);
        }
        
        
    }

    private class UserTableMouseListener extends MouseAdapter {

        public UserTableMouseListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int index = vetiryUsersView.getUserTable().getSelectedRow();
            TableModel model = vetiryUsersView.getUserTable().getModel();
            String email = model.getValueAt(index, 2).toString();
            String status = model.getValueAt(index, 6).toString();

            if (status.equals("true")) {
                status = "false";
            } else {
                status = "true";
            }

            int a = JOptionPane.showConfirmDialog(null, "Do you want to change status of " + email + "?");
            if (a == JOptionPane.YES_OPTION) {
                userService.changeStatus(email, status); 
                vetiryUsersView.reloadTable(userService.getAllUsersExceptAdmin());
            }
        }
    }

    private class LoginListener implements ActionListener {

        public LoginListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            forgotPassword.setVisible(false);
            Login loginView = new Login();
            AuthController auth = new AuthController(loginView);
            auth.showLoginView();
        }
    }

    private class SignUpListener implements ActionListener {

        public SignUpListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            forgotPassword.setVisible(false);
            Signup signUpV = new Signup();
            AuthController auth = new AuthController(signUpV);
            auth.showSignUpView();
        }
    }

    private class UpdatedListener implements ActionListener {

        public UpdatedListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           String answer = forgotPassword.getAnswer();
           String newPassword = forgotPassword.getNewPassword();
           if(answer.equals(accountAnswer)){
               userService.update(forgotPassword.getEmail(), newPassword);
               JOptionPane.showMessageDialog(null, "<html><b style=\"color:green\">Change password successfully!</b></html>", "Message", JOptionPane.INFORMATION_MESSAGE);
           }else{
               JOptionPane.showMessageDialog(null, "<html><b style=\"color:red\">Incorrect Answer</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
           }
        }
    }

    private class SearchListener implements ActionListener {

        public SearchListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            User theUser = userService.getUserByEmail(forgotPassword.getEmail());
            if(theUser == null){
                JOptionPane.showMessageDialog(null, "<html><b style=\"color:red\">Incorrect Email</b></html>", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else{
                forgotPassword.getBtnSearch().setEnabled(false);
                forgotPassword.getTxtEmail().setEnabled(false);
                accountAnswer = theUser.getAnswer();
                forgotPassword.getTxtSeQue().setText(theUser.getSecurityQuestion());
            }
        }
    }

    private class ExitListener implements ActionListener {

        public ExitListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int a = JOptionPane.showConfirmDialog(null, "Do you really want to close Application?", "Select", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                System.exit(0);
            }
        }
    }
}