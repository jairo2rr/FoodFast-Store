package com.example.web.service;

import com.example.web.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listUser();
    public void saveUser(Usuario user);
    public Usuario searchByUsername(String username);
    public void deleteUser(Integer id);
    public String getRolByUsername(String username);
}
