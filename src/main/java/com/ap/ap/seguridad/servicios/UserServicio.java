package com.ap.ap.seguridad.servicios;

import com.ap.ap.seguridad.entidades.UserUser;
import com.ap.ap.seguridad.repositorios.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServicio {

    @Autowired
    UserRepositorio userRepositorio;

    public Optional<UserUser> getByNombreUser(String nombreUser) {
        return userRepositorio.findByNombreUser(nombreUser);
    }

    public boolean existsByNombreUser(String nombreUser) {
        return userRepositorio.existsByNombreUser(nombreUser);
    }

    public boolean existsByEmail(String email) {
        return userRepositorio.existsByEmail(email);
    }

    public void save (UserUser userUser) {
        userRepositorio.save(userUser);
    }
}
