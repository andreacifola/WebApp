package controller.payment;

import model.payment.Status;


public interface PaymentObserver {
    void update(Status status); //nell'update implementato accedere all'attributo transaction e
                                // fare getStatus. In base allo stato comportarsi di conseguenza.
}
