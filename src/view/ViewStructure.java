package view;

import model.insertNewLocation.Structure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tizianoditoma on 09/09/16.
 */
public class ViewStructure {
    private JButton JButton_Details;
    private JPanel JPanel_Main;
    private JLabel JLabel_Name;
    private JTextPane JTextPane_Description;
    private JLabel JLabel_Address;


    public ViewStructure(Structure structuresToShow) {
        JTextPane_Description.setText(structuresToShow.getDescription());
        JLabel_Name.setText(structuresToShow.getName());
        JLabel_Address.setText(structuresToShow.getAddress().toString());

        JButton_Details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new LocationForStructure(structuresToShow).getjPanelMain());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public JPanel getjPanelMain() {
        return JPanel_Main;
    }

}

