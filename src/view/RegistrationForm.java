
package view;

import controller.language.LanguageController;
import controller.registration.RegistrationController;
import model.language.registration.RegistrationLanguage;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by andreacifola on 05/09/16.
 */
public class RegistrationForm {
    private JPanel panelMain;
    private JButton jButton_EnglishLanguage;
    private JButton jButton_ItalianLanguage;
    private JTextField jtextField_Name;
    private JTextField jtextField_Surname;
    private JTextField jTextField_City;
    private JTextField jtextField_Address;
    private JComboBox jcomboBox_Day;
    private JComboBox jcomboBox_Month;
    private JComboBox jcomboBox_Year;
    private JTextField jtextField_Email;
    private JTextField jtextField_Username;
    private JTextField jtextField_IBAN;
    private JButton jButton_Register;
    private JPasswordField jPasswordField_Password;
    private JPasswordField jPasswordField_RepeatPassword;
    private JLabel jLabel_Name;
    private JLabel jLabel_Surname;
    private JLabel jLabel_City;
    private JLabel jLabel_Address;
    private JLabel jLabel_birthdate;
    private JLabel jLabel_Email;
    private JLabel jLabel_Username;
    private JLabel jLabel_Password;
    private JLabel jLabel_RepeatPassword;
    private JLabel jLabel_IBAN;
    private JLabel jLabel_registration;
    private JButton jButton_Cancel;

    public RegistrationForm(JFrame frame) {

        setComboBoxValues(jcomboBox_Day, 1, 31);
        setComboBoxValues(jcomboBox_Month, 1, 12);
        setComboBoxValues(jcomboBox_Year, 1930, Calendar.getInstance().get(Calendar.YEAR));

        setLabelTextLanguageRegistration();
        jButton_ItalianLanguage.addActionListener(e -> {
            LanguageController.setItalianLanguage();
            setLabelTextLanguageRegistration();
        });

        jButton_EnglishLanguage.addActionListener(e -> {
            LanguageController.setEnglishLanguage();
            setLabelTextLanguageRegistration();
        });

        RegistrationController registrationController = new RegistrationController();

        jButton_Register.addActionListener(e -> {
            GregorianCalendar calendar = new GregorianCalendar((int) jcomboBox_Year.getSelectedItem(),
                    (int) jcomboBox_Month.getSelectedItem(), (int) jcomboBox_Day.getSelectedItem());
            if (registrationController.addNewUser(jtextField_Name.getText().trim(), jtextField_Surname.getText().trim(),
                    jTextField_City.getText().trim(), jtextField_Address.getText().trim(), calendar, jtextField_Email.getText().trim(),
                    jtextField_Username.getText().trim(), ((JTextField) jPasswordField_Password).getText().trim(),
                    ((JTextField) jPasswordField_RepeatPassword).getText().trim(), jtextField_IBAN.getText().trim())) {
                JOptionPane.showMessageDialog(null, RegistrationLanguage.registration_newUserAdded);
                frame.setVisible(false);
                frame.dispose();
                openPreviousFrame();
            }
        });

        jButton_Cancel.addActionListener(e -> {
            frame.setVisible(false);
            frame.dispose();
            openPreviousFrame();
        });
    }

    private void openPreviousFrame() {
        JFrame frame = new JFrame();
        frame.setContentPane(new Login(frame).getPanelMain());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void setComboBoxValues(JComboBox<Object> jcomboBox, int minValue, int maxValue) {
        DefaultComboBoxModel<Object> dcbm = new DefaultComboBoxModel<>();
        for (int value = minValue; value <= maxValue; value++)
            dcbm.addElement(value);
        jcomboBox.setModel(dcbm);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void setLabelTextLanguageRegistration(){
        jLabel_registration.setText(RegistrationLanguage.registration_registration);
        jLabel_Name.setText(RegistrationLanguage.registration_name);
        jLabel_Surname.setText(RegistrationLanguage.registration_surname);
        jLabel_City.setText(RegistrationLanguage.registration_city);
        jLabel_Address.setText(RegistrationLanguage.registration_address);
        jLabel_birthdate.setText(RegistrationLanguage.registration_birthdate);
        jLabel_Email.setText(RegistrationLanguage.registration_email);
        jLabel_Username.setText(RegistrationLanguage.registration_username);
        jLabel_Password.setText(RegistrationLanguage.registration_password);
        jLabel_RepeatPassword.setText(RegistrationLanguage.registration_repeatPassword);
        jLabel_IBAN.setText(RegistrationLanguage.registration_iban);
        jButton_Cancel.setText(RegistrationLanguage.registration_cancel);
        jButton_Register.setText(RegistrationLanguage.registration_register);
    }
}