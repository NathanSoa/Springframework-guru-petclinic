package com.student.guru.springframework.petclinic.bootstrap;

import com.student.guru.springframework.petclinic.model.*;
import com.student.guru.springframework.petclinic.service.OwnerService;
import com.student.guru.springframework.petclinic.service.PetTypeService;
import com.student.guru.springframework.petclinic.service.SpecialityService;
import com.student.guru.springframework.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(noDataWasLoaded())
            loadData();
    }

    private boolean noDataWasLoaded() {
        return petTypeService.findAll().size() == 0;
    }

    private void loadData() {
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
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("12321321321");

        Pet johnPet = new Pet();
        johnPet.setPetType(savedDogPetType);
        johnPet.setOwner(owner1);
        johnPet.setBirthDate(LocalDate.now());
        johnPet.setName("Doggo");
        owner1.getPets().add(johnPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Jordan");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("127646521321");

        Pet michaelPet = new Pet();
        michaelPet.setPetType(savedCatPetType);
        michaelPet.setOwner(owner2);
        michaelPet.setBirthDate(LocalDate.now());
        michaelPet.setName("Cat");
        owner2.getPets().add(michaelPet);

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loading Owners...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Loading Specialities...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Neymar");
        vet1.setLastName("Junior");
        vet1.getSpecialities().add(savedRadiology);
        vet1.getSpecialities().add(savedSurgery);

        Vet vet2 = new Vet();
        vet2.setFirstName("Roger");
        vet2.setLastName("Guedes");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loading Vets...");
    }
}
