package com.grupo6.examengrupo6.Interface;

import com.grupo6.examengrupo6.Model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    public Long countById(Integer id);
}
