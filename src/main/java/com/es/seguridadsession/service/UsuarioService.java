package com.es.seguridadsession.service;

import com.es.seguridadsession.dto.UsuarioDTO;
import com.es.seguridadsession.model.Session;
import com.es.seguridadsession.model.Usuario;
import com.es.seguridadsession.repository.SessionRepository;
import com.es.seguridadsession.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public String login(UsuarioDTO userLogin) {
        // Comprobar si user y pass son correctos -> obtener de la BDD el usuario
        String nombreUser = userLogin.getNombre();
        String passUser = userLogin.getPassword();

        List<Usuario> users = usuarioRepository.findByNombre(nombreUser);

        Usuario u = users
                .stream()
                .filter(user -> user.getNombre().equals(nombreUser) && user.getPassword().equals(passUser))
                .findFirst()
                .orElseThrow(); // LANZAR EXCEPCION PROPIA

        // Si coincide -> Insertar una sesión
        // Genero un TOKEN
        String token = UUID.randomUUID().toString(); // Esto genera un token aleatorio
        System.out.println("Token generado: "+token);
        // Almaceno la Session en la base de datos
        Session s = new Session();
        s.setToken(token);
        s.setUsuario(u);
        s.setExpirationDate(
                LocalDateTime.now().plusDays(1)
        );

        sessionRepository.save(s);

        return token;
    }
}
