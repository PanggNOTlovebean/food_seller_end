package com.res.mapper;

import com.res.object.Raw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RawMapper {
    @Select("select * from raw where id=#{id}")
    Raw findById(Integer id);
    @Update("update raw set number=#{0} where id=#{1}")
    void changeNumById(Float num,Integer id);
}
