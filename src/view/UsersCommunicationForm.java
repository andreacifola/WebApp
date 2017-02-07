package view;

import controller.communication.UsersCommunicationController;
import model.User;
import model.language.usersCommunicationForm.UsersCommunicationFormLanguage;

import javax.swing.*;

public class UsersCommunicationForm {
    private JPanel panelMain;
    private JButton jButton_send;
    private JButton jButton_cancel;
    private JTextField jtextField_From;
    private JTextField jtextField_To;
    private JTextField jtextField_Object;
    private JTextArea jtextArea;
    private JLabel jLabel_from;
    private JLabel jLabel_to;
    private JLabel jLabel_object;
    private UsersCommunicationController ucc = new UsersCommunicationController();

    public UsersCommunicationForm(User sender, User receiver) {

        setLabelTextLanguageUsersCommunicationForm();

        JFrame frame = new JFrame();
        frame.setContentPane(panelMain);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        ucc.disableTextFieldForCommunication(jtextField_From, sender.getUsername(), jtextField_To, receiver.getUsername());

        jButton_send.addActionListener(e -> {
            UsersCommunicationController usersCommunicationController = new UsersCommunicationController();
            if (usersCommunicationController.sendEmail(jtextField_From.getText().trim(), jtextField_To.getText().trim(), jtextField_Object.getText().trim(), jtextArea.getText().trim())) {
                JOptionPane.showMessageDialog(null, UsersCommunicationFormLanguage.usersCommunicationForm_emailSendedSuccessfully);
                frame.setVisible(false);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, UsersCommunicationFormLanguage.usersCommunicationForm_errors);
            }
        });

        jButton_cancel.addActionListener(e -> {
            int dialog = JOptionPane.showConfirmDialog(null, UsersCommunicationFormLanguage.usersCommuncationForm_sureExit, "Warning", JOptionPane.YES_NO_OPTION);
            if (dialog == JOptionPane.YES_OPTION) {
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

    private void setLabelTextLanguageUsersCommunicationForm() {

        jButton_cancel.setText(UsersCommunicationFormLanguage.usersCommunicationForm_cancel);
        jButton_send.setText(UsersCommunicationFormLanguage.usersCommunicationForm_send);
        jLabel_from.setText(UsersCommunicationFormLanguage.usersCommunicationForm_from);
        jLabel_to.setText(UsersCommunicationFormLanguage.usersCommunicationForm_to);
        jLabel_object.setText(UsersCommunicationFormLanguage.usersCommunicationForm_object);
    }
}