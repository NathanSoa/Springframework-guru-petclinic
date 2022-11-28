package com.student.guru.springframework.petclinic.service.map;

import com.student.guru.springframework.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private final Map<Long, T> map = new HashMap<>();

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {
        if(object == null)
            throw new RuntimeException("Object should not be null!");


        if(object.getId() == null)
            object.setId(getNextId());

        map.put(object.getId(), object);

        return object;
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId(){
        Long nextId;

        try{
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
