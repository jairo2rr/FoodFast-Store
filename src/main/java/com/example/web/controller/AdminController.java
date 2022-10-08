package com.example.web.controller;

import com.example.web.entity.Usuario;
import com.example.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private IUsuarioService userService;

    @GetMapping("/inicio-admin")
    public String showInicioAdmin(){
        return "";
    }

    @GetMapping("/lista-usuarios")
    public String listUser(Model model){
        List<Usuario> listUsers = userService.listUser();
        model.addAttribute("titulo","Lista de Usuarios");
        model.addAttribute("usuarios",listUsers);
        return "admin/listUsers";
    }
}
