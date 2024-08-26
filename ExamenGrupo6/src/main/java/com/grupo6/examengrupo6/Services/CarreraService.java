package com.grupo6.examengrupo6.Services;

import com.grupo6.examengrupo6.Exeptions.CarreraNotFoundException;
import com.grupo6.examengrupo6.Interface.CarreraRepository;
import com.grupo6.examengrupo6.Model.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository repo;

    public List<Carrera> listAll() {
        return (List<Carrera>) repo.findAll();
    }

    public void save(Carrera carrera) {
        repo.save(carrera);
    }

    public Carrera get(Integer id) throws CarreraNotFoundException {
        Optional<Carrera> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CarreraNotFoundException("No se pudo encontrar ninguna carrera con el ID " + id);

    }

    public void delete(Integer id) throws CarreraNotFoundException {
        Long count = repo.countByCarreraId(id);
        if (count == null || count == 0) {
            throw new CarreraNotFoundException("No se pudo encontrar ninguna carrera con el ID " + id);
        }
        repo.deleteById(id);
    }

}
