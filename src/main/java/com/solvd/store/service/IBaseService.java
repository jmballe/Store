package com.solvd.store.service;

public interface IBaseService <T> {
    T getEntityById(int id);
    void update(T entity);
    void create(T entity);
    void delete(T entity);
}
