package com.example.userstdd.usuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuariosTest {
    private final String NOMBRE_POR_DEFECTO = "pruebas";
    Usuarios usuarios = new Usuarios();

    Usuario usuario = new Usuario();

    @BeforeEach
    void inicializa(){
        usuario.nombre = NOMBRE_POR_DEFECTO;
    }

    @Test
    void pruebaCrearUsuario(){
        Usuario usuarioCreado = usuarios.crear(usuario);
        assertEquals(usuarioCreado.nombre, NOMBRE_POR_DEFECTO);
    }

    @Test
    void pruebaObtenerUsuario(){
        usuarios.crear(usuario);

        String resultado = usuarios.buscar(usuario);
        assertEquals(NOMBRE_POR_DEFECTO, resultado);
    }

    @Test
    void pruebaObtenerUsuarioNoExistente(){
        String resultado = usuarios.buscar(usuario);
        assertNull(resultado);
    }

    @Test
    void pruebaBorrarUsuario(){
        usuarios.crear(usuario);

        boolean resultado = usuarios.borrar(usuario);
        assertTrue(resultado);
    }

    @Test
    void pruebaBorrarUsuarioNoExistente(){
        boolean resultado = usuarios.borrar(usuario);
        assertFalse(resultado);
    }
}
