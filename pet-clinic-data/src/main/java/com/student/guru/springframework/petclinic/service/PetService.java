package com.student.guru.springframework.petclinic.service;

import com.student.guru.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
