
package Menus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuDeInicio extends Menu{
    
    ArrayList<Usuario> usuarios = new ArrayList<>(); 
    
    public MenuDeInicio(String texto,  JPanel contenedor, CardLayout transicion){ 
        super(texto, contenedor, transicion);
        JButton btnIniciarSesion = Botones(columna, panel, "Iniciar sesion", 60);
        JButton btnCrearJugador = Botones(columna, panel, "Crear Jugador", 60);
        JButton btnSalir = Botones(columna, panel, "Salir", 60);   
        
        JPanel principalIniciarSesion = crearPanel("IniciarSesion");
        IniciarSesion sesion = new IniciarSesion(this, principalIniciarSesion, usuarios, "Iniciar Sesion", "Nombre de Usuario: ", "Contraseña: ", "Ingresar", "Regresar"); 
        btnIniciarSesion.addActionListener(e -> {    
            cambiarPanel("IniciarSesion");
        }); 
        
        JPanel principalCrearJugador = crearPanel("CrearJugador");
        CrearJugador crear = new CrearJugador(this, principalCrearJugador, usuarios);
        btnCrearJugador.addActionListener(e -> {   
            cambiarPanel("CrearJugador");  
        });
        btnSalir.addActionListener(e -> {
            System.exit(0);
        });
        
        add(panel);
                
    }   
}
