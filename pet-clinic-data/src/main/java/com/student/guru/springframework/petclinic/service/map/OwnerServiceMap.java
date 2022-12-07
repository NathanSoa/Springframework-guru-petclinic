package com.student.guru.springframework.petclinic.service.map;

import com.student.guru.springframework.petclinic.model.Owner;
import com.student.guru.springframework.petclinic.model.Pet;
import com.student.guru.springframework.petclinic.service.CrudService;
import com.student.guru.springframework.petclinic.service.OwnerService;
import com.student.guru.springframework.petclinic.service.PetService;
import com.student.guru.springframework.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService, CrudService<Owner, Long> {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object == null)
            return null;

        if(object.getPets() != null) {

            object.getPets().forEach(eachPet -> {

                if(eachPet.getPetType() == null)
                    throw new RuntimeException("Pet Type is required");

                if(eachPet.getPetType().getId() == null)
                    eachPet.setPetType(petTypeService.save(eachPet.getPetType()));

                if(eachPet.getId() == null){
                    Pet savedPet = petService.save(eachPet);
                    eachPet.setId(savedPet.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
