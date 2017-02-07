package boundary;

import model.payment.Transaction;


public class CreditCardSociety {
    private Transaction transaction;

    public CreditCardSociety(Transaction transaction) {
        this.transaction = transaction;
    }

    public boolean forwardPayment() {
        //TODO qui bisognerebbe invocare le API della società
        return true;
    }
}
