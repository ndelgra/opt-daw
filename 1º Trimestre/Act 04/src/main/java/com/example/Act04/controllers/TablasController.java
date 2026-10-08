package com.example.Act04.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TablasController {
    @GetMapping("/tabla")
    public String tabla(
            @RequestParam(name="filas", defaultValue = "1") Integer filas,
            @RequestParam(name="columnas", defaultValue = "1") Integer columnas)
    {

        int nfilas = Integer.parseInt(String.valueOf(filas));
        int ncolumnas = Integer.parseInt(String.valueOf(columnas));

        String tablahtml="""
        <h1>Tabla generada</h1>
        <table style="border: 2px solid pink;">
        """;

        if (nfilas > 20 || nfilas < 1) {
            nfilas=1;
        }

        if (ncolumnas > 20 || ncolumnas < 1) {
            ncolumnas=1;
        }

        for (int i = 1; i <= nfilas; i++) {
            tablahtml=tablahtml+"<tr style=\"border: 1px solid pink;\">";
            for (int j = 1; j<= ncolumnas; j++) {
                tablahtml=tablahtml + "<td style=\"border: 1px solid pink;\">Fila " + i + " Columna " + j + "</td>";
            }
            tablahtml=tablahtml + "</tr>";
        }

        return tablahtml;
    }

    @ExceptionHandler(NumberFormatException.class)
    public String error(){
        return "<h1>Error: El parámetro debe ser un número</h1>";
    }
}
