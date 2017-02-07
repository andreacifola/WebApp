package bean;

import model.communication.Letter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by andreacifola on 11/01/17.
 */
public class ListLetterBean implements Serializable {
    private ArrayList<Letter> letters;

    public ListLetterBean() {
        letters = new ArrayList<>();
    }

    public ArrayList<Letter> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Letter> letters) {
        this.letters = letters;
    }
}