package com.res.service.impl;

import com.res.object.Raw;
import com.res.repository.RawRepository;
import com.res.service.RawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawServiceImpl implements RawService {
    @Autowired
    RawRepository rawRepository;

    @Override
    public List<Raw> findAll() {
        return rawRepository.findAll();
    }

    @Override
    public Page<Raw> findAll(Pageable pageable) {
        return rawRepository.findAll(pageable);
    }

    @Override
    public Raw getById(Integer id) {
        return rawRepository.findById(id).get();
    }

    @Override
    public void save(Raw raw) {
        rawRepository.save(raw);
    }
}
