package com.project.billingSoftware.service;

import java.time.LocalDate;
import java.util.List;

import com.project.billingSoftware.io.OrderRequest;
import com.project.billingSoftware.io.OrderResponse;
import com.project.billingSoftware.io.PaymentVerificationRequest;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);
    void deleteOrder(String orderId);
    List<OrderResponse> getLatestOrders();
    OrderResponse verifyPayment(PaymentVerificationRequest request);
    Double sumSalesByDate(LocalDate date);
    Long countByOrderDate(LocalDate date);
    List<OrderResponse> findRecentOrders();
}