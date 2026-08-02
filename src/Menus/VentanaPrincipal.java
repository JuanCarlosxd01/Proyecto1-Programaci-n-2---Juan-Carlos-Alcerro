
package Menus;

import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame{
    
    CardLayout transicion;
    JPanel contenedor;
    public VentanaPrincipal(String titulo){
        setTitle(titulo);
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        transicion = new CardLayout();
        contenedor = new JPanel(transicion);
        
        MenuDeInicio menu = new MenuDeInicio(titulo, contenedor, transicion);     
        contenedor.add(menu, "MenuDeInicio");

        add(contenedor);
        transicion.show(contenedor, "MenuDeInicio");

        setVisible(true);
    }
    
}
