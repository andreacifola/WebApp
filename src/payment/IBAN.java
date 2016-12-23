package payment;

import static payment.Utils.validateField;
import static payment.Utils.validationIBANRegex;
import static payment.Utils.validationNameRegex;

/**
 * Created by luca on 23/12/16.
 */
public class IBAN {
    private String number;
    private String ownerFirstName;
    private String ownerLastName;

    public IBAN(String number, String ownerFirstName, String ownerLastName) throws IBANCredentialNotValid {

        if (!validateField(number, validationIBANRegex))
            throw new IBANCredentialNotValid("Codice payment.IBAN inserito non valido: " + number);
        this.number = number;

        if (!validateField(ownerFirstName, validationNameRegex))
            throw new IBANCredentialNotValid("Nome non valido: " + ownerFirstName);
        this.ownerFirstName = ownerFirstName;

        if (!validateField(ownerLastName, validationNameRegex))
            throw new IBANCredentialNotValid("Cognome non valido: " + ownerLastName);
        this.ownerLastName = ownerLastName;
    }

    public String getNumber() {
        return number;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }
}
