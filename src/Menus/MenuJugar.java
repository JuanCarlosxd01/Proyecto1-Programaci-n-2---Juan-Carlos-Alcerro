
package Menus;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MenuJugar extends Menu{
    
    public MenuJugar(String texto, JPanel contenedor, CardLayout transicion, ArrayList<Usuario> usuarios, Usuario usuarioActivo){
        super(texto, contenedor, transicion);
        JButton btnSeleccionarOponente = Botones(columna, panel, "NUEVA PARTIDA", 60);
        JButton btnRegresar = Botones(columna, panel, "REGRESAR", 60);
        
        add(panel);
        
        btnSeleccionarOponente.addActionListener(e -> {
            sonidoBoton.reproducir();
            PanelSeleccionarOponente oponente = new PanelSeleccionarOponente("Seleccionar Oponente: ", contenedor, transicion, usuarios, usuarioActivo);           
            contenedor.add(oponente, "Seleccionar Oponente");
            cambiarPanel("Seleccionar Oponente");
        });
        
        btnRegresar.addActionListener(e -> {
            sonidoBoton.reproducir();
            cambiarPanel("MenuPrincipal");
        });
    }
}
