package view;

import controller.language.LanguageController;
import controller.payment.PaymentController;
import model.language.payment.PaymentLanguage;
import model.payment.Status;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by davidemagnanimi on 06/09/16 at 11:42.
 */
public class PaymentForm {
    private JTextField jtextField_CreditCardNumber;
    private JTextField jtextField_CreditCardFirstNameOwner;
    private JTextField jtextField_CreditCardLastNameOwner;
    private JTextField jtextField_ExpirationDate;
    private JButton jButton_cancelPayment;
    private JButton jButton_confirmPayment;
    private JButton jButton_englishLanguage;
    private JButton jButton_italianLanguage;
    private JLabel jLabel_creditCardNumberPayment;
    private JLabel jLabel_creditCardFirstNameOwnerPayment;
    private JLabel jLabel_creditCardLastNameOwnerPayment;
    private JLabel jLabel_expirationDatePayment;
    private JLabel jLabel_amountPayment;
    private JLabel jLabel_amountOfTransaction;
    private JPanel panelMain;
    private JLabel jLabel_payment;

    private PaymentController paymentController;

    public PaymentForm(JFrame frame, PaymentController paymentController, String amount) {
        this.paymentController = paymentController;
        jLabel_amountOfTransaction.setText(amount + " €");

        setLabelTextLanguagePayment();
        jButton_italianLanguage.addActionListener(e -> {

            LanguageController.setItalianLanguage();
            setLabelTextLanguagePayment();
        });

        jButton_englishLanguage.addActionListener(e -> {

            LanguageController.setEnglishLanguage();
            setLabelTextLanguagePayment();
                }

        );

        /*
        jButton_cancelPayment.addActionListener(e ->
                paymentController.setTransactionStatus(Status.Cancelled)
        );

        jButton_confirmPayment.addActionListener(e ->
                paymentController.confirmForm(jtextField_CreditCardNumber.getText().trim(),
                        jtextField_CreditCardFirstNameOwner.getText().trim(),
                        jtextField_CreditCardLastNameOwner.getText().trim(),
                        jtextField_ExpirationDate.getText().trim()));

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                paymentController.setTransactionStatus(Status.Cancelled);
            }
        });
        */

    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void setLabelTextLanguagePayment(){
        jLabel_payment.setText(PaymentLanguage.payment_payment);
        jLabel_creditCardFirstNameOwnerPayment.setText(PaymentLanguage.payment_nameOwner);
        jLabel_creditCardLastNameOwnerPayment.setText(PaymentLanguage.payment_surnameOwner);
        jLabel_creditCardNumberPayment.setText(PaymentLanguage.payment_creditaCardNumber);
        jLabel_expirationDatePayment.setText(PaymentLanguage.payment_expirationCard);
        jLabel_amountOfTransaction.setText(PaymentLanguage.payment_amount);
        jButton_cancelPayment.setText(PaymentLanguage.payment_cancel);
        jButton_confirmPayment.setText(PaymentLanguage.payment_confirm);
    }
}
