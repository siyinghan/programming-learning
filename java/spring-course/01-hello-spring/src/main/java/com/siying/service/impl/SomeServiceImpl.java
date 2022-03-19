package com.siying.service.impl;

import com.siying.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl() {
        System.out.println("SomeServiceImpl的无参构造方法");
    }

    @Override
    public void doSome() {
        System.out.println("执行了SomeServiceImpl的dosome()方法");
    }
}
