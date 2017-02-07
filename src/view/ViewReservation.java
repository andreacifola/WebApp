package view;

import model.Reservation.Reservation;
import model.language.viewReservation.ViewReservationLanguage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewReservation {
    private JPanel JPanel_Main;
    private JButton jButton_Reservation;
    private JLabel JLabel_Name;
    private JTextField JTextField_From;
    private JTextField JTextField_To;
    private JTextField JTextField_Price;
    private JLabel jLabel_From;
    private JLabel jLabel_To;
    private JLabel jLabel_Price;

    public ViewReservation(Reservation reservationToShow) {
        JTextField_From.setText(String.valueOf(reservationToShow.getFromDate()));
        JTextField_To.setText(String.valueOf(reservationToShow.getToDate()));
        JLabel_Name.setText("Reservation n°" + reservationToShow.getId());

        setLabelTextLanguageViewReservation();

        jButton_Reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getjPanelMain() {
        return JPanel_Main;
    }

    private void setLabelTextLanguageViewReservation() {
        jLabel_From.setText(ViewReservationLanguage.viewReservation_locationReservation);
        jLabel_Price.setText(ViewReservationLanguage.viewReservation_price);
        jLabel_To.setText(ViewReservationLanguage.viewReservation_to);
        jButton_Reservation.setText(ViewReservationLanguage.viewReservation_reservation);
    }
}
