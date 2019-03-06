package com.res.service;

import com.res.object.OrderPaid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderPaidService {
    List<OrderPaid> findAll();
    Page<OrderPaid> findAll(Pageable pageable);
    OrderPaid getById(String id);
    void save(OrderPaid orderPaid);
}
