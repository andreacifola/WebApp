package controller.payment;

import boundary.CreditCardSociety;
import model.User;
import model.language.payment.PaymentLanguage;
import model.payment.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by davidemagnanimi on 06/09/16 at 12:57.
 */
public class PaymentController {
    private Transaction transaction;
    private PaymentObserver observer;

    public PaymentController(Double amount, User recipient) throws TransactionNotValid {
        this.transaction = new Transaction(amount, null, recipient.getIban(), Status.Processing);
        createView(String.format("%.2f", amount));
    }


    private void createView(String amount) {
        JFrame frame = new JFrame(PaymentLanguage.payment_payment);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void confirmForm(String cardNumber, String ownerFirstName, String ownerLastName, String expirationDate) {
        try {
            CreditCard creditCard = new CreditCard(cardNumber, ownerFirstName, ownerLastName, expirationDate);
            transaction.setCreditCard(creditCard);
            if (new CreditCardSociety(transaction).forwardPayment())
                setTransactionStatus(Status.Approved);
            else
                setTransactionStatus(Status.Failed);
        } catch (CreditCardCredentialNotValid creditCardCredentialNotValid) {
            JOptionPane.showMessageDialog(new Frame(), creditCardCredentialNotValid.getMessage());
            creditCardCredentialNotValid.printStackTrace();
        }
    }

    public void attachObserver(PaymentObserver observer) {
        this.observer = observer;
    }

    /*
    public void detachObserver(){
        this.observer = null;
    }
    */

    public void setTransactionStatus(Status status) {
        try {
            this.observer.update(status);
            this.transaction.setStatus(status);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
