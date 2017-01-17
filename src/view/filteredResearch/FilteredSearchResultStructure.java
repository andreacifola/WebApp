package view.filteredResearch;

import model.insertNewLocation.Location;
import model.insertNewLocation.Structure;
import model.language.filteredSearchResultStructure.FilteredSearchLanguage;
import view.TorVergataRent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by davidemagnanimi on 08/09/16.
 */
public class FilteredSearchResultStructure {
    private JButton jButton_select;
    private JTextPane jTextPane_description;
    private JLabel jLabel_name;
    private JLabel jLabel_address;
    private JPanel jPanelMain;
    private TorVergataRent mainView;

    public FilteredSearchResultStructure(TorVergataRent mainView, Structure structure, Date fromDate, Date toDate) {
        this.mainView = mainView;
        jTextPane_description.setText(structure.getDescription());
        jLabel_name.setText(structure.getName());
        jLabel_address.setText(structure.getAddress().toString());

        jButton_select.setText(FilteredSearchLanguage.visualiseLocation);

        jButton_select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel container = new JPanel();
                container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
                for (Location location : structure.getLocations()) {
                    container.add(new FilteredSearchResultLocation(mainView, location, structure.getOwner(), fromDate, toDate).getjPanelMain());
                }
                JScrollPane scrollPaneLayout = new JScrollPane(container);
                JFrame frame = new JFrame(FilteredSearchLanguage.availableLocation); //TODO inserire limite massimo grandezza finestra
                frame.setContentPane(scrollPaneLayout);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public JPanel getjPanelMain() {
        return jPanelMain;
    }


}
