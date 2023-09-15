package com.example.PaymentGateway.KonnectPayment;


import com.example.PaymentGateway.Order.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;



@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${apiKey}")
    private String apiKey;

    @Value("${apiUrl}")
    private String apiUrl;

    public PaymentResponse  initPayment(PaymentRequest paymentRequest) {

        WebClient webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("x-api-key", apiKey)
                .build();

        PaymentRequest payment = new PaymentRequest();
        payment.setReceiverWalletId(paymentRequest.getReceiverWalletId());
        payment.setToken(paymentRequest.getToken());
        payment.setAmount(paymentRequest.getAmount());
        payment.setType(paymentRequest.getType());
        payment.setDescription(paymentRequest.getDescription());
        payment.setLifeSpan(paymentRequest.getLifeSpan());
        payment.setAcceptedPaymentMethods(paymentRequest.getAcceptedPaymentMethods());
        payment.setAddPaymentFeesToAmount(paymentRequest.getAddPaymentFeesToAmount());
        payment.setFirstName(paymentRequest.getFirstName());
        payment.setLastName(paymentRequest.getLastName());
        payment.setPhoneNumber(paymentRequest.getPhoneNumber());
        payment.setEmail(paymentRequest.getEmail());
        payment.setOrderId(paymentRequest.getOrderId());
        payment.setWebhook(paymentRequest.getWebhook());
        payment.setSilentWebhook(paymentRequest.getSilentWebhook());
        payment.setSuccessUrl(paymentRequest.getSuccessUrl());
        payment.setFailUrl(paymentRequest.getFailUrl());
        payment.setTheme(paymentRequest.getTheme());



        PaymentResponse  paymentResponse = webClient.post()
                .uri(apiUrl)
                .body(BodyInserters.fromValue(paymentRequest))
                .retrieve()
                .bodyToMono(PaymentResponse.class) // Deserialize the response as a PaymentResponse object
                .block();

        return paymentResponse;


    }



}
