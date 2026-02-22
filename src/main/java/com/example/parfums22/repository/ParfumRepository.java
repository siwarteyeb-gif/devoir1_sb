package com.example.parfums22.repository;

import com.example.parfums22.entities.Parfum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParfumRepository extends JpaRepository<Parfum, Long> {
}
