package com.student.guru.springframework.petclinic.controller;

import com.student.guru.springframework.petclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/", "/vets.html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
