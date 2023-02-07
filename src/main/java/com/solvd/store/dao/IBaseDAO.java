package com.solvd.store.dao;


public interface IBaseDAO<T>{
    T getEntityById(int id);
    void update(T entity);
    void create(T entity);
    void delete(T entity);

}
