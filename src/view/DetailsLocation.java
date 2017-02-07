package view;

import controller.language.LanguageController;
import controller.torVergataRent.TorVergataRentController;
import model.insertNewLocation.Location;
import model.language.detailsLocation.DetailsLocationLanguage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tizianoditoma on 11/09/16.
 */
public class DetailsLocation {
    private static JFrame frame = null;

    private JButton jButton_italianLanguage;
    private JButton jButton_englishLanguage;
    private JLabel jLabel_NumMaxGuest;
    private JLabel jLabel_description;
    private JLabel jLabel_NumRooms;
    private JLabel jLabel_Price;
    private JLabel jLabel_NumBath;
    private JLabel jLabel_NumberOfBed;
    private JTextArea JTextArea_Description;
    private JLabel jField_Details;
    private JCheckBox jCheckBox_Wifi;
    private JCheckBox jCheckBox_Parking;
    private JCheckBox jCheckBox_ConditionedAir;
    private JCheckBox jCheckBox_RoomService;
    private JCheckBox jCheckBox_SmokingRoom;
    private JCheckBox jCheckBox_PetsAllowed;
    private JCheckBox jCheckBox_View;
    private JCheckBox jCheckBox_PlasmaTv;
    private JTextField JTextField_Price;
    private JPanel JPanel_Main;
    private JLabel JLabel_NUmberOfRoom;
    private JLabel JLabel_NumberMaxGuest;
    private JLabel JLabel_NunmOfBed;
    private JLabel JLabel_NumberOfBath;
    private JLabel JLabel_PriceL;

    private TorVergataRentController tvrc;


    public DetailsLocation(Location locationForStructure){

        JTextArea_Description.setText(locationForStructure.getDescription());
        JLabel_NUmberOfRoom.setText(String.valueOf((locationForStructure.getNumOfRooms())));
        JLabel_NumberOfBath.setText(String.valueOf(locationForStructure.getNumOfBath()));
        JLabel_NumberMaxGuest.setText(String.valueOf(locationForStructure.getNumMaxGuests()));
        JLabel_PriceL.setText(String.valueOf(locationForStructure.getPrice()));
        JLabel_NunmOfBed.setText(String.valueOf(locationForStructure.getNumBeds()));

        jCheckBox_SmokingRoom.setSelected(locationForStructure.getService().isWifi());
        jCheckBox_PetsAllowed.setSelected(locationForStructure.getService().isPetsAllowed());
        jCheckBox_View.setSelected(locationForStructure.getService().isViews());
        jCheckBox_PlasmaTv.setSelected(locationForStructure.getService().isPlasmaTv());
        jCheckBox_Wifi.setSelected(locationForStructure.getService().isWifi());
        jCheckBox_Parking.setSelected(locationForStructure.getService().isParking());
        jCheckBox_ConditionedAir.setSelected(locationForStructure.getService().isConditionedAir());
        jCheckBox_RoomService.setSelected(locationForStructure.getService().isRoomService());


        setLabelTextLanguageDetailsLocation();
        jButton_italianLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setItalianLanguage();
                setLabelTextLanguageDetailsLocation();

            }
        });
        jButton_englishLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setEnglishLanguage();
                setLabelTextLanguageDetailsLocation();

            }
        });
    }

    public JPanel getPanelMain() {
        return JPanel_Main;
    }

    private void setLabelTextLanguageDetailsLocation() {

        jField_Details.setText(DetailsLocationLanguage.details_details);
        jLabel_description.setText(DetailsLocationLanguage.details_description);
        jLabel_NumRooms.setText(DetailsLocationLanguage.details_numberOfRooms);
        jLabel_NumMaxGuest.setText(DetailsLocationLanguage.details_maximumGuests);
        jLabel_NumberOfBed.setText(DetailsLocationLanguage.details_numberOfBeds);
        jLabel_NumBath.setText(DetailsLocationLanguage.details_numberOfBath);
        jLabel_Price.setText(DetailsLocationLanguage.details_price);
        jCheckBox_SmokingRoom.setText(DetailsLocationLanguage.details_smokingRoom);
        jCheckBox_PetsAllowed.setText(DetailsLocationLanguage.details_petsAllowed);
        jCheckBox_View.setText(DetailsLocationLanguage.details_view);
        jCheckBox_PlasmaTv.setText(DetailsLocationLanguage.details_plasmaTV);
        jCheckBox_Wifi.setText(DetailsLocationLanguage.details_Wifi);
        jCheckBox_Parking.setText(DetailsLocationLanguage.details_parking);
        jCheckBox_ConditionedAir.setText(DetailsLocationLanguage.details_conditionedAir);
        jCheckBox_RoomService.setText(DetailsLocationLanguage.details_roomService);
    }



}
