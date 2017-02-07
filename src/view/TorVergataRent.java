package view;

import controller.ReservationController.FindReservationByUsername;
import controller.filteredSearch.FilteredSearchController;
import controller.insertLocationController.FindStructureByUsername;
import controller.language.LanguageController;
import controller.managementProfile.ManagementProfileController;
import controller.torVergataRent.TorVergataRentController;
import model.Reservation.Reservation;
import model.User;
import model.communication.Letter;
import model.insertNewLocation.Structure;
import model.language.filteredSearchResultStructure.FilteredSearchLanguage;
import model.language.managementLocation.ManagementLocationLanguage;
import model.language.managementProfile.ManagementProfileLanguage;
import model.language.usersCommunicationForm.UsersCommunicationFormLanguage;
import model.language.viewReservation.ViewReservationLanguage;
import model.payment.IBANCredentialNotValid;
import querySQL.Query;
import view.filteredResearch.FilteredSearchResultStructure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//import controller.managementProfile.ModifyPasswordController;

/**
 * Created by davidemagnanimi on 05/09/16 at 11:39.
 */
public class TorVergataRent {
    private JScrollPane JScrollPane_Reservation1;
    private JButton jButton_EnglishLanguage;
    private JButton jButton_ItalianLanguage;
    private JTabbedPane jTabbedPane;
    private JPanel panelMain;
    private JPanel jPanel_Ricerca;
    private JPanel jPanel_GestisciPrenotazioni;
    private JPanel jPanel_GestisciLocazioni;
    private JPanel jPanel_Profilo;
    private JButton jButton_NuovaStruttura;
    private JPanel jPanel_Comunicazioni;
    private JButton previousButtonSended;
    private JButton nextButtonSended;
    private JButton previousButtonReceived;
    private JButton nextButtonReceived;
    private JTextPane jTextPane_Sended;
    private JTextField jTextField_To;
    private JTextField jTextField_ObjectSended;
    private JTextField jTextField_From;
    private JTextField jTextField_ObjectReceived;
    private JTextPane jTextPane_Received;
    private JLabel jLabel_From;
    private JLabel jLabel_To;
    private JLabel jLabel_ObjectSended;
    private JLabel jLabel_ObjectReceived;
    private JLabel jLabel_Sended;
    private JLabel jLabel_Received;

    private JTextField jTextField_region;
    private JLabel jLabel_region;
    private JLabel jLabel_city;
    private JLabel jLabel_name;
    private JTextField jTextField_city;
    private JTextField jTextField_name;
    private JSpinner jSpinner_rooms;
    private JSlider jSlider_maxPrice;
    private JCheckBox jCheckBox_wifi;
    private JCheckBox jCheckBox_smoking;
    private JCheckBox jCheckBox_pets;
    private JCheckBox jCheckBox_parking;
    private JCheckBox jCheckBox_roomService;
    private JCheckBox jCheckBox_conditionedAir;
    private JCheckBox jCheckBox_views;
    private JCheckBox jCheckBox_plasmaTV;
    private JButton jButton_filteredSearch;
    private JSpinner jSpinner_baths;
    private JSpinner jSpinner_maxguests;
    private JSpinner jSpinner_beds;
    private JLabel jLabel_rooms;
    private JLabel jLabel_bath;
    private JLabel jLabel_maxguest;
    private JLabel jLabel_beds;
    private JLabel jLabel_maxprice;
    private JScrollPane jScrollPane_filteredSearcStructureResults;
    private JPanel jContainerFilteredSearchResults;
    private JButton JButton_AddNewStructureForm;
    private JPanel JContainerStructure;
    private JScrollPane JScrollPane_Structure;
    private JButton jButton_Logout;
    private JTextField jTextField_Name;
    private JTextField jTextField_Surname;
    private JTextField jTextField_City;
    private JTextField jTextField_Address;
    private JComboBox jComboBox_day;
    private JComboBox jComboBox_year;
    private JComboBox jComboBox_month;
    private JTextField jTextField_email;
    private JTextField jTextField_username;
    private JTextField textField7;
    private JButton jButton_modify;
    private JButton jButton_Confirm;
    private JButton jButton_cancelProfile;
    private JPasswordField jPasswordField_newPassword;
    private JTextField jTextField_iban;
    private JPanel JContainer_Reservation;
    private JLabel jLabel_fromdate;
    private JLabel jLabel_todate;
    private JLabel jTextField_managementProfile;
    private JLabel jLabel_surnameProfile;
    private JLabel jLabel_addressProfile;
    private JLabel jLabel_birthdateProfile;
    private JLabel jLabel_emailProfile;
    private JLabel jLabel_nameProfile;
    private JLabel jLabel_cityProfile;
    private JLabel jLabel_usernameProfile;
    private JLabel jLabel_newPasswordProfile;
    private JLabel jLabel_ibanProfile;
    private JButton jButton_confirmProfile;
    private TorVergataRentController torVergataRentController;


    public TorVergataRent(JFrame frame, TorVergataRentController tvrc) {
        this.torVergataRentController = tvrc;
        if (tvrc.getLoggedUser() == null) {
            getjTabbedPane().setEnabledAt(1, false);
            getjTabbedPane().setEnabledAt(2, false);
            getjTabbedPane().setEnabledAt(3, false);
            getjTabbedPane().setEnabledAt(4, false);
            jButton_Logout.setVisible(false);
        }

        jContainerFilteredSearchResults.setLayout(new BoxLayout(jContainerFilteredSearchResults, BoxLayout.Y_AXIS));
        JContainerStructure.setLayout(new BoxLayout(JContainerStructure, BoxLayout.Y_AXIS));
        JContainer_Reservation.setLayout(new BoxLayout(JContainer_Reservation, BoxLayout.Y_AXIS));

        jButton_filteredSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FilteredSearchController filteredSearchController = new FilteredSearchController();
                String region = jTextField_region.getText().trim(),
                        city = jTextField_city.getText().trim(),
                        name = jTextField_name.getText().trim();
                Integer rooms = (Integer) jSpinner_rooms.getValue(),
                        baths = (Integer) jSpinner_baths.getValue(),
                        maxGuests = (Integer) jSpinner_maxguests.getValue(),
                        beds = (Integer) jSpinner_beds.getValue(),
                        maxPrice = jSlider_maxPrice.getValue();
                Boolean wifi = jCheckBox_wifi.isSelected(),
                        smoking = jCheckBox_smoking.isSelected(),
                        petsAllowed = jCheckBox_pets.isSelected(),
                        parking = jCheckBox_parking.isSelected(),
                        roomService = jCheckBox_roomService.isSelected(),
                        conditionedAir = jCheckBox_conditionedAir.isSelected(),
                        views = jCheckBox_views.isSelected(),
                        plasmaTV = jCheckBox_plasmaTV.isSelected();
                ArrayList<Structure> foundedStructures = null;

                Date fromDate = null, toDate = null;

                try {
                    foundedStructures = filteredSearchController.startResearch(fromDate, toDate, region, city, name, rooms, baths,
                            maxGuests, beds, maxPrice, wifi, smoking, petsAllowed, parking, roomService, conditionedAir, views, plasmaTV);
                } catch (IBANCredentialNotValid | SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    showFilteredResearchResults(foundedStructures, fromDate, toDate);
                }
            }
        });

        jButton_Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                JFrame frame = new JFrame();
                frame.setContentPane(new Login(frame).getPanelMain());
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        JButton_AddNewStructureForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new FormStructure(frame).getPanelMain());
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        //Management Structure Panned
        jTabbedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                FindStructureByUsername findStructureByUsernameManagement = new FindStructureByUsername();
                ArrayList<Structure> foundedStructureManagement = null;
                try {
                    foundedStructureManagement = findStructureByUsernameManagement.findStructureByUsername(tvrc.getLoggedUser().getUsername());
                } catch (IBANCredentialNotValid | SQLException ibanCredentialNotValid) {
                    ibanCredentialNotValid.printStackTrace();
                } finally {
                    showStructure(foundedStructureManagement);
                }
            }
        });
        jButton_confirmProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = tvrc.getLoggedUser().getPassword();
                if (ManagementProfileController.modifyData(jTextField_Name.getText().trim(), jTextField_Surname.getText().trim(),
                        jTextField_City.getText().trim(), jTextField_Address.getText().trim(), null, jTextField_email.getText().trim(),
                        ((JTextField) jPasswordField_newPassword).getText().trim(),
                        jTextField_iban.getText().trim(), tvrc.getLoggedUser())) {
                    JOptionPane.showMessageDialog(null, "data modified");
                }
               /* if (!(((JTextField) jPasswordField_newPassword).getText()).isEmpty())
                    password =  UtilityMD5.stringByHashingPassword((((JTextField) jPasswordField_newPassword).getText()).trim());
                if (ManagementProfileController.checkMajorAge(birthdate)){
                    ManagementProfileController.modifyData(jTextField_Name.getText(), jTextField_Surname.getText(),
                            jTextField_City.getText(), jTextField_Address.getText(), birthdate,
                            jTextField_email.getText(), password,
                            jTextField_iban.getText(), tvrc.getLoggedUser());
                    JOptionPane.showMessageDialog(null, ManagementProfileLanguage.managementProfile_dataModified);
                }else {
                    JOptionPane.showMessageDialog(null, ManagementProfileLanguage.managementProfile_notMajorAge);
                }*/
            }
        });
        jTabbedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                disableTextFieldManagementProfile();
                setField(tvrc.getLoggedUser());
            }
        });
        jTabbedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                final int[] i = {0}, j = {0};
                final String[] receiver = new String[1], object1 = new String[1], body1 = new String[1],
                        sender = new String[1], object2 = new String[1], body2 = new String[1];
                ArrayList<Letter> arrayReceiver = tvrc.getCommunicationController().getEmailInfo(tvrc.getLoggedUser().getEmail(), Query.findSenderNameAndSurname);
                ArrayList<Letter> arraySender = tvrc.getCommunicationController().getEmailInfo(tvrc.getLoggedUser().getEmail(), Query.findReceiverNameAndSurname);

                tvrc.getCommunicationController().setCommunicationTabParameters(arrayReceiver, receiver, object1, body1, i);
                tvrc.getCommunicationController().disableTextField(jTextField_To, receiver[0], jTextField_ObjectSended, object1[0], jTextPane_Sended, body1[0]);

                tvrc.getCommunicationController().setCommunicationTabParameters(arraySender, sender, object2, body2, i);
                tvrc.getCommunicationController().disableTextField(jTextField_From, sender[0], jTextField_ObjectReceived, object2[0], jTextPane_Received, body2[0]);

                previousButtonSended.addActionListener(e1 -> {
                    if (i[0] > 0) {
                        i[0]--;
                        if (i[0] >= 0) {
                            receiver[0] = arrayReceiver.get(i[0]).getUsername().trim();
                            object1[0] = arrayReceiver.get(i[0]).getObject().trim();
                            body1[0] = arrayReceiver.get(i[0]).getBody().trim();
                            tvrc.getCommunicationController().disableTextField(jTextField_To, receiver[0], jTextField_ObjectSended, object1[0], jTextPane_Sended, body1[0]);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, UsersCommunicationFormLanguage.usersCommunicationForm_notPreviousMessage);
                    }
                });

                nextButtonSended.addActionListener(e2 -> {
                    if (arrayReceiver == null || i[0] > (arrayReceiver.size() - 2))
                        JOptionPane.showMessageDialog(null, "Non ci sono messaggi inviati successivi da mostrare");
                    else {
                        i[0]++;
                        receiver[0] = arrayReceiver.get(i[0]).getUsername().trim();
                        object1[0] = arrayReceiver.get(i[0]).getObject().trim();
                        body1[0] = arrayReceiver.get(i[0]).getBody().trim();
                        tvrc.getCommunicationController().disableTextField(jTextField_To, receiver[0], jTextField_ObjectSended, object1[0], jTextPane_Sended, body1[0]);
                    }
                });

                previousButtonReceived.addActionListener(e3 -> {
                    if (j[0] > 0) {
                        j[0]--;
                        if (j[0] >= 0) {
                            sender[0] = arraySender.get(j[0]).getUsername().trim();
                            object2[0] = arraySender.get(j[0]).getObject().trim();
                            body2[0] = arraySender.get(j[0]).getBody().trim();
                            tvrc.getCommunicationController().disableTextField(jTextField_From, sender[0], jTextField_ObjectReceived, object2[0], jTextPane_Received, body2[0]);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, UsersCommunicationFormLanguage.usersCommunicationForm_notPreviousMessage);
                    }
                });

                nextButtonReceived.addActionListener(e4 -> {
                    if (arraySender == null)
                        JOptionPane.showMessageDialog(null, UsersCommunicationFormLanguage.usersCommunicationForm_notFollowingMessage);
                    if (j[0] <= (arraySender.size() - 2)) {
                        j[0]++;
                        sender[0] = arraySender.get(j[0]).getUsername().trim();
                        object2[0] = arraySender.get(j[0]).getObject().trim();
                        body2[0] = arraySender.get(j[0]).getBody().trim();
                        tvrc.getCommunicationController().disableTextField(jTextField_From, sender[0], jTextField_ObjectReceived, object2[0], jTextPane_Received, body2[0]);
                    } else {
                        JOptionPane.showMessageDialog(null, UsersCommunicationFormLanguage.usersCommunicationForm_notFollowingMessage);
                    }
                });
            }
        });
        setLabelTextLanguageTorVergataRent();
        jButton_ItalianLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setItalianLanguage();
                setLabelTextLanguageTorVergataRent();
            }
        });
        jButton_EnglishLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageController.setEnglishLanguage();
                setLabelTextLanguageTorVergataRent();
            }
        });

        //Management Reservation Panned
        jTabbedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                FindReservationByUsername findReservationByUsernameManagement = new FindReservationByUsername();
                ArrayList<Reservation> foundedReservationManagement = null;
                try {
                    foundedReservationManagement = findReservationByUsernameManagement.findReservationByUsername(tvrc.getLoggedUser().getUsername());
                } catch (SQLException ibanCredentialNotValid) {
                    ibanCredentialNotValid.printStackTrace();
                } finally {
                    showReservation(foundedReservationManagement);
                }
            }
        });

    }


    public static void main(String[] args) throws IBANCredentialNotValid {
        new TorVergataRentController(new User("Andrea", "Cifola", "Roma", "Via Ferla 11", new Date(1994, 7, 19), "cifola.andrea@gmail.com", "andreacifola", "password", "IT60X0542811101000000123456"));
    }

    private void showFilteredResearchResults(ArrayList<Structure> structuresToShow, Date fromDate, Date toDate) {
        jContainerFilteredSearchResults.removeAll();
        if (structuresToShow == null) {
            jContainerFilteredSearchResults.add(new JLabel(FilteredSearchLanguage.dateNotValid));
        } else if (structuresToShow.isEmpty()) {
            jContainerFilteredSearchResults.add(new JLabel(FilteredSearchLanguage.serchWithoutResult));
        } else {
            for (Structure structure : structuresToShow) {
                jContainerFilteredSearchResults.add(new FilteredSearchResultStructure(this, structure, fromDate, toDate).getjPanelMain());
            }
        }
        jScrollPane_filteredSearcStructureResults.setViewportView(jContainerFilteredSearchResults);
    }

    private void showStructure(ArrayList<Structure> structuresToShow) {
        JContainerStructure.removeAll();
        if (structuresToShow.isEmpty()) {
            return;
        }
        for (Structure structure : structuresToShow) {
            JContainerStructure.add(new ViewStructure(structure).getjPanelMain());
        }
        JScrollPane_Structure.setViewportView(JContainerStructure);
    }

    private void showReservation(ArrayList<Reservation> reservationToShow) {
        JContainer_Reservation.removeAll();
        if (reservationToShow.isEmpty()) {
            return;
        }
        for (Reservation reservation : reservationToShow) {
            JContainer_Reservation.add(new ViewReservation(reservation).getjPanelMain());
        }
        JScrollPane_Reservation1.setViewportView(JContainer_Reservation);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }


    public TorVergataRentController getTorVergataRentController() {
        return torVergataRentController;
    }

    private void disableTextFieldManagementProfile() {
        jTextField_username.setEnabled(false);
        jTextField_username.setDisabledTextColor(Color.BLACK);
    }

    private void setField(User loggedUser) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(loggedUser.getBirthDate());
        jTextField_Name.setText(loggedUser.getName());
        jTextField_Surname.setText(loggedUser.getSurname());
        jTextField_City.setText(loggedUser.getCity());
        jTextField_Address.setText(loggedUser.getAddress());
        jTextField_email.setText(loggedUser.getEmail());
        jTextField_username.setText(loggedUser.getUsername());
        jTextField_iban.setText(loggedUser.getIban().getNumber());
    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }

    private void setLabelTextLanguageTorVergataRent() {
        jTabbedPane.setTitleAt(0, FilteredSearchLanguage.search);
        jTabbedPane.setTitleAt(1, ViewReservationLanguage.managementReservation_managementReservation);
        jTabbedPane.setTitleAt(2, ManagementLocationLanguage.managementLocation_managementLocation);
        jTabbedPane.setTitleAt(3, ManagementProfileLanguage.managementProfile_managementProfile);
        jTabbedPane.setTitleAt(4, UsersCommunicationFormLanguage.usersCommunication_communication);
        jLabel_fromdate.setText(FilteredSearchLanguage.fromDate);
        jLabel_todate.setText(FilteredSearchLanguage.toDate);
        jLabel_region.setText(FilteredSearchLanguage.region);
        jLabel_city.setText(FilteredSearchLanguage.city);
        jLabel_name.setText(FilteredSearchLanguage.name);
        jLabel_rooms.setText(FilteredSearchLanguage.rooms);
        jLabel_bath.setText(FilteredSearchLanguage.bathrooms);
        jLabel_maxguest.setText(FilteredSearchLanguage.maxGuests);
        jLabel_beds.setText(FilteredSearchLanguage.beds);
        jLabel_maxprice.setText(FilteredSearchLanguage.price);
        jCheckBox_wifi.setText(FilteredSearchLanguage.wifi);
        jCheckBox_smoking.setText(FilteredSearchLanguage.smokingRoom);
        jCheckBox_pets.setText(FilteredSearchLanguage.petsAllowed);
        jCheckBox_parking.setText(FilteredSearchLanguage.parking);
        jCheckBox_roomService.setText(FilteredSearchLanguage.roomService);
        jCheckBox_conditionedAir.setText(FilteredSearchLanguage.conditionedAir);
        jCheckBox_views.setText(FilteredSearchLanguage.views);
        jCheckBox_plasmaTV.setText(FilteredSearchLanguage.plasmaTV);
        jButton_filteredSearch.setText(FilteredSearchLanguage.search);
        jTextField_managementProfile.setText(ManagementProfileLanguage.managementProfile_managementProfile);
        jLabel_nameProfile.setText(ManagementProfileLanguage.managementProfile_name);
        jLabel_surnameProfile.setText(ManagementProfileLanguage.managementProfile_surname);
        jLabel_cityProfile.setText(ManagementProfileLanguage.managementProfile_city);
        jLabel_addressProfile.setText(ManagementProfileLanguage.managementProfile_address);
        jLabel_birthdateProfile.setText(ManagementProfileLanguage.managementProfile_birthdate);
        jLabel_emailProfile.setText(ManagementProfileLanguage.managementProfile_email);
        jLabel_usernameProfile.setText(ManagementProfileLanguage.managementProfile_username);
        jLabel_newPasswordProfile.setText(ManagementProfileLanguage.managementProfile_newPassword);
        jLabel_ibanProfile.setText(ManagementProfileLanguage.managementProfile_iban);
        jButton_cancelProfile.setText(ManagementProfileLanguage.managementProfile_cancel);
        jButton_confirmProfile.setText(ManagementProfileLanguage.managementProfile_confirm);
    }
}