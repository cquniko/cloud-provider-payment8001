package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {
    public Payment selectById(Long id);
    public int addPayment(Payment payment);
}
