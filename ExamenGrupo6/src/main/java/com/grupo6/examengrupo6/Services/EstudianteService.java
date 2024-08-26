package com.grupo6.examengrupo6.Services;


import com.grupo6.examengrupo6.Exeptions.EstudianteNotFoundException;
import com.grupo6.examengrupo6.Interface.EstudianteRepository;
import com.grupo6.examengrupo6.Model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repo;

    public List<Estudiante> listAll() {
        return (List<Estudiante>) repo.findAll();
    }

    public void save(Estudiante estudiante) {
        repo.save(estudiante);
    }

    public Estudiante get(Integer id) throws EstudianteNotFoundException {
        Optional<Estudiante> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new EstudianteNotFoundException("No se pudo encontrar ningún estudiante con el ID " + id);
    }

    public void delete(Integer id) throws EstudianteNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new EstudianteNotFoundException("No se pudo encontrar ningún estudiante con el ID " + id);
        }
        repo.deleteById(id);
    }
}

