package com.ap.ap.seguridad.servicios;

import com.ap.ap.seguridad.entidades.Rol;
import com.ap.ap.seguridad.enumerados.RolNombre;
import com.ap.ap.seguridad.repositorios.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolServicio {

    @Autowired
    RolRepositorio rolRepositorio;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepositorio.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        rolRepositorio.save(rol);
    }
}
