
package Menus;

import java.awt.*;
import javax.swing.*;

public class MenuJugar extends Menu{
    
    public MenuJugar(String texto, JPanel contenedor, CardLayout transicion){
        super(texto, contenedor, transicion);
        JButton btnNuevaPartida = Botones(columna, panel, "NUEVA PARTIDA", 60);
        JButton btnRegresar = Botones(columna, panel, "REGRESAR", 60);
        
        add(panel);
        
        btnNuevaPartida.addActionListener(e -> {
            cambiarPanel("NuevaPartida");
        });
        
        btnRegresar.addActionListener(e -> {
            cambiarPanel("MenuPrincipal");
        });
    }
}
