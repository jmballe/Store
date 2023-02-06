package com.solvd.store.dao;

public interface IBaseDAO<T>{
    T getEntityById(int id);
    Boolean update(T entity);
    T create(T entity);
    Boolean delete(T entity);

}
