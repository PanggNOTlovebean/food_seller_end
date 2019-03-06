package com.res.mapper;

import com.res.object.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodMapperTest {
    @Autowired FoodMapper foodMapper;
    @Test
    public void getAll() {
        System.out.println(foodMapper.getAll());
    }

    @Test
    public void getById() {
        System.out.println(foodMapper.getById(1));
    }

    @Test
    public void updateFoodById() {
        Food food=new Food();
        food.setId(1);
        food.setPrice(2);
        foodMapper.updateFoodById(food);
    }
}