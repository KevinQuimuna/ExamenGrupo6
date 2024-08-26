package com.grupo6.examengrupo6.Services;

import com.grupo6.examengrupo6.Interface.DepartamentoRepository;
import com.grupo6.examengrupo6.Model.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository repo;

    public List<Departamento> listAll() {
        return (List<Departamento>) repo.findAll();
    }
}
