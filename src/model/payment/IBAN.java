package model.payment;

import static model.payment.Utils.*;

/**
 * Created by davidemagnanimi on 06/09/16 at 09:56.
 */
public class IBAN {
    private String number;
    private String ownerFirstName;
    private String ownerLastName;

    public IBAN(String number, String ownerFirstName, String ownerLastName) throws IBANCredentialNotValid {

        if (!validateField(number, validationIBANRegex))
            throw new IBANCredentialNotValid("Codice IBAN inserito non valido: " + number);
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
