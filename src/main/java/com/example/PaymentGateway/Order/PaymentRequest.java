package com.example.PaymentGateway.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

        private String receiverWalletId;
        private String token;
        private Float amount;
        private Type type;
        private String description;
        private Integer lifeSpan;
        private Boolean checkoutForm;
        private List<PaymentMethod> acceptedPaymentMethods = new ArrayList<>(Arrays.asList(
                PaymentMethod.WALLET,
                PaymentMethod.BANK_CARD,
                PaymentMethod.E_DINAR,
                PaymentMethod.FLOUCI)
        );
        private Boolean addPaymentFeesToAmount=false;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String orderId;
        private String webhook;
        private String silentWebhook;
        private String successUrl;
        private String failUrl;
        private String theme    ;
}
