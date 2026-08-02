
package proyecto_vampirewargame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuDeInicio extends JFrame{
    
    private CardLayout transicion = new CardLayout();
    JPanel contenedor = new JPanel(transicion);
    private ArrayList<Usuario> usuarios = new ArrayList<>(); 
    
    public MenuDeInicio(){      
        JPanel panel = new JPanel();
        contenedor.add(panel, "Menu de Inicio");
        setTitle("VAMPIRE WARGAME");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BoxLayout columna = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(columna);
        
        JLabel Titulo = new JLabel("VAMPIRE WARGAME");
        Titulo.setForeground(Color.BLACK);
        Titulo.setFont(new Font("Arial", Font.BOLD, 20));
        Titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalStrut(80));
        panel.add(Titulo);  
        panel.add(Box.createVerticalStrut(80));
        JButton btnIniciarSesion = Botones(columna, panel, "Iniciar sesion");
        JButton btnCrearJugador = Botones(columna, panel, "Crear Jugador");
        JButton btnSalir = Botones(columna, panel, "Salir");   
        
        
        btnIniciarSesion.addActionListener(e -> {
            JPanel principalIniciarSesion = new JPanel();
            BoxLayout columnaIniciarSesion = new BoxLayout(principalIniciarSesion, BoxLayout.Y_AXIS);
            principalIniciarSesion.setLayout(columnaIniciarSesion);
            contenedor.add(principalIniciarSesion, "Iniciar Sesion");
            cambiarPanel("Iniciar Sesion");
            IniciarSesion sesion = new IniciarSesion(this, principalIniciarSesion, usuarios, "Iniciar Sesion", "Nombre de Usuario: ", "Contraseña: ", "Ingresar", "Regresar");
        });
        
        btnCrearJugador.addActionListener(e -> {
            JPanel principalCrearJugador = new JPanel();
             BoxLayout columnaCrearJugador = new BoxLayout(principalCrearJugador, BoxLayout.Y_AXIS);
             principalCrearJugador.setLayout(columnaCrearJugador);
            contenedor.add(principalCrearJugador, "Crear Jugador");
            cambiarPanel("Crear Jugador");
            CrearJugador crear = new CrearJugador(this, principalCrearJugador, usuarios);
        });
        btnSalir.addActionListener(e -> {
            System.exit(0);
        });
        
        add(contenedor);
        transicion.show(contenedor, "Menu de Inicio");
        
        setVisible(true);
        
    }
    
    public static JButton Botones(BoxLayout columna, JPanel panel, String texto){
        Dimension d = new Dimension(300, 80);
        JButton boton = new JButton(texto);
        boton.setPreferredSize(d);
        boton.setMaximumSize(d);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(60));
        panel.add(boton);    
        
        return boton;
    }
    
    public void cambiarPanel(String nombre){
        transicion.show(contenedor, nombre);
    }
    
}
