package controller.payment;

import model.payment.Status;


public interface PaymentObserver {
    /**
     * Notify on change of the state
     * @param status new status
     */
    void update(Status status);
}
