package com.res.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderPaidRepositoryTest {
    @Autowired
    OrderPaidRepository orderPaidRepository;
    @Test
    public void findAll()
    {
        System.out.println(orderPaidRepository.findAll());
    }
}