package core;

import java.util.List;

/**
 * Using Data Access Object Pattern - DA0
 * @param <T> Using generic type to reuse
 * Seperation of Logic
 * Loose coupling
 * Encapsulate code to perform CRUD, prevent implement individually different part of Application
 */
public interface IGenericDAO<T>  { // CRUD

    /**
     * Create data
     * @param query
     * @param params
     */
    boolean create(final String query, final Object... params);

    /**
     * Read data
     * @param query
     * @param params
     * @param <T>
     * @param IRowMapper
     * @return
     */
    <T> List<T> read(final String query, final IRowMapper<T> IRowMapper, final Object... params);

    /**
     * Update data
     * @param query
     * @param params
     */
    boolean update(final String query,final Object... params);

    /**
     * Delete data
     * @param query
     * @param params
     */
    boolean delete(final String query,final Object... params);

    /**
     * Count something
     * @param query
     * @param params
     * @return
     */
    int count(final  String query, final Object... params);
}
