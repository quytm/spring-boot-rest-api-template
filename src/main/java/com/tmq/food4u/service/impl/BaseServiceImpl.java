package com.tmq.food4u.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 11, 2019
 */
public class BaseServiceImpl<R extends CrudRepository<T, ID>, T, ID> {

    @Autowired
    protected R repo;

    public Optional<T> save(T entity) {
        entity = repo.save(entity);
        return Optional.ofNullable(entity);
    }

    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        return repo.saveAll(entities);
    }

    public Optional<T> findById(ID id) {
        return repo.findById(id);
    }

    public boolean existsById(ID id) {
        return repo.existsById(id);
    }

    public Iterable<T> findAll() {
        return repo.findAll();
    }

    public Iterable<T> findAllById(Iterable<ID> ids) {
        return repo.findAllById(ids);
    }

    public long count() {
        return repo.count();
    }

    public void deleteById(ID id) {
        repo.deleteById(id);
    }

    public void delete(T entity) {
        repo.delete(entity);
    }

    public void deleteAll(Iterable<? extends T> entities) {
        repo.deleteAll(entities);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

}
