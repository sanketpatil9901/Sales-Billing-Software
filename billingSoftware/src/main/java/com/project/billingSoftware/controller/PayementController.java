package com.project.billingSoftware.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.billingSoftware.io.OrderResponse;
import com.project.billingSoftware.io.PaymentRequest;
import com.project.billingSoftware.io.PaymentVerificationRequest;
import com.project.billingSoftware.io.RazorpayOrderResponse;
import com.project.billingSoftware.service.OrderService;
import com.project.billingSoftware.service.RazorPayService;
import com.razorpay.RazorpayException;

import lombok.RequiredArgsConstructor;

@RequestMapping("/payments")
@RequiredArgsConstructor
public class PayementController {
    private final RazorPayService razorPayService;
    private final OrderService orderService;

    @PostMapping("/create-order")
    @ResponseStatus(HttpStatus.CREATED)
    public RazorpayOrderResponse creatRazorpayOrder(@RequestBody PaymentRequest request) throws RazorpayException{
        return razorPayService.createOrder(request.getAmount(), request.getCurrency());
    }

    public OrderResponse verifyPayment(@RequestBody PaymentVerificationRequest request) {
        return orderService.verifyPayment(request);
    }
}
