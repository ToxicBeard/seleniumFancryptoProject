package is.toxic.repository;

import org.jooq.Condition;

import java.util.List;

public interface CrudRepository<G ,T> {

    Integer SUCCESS_CODE = 1;

    T insert(T t);

    T update(T t);

    T find(G id);

    T find(Condition condition);

    List<T> findAll(Condition condition);

    Boolean delete(G id);

}
