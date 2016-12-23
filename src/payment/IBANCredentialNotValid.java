package payment;

/**
 * Created by luca on 23/12/16.
 */
public class IBANCredentialNotValid extends Exception {

    public IBANCredentialNotValid(String message) {
        super(message);
    }
}
