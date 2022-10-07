package com.example.web.controller;

import com.example.web.entity.Usuario;
import com.example.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private IUsuarioService userService;

    @GetMapping("/")
    public String showLogin(Model model){
        model.addAttribute("isCorrect", true);
        model.addAttribute("mssg","Rellene los campos");
        return "login/login";
    }

    @PostMapping("/verify")
    public String verifyLogin(String username, String password , Model model, RedirectAttributes redirect){
        Usuario usuarioFound = userService.searchByUsername(username);
        if(usuarioFound != null){
            redirect.addFlashAttribute("usuario",usuarioFound);
            return "redirect:profile";
        }
        model.addAttribute("isCorrect",false);
        model.addAttribute("mssg","El usuario y/o contrasena son incorrectos.");
        return "login/login";
    }

    @GetMapping("/profile")
    public String introProfile(Model model, @ModelAttribute("usuario") Usuario userFound){
        String rol = userService.getRolByUsername(userFound.getUsername());
        model.addAttribute("userActivate",userFound);
        model.addAttribute("rol",rol);
        return "user/userProfile";
    }


    @GetMapping("/lista-usuarios")
    public String listUser(Model model){
        System.out.println("Ssadsad");
        List<Usuario> listUsers = userService.listUser();
        System.out.println("This: "+ listUsers);

        model.addAttribute("titulo","Lista de Usuarios");
        model.addAttribute("usuarios",listUsers);
        return "admin/listUsers";
    }

    @GetMapping("/inicio")
    public String showInicio(){
        return "index";
    }
}
