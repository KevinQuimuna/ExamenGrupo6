package com.grupo6.examengrupo6.Interface;

import com.grupo6.examengrupo6.Model.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> {
    public Long countById(Integer id);
}
