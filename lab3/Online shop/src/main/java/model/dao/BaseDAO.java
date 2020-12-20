package lab3.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<K, E> {
     List<E> findAll();
     List<E>findAll(K parameter);
     E findEntityById(K id);
    E findEntityByName(String name) throws SQLException;
    boolean delete(K id);
     boolean deleteEntity(E entity);
     void create(E entity) throws SQLException;
     void update(E entity);

}
