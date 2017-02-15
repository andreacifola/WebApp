import controller.feedback.FeedbackController;

import java.sql.Timestamp;
import java.util.Random;

/**
 * Created by davidemagnanimi on 13/02/17.
 */
public class ThreadProva {


    public static void main(String args[]) throws InterruptedException {
        String author[] = {"davidemagnanimi", "andreacifola", "lucatabacchino", "tizianoditoma"};
        Integer locationID = 1;
        Integer rating = 3;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer selectedAuthor = random.nextInt(4);
            String description = new Timestamp(System.currentTimeMillis()).toString();
            Thread thread = new Thread(new FeedbackController(author[selectedAuthor], description, locationID, rating));
            thread.run();
        }
    }

}
