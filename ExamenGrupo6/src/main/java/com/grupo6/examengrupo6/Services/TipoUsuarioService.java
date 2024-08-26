package com.grupo6.examengrupo6.Services;

import com.grupo6.examengrupo6.Interface.TipousuarioRepository;
import com.grupo6.examengrupo6.Model.Tipousuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {
    @Autowired
    private TipousuarioRepository repo;

    public List<Tipousuario> listAll() {
        return (List<Tipousuario>) repo.findAll();
    }
}
