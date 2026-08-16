
package Menus;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MenuReportes extends Menu{
    
    public MenuReportes(String titulo, JPanel contenedor, CardLayout transicion, ArrayList<Usuario> usuarios, Usuario usuarioActivo){
        super(titulo, contenedor, transicion);
        
        JButton btnRankingJugadores = Botones(columna, panel, "RANKING DE JUGADORES", 50);
        JButton btnHistorial = Botones(columna, panel, "HISTORIAL DE PARTIDAS", 50);
        JButton btnRegresar = Botones(columna, panel, "REGRESAR", 50);
        
        btnRankingJugadores.addActionListener(e -> {
            sonidoBoton.reproducir();
            MenuRanking ranking = new MenuRanking("RANKING DE JUGADORES", contenedor, transicion, usuarios);
            contenedor.add(ranking, "ranking");
            cambiarPanel("ranking");
        });
        
        btnHistorial.addActionListener(e ->{
            sonidoBoton.reproducir();
            MenuHistorial historial = new MenuHistorial("HISTORIAL DE PARTIDAS", contenedor, transicion, usuarioActivo);
            contenedor.add(historial, "historial");
            cambiarPanel("historial");
        });  
                
        btnRegresar.addActionListener(e -> {
            sonidoBoton.reproducir();
            cambiarPanel("MenuPrincipal");
        });
        
        add(panel);
    }
    
}
