package com.res.service.impl;

import com.res.object.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodServiceImplTest {
    @Autowired
    FoodServiceImpl foodService;
    @Test
    public void findAll() {
        System.out.println(foodService.findAll());
    }

    @Test
    public void findAll1() {
        PageRequest request= PageRequest.of(1-1,10);
        System.out.println(foodService.findAll(request));

    }

    @Test
    public void getById() {
        Integer integer=1;
        System.out.println(foodService.getById(integer));
    }

    @Test
    public void updateFood() {
        Food food=new Food();
        food.setId(1);
        food.setName("鲶鱼");
        food.setPrice(33);
        foodService.updateFood(food);
    }

    @Test
    public void save() {
        Food food=new Food();
        food.setId(1);
        food.setName("鲶鱼");
        food.setPrice(33);
        foodService.save(food);
    }
}