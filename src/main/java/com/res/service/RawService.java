package com.res.service;

import com.res.object.Raw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RawService {
    List<Raw> findAll();
    Page<Raw> findAll(Pageable pageable);
    Raw getById(Integer id);
    void save(Raw raw);
}
