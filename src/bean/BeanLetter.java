package bean;

/**
 * Created by andreacifola on 22/12/16.
 */
public class BeanLetter {

    private String username;
    private String object;
    private String body;

    public BeanLetter(String username, String object, String body) {
        this.username = username;
        this.object = object;
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
