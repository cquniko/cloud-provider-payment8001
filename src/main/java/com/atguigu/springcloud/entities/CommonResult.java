package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    private String message;
    private Integer code;
    private T data;
    public CommonResult(String message,Integer code){
        this(message,code,null);
    }
}
