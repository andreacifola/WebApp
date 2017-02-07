package view;

import controller.language.LanguageController;
import controller.login.LoginController;
import controller.torVergataRent.TorVergataRentController;
import model.User;
import model.language.login.LoginLanguage;
import model.payment.IBANCredentialNotValid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    private JPanel panelMain;
    private JButton jButton_englishLanguage;
    private JButton jButton_italianLanguage;
    private JLabel jLabel_Login;
    private JTextField jTextField_Username;
    private JPasswordField jPasswordField_Password;
    private JButton jButton_Register;
    private JButton jButton_signin;
    private JButton jButton_search;
    private JLabel jLabel_Username;
    private JLabel jLabel_Password;
    private JLabel jTextLabel_unregisteredSearch;
    private JFrame frame = null;

    public Login(JFrame frame) {

        LanguageController.setItalianLanguage();
        setLabelTextLanguageLogin();
        jButton_italianLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setItalianLanguage();
                setLabelTextLanguageLogin();
            }
        });

        jButton_englishLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setEnglishLanguage();
                setLabelTextLanguageLogin();

            }
        });
        jButton_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TorVergataRentController tvrc = new TorVergataRentController(null);

            }
        });
        jButton_Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setVisible(false);
                frame.dispose();
                JFrame frame = new JFrame();
                frame.setContentPane(new RegistrationForm(frame).getPanelMain());
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);


            }
        });
        jButton_signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    User loggedUser = LoginController.LoginController(jTextField_Username.getText().trim(),
                            String.valueOf(jPasswordField_Password.getPassword()));
                    if (loggedUser != null){
                        frame.setVisible(false);
                        frame.dispose();
                       new TorVergataRentController(loggedUser);
                    }
                    else{
                        JOptionPane.showMessageDialog(new Frame(), LoginLanguage.login_invalidCredential);
                    }
                } catch (IBANCredentialNotValid ibanCredentialNotValid) {
                    ibanCredentialNotValid.printStackTrace();
                }
            }
        });
    }

    public static void main (String[] args){
        JFrame frame = new JFrame();
        frame.setContentPane(new Login(frame).getPanelMain());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void setLabelTextLanguageLogin(){
        jLabel_Login.setText(LoginLanguage.login_login);
        jLabel_Password.setText(LoginLanguage.login_password);
        jLabel_Username.setText(LoginLanguage.login_username);
        jButton_Register.setText(LoginLanguage.login_registered);
        jButton_search.setText(LoginLanguage.login_search);
        jButton_signin.setText(LoginLanguage.login_signin);
        jTextLabel_unregisteredSearch.setText(LoginLanguage.login_unregisteredSearch);
    }
}