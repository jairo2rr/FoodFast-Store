package com.example.web.controller;

import com.example.web.entity.Usuario;
import com.example.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class InicioController {

    @Autowired
    private IUsuarioService userService;

    @GetMapping("/")
    public String showInicio(Model model, @ModelAttribute("usuario") Usuario userFound){
        model.addAttribute("userActivate",userFound.getUsername()!="");
        /*Resolver caso de que no se reciba el atributo 'usuario'.*/
        String rol = userService.getRolByUsername(userFound.getUsername());
        model.addAttribute("userFound",userFound);
        model.addAttribute("rol",rol);
        return "inicio/inicio";
    }

    @GetMapping("/promociones")
    public String showPromociones(Model model){
        model.addAttribute("userActivate",true);
        return "inicio/promociones";
    }

    @GetMapping("/contactanos")
    public String showContactanos(Model model){
        model.addAttribute("userActivate",true);
        return "inicio/contactanos";
    }
}
