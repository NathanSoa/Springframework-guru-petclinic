package com.student.guru.springframework.petclinic.bootstrap;

import com.student.guru.springframework.petclinic.model.Owner;
import com.student.guru.springframework.petclinic.model.PetType;
import com.student.guru.springframework.petclinic.model.Vet;
import com.student.guru.springframework.petclinic.service.OwnerService;
import com.student.guru.springframework.petclinic.service.PetTypeService;
import com.student.guru.springframework.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedDogPetType = petTypeService.save(dog);
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loading Pet Types...");

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Jordan");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loading Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Neymar");
        vet1.setLastName("Junior");

        Vet vet2 = new Vet();
        vet2.setFirstName("Roger");
        vet2.setLastName("Guedes");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loading Vets...");
    }
}
