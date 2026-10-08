package com.actividad3.actividad3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Actividad3Controller {
    @GetMapping("/idioma")
    public String idioma(@RequestParam(name="idioma", defaultValue="english") String idioma) {

        switch (idioma.toLowerCase()) {
            case "spanish":
                return "redirect:/spanish.html";
            case "french":
                return "redirect:/french.html";
            case "german":
                return "redirect:/german.html";
            default:
                return "redirect:/english.html";
        }
    }
}
