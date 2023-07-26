package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T,ID> {
    public T save(T entity);
    public List<T> findAll();
    public Optional<T> findById();
    public Optional<T> findByName();
    public void delete(T entitiy);
    boolean existsById(ID id);
    public long count();
    public void deleteById(ID id);
}
