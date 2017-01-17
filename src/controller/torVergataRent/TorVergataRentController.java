package controller.torVergataRent;

import controller.communication.CommunicationController;
import model.User;

import javax.swing.*;

public class TorVergataRentController {

    private User loggedUser;
    private CommunicationController communicationController = new CommunicationController();

    public TorVergataRentController(User loggedUser) {
        JFrame frame = new JFrame();
        this.loggedUser = loggedUser;
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public CommunicationController getCommunicationController() {
        return communicationController;
    }

}
