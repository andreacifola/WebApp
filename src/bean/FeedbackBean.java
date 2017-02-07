package bean;

import java.io.Serializable;

/**
 * Created by davidemagnanimi on 18/01/17.
 */
public class FeedbackBean implements Serializable {
    String username, description;
    Integer rating;

    public FeedbackBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
