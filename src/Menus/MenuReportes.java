
package Menus;

import java.awt.*;
import javax.swing.*;

public class MenuReportes extends Menu{
    
    public MenuReportes(String titulo, JPanel contenedor, CardLayout transicion){
        super(titulo, contenedor, transicion);
        
        JButton btnRankingJugadores = Botones(columna, panel, "RANKING DE JUGADORES", 50);
        JButton btnHistorial = Botones(columna, panel, "HISTORIAL DE PARTIDAS", 50);
        JButton btnRegresar = Botones(columna, panel, "REGRESAR", 50);
        
        btnRankingJugadores.addActionListener(e -> {
            MenuRanking ranking = new MenuRanking("RANKING DE JUGADORES", contenedor, transicion);
            contenedor.add(ranking, "ranking");
            cambiarPanel("ranking");
        });
        
        btnHistorial.addActionListener(e ->{
            MenuHistorial historial = new MenuHistorial("HISTORIAL DE PARTIDAS", contenedor, transicion);
            contenedor.add(historial, "historial");
            cambiarPanel("historial");
        });  
                
        btnRegresar.addActionListener(e -> {
            cambiarPanel("MenuPrincipal");
        });
        
        add(panel);
    }
    
}
