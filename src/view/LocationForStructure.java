package view;

import controller.torVergataRent.TorVergataRentController;
import model.insertNewLocation.Location;
import model.insertNewLocation.Structure;
import model.language.locationForStructure.LocationForStructureLanguage;

import javax.swing.*;

/**
 * Created by tizianoditoma on 11/09/16.
 */
public class LocationForStructure {
    private JPanel JPanel_Main;
    private JLabel jLabel_Locations;
    private JScrollPane JScrollPane_LocationForStructure;
    private JPanel JContainerLocation;
    private JButton jButton_AddNewLocation;
    private ViewLocation MainView;
    private Structure structure;

    private TorVergataRentController torVergataRentController;

    public LocationForStructure(Structure structure) {
        this.structure = structure;
        loadLocation(structure);

        setLabelTextLanguageLocationForStructure();

        jButton_AddNewLocation.addActionListener(e -> {
            JFrame frame = new JFrame();
            frame.setContentPane(new FormLocation(this, frame, structure).getPanelMain());
            frame.pack();
            frame.setVisible(true);
        });
    }

    public void loadLocation(Structure structure) {
        JContainerLocation.setLayout(new BoxLayout(JContainerLocation, BoxLayout.Y_AXIS));

        JContainerLocation.removeAll();
        if (structure.getLocations().isEmpty())
            return;
        for (Location location : structure.getLocations()) {
            JContainerLocation.add(new ViewLocation(this, location).getjPanelMain());
        }
        JScrollPane_LocationForStructure.setViewportView(JContainerLocation);

    }

    public JPanel getjPanelMain() {
        return JPanel_Main;
    }

    public Structure getStructure() {
        return structure;
    }

    private void setLabelTextLanguageLocationForStructure() {
        jLabel_Locations.setText(LocationForStructureLanguage.locationForStructure_locations);
        jButton_AddNewLocation.setText(LocationForStructureLanguage.getLocationForStructure_addNewLocation);
    }
}
