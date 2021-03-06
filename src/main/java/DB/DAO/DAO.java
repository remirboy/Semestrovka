package DB.DAO;

        import java.lang.reflect.InvocationTargetException;
        import java.sql.SQLException;
        import java.util.List;
        import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(int id);

    List<T> getAll();

    void add(T t) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException;

    void update(T t);

    void delete(T t);
}
