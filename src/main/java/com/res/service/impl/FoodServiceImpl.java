package com.res.service.impl;

import com.res.object.Food;
import com.res.repository.FoodRepository;
import com.res.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Page<Food> findAll(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    @Override
    public Food getById(Integer id) {
        return foodRepository.findById(id).get();
    }

    @Override
    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public void save(Food food) {
        foodRepository.save(food);
    }


}
