package com.grupo6.examengrupo6.Controller;

import com.grupo6.examengrupo6.Exeptions.UsuarioNotFoundException;
import com.grupo6.examengrupo6.Model.Carrera;
import com.grupo6.examengrupo6.Model.Tipousuario;
import com.grupo6.examengrupo6.Model.Usuario;
import com.grupo6.examengrupo6.Services.CarreraService;
import com.grupo6.examengrupo6.Services.UsuarioService;
import com.grupo6.examengrupo6.Services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @Autowired
    private TipoUsuarioService tipousuarioService;



    @GetMapping("/usuarios")
    public String showUsuarioList(Model model) {
        List<Usuario> listUsuarios = service.listAll();
        model.addAttribute("listUsuarios", listUsuarios);
        return "Usuario/usuarios";
    }

    @GetMapping("/usuarios/detalles/{id}")
    public String showUsuarioDetails(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Usuario usuario = service.get(id); // Obtener el usuario por ID
            model.addAttribute("usuario", usuario);
            return "Usuario/usuario_detalles"; // Nombre de la plantilla HTML para los detalles
        } catch (UsuarioNotFoundException e) {
            ra.addFlashAttribute("message", "El usuario con ID " + id + " no fue encontrado.");
            return "redirect:/usuarios";
        }
    }



    @GetMapping("/usuarios/nuevo")
    public String showNewUsuarioForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        List<Tipousuario> listTipos = tipousuarioService.listAll();
        model.addAttribute("tipos", listTipos);


        model.addAttribute("pageTitle", "Crear Nuevo Usuario");
        return "Usuario/usuario_form";
    }

    @PostMapping("/usuarios/guardar")
    public String saveUsuario(Usuario usuario, RedirectAttributes ra) {

        service.save(usuario);
        ra.addFlashAttribute("message", "El usuario ha sido guardado exitosamente.");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Usuario usuario = service.get(id);
            model.addAttribute("usuario", usuario);
            List<Tipousuario> listTipos = tipousuarioService.listAll();
            model.addAttribute("tipos", listTipos);
            model.addAttribute("pageTitle", "Editar Usuario (ID: " + id + ")");
            return "Usuario/usuario_form";
        } catch (UsuarioNotFoundException e) {
            ra.addFlashAttribute("message", "El usuario con ID " + id + " no fue encontrado.");
            return "redirect:/usuarios";
        }
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String deleteUsuario(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "El usuario con ID " + id + " ha sido eliminado exitosamente.");
        } catch (UsuarioNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/usuarios";
    }
}
