package com.student.guru.springframework.petclinic.service;

import com.student.guru.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
