
package proyecto_vampirewargame;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame{
    
    public MenuPrincipal(){
        JPanel panel = new JPanel();
        
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
        
        add(panel);
        
        setVisible(true);
        
    }
    
    public JButton Botones(BoxLayout columna, JPanel panel, String texto){
        Dimension d = new Dimension(300, 80);
        JButton boton = new JButton(texto);
        boton.setPreferredSize(d);
        boton.setMaximumSize(d);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(60));
        panel.add(boton);
        
        return boton;
    }
    
}
