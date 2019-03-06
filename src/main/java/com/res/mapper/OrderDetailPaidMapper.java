package com.res.mapper;

import com.res.object.Food;
import com.res.object.OrderDetailPaid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface OrderDetailPaidMapper {
    @Select("select * from order_detail_paid where order_id=#{orderId}")
    @Results(
            @Result(column = "order_id" ,property = "orderId")
    )
    List<OrderDetailPaid> getByOrderId(String orderId);

    @Select("select * from order_detail_paid")
    @Results(
            @Result(column = "order_id" ,property = "orderId")
    )
    List<OrderDetailPaid> getAll();
}
