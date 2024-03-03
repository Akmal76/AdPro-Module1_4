package enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    SUCCESS("SUCCESS"),
    REJECTED("REJECTED");

    private final String value;

    private PaymentStatus(String value) {
        this.value = value;
    }

    public static boolean contains (String param) {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (paymentStatus.getValue().equals(param)) {
                return true;
            }
        }
        return false;
    }
}
