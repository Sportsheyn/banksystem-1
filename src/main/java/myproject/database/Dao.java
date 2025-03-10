package myproject.database;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    T get(int id); // Optional<T>

    List<T> getAll();

    void save(T t);

    void update(T t); //, String[] params

    void delete(T t);

}
