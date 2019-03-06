package com.res.mapper;

import com.res.object.FoodRaw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodRawMapper {
    @Select("select * from food_raw where food_id=#{id}")
    @Results({
            @Result(column = "food_id", property = "foodId"),
            @Result(column = "raw_id", property = "rawId"),
    })
    List<FoodRaw> findByFoodId(Integer id);
}

