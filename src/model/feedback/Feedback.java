package model.feedback;

/**
 * Created by davidemagnanimi on 12/09/16 at 11:17.
 */
public class Feedback {
    private Integer rating;
    private String description;
    private String username;

    public Feedback(Integer rating, String description, String username) {
        this.rating = rating;
        this.description = description;
        this.username = username;
    }

    public Integer getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }
}
