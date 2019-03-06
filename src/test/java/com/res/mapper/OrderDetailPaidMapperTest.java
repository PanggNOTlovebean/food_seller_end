package com.res.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailPaidMapperTest {
    @Autowired
    OrderDetailPaidMapper mapper;

    @Test
    public void getByOrderId() {
//        System.out.println(mapper.getAll());
        System.out.println( mapper.getByOrderId("1551777291959"));
    }
}