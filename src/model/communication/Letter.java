package model.communication;

/**
 * Created by andreacifola on 16/09/16.
 */
public class Letter {

    private String username;
    private String object;
    private String body;

    public Letter(String username, String object, String body) {
        this.username = username;
        this.object = object;
        this.body = body;
    }

    /**
     * @return the username of the sender or receiver of the letter
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the object of the letter
     */
    public String getObject() {
        return object;
    }

    /**
     * @return the body of the letter
     */
    public String getBody() {
        return body;
    }
}
