package com.res.service.impl;

import com.res.object.OrderPaid;
import com.res.repository.OrderPaidRepository;
import com.res.service.OrderPaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderPaidServiceImpl implements OrderPaidService {
    @Autowired
    OrderPaidRepository repository;
    @Override
    public List<OrderPaid> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<OrderPaid> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public OrderPaid getById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(OrderPaid orderPaid) {
        repository.save(orderPaid);
    }
}
