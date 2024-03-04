package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

public class PaymentVoucherCode extends Payment {
    public PaymentVoucherCode(String id, String method, Map<String, String> paymentData) {
        super(id, method, paymentData);
    }

    public PaymentVoucherCode(String id, String method, Map<String, String> paymentData, String status) {
        super(id, method, paymentData, status);
    }

    @Override
    public void setPaymentData(Map<String, String> paymentData) {
    }
}
