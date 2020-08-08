package ru.toxic.repository;

import io.vavr.Tuple;
import org.springframework.stereotype.Repository;
import ru.toxic.model.Table;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public interface TableRepository {

    ConcurrentMap<Tuple, Table> TABLE_CONCURRENT_MAP = new ConcurrentHashMap<>();

    Table getTable(Tuple key);

    Collection<Table> getAllTables();

    void save(Table table);

    void save(Table table, String key);

}
