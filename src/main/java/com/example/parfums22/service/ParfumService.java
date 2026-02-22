package com.example.parfums22.service;

import com.example.parfums22.entities.Parfum;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ParfumService {
    Parfum saveParfum(Parfum p);
    Parfum updateParfum(Parfum p);
    void deleteParfum(Parfum p);
    void deleteParfumById(Long id);
    Parfum getParfum(Long id);
    List<Parfum> getAllParfums();
    Page<Parfum> getAllParfumsParPage(int page, int size);
}
