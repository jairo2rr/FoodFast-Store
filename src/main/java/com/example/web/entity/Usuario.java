package com.example.web.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String username;
    private String password;
    private Date created_at;
    private Date updated_at;
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Usuario() {
        this.id_usuario = 0;
        this.username = "";
        this.password = "";
        this.created_at = Date.valueOf(LocalDate.now());
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Id
    public Integer getId_usuario() {
        return id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
