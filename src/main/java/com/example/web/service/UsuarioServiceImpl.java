package com.example.web.service;

import com.example.web.dao.UsuarioDAO;
import com.example.web.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    @Autowired
    private UsuarioDAO userDAO;

    @Override
    public List<Usuario> listUser() {
        return (List<Usuario>) userDAO.findAll();
    }

    @Override
    public void saveUser(Usuario user) {
        userDAO.save(user);
    }

    @Override
    public Usuario searchByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public void deleteUser(Integer id) {
        userDAO.deleteById(id);
    }

    @Override
    public String getRolByUsername(String username) {
        return userDAO.getRolByUsername(username);
    }
}
