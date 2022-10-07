package com.example.web.dao;

import com.example.web.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario,Integer> {
    public Usuario findByUsername(String username);

    @Query(value="SELECT r.rolname FROM rol AS r INNER JOIN rol_usuario AS ru ON ru.id_rol = r.id_rol INNER JOIN usuario AS u ON u.id_usuario=ru.id_usuario WHERE u.username=:nUsuario",nativeQuery = true)
    public String getRolByUsername(@Param("nUsuario") String username);
}
