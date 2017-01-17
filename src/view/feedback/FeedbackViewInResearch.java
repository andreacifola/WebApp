package view.feedback;

import model.feedback.Feedback;

import javax.swing.*;

/**
 * Created by davidemagnanimi on 12/09/16 at 10:39.
 */
public class FeedbackViewInResearch {
    private JTextArea jTextArea_Description;
    private StarRater jStarRater;
    private JLabel jLabel;
    private JPanel jPanelMain;

    public FeedbackViewInResearch(Feedback feedback) {
        jLabel.setText(feedback.getUsername());
        jStarRater.setRating(feedback.getRating());
        jTextArea_Description.setText(feedback.getDescription());

        jLabel.setEnabled(false);
        jStarRater.setEnabled(false);
        jTextArea_Description.setEnabled(false);
    }

    public JPanel getjPanelMain() {
        return jPanelMain;
    }
}
