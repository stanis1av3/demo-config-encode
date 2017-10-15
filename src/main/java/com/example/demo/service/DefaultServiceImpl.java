package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by stas on 10/15/2017.
 */
@Service
public class DefaultServiceImpl {

    @Value("${config.property.one}")
    String propertyOne;


    @Value("${config.property.encoded}")
    String propertyEncoded;

    public void createSomeData(){
        System.out.println("config property one: "+propertyOne);
        System.out.println("config property encoded: "+propertyEncoded);
    }

}
