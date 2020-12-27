package application.model.dao;

import application.model.exception.MySQLException;

import java.util.List;

public interface BaseDAO<K, E, D> {
    List<E> findAll() throws MySQLException;

    List<E> findAll(K parameter) throws MySQLException;

    E findEntityById(K id) throws MySQLException;

    E findEntityByName(String name) throws MySQLException;

    boolean delete(K id) throws MySQLException;

    void create(D entity) throws MySQLException;

    void update(D entity) throws MySQLException;

    void updateEntity(E entity) throws MySQLException;

}
