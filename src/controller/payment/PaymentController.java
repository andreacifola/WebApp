package controller.payment;

import boundary.CreditCardSociety;
import model.User;
import model.language.payment.PaymentLanguage;
import model.payment.*;
import view.PaymentForm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by davidemagnanimi on 06/09/16 at 12:57.
 */
public class PaymentController {
    private Transaction transaction;

    public PaymentController(Double amount, User recipient) throws TransactionNotValid {
        this.transaction = new Transaction(amount, null, recipient.getIban());
    }

    public boolean confirmForm(String cardNumber, String firstName, String lastName, String expirationDate) {
        try {
            CreditCard creditCard = new CreditCard(cardNumber, firstName, lastName, expirationDate);
            transaction.setCreditCard(creditCard);
            return new CreditCardSociety(transaction).forwardPayment();
        } catch (CreditCardCredentialNotValid creditCardCredentialNotValid) {
            creditCardCredentialNotValid.printStackTrace();
            return false;
        }
    }
}
