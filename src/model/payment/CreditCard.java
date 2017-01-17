package model.payment;


import java.text.ParseException;
import java.util.Date;

import static model.payment.Utils.*;

/**
 * Created by davidemagnanimi on 05/09/16 at 14:14.
 */
public class CreditCard {

    private String cardNumber;
    private String ownerFirstName;
    private String ownerLastName;
    private Date expirationDate;

    public CreditCard(String cardNumber, String ownerFirstName, String ownerLastName, String expirationDate) throws CreditCardCredentialNotValid {

        if (!validateField(cardNumber, validationCardNumberRegex))
            throw new CreditCardCredentialNotValid("Numero di carta non valido: " + cardNumber);
        this.cardNumber = cardNumber;

        if (!validateField(ownerFirstName, validationNameRegex))
            throw new CreditCardCredentialNotValid("Nome non valido: " + ownerFirstName);
        this.ownerFirstName = ownerFirstName;

        if (!validateField(ownerLastName, validationNameRegex))
            throw new CreditCardCredentialNotValid("Cognome non valido: " + ownerLastName);
        this.ownerLastName = ownerLastName;

        try {
            this.expirationDate = parseDate(expirationDate);
        } catch (ParseException e) {
            throw new CreditCardCredentialNotValid("Data non valida: " + expirationDate);
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
