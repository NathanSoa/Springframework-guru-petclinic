package com.student.guru.springframework.petclinic.bootstrap;

import com.student.guru.springframework.petclinic.model.Owner;
import com.student.guru.springframework.petclinic.model.Vet;
import com.student.guru.springframework.petclinic.service.OwnerService;
import com.student.guru.springframework.petclinic.service.VetService;
import com.student.guru.springframework.petclinic.service.map.OwnerServiceMap;
import com.student.guru.springframework.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Michael");
        owner2.setLastName("Jordan");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loading Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Neymar");
        vet1.setLastName("Junior");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Roger");
        vet2.setLastName("Guedes");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loading Vets...");
    }
}
