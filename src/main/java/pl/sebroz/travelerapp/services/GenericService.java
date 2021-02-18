package pl.sebroz.travelerapp.services;

import java.util.List;

public interface GenericService<T> {
    List<T> findAll();

    T getOne(Long id);

    void delete(Long id);

    void save(T t);
}
