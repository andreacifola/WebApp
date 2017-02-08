package model.payment;

/**
 * Created by davidemagnanimi on 06/09/16 at 10:23.
 */
public class Transaction {
    private Double amount;
    private CreditCard creditCard;
    private IBAN iban;

    public Transaction(Double amount, CreditCard creditCard, IBAN iban) throws TransactionNotValid {
        if (amount.compareTo(0d) < 0)
            throw new TransactionNotValid("Importo inserito non valido: " + amount);
        this.amount = amount;
        this.creditCard = creditCard;
        this.iban = iban;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public IBAN getIban() {
        return iban;
    }

    public void setIban(IBAN iban) {
        this.iban = iban;
    }
}
