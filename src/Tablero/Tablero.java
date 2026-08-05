
package Tablero;

import javax.swing.*;
import java.awt.*;
import Juego.*;

public class Tablero {
    
    JButton casillas[][] = new JButton[6][6];
    
    public Tablero(JPanel panelPrincipal){
        GridLayout tablero = new GridLayout(6,6);
        JPanel panelCentro = new JPanel(tablero);
        panelCentro.setBackground(Color.BLACK);     
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        crearCasillas(panelCentro, 5, 5);
    }
    
    public int crearCasillas(JPanel panelCentro, int fila, int columna){
        if(fila < 0){
            return 0;
        }
        if(columna >= 0){
            casillas[fila][columna]= new JButton();
            casillas[fila][columna].setPreferredSize(new Dimension(150,150));
            panelCentro.add(casillas[fila][columna]);
            casillas[fila][columna].addActionListener(e -> {
                 Ruleta.casillasDisponibles(casillas, fila, columna);
            });
            return crearCasillas(panelCentro, fila, columna - 1);
        }
        
        return crearCasillas(panelCentro, fila - 1, 5);
    }
    
    public void crearPiezas(JButton[][] casillas, int fila, int columna){
        HombreLobo lobo1 = new HombreLobo();
        ponerImagen(casillas[fila][columna], lobo1.getImagen());
        
        Vampiro vampiro1 = new Vampiro();
        ponerImagen(casillas[fila][columna + 1], vampiro1.getImagen());
        
        Necromante muerte1 = new Necromante();
        ponerImagen(casillas[fila][columna + 2], muerte1.getImagen());
        
        Necromante muerte2 = new Necromante();
        ponerImagen(casillas[fila][columna + 3], muerte2.getImagen());
        
        Vampiro vampiro2 = new Vampiro();
        ponerImagen(casillas[fila][columna + 4], vampiro2.getImagen());
        
        HombreLobo lobo2 = new HombreLobo();
        ponerImagen(casillas[fila][columna + 5], lobo2.getImagen());
        
    }
    
    public void ponerImagen(JButton casilla, ImageIcon imagen){
        Image icono = imagen.getImage();
        Image escalada = icono.getScaledInstance(150, 150,Image.SCALE_SMOOTH);
        casilla.setIcon(new ImageIcon(escalada));
    }
    
    public JButton[][] getCasillas(){
        return casillas;
    }
    
}
