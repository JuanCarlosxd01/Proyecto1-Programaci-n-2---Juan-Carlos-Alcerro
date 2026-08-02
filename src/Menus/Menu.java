
package Menus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JFrame{
    
    //Atributos en protected
    protected JPanel panel;
    protected BoxLayout columna;
    protected CardLayout transicion;
    protected JPanel contenedor;
    protected ArrayList<Usuario> usuarios = new ArrayList<>(); 
    
    //Constructor  que crea la ventana y le pone titulo
    public Menu(String titulo){
        panel = new JPanel();
        setTitle(titulo);
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        transicion = new CardLayout();
        contenedor = new JPanel(transicion);
        
        columna = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(columna);
        
        JLabel Titulo = new JLabel(titulo);
        Titulo.setForeground(Color.BLACK);
        Titulo.setFont(new Font("Arial", Font.BOLD, 20));
        Titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(80));
        panel.add(Titulo);  
        panel.add(Box.createVerticalStrut(80));
      
    }
    //Funcion para crear botones
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
    
    //Funcion paracrear BoxLayouts
    public static BoxLayout BoxLayouts(JPanel panel){
        return new BoxLayout(panel, BoxLayout.Y_AXIS);
    }
    
    //Funcion para cambiar de paneles
    public void cambiarPanel(String nombre){
        transicion.show(contenedor, nombre);
    }
}
