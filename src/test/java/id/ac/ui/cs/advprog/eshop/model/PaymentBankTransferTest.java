package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentMethod;
import enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentBankTransferTest {
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
    }

    @Test
    void testSetPaymentData() {
        this.paymentData.put("bankName", "BCA");
        this.paymentData.put("referenceCode", "1234567890");
        PaymentBankTransfer payment = new PaymentBankTransfer("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.BANK_TRANSFER.getValue(), this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentDataWithEmptyBankName() {
        this.paymentData.put("bankName", "");
        this.paymentData.put("referenceCode", "1234567890");
        PaymentBankTransfer payment = new PaymentBankTransfer("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.BANK_TRANSFER.getValue(), this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentDataWithEmptyReferenceCode() {
        this.paymentData.put("bankName", "BCA");
        this.paymentData.put("referenceCode", "");
        PaymentBankTransfer payment = new PaymentBankTransfer("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.BANK_TRANSFER.getValue(), this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentDataWithEmptyPaymentData() {
        PaymentBankTransfer payment = new PaymentBankTransfer("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.BANK_TRANSFER.getValue(), this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }
}
