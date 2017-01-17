package view.feedback;

import controller.feedback.FeedbackController;
import model.feedback.Feedback;
import model.language.feedback.FeedbackLanguage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by davidemagnanimi on 12/09/16 at 14:35.
 */
public class AddFeedback {
    private JButton jButton_confirm;
    private JTextPane jTextPane_description;
    private JLabel jLabel_rating;
    private StarRater jStarRater;
    private JLabel jLabel_description;
    private JPanel jPanelMain;

    public AddFeedback(FeedbackController feedbackController) {

        setLabelTextLanguageFeedback();

        jButton_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                feedbackController.storeFeedback(jStarRater.getSelection(), jTextPane_description.getText().trim());
                feedbackController.getFrame().dispose();
            }
        });
    }

    public AddFeedback(FeedbackController feedbackController, Feedback feedback) {
        this(feedbackController);
        if (feedback != null) {
            jStarRater.setSelection(feedback.getRating());
            jTextPane_description.setText(feedback.getDescription());
        }
    }

    public JPanel getjPanelMain() {
        return jPanelMain;
    }

    private void setLabelTextLanguageFeedback(){
        jLabel_rating.setText(FeedbackLanguage.feedback_rating);
        jLabel_description.setText(FeedbackLanguage.feedback_description);
        jButton_confirm.setText(FeedbackLanguage.feedback_confirm);
    }
}
