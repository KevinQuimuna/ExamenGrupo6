package com.grupo6.examengrupo6.Controller;


import com.grupo6.examengrupo6.Exeptions.EstudianteNotFoundException;
import com.grupo6.examengrupo6.Model.Carrera;
import com.grupo6.examengrupo6.Model.Estudiante;
import com.grupo6.examengrupo6.Model.Usuario;
import com.grupo6.examengrupo6.Services.CarreraService;
import com.grupo6.examengrupo6.Services.EstudianteService;
import com.grupo6.examengrupo6.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @Autowired
    private UsuarioService ususervice;

    @Autowired
    private CarreraService carreraService;



    @GetMapping("/estudiantes")
    public String showEstudianteList(Model model) {
        List<Estudiante> listEstudiantes = service.listAll();
        model.addAttribute("listEstudiantes", listEstudiantes);
        return "Estudiante/estudiantes";
    }

    @GetMapping("/estudiantes/detalles/{id}")
    public String showEstudianteDetails(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Estudiante estudiante = service.get(id);
            model.addAttribute("estudiante", estudiante);
            return "Estudiante/estudiante_detalles";
        } catch (EstudianteNotFoundException e) {
            ra.addFlashAttribute("message", "El estudiante con ID " + id + " no fue encontrado.");
            return "redirect:/estudiantes";
        }
    }

    @GetMapping("/estudiantes/nuevo")
    public String showNewEstudianteForm(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);

        List<Carrera> listCarreras = carreraService.listAll();
        model.addAttribute("carreras", listCarreras);

        List<Usuario> listUsuarios = ususervice.listAll();
        model.addAttribute("usuarios", listUsuarios);

        model.addAttribute("pageTitle", "Crear Nuevo Estudiante");
        return "Estudiante/estudiante_form";
    }

    @PostMapping("/estudiantes/guardar")
    public String saveEstudiante(Estudiante estudiante, RedirectAttributes ra) {
        service.save(estudiante);
        ra.addFlashAttribute("message", "El estudiante ha sido guardado exitosamente.");
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Estudiante estudiante = service.get(id);
            model.addAttribute("estudiante", estudiante);

            List<Carrera> listCarreras = carreraService.listAll();
            model.addAttribute("carreras", listCarreras);

            List<Usuario> listUsuarios = ususervice.listAll();
            model.addAttribute("usuarios", listUsuarios);

            model.addAttribute("pageTitle", "Editar Estudiante (ID: " + id + ")");
            return "Estudiante/estudiante_form";
        } catch (EstudianteNotFoundException e) {
            ra.addFlashAttribute("message", "El estudiante con ID " + id + " no fue encontrado.");
            return "redirect:/estudiantes";
        }
    }

    @GetMapping("/estudiantes/eliminar/{id}")
    public String deleteEstudiante(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "El estudiante con ID " + id + " ha sido eliminado.");
        } catch (EstudianteNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/estudiantes";
    }
}
