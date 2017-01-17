package bean;

import java.io.Serializable;

/**
 * Created by andreacifola on 11/01/17.
 */
public class LetterBean implements Serializable {
    private String object;
    private String text;

    public LetterBean() {
        this.object = object;
        this.text = text;
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
