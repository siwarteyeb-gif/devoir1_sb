package com.example.parfums22;

import com.example.parfums22.entities.Parfum;
import com.example.parfums22.repository.ParfumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Parfums22ApplicationTests {

    @Autowired
    private ParfumRepository parfumRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateParfum() {
        Parfum parf = new Parfum("Chanel", "Coco Mademoiselle", 250, "50ml", "contact@chanel.com");
        parfumRepository.save(parf);
    }
    @Test
    public void testDeleteParfum()
    {
        parfumRepository.deleteById(1L);;
    }
    @Test
    public void testListerTousPrafums()
    {
        List<Parfum> parfs = parfumRepository.findAll();
        for (Parfum p : parfs)
        {
            System.out.println(p);
        }
    }
}