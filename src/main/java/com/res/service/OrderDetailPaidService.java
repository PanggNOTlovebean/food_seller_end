package com.res.service;

import com.res.object.OrderDetailPaid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderDetailPaidService {
    List<OrderDetailPaid> findAll();
    Page<OrderDetailPaid> findAll(Pageable pageable);
    OrderDetailPaid getById(String id);
    void save(OrderDetailPaid orderDetailPaid);
}
