package view.filteredResearch;

import controller.ReservationController.ReservationController;
import controller.feedback.FeedbackController;
import model.User;
import model.feedback.Feedback;
import model.insertNewLocation.Location;
import model.language.filteredSearchResultLocation.FilteredSearchResultLocationLanguage;
import view.TorVergataRent;
import view.UsersCommunicationForm;
import view.feedback.FeedbackViewInResearch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by davidemagnanimi on 11/09/16.
 */
public class FilteredSearchResultLocation {
    private JButton jButton_sendEmail;
    private JButton jButton_Reserve;
    private JTextField jTextField_rooms;
    private JCheckBox jCheckBox_wifi;
    private JCheckBox jCheckBox_smoking;
    private JCheckBox jCheckBox_pets;
    private JCheckBox jCheckBox_parking;
    private JCheckBox jCheckBox_roomservice;
    private JCheckBox jCheckBox_conditionedair;
    private JCheckBox jCheckBox_view;
    private JCheckBox jCheckBox_plasmatv;
    private JLabel jLabel_name;
    private JLabel jLabel_rooms;
    private JTextPane jTextPane_description;
    private JTextField jTextField_baths;
    private JTextField jTextField_maxguest;
    private JTextField jTextField_beds;
    private JTextField jTextField_price;
    private JLabel jLabel_baths;
    private JLabel jLabel_maxguest;
    private JLabel jLabel_beds;
    private JLabel jLabel_price;
    private JPanel jPanelMain;
    private JLabel jLabel_description;
    private JScrollPane jScrollPane_feedback;
    private JPanel jPanel_feedbackContainer;
    private JButton jButton_addFeedback;
    private TorVergataRent mainView;

    public FilteredSearchResultLocation(TorVergataRent mainView, Location location, User owner, Date fromDate, Date toDate) {
        this.mainView = mainView;

        setLabelTextLanguageFilteredSearchResultLocation();

        if (mainView.getTorVergataRentController().getLoggedUser() == null) {
            jButton_addFeedback.setEnabled(false);
            jButton_Reserve.setEnabled(false);
            jButton_sendEmail.setEnabled(false);
        }


        jTextField_baths.setEditable(false);
        jTextField_rooms.setEditable(false);
        jTextField_beds.setEditable(false);
        jTextField_maxguest.setEditable(false);
        jTextField_price.setEditable(false);
        jTextPane_description.setEditable(false);

        jTextField_rooms.setText(String.valueOf(location.getNumOfRooms()));
        jTextField_baths.setText(String.valueOf(location.getNumOfBath()));
        jTextField_beds.setText(String.valueOf(location.getNumBeds()));
        jTextField_maxguest.setText(String.valueOf(location.getNumMaxGuests()));
        jTextField_price.setText(String.valueOf(location.getPrice()));
        jTextPane_description.setText(location.getDescription());

        jCheckBox_wifi.setSelected(location.getService().isWifi());
        jCheckBox_smoking.setSelected(location.getService().isSmokingRoom());
        jCheckBox_pets.setSelected(location.getService().isPetsAllowed());
        jCheckBox_parking.setSelected(location.getService().isParking());
        jCheckBox_roomservice.setSelected(location.getService().isRoomService());
        jCheckBox_conditionedair.setSelected(location.getService().isConditionedAir());
        jCheckBox_view.setSelected(location.getService().isViews());
        jCheckBox_plasmatv.setSelected(location.getService().isPlasmaTv());

        jCheckBox_wifi.setEnabled(false);
        jCheckBox_smoking.setEnabled(false);
        jCheckBox_pets.setEnabled(false);
        jCheckBox_parking.setEnabled(false);
        jCheckBox_roomservice.setEnabled(false);
        jCheckBox_conditionedair.setEnabled(false);
        jCheckBox_view.setEnabled(false);
        jCheckBox_plasmatv.setEnabled(false);

        loadFeedback(location);

        jButton_sendEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UsersCommunicationForm(mainView.getTorVergataRentController().getLoggedUser(), owner);
            }
        });
        jButton_addFeedback.addActionListener(e ->
                new FeedbackController(this, mainView.getTorVergataRentController().getLoggedUser(), location));

        jButton_Reserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReservationController(location, mainView.getTorVergataRentController().getLoggedUser(), owner, fromDate, toDate);

            }
        });
    }

    public JPanel getjPanelMain() {
        return jPanelMain;
    }

    public void loadFeedback(Location location) {
        jPanel_feedbackContainer.removeAll();
        jPanel_feedbackContainer.setLayout(new BoxLayout(jPanel_feedbackContainer, BoxLayout.Y_AXIS));
        for (Feedback feedback : location.getFeedbacks()) {
            jPanel_feedbackContainer.add(new FeedbackViewInResearch(feedback).getjPanelMain());
        }
        jScrollPane_feedback.setViewportView(jPanel_feedbackContainer);
    }

    private void setLabelTextLanguageFilteredSearchResultLocation() {
        jButton_sendEmail.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_sendEmail);
        jButton_addFeedback.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_addFeedback);
        jButton_Reserve.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_reserve);
        jLabel_rooms.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_rooms);
        jLabel_baths.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_baths);
        jLabel_maxguest.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_maxGuest);
        jLabel_beds.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_beds);
        jLabel_price.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_price);
        jLabel_description.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_description);
        jCheckBox_wifi.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_wifi);
        jCheckBox_pets.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_petsAllowed);
        jCheckBox_roomservice.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_roomService);
        jCheckBox_view.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_view);
        jCheckBox_smoking.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_smokingRoom);
        jCheckBox_parking.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_parking);
        jCheckBox_conditionedair.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_airConditioned);
        jCheckBox_plasmatv.setText(FilteredSearchResultLocationLanguage.filteredSearchResultLocation_plasmaTV);
    }

}
