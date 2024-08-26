package com.grupo6.examengrupo6.Controller;

import com.grupo6.examengrupo6.Exeptions.CarreraNotFoundException;
import com.grupo6.examengrupo6.Model.Departamento;
import com.grupo6.examengrupo6.Services.CarreraService; // Asegúrate de que la importación sea correcta
import com.grupo6.examengrupo6.Model.Carrera;
import com.grupo6.examengrupo6.Services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CarreraContoller {

    @Autowired
    private CarreraService servicecarrera;

    @Autowired
    private DepartamentoService servicedepartamento;

    @GetMapping("/carreras")
    public String showCarreraList(Model model) {
        List<Carrera> listCarreras = servicecarrera.listAll();
        model.addAttribute("listCarreras", listCarreras);

        return "Carrera/carreras";
    }

    @GetMapping("/carreras/nuevo")
    public String showNewCarreraForm(Model model) {
        Carrera carrera = new Carrera();
        model.addAttribute("carrera", carrera);

        List<Departamento> listDepartamentos = servicedepartamento.listAll();
        model.addAttribute("departamentos", listDepartamentos);

        model.addAttribute("pageTitle", "Crear Nueva Carrera");
        return "Carrera/carrera_form";
    }

    @GetMapping("/carreras/detalles/{id}")
    public String showCarreraDetails(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Carrera carrera = servicecarrera.get(id); // Obtener la carrera por ID
            model.addAttribute("carrera", carrera);
            return "Carrera/carrera_detalles"; // Nombre de la plantilla HTML
        } catch (CarreraNotFoundException e) {
            ra.addFlashAttribute("message", "La carrera con ID " + id + " no fue encontrada.");
            return "redirect:/carreras";
        }
    }




    @PostMapping("/carreras/guardar")
    public String saveCarrera(Carrera carrera, RedirectAttributes ra) {
        servicecarrera.save(carrera);
        ra.addFlashAttribute("message", "La carrera ha sido guardada exitosamente.");
        return "redirect:/carreras";
    }

    @GetMapping("/carreras/editar/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Carrera carrera = servicecarrera.get(id); // Usa 'id' en lugar de 'Id'
            model.addAttribute("carrera", carrera);
            model.addAttribute("pageTitle", "Editar Carrera (ID: " + id + ")");

            List<Departamento> listDepartamentos = servicedepartamento.listAll();
            model.addAttribute("departamentos", listDepartamentos);

            return "Carrera/carrera_form";
        } catch (CarreraNotFoundException e) {
            ra.addFlashAttribute("message", "La carrera con ID " + id + " no fue encontrada.");
            return "redirect:/carreras";
        }
    }

    @GetMapping("/carreras/eliminar/{id}")
    public String deleteCarrera(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            servicecarrera.delete(id);
            ra.addFlashAttribute("message", "La carrera con ID " + id + " ha sido eliminada.");
        } catch (CarreraNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/carreras";
    }
}
