package com.res.repository;

import com.res.object.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository  extends JpaRepository<Food,Integer> {

}
