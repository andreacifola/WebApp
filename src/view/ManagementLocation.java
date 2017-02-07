package view;

import controller.managementLocationController.ManagementLocationController;
import model.insertNewLocation.Location;
import model.insertNewLocation.Service;
import model.language.managementLocation.ManagementLocationLanguage;

import javax.swing.*;

/**
 * Created by andreacifola on 13/09/16.
 */
public class ManagementLocation {
    private JTextArea jTextArea_Description;
    private JTextField jTextField_NumberOfBed;
    private JCheckBox jCheckBox_PetsAllowed;
    private JCheckBox jCheckBox_PlasmaTV;
    private JCheckBox jCheckBox_WiFi;
    private JCheckBox jCheckBox_Parking;
    private JCheckBox jCheckBox_SmokingRoom;
    private JCheckBox jCheckBox_RoomService;
    private JCheckBox jCheckBox_View;
    private JCheckBox jCheckBox_ConditionedAir;
    private JButton jButton_Back;
    private JButton jButton_Save;
    private JPanel jPanelMain;
    private JTextField jTextField_NumRooms;
    private JTextField jTextField_NumMaxGuest;
    private JTextField jTextField_Bath;
    private JTextField jTextField_Price;
    private JLabel jLabel_Description;
    private JLabel jLabel_NumRooms;
    private JLabel jLabel_MaxNumGuest;
    private JLabel jLabel_NumBed;
    private JLabel jLabel_numBath;
    private JLabel jLabel_Price;
    private JLabel jLabel_modifyLocation;

    private ManagementLocationController mlc = new ManagementLocationController();


    public ManagementLocation(LocationForStructure locationForStructure, Location location, JFrame frame) {

        setLabelTextLanguageManagementLocation();


        jTextArea_Description.setText(location.getDescription());
        jTextField_NumRooms.setText(String.valueOf((location.getNumOfRooms())));
        jTextField_Bath.setText(String.valueOf(location.getNumOfBath()));
        jTextField_NumMaxGuest.setText(String.valueOf(location.getNumMaxGuests()));
        jTextField_Price.setText(String.valueOf(location.getPrice()));
        jTextField_NumberOfBed.setText(String.valueOf(location.getNumBeds()));
        jCheckBox_SmokingRoom.setSelected(location.getService().isWifi());
        jCheckBox_PetsAllowed.setSelected(location.getService().isPetsAllowed());
        jCheckBox_View.setSelected(location.getService().isViews());
        jCheckBox_PlasmaTV.setSelected(location.getService().isPlasmaTv());
        jCheckBox_WiFi.setSelected(location.getService().isWifi());
        jCheckBox_Parking.setSelected(location.getService().isParking());
        jCheckBox_ConditionedAir.setSelected(location.getService().isConditionedAir());
        jCheckBox_RoomService.setSelected(location.getService().isRoomService());

        jButton_Back.addActionListener(e -> {
            frame.setVisible(false);
            frame.dispose();
        });

        jButton_Save.addActionListener(e -> {

            if (ManagementLocationController.checkFields(jTextField_NumRooms.getText().trim(), jTextField_Bath.getText().trim(), jTextField_NumMaxGuest.getText().trim(),
                    jTextField_NumberOfBed.getText().trim(), jTextField_Price.getText().trim())) {
                Integer idLocation = location.getId();
                String description = jTextArea_Description.getText().trim();
                Integer rooms = Integer.valueOf(jTextField_NumRooms.getText().trim()),
                        bath = Integer.valueOf(jTextField_Bath.getText().trim()),
                        maxGuest = Integer.valueOf(jTextField_NumMaxGuest.getText().trim()),
                        bed = Integer.valueOf(jTextField_NumberOfBed.getText().trim());
                Double price = Double.valueOf(jTextField_Price.getText().trim());
                Boolean wifi = jCheckBox_WiFi.isSelected(),
                        smokingRoom = jCheckBox_SmokingRoom.isSelected(),
                        petsAllowed = jCheckBox_PetsAllowed.isSelected(),
                        parking = jCheckBox_Parking.isSelected(),
                        roomService = jCheckBox_RoomService.isSelected(),
                        conditionedAir = jCheckBox_ConditionedAir.isSelected(),
                        view = jCheckBox_View.isSelected(),
                        plasmaTV = jCheckBox_PlasmaTV.isSelected();

                if (mlc.modifyLocation(idLocation, description, rooms, bath, maxGuest, bed, price, wifi, smokingRoom, petsAllowed,
                        parking, roomService, conditionedAir, view, plasmaTV)) {
                    locationForStructure.getStructure().getLocations().remove(location);
                    Location locationToAdd = new Location(description, rooms, bath, maxGuest, bed, price,
                            new Service(wifi, smokingRoom, petsAllowed, parking, roomService, conditionedAir, view, plasmaTV), null, null);
                    locationForStructure.getStructure().getLocations().add(locationToAdd);
                    locationForStructure.loadLocation(locationForStructure.getStructure());

                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
    }

    public JPanel getPanelMain() {
        return jPanelMain;
    }

    private void setLabelTextLanguageManagementLocation() {

        jLabel_modifyLocation.setText(ManagementLocationLanguage.managementLocation_modifyLocation);
        jLabel_Description.setText(ManagementLocationLanguage.managementLocation_description);
        jLabel_NumRooms.setText(ManagementLocationLanguage.managementLocation_numberOfRooms);
        jLabel_MaxNumGuest.setText(ManagementLocationLanguage.managementLocation_maximumGuests);
        jLabel_NumBed.setText(ManagementLocationLanguage.managementLocation_numberOfBeds);
        jLabel_numBath.setText(ManagementLocationLanguage.managementLocation_numberOfBath);
        jLabel_Price.setText(ManagementLocationLanguage.managementLocation_price);
        jCheckBox_SmokingRoom.setText(ManagementLocationLanguage.managementLocation_smokingRoom);
        jCheckBox_PetsAllowed.setText(ManagementLocationLanguage.managementLocation_petsAllowed);
        jCheckBox_View.setText(ManagementLocationLanguage.managementLocation_view);
        jCheckBox_PlasmaTV.setText(ManagementLocationLanguage.managementLocation_plasmaTV);
        jCheckBox_WiFi.setText(ManagementLocationLanguage.managementLocation_Wifi);
        jCheckBox_Parking.setText(ManagementLocationLanguage.managementLocation_parking);
        jCheckBox_ConditionedAir.setText(ManagementLocationLanguage.managementLocation_conditionedAir);
        jCheckBox_RoomService.setText(ManagementLocationLanguage.managementLocation_roomService);
        jButton_Back.setText(ManagementLocationLanguage.managementLocation_back);
        jButton_Save.setText(ManagementLocationLanguage.managementLocation_save);
    }
}