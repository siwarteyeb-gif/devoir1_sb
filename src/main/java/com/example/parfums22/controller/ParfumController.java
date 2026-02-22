package com.example.parfums22.controllers;

import com.example.parfums22.entities.Parfum;
import com.example.parfums22.service.ParfumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/parfums")
public class ParfumController {

    @Autowired
    private ParfumService parfumService;

    // Affichage avec pagination
    @RequestMapping("/Liste")
    public String listeParfums(ModelMap modelMap,
                               @RequestParam(name="page", defaultValue="0") int page,
                               @RequestParam(name="size", defaultValue="2") int size) {
        Page<Parfum> parfumsPage = parfumService.getAllParfumsParPage(page, size);
        List<Parfum> parfums = parfumsPage.getContent();
        modelMap.addAttribute("parfums", parfums);
        modelMap.addAttribute("pages", new int[parfumsPage.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "ListeParfum";
    }

    // Formulaire d'ajout
    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("parfum", new Parfum());
        modelMap.addAttribute("mode", "new");
        return "formParfum";
    }

    // Enregistrement
    @RequestMapping("/saveParfum")
    public String saveParfum(@Valid Parfum parfum, BindingResult bindingResult,
                             @RequestParam(name="page", defaultValue="0") int page,
                             @RequestParam(name="size", defaultValue="2") int size) {
        int currentPage;
        boolean isNew = false;

        if(bindingResult.hasErrors()) return "formParfum";

        if(parfum.getId() == null) isNew = true;

        parfumService.saveParfum(parfum);

        if(isNew) {
            Page<Parfum> parfums = parfumService.getAllParfumsParPage(page, size);
            currentPage = parfums.getTotalPages() - 1;
        } else {
            currentPage = page;
        }

        return "redirect:/parfums/Liste?page=" + currentPage + "&size=" + size;
    }

    // Suppression
    @RequestMapping("/supprimerParfum")
    public String supprimerProduit(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam (name="page",defaultValue = "0") int page,
                                   @RequestParam (name="size", defaultValue = "2") int size) {
        parfumService.deleteParfumById(id);
        Page<Parfum> parfs = parfumService.getAllParfumsParPage(page,
                size);
        modelMap.addAttribute("produits", parfs);
        modelMap.addAttribute("pages", new int[parfs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeParfum";
    }

    // Formulaire de modification
    @RequestMapping("/modifierParfum")
    public String editerParfum(@RequestParam("id") Long id,
                               ModelMap modelMap,
                               @RequestParam(name="page", defaultValue="0") int page,
                               @RequestParam(name="size", defaultValue="2") int size) {
        Parfum p = parfumService.getParfum(id);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("parfum", p);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formParfum";
    }

    // Mise à jour
    @RequestMapping("/updateParfum")
    public String updateParfum(@ModelAttribute("parfum") Parfum parfum,
                               ModelMap modelMap) {
        parfumService.updateParfum(parfum);
        List<Parfum> parfums = parfumService.getAllParfums();
        modelMap.addAttribute("parfums", parfums);
        return "ListeParfum";
    }
}