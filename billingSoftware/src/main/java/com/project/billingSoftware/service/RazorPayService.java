package com.project.billingSoftware.service;

import com.project.billingSoftware.io.RazorpayOrderResponse;
import com.razorpay.RazorpayException;

public interface  RazorPayService {
    RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException;
}
