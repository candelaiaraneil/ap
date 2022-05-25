package com.ap.ap.seguridad.repositorios;

import com.ap.ap.seguridad.entidades.UserUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositorio extends JpaRepository<UserUser, Integer> {
    Optional<UserUser> findByNombreUser(String nombreUser);
    boolean existsByNombreUser(String nombreUser);
    boolean existsByEmail(String email);
}
