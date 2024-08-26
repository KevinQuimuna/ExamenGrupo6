package com.grupo6.examengrupo6.Interface;

import com.grupo6.examengrupo6.Model.Carrera;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    public Long countByCarreraId(Integer carreraId);


}
