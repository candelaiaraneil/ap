package com.ap.ap.seguridad.repositorios;

import com.ap.ap.seguridad.entidades.Rol;
import com.ap.ap.seguridad.enumerados.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
