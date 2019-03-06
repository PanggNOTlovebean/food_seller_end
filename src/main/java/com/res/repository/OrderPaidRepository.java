package com.res.repository;

import com.res.object.Food;
import com.res.object.OrderPaid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPaidRepository extends JpaRepository<OrderPaid,String> {
}
