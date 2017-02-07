package view;

import model.insertNewLocation.Location;
import model.language.viewLocation.ViewLocationLanguage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tizianoditoma on 11/09/16.
 */
public class ViewLocation {
    private JButton jButton_DetailsLocation;
    private JButton jButton_Delete;
    private JButton JButton_AddNewLocation;
    private JLabel JLabel_NameLocation;
    private LocationForStructure MainView;
    private JPanel JPanel_Main;
    private JButton jButton_Modify;
    private JTextArea JTextArea_Description;
    private Location location;

    public ViewLocation(LocationForStructure locationForStructure, Location locationToShow) {
        JTextArea_Description.setText(locationToShow.getDescription());
        JLabel_NameLocation.setText(ViewLocationLanguage.viewLocation_number + locationToShow.getId());

        setLabelTextLanguageViewLocation();

        jButton_DetailsLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame();
                frame.setContentPane(new DetailsLocation(locationToShow).getPanelMain());
                frame.pack();
                frame.setVisible(true);
            }
        });
        jButton_Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jButton_Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame();
                frame.setContentPane(new ManagementLocation(locationForStructure, locationToShow, frame).getPanelMain());
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public JPanel getjPanelMain() {
        return JPanel_Main;
    }

    private void setLabelTextLanguageViewLocation() {
        jButton_Delete.setText(ViewLocationLanguage.viewLocation_delete);
        jButton_DetailsLocation.setText(ViewLocationLanguage.viewLocation_details);
        jButton_Modify.setText(ViewLocationLanguage.viewLocation_modify);
    }
}
