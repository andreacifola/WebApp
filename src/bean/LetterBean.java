package bean;

import java.io.Serializable;

/**
 * Created by andreacifola on 06/02/17.
 */
public class LetterBean implements Serializable {
    String username, object, text;

    public LetterBean(String username, String object, String text) {
        this.username = username;
        this.object = object;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
