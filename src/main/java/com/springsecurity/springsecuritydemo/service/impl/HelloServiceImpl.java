package com.springsecurity.springsecuritydemo.service.impl;


import com.springsecurity.springsecuritydemo.entity.Hello;
import com.springsecurity.springsecuritydemo.mapper.HelloMapper;
import com.springsecurity.springsecuritydemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private HelloMapper mapper;


    @Override
    public void save(Hello hello) {
        mapper.save(hello);
    }

    @Override
    public Optional<Hello> findById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public Iterable<Hello> findAll() {
        return mapper.findAll();
    }

    @Override
    public void deleteById(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public void deleteAll() {
        mapper.deleteAll();
    }

    @Override
    public List<Hello> findByTitle(String title) {
        return mapper.findByTitle(title);
    }

    @Override
    public List<Hello> findByTitle(String title, Pageable pageable) {
        return mapper.findByTitle(title, pageable);
    }
}
