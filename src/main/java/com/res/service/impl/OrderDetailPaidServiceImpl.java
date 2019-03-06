package com.res.service.impl;

import com.res.object.OrderDetailPaid;
import com.res.repository.OrderDetailPaidRepository;
import com.res.service.OrderDetailPaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailPaidServiceImpl implements OrderDetailPaidService {
    @Autowired
    OrderDetailPaidRepository repository;
    @Override
    public List<OrderDetailPaid> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<OrderDetailPaid> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public OrderDetailPaid getById(String id) {
        return repository.findById(id).get();
    }


    @Override
    public void save(OrderDetailPaid orderDetailPaid) {
        repository.save(orderDetailPaid);
    }
}
