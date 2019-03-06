package com.res.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodRepositoryTest {
    @Autowired
    FoodRepository foodRepository;
    @Test
    public void findAll()
    {
        System.out.println(foodRepository.findAll());
    }
}