package com.res.service;

import com.res.object.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodService {
    List<Food> findAll();
    Page<Food> findAll(Pageable pageable);
    Food getById(Integer id);
    Food updateFood(Food food);
    void save(Food food);
}
