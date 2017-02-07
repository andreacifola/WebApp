package view;

import controller.insertStructureController.InsertNewStructureController;
import controller.language.LanguageController;
import controller.torVergataRent.TorVergataRentController;
import model.language.formStructure.FormStructureLanguage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tizianoditoma on 05/09/16.
 */
public class FormStructure {
    private static JFrame frame = null;
    private JButton jButton_EnglishLanguage;
    private JButton jButton_ItalianLanguage;
    private JTextField JTextField_Region;
    private JTextField JTextField_City;
    private JTextField JTextField_Address;
    private JTextField JTextField_NumberOfHouse;
    private JTextField JTextField_CAP;
    private JTextField JTextField_Owner;
    private JTextArea JTextArea_Description;
    private JButton JButton_Insert;
    private JLabel JLabel_Name;
    private JLabel JLabel_Region;
    private JLabel JLabel_City;
    private JLabel JLabel_Address;
    private JLabel JLabel_NumOfHouse;
    private JLabel JLabel_CAP;
    private JLabel JLabel_Owner;
    private JLabel JLabel_Description;
    private JTextField JTextField_Name;
    private JPanel JPanel_Main;
    private JButton JButton_Cancel;
    private JLabel JLabel_AddNewStructure;
    private TorVergataRentController tvrc;



    public FormStructure(JFrame frame) {

        setLabelTextLanguageFormStructure();
        jButton_ItalianLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setItalianLanguage();
                setLabelTextLanguageFormStructure();

            }
        });
        jButton_EnglishLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setEnglishLanguage();
                setLabelTextLanguageFormStructure();

            }
        });
        JButton_Insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (InsertNewStructureController.addNewStructure(JTextField_Name.getText().trim(), JTextField_Owner.getText().trim(),
                        JTextArea_Description.getText().trim(), JTextField_Region.getText().trim(), JTextField_City.getText().trim(), JTextField_Address.getText().trim(),
                        Integer.valueOf(JTextField_NumberOfHouse.getText().trim()), Integer.valueOf(JTextField_CAP.getText().trim())))
                    ;
                JOptionPane.showMessageDialog(null, FormStructureLanguage.formStructure_newStructureAdded);
                frame.setVisible(false);
                frame.dispose();
                //TODO torna da qualche parte
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormStructure(frame).getPanelMain());
        frame.pack();
        frame.setVisible(true);
    }

    private void openPreviousFrame() {
        frame = new JFrame();
        frame.setContentPane(new TorVergataRent(frame, tvrc).getPanelMain());
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanelMain() {
        return JPanel_Main;
    }

    private void setLabelTextLanguageFormStructure() {
        JLabel_Name.setText(FormStructureLanguage.formStructure_name);
        JLabel_Region.setText(FormStructureLanguage.formStructure_region);
        JLabel_City.setText(FormStructureLanguage.formStructure_city);
        JLabel_Address.setText(FormStructureLanguage.formStructure_address);
        JLabel_Owner.setText(FormStructureLanguage.formStructure_owner);
        JLabel_Description.setText(FormStructureLanguage.formStructure_description);
        JLabel_NumOfHouse.setText(FormStructureLanguage.formStructure_numberOfHouse);
        JLabel_CAP.setText(FormStructureLanguage.formStructure_postCode);
        JButton_Cancel.setText(FormStructureLanguage.formStructure_cancel);
        JButton_Insert.setText(FormStructureLanguage.formStructure_insert);
    }

}