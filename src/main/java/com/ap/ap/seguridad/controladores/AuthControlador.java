package com.ap.ap.seguridad.controladores;

import com.ap.ap.seguridad.dto.JwtDto;
import com.ap.ap.seguridad.dto.LoginUser;
import com.ap.ap.seguridad.dto.Mensaje;
import com.ap.ap.seguridad.dto.NewUser;
import com.ap.ap.seguridad.entidades.Rol;
import com.ap.ap.seguridad.entidades.UserUser;
import com.ap.ap.seguridad.enumerados.RolNombre;
import com.ap.ap.seguridad.jwt.JwtProvider;
import com.ap.ap.seguridad.servicios.RolServicio;
import com.ap.ap.seguridad.servicios.UserServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthControlador {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserServicio userServicio;

    @Autowired
    RolServicio rolServicio;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo (@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        if (userServicio.existsByNombreUser(newUser.getNombreUser()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if (userServicio.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        UserUser userUser =
                new UserUser(newUser.getNombre(), newUser.getNombreUser(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolServicio.getByRolNombre(RolNombre.ROLE_USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(rolServicio.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        userUser.setRoles(roles);
        userServicio.save(userUser);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getNombreUser(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
