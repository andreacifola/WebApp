package bean;

import model.communication.Letter;

import java.io.Serializable;
import java.util.ArrayList;

public class ListLetterBean implements Serializable {
    int prev, next;
    private ArrayList<Letter> letters;

    public ListLetterBean() {
        letters = null;
        prev = 0;
        next = 0;
    }

    public ArrayList<Letter> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Letter> letters) {
        this.letters = letters;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}