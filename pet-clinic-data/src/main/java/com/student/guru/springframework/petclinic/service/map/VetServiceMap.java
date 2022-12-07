package com.student.guru.springframework.petclinic.service.map;

import com.student.guru.springframework.petclinic.model.Speciality;
import com.student.guru.springframework.petclinic.model.Vet;
import com.student.guru.springframework.petclinic.service.CrudService;
import com.student.guru.springframework.petclinic.service.SpecialityService;
import com.student.guru.springframework.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long>, VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() > 0)
            object.getSpecialities()
                    .stream()
                    .filter(eachSpeciality -> eachSpeciality.getId() == null)
                    .forEach(eachSpeciality -> {
                        Speciality savedSpeciality = specialityService.save(eachSpeciality);
                        eachSpeciality.setId(savedSpeciality.getId());
                    });
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
