package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentServiceImpl;
    @Value("${server.port}")
    private String serverport;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        System.out.println(payment);
        int result = paymentServiceImpl.addPayment(payment);
        if (result>0){
            return new CommonResult("success!"+serverport,200,result);
        }else {
            return  new CommonResult("fail！"+serverport,444);
        }
    }
    @GetMapping(value = "/payment/select/{id}")
    public CommonResult<Payment> select(@PathVariable("id") Long id){
        Payment result = paymentServiceImpl.selectById(id);
        if (result!=null){
            return new CommonResult("success!"+serverport,200,result);
        }else {
            return  new CommonResult("fail！"+serverport,444,null);
        }
    }
}
