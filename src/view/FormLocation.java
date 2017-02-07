package view;

import controller.insertLocationController.InsertNewLocationController;
import controller.language.LanguageController;
import controller.torVergataRent.TorVergataRentController;
import model.insertNewLocation.Service;
import model.insertNewLocation.Structure;
import model.language.formLocation.FormLocationLanguage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tizianoditoma on 05/09/16.
 */
public class FormLocation {
    private static JFrame frame = null;
    private JButton jButton_EnglishLanguage;
    private JButton jButton_ItalianLanguage;
    private JTextArea JTextArea_Description;
    private JTextField JTextField_NumberOfRooms;
    private JTextField JTextField_NumberMaxGuest;
    private JTextField JTextField_NumberOfBath;
    private JTextField JTextField_Price;
    private JCheckBox JCheckBox_Wifi;
    private JCheckBox JCheckBox_SmokingRoom;
    private JButton JButton_AddNewLocation;
    private JCheckBox JCheckBox_PetsAllowed;
    private JCheckBox JCheckBox_ConditionedAir;
    private JCheckBox JCheckBox_View;
    private JLabel JLabel_Description;
    private JLabel JLabel_NumMaxGuest;
    private JLabel JLabel_NumRooms;
    private JLabel JLabel_NumBath;
    private JLabel JLabel_Price;
    private JCheckBox JCheckBox_Parking;
    private JCheckBox JCheckBox_RoomService;
    private JCheckBox JCheckBox_PlasmaTv;
    private JPanel JPanel_Main;
    private JTextField JTextField_NumberOfBed;
    private JLabel JLabel_NumberOfBed;
    private JComboBox JComboBox_DayFrom;
    private JComboBox JComboBox_MonthFrom;
    private JComboBox JComboBox_DayTo;
    private JComboBox JComboBox_MonthTo;
    private JComboBox JComboBox_YearFrom;
    private JComboBox JComboBox_YearTo;
    private JLabel JLabel_From;
    private JLabel JLabel_To;
    private JLabel JLabel_Available;
    private JLabel JField_InserireNuovaLocazione;
    private TorVergataRentController tvrc;
    private Structure structure;


    public FormLocation(LocationForStructure locationForStructure, JFrame frame, Structure structure) {
        this.structure = structure;
        setLabelTextLanguageFormLocation();
        jButton_ItalianLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setItalianLanguage();
                setLabelTextLanguageFormLocation();

            }
        });
        jButton_EnglishLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setEnglishLanguage();
                setLabelTextLanguageFormLocation();

            }
        });
        JButton_AddNewLocation.addActionListener(e -> {

            String description = JTextArea_Description.getText().trim(),
                    rooms = JTextField_NumberOfRooms.getText().trim(),
                    bath = JTextField_NumberOfBath.getText().trim(),
                    maxGuest = JTextField_NumberMaxGuest.getText().trim(),
                    bed = JTextField_NumberOfBed.getText().trim(),
                    price = JTextField_Price.getText().trim();
            Integer idStructure = structure.getId();
            Service service = new Service(JCheckBox_Wifi.isSelected(), JCheckBox_SmokingRoom.isSelected(),
                    JCheckBox_PetsAllowed.isSelected(), JCheckBox_Parking.isSelected(), JCheckBox_RoomService.isSelected(),
                    JCheckBox_ConditionedAir.isSelected(), JCheckBox_View.isSelected(), JCheckBox_PlasmaTv.isSelected());

            InsertNewLocationController.addNewLocation(description, rooms, bath, maxGuest, bed, price, null, null, service, idStructure);

            JOptionPane.showMessageDialog(null, FormLocationLanguage.formLocation_newLocationAdded);
            frame.setVisible(false);
            frame.dispose();

            //TODO torna da qualche parte
        });
    }


    private void openPreviousFrame(TorVergataRentController tvrc) {
        JFrame frame = new JFrame();
        this.tvrc = tvrc;
        frame.setContentPane(new TorVergataRent(frame, tvrc).getPanelMain());
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanelMain() {
        return JPanel_Main;
    }

    public Structure getStructure() {
        return structure;
    }

    private void setLabelTextLanguageFormLocation() {
        JField_InserireNuovaLocazione.setText(FormLocationLanguage.formLocation_addNewLocation);
        JLabel_Description.setText(FormLocationLanguage.formLocation_description);
        JLabel_NumBath.setText(FormLocationLanguage.formLocation_numberOfBath);
        JLabel_NumRooms.setText(FormLocationLanguage.formLocation_numberOfRooms);
        JLabel_NumMaxGuest.setText(FormLocationLanguage.formLocation_maximumGuests);
        JLabel_NumberOfBed.setText(FormLocationLanguage.formLocation_numberOfBeds);
        JLabel_Available.setText(FormLocationLanguage.formLocation_available);
        JLabel_Price.setText(FormLocationLanguage.formLocation_price);
        JLabel_From.setText(FormLocationLanguage.formLocation_from);
        JLabel_To.setText(FormLocationLanguage.formLocation_to);
        JCheckBox_SmokingRoom.setText(FormLocationLanguage.formLocation_smokingRoom);
        JCheckBox_PetsAllowed.setText(FormLocationLanguage.formLocation_petsAllowed);
        JCheckBox_View.setText(FormLocationLanguage.formLocation_view);
        JCheckBox_PlasmaTv.setText(FormLocationLanguage.formLocation_plasmaTV);
        JCheckBox_Wifi.setText(FormLocationLanguage.formLocation_Wifi);
        JCheckBox_Parking.setText(FormLocationLanguage.formLocation_parking);
        JCheckBox_ConditionedAir.setText(FormLocationLanguage.formLocation_conditionedAir);
        JCheckBox_RoomService.setText(FormLocationLanguage.formLocation_roomService);
        JButton_AddNewLocation.setText(FormLocationLanguage.formLocation_addNewLocation);

    }

}
