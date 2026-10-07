package com.prueba.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Actividad2Controller {

    @GetMapping("/inicio")
    public String inicio() {
        return """
                <h1>Bienvenido a la aplicación</h1>
                <p>Esto es un controlador con dos endpoints diferentes, \"/inicio\" y \"/contacto\"</p>
                """;
    }

    @GetMapping("/contacto")
    public String contacto() {
        return """
                <h1>Página de contacto</h1>
                <p>ndelgra1703@g.educaand.es</p>
                """;
    }
}
