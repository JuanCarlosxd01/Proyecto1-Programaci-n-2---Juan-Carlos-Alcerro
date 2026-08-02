
package Menus;

import javax.swing.*;

public class MenuDeInicio extends Menu{
    
    public MenuDeInicio(String texto){ 
        super(texto);
        
        JButton btnIniciarSesion = Botones(columna, panel, "Iniciar sesion");
        JButton btnCrearJugador = Botones(columna, panel, "Crear Jugador");
        JButton btnSalir = Botones(columna, panel, "Salir");   
        
        JPanel principalIniciarSesion = new JPanel();
        BoxLayout columnaIniciarSesion = BoxLayouts(principalIniciarSesion);
        principalIniciarSesion.setLayout(columnaIniciarSesion);
        IniciarSesion sesion = new IniciarSesion(this, principalIniciarSesion, usuarios, "Iniciar Sesion", "Nombre de Usuario: ", "Contraseña: ", "Ingresar", "Regresar"); 
        contenedor.add(principalIniciarSesion, "IniciarSesion");
        btnIniciarSesion.addActionListener(e -> {    
            cambiarPanel("IniciarSesion");
        }); 
        
        JPanel principalCrearJugador = new JPanel();
        BoxLayout columnaCrearJugador = BoxLayouts(principalCrearJugador);
        principalCrearJugador.setLayout(columnaCrearJugador);
        CrearJugador crear = new CrearJugador(this, principalCrearJugador, usuarios);
        contenedor.add(principalCrearJugador, "CrearJugador");
        btnCrearJugador.addActionListener(e -> {   
            cambiarPanel("CrearJugador");  
        });
        btnSalir.addActionListener(e -> {
            System.exit(0);
        });
        
        contenedor.add(panel, "MenuDeInicio");
        add(contenedor);
        transicion.show(contenedor, "MenuDeInicio");
        
        setVisible(true);
        
    }   
}
