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

    public String getUsername() {
        return username;
    }

    public String getObject() {
        return object;
    }

    public String getBody() {
        return body;
    }
}
