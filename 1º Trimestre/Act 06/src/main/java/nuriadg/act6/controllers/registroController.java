package nuriadg.act6.controllers;

import nuriadg.act6.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class registroController {

    Map<String, String> usuarios = new HashMap<>();

    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro";
    }

    @PostMapping("/registro")
    @ResponseBody
    public String procesarFormulario(@ModelAttribute Usuario usuario) {
        String respuesta = "Se ha registrado al usuario de nombre " + usuario.getNombre();

        if (usuario.getApellidos() != null) {
            respuesta += " " + usuario.getApellidos();
        }

        respuesta += ". Correo: " + usuario.getEmail();

        if (usuario.isEmptyPswd() == true) {
            respuesta += ".\nContraseña generada automáticamente: " + usuario.getPassword();
        }

        usuarios.put(usuario.getEmail(), usuario.getPassword());

        return respuesta + """
                <br><a href="/login">iniciar sesión</a>""";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String procesarLogin(@RequestParam("email") String email,
                                @RequestParam("password") String password
                                ) {
        if (!usuarios.containsKey(email)) {
            return "Este usuario no existe";
        }

        if (usuarios.get(email).equals(password)) {
            return "Inicio de sesión exitoso";
        } else {
            return "Contraseña incorrecta";
        }
    }
}
