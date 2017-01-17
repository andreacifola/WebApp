package model.language.feedback;

/**
 * Created by luca on 20/09/16.
 */
public class ItalianLanguageFeedback extends FeedbackLanguage {

    public ItalianLanguageFeedback() {

        feedback_rating = "Valutazione";
        feedback_description = "Descrizione";
        feedback_confirm = "Aggiungi";
        feedack_cantInsertFeedback = "Non puoi inserire un feedback su una locazione che non hai prenotato, o comunque devi attendere la data di inizio della prenotazione";
    }
}
