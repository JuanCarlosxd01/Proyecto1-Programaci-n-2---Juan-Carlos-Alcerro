
package Menus;

import java.awt.*;
import javax.swing.*;

public final class VentanaPrincipal extends JFrame{
    
    CardLayout transicion;
    JPanel contenedor;
    private ImageIcon fondoMenu = new ImageIcon(getClass().getResource("/Imagenes/FondoMenu.png"));
    
    public VentanaPrincipal(String titulo){
        setTitle(titulo);
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel fondo = new JPanel(new BorderLayout()){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(fondoMenu.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };   
        
        transicion = new CardLayout();
        contenedor = new JPanel(transicion);
        contenedor.setOpaque(false);
        
        MenuDeInicio menu = new MenuDeInicio(titulo, contenedor, transicion);    
        menu.setVentana(this);
        contenedor.add(menu, "MenuDeInicio");
        fondo.add(contenedor, BorderLayout.CENTER);
        add(fondo);
        transicion.show(contenedor, "MenuDeInicio");

        setVisible(true); 
        
    }
    
    public void mostrarMenuPrincipal(){
        transicion.show(contenedor, "MenuDeInicio");
    }
    
    
}
