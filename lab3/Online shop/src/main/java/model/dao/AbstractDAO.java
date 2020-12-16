package model.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO <K, E> {
     List<E> findAll();
     List<E>findAll(K parameter);
     E findEntityById(K id);
    E findEntityByName(String name) throws SQLException;
    void delete(K id);
     boolean deleteEntity(E entity);
     void create(E entity) throws SQLException;
     void update(E entity);

}
