package model.payment;

/**
 * Created by davidemagnanimi on 06/09/16 at 10:30.
 */
public class TransactionNotValid extends Exception {
    public TransactionNotValid(String message) {
        super(message);
    }
}
