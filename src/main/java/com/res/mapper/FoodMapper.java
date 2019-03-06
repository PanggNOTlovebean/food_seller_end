package com.res.mapper;

import com.res.object.Food;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FoodMapper {
    @Select("select * from food")
    @Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<Food> getAll();

    @Select("select * from food where id = #{id}")
    Food getById(Integer id);

    @Update("update food set price=#{price},introduction=#{introduction} where id=#{id}")
    void updateFoodById(Food food);
    @Select("select * from food where name = #{name}")

    Food findByName(String name);
}
