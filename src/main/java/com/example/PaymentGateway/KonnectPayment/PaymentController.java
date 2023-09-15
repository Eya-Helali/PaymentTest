package com.example.PaymentGateway.KonnectPayment;

import com.example.PaymentGateway.Order.PaymentRequest;
import com.example.PaymentGateway.Order.PaymentResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200")
public class PaymentController {
    private final PaymentService paymentService;


        @PostMapping(path="/init-payment")
        public ResponseEntity<PaymentResponse > initPayment (@RequestBody PaymentRequest paymentRequest ) {
            PaymentResponse  response= paymentService.initPayment(paymentRequest);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }


    }
