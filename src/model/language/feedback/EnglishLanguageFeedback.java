package model.language.feedback;

/**
 * Created by luca on 20/09/16.
 */
public class EnglishLanguageFeedback extends FeedbackLanguage {

    public EnglishLanguageFeedback() {

        feedback_rating = "Rating";
        feedback_description = "Description";
        feedback_confirm = "Add";
        feedack_cantInsertFeedback = "You may not post feedback on a location that you have not booked , or otherwise you have to wait until the start date of the reservation";
    }
}
