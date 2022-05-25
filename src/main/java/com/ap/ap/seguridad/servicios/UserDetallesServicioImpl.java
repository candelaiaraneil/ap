package com.ap.ap.seguridad.servicios;

import com.ap.ap.seguridad.entidades.UserUser;
import com.ap.ap.seguridad.entidades.UserUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetallesServicioImpl implements UserDetailsService {

    @Autowired
    UserServicio userServicio;

    @Override
    public UserDetails loadUserByUsername(String nombreUser) throws UsernameNotFoundException {
        UserUser userUser = userServicio.getByNombreUser(nombreUser).get();
        return UserUserPrincipal.build(userUser);
    }
}
