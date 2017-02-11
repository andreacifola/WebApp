package boundary;

import model.payment.Transaction;


public class CreditCardSociety {
    private Transaction transaction;

    public CreditCardSociety(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * Forward transaction to bank
     * @return
     */
    public boolean forwardPayment() {
        //TODO qui bisognerebbe invocare le API della società
        return randomWithProbability(0.7);
    }

    /**
     * Random boolean with probabilty
     * @param probabilityTrue probability of true
     * @return true with a give probability
     */
    private boolean randomWithProbability(double probabilityTrue) {
        return Math.random() >= 1.0 - probabilityTrue;
    }
}
