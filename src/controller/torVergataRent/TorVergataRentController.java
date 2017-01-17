package controller.torVergataRent;

import controller.communication.CommunicationController;
import model.User;
import view.TorVergataRent;

import javax.swing.*;

public class TorVergataRentController {

    private User loggedUser;
    private CommunicationController communicationController = new CommunicationController();
    private TorVergataRent torVergataRentView;

    public TorVergataRentController(User loggedUser) {
        JFrame frame = new JFrame();
        this.loggedUser = loggedUser;
        this.torVergataRentView = new TorVergataRent(frame, this);
        frame.setContentPane(torVergataRentView.getPanelMain());
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

    public TorVergataRent getTorVergataRentView() {
        return torVergataRentView;
    }
}
