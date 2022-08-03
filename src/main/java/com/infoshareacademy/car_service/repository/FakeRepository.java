package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.entity.Entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class FakeRepository <T, E extends Entity<T>>{

    private final Map<T,E> fakeDb = new ConcurrentHashMap<>();

    public void save(E entity) {
        T id = entity.getId();
        if(id == null) {
            entity.setId(nextId());
        }
    }

    public E findById(T id) {
        return fakeDb.get(id);
    }
    abstract T nextId();
}
