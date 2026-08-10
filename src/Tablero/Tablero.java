
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
        crearPiezas(casillas, 0, 0);
        crearPiezas(casillas, 5, 0);
    }
    
    public int crearCasillas(JPanel panelCentro, int fila, int columna){
        if(fila < 0){
            return 0;
        }
        if(columna >= 0){
            casillas[fila][columna]= new JButton();
            casillas[fila][columna].setPreferredSize(new Dimension(150, 150));
            panelCentro.add(casillas[fila][columna]);
            return crearCasillas(panelCentro, fila, columna - 1);
        }      
        return crearCasillas(panelCentro, fila - 1, 5);
    }
    
    public void crearPiezas(JButton[][] casillas, int fila, int columna){
        ponerImagen(casillas[fila][columna], "/Imagenes/hombreLobo.png");
            
        ponerImagen(casillas[fila][columna + 1], "/Imagenes/vampiro.png");
        
        ponerImagen(casillas[fila][columna + 2], "/Imagenes/necromante.png");
        
        ponerImagen(casillas[fila][columna + 3], "/Imagenes/necromante.png");
        
        ponerImagen(casillas[fila][columna + 4], "/Imagenes/vampiro.png");
        
        ponerImagen(casillas[fila][columna + 5], "/Imagenes/hombreLobo.png");
    }
    
    public void ponerImagen(JButton casilla, String archivo){
        ImageIcon imagen = new ImageIcon(getClass().getResource(archivo));
        Image icono = imagen.getImage();
        Image escalada = icono.getScaledInstance(150, 150,Image.SCALE_SMOOTH);
        casilla.setIcon(new ImageIcon(escalada));
    }
    
    public int inhabilitarCasillas(int fila, int columna){
        if(fila < 0){
            return 0;
        }
        if(columna >= 0){
            casillas[fila][columna].setEnabled(false);
            casillas[fila][columna].setBackground(UIManager.getColor("Button.background"));
            return inhabilitarCasillas(fila, columna - 1);
        }
        return inhabilitarCasillas(fila - 1, 5);
    }
    
    public JButton[][] getCasillas(){
        return casillas;
    }
    
}
