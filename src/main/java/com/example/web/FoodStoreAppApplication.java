package com.example.web;

import com.example.web.dao.UsuarioDAO;
import com.example.web.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.web.dao")
public class FoodStoreAppApplication {
    @Autowired
    private UsuarioDAO userDao;

    public static void main(String[] args) {
        SpringApplication.run(FoodStoreAppApplication.class, args);
    }

    @EventListener({ApplicationReadyEvent.class})
    public void initUser(){
        Usuario user = userDao.findById(1).get();
        System.out.println("This is the name: " + user.getUsername());
    }
}
