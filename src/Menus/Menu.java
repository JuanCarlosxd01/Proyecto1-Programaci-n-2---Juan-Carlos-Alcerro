
package Menus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JPanel{
    
    //Atributos en protected
    protected JPanel panel;
    protected BoxLayout columna;
    protected ArrayList<Usuario> usuarios = new ArrayList<>(); 
    CardLayout transicion;
    JPanel contenedor;
    protected static VentanaPrincipal ventana;
    
    //Constructor  que crea el panel y le pone titulo
    public Menu(String titulo, JPanel contenedor, CardLayout transicion){
        this.contenedor = contenedor;
        this.transicion = transicion;
        panel = new JPanel(); 
        
        columna = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(columna);
        
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
    public static JButton Botones(BoxLayout columna, JPanel panel, String texto, int esp){
        Dimension d = new Dimension(300, 80);
        JButton boton = new JButton(texto);
        boton.setPreferredSize(d);
        boton.setMaximumSize(d);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(esp));
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
    
    public JPanel crearPanel(String codigo){
        JPanel principal = new JPanel();
        BoxLayout columna = BoxLayouts(principal);
        principal.setLayout(columna);
        contenedor.add(principal, codigo);
        return principal;
    }
    
    public  void setVentana(VentanaPrincipal ventana){
        this.ventana = ventana;
    }
}
