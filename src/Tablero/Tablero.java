
package Tablero;

import javax.swing.*;
import java.awt.*;
import Juego.*;

public class Tablero {
    
    JButton casillas[][] = new JButton[6][6];
    
    public Tablero(JPanel panelPrincipal){
        GridLayout tablero = new GridLayout(6,6);
        JPanel panelCentro = new JPanel(tablero){
            private Image fondo = new ImageIcon(getClass().getResource("/Imagenes/FondoTablero.png")).getImage();
        
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
        }; 
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        crearCasillas(panelCentro, 5, 5);
        crearPiezas(casillas, 0, 0, "1");
        crearPiezas(casillas, 5, 0, "2");
    }
    
    public int crearCasillas(JPanel panelCentro, int fila, int columna){
        if(fila < 0){
            return 0;
        }
        if(columna >= 0){
            casillas[fila][columna]= new JButton();
            casillas[fila][columna].setPreferredSize(new Dimension(150, 150));
            casillas[fila][columna].setOpaque(false);
            casillas[fila][columna].setContentAreaFilled(false);
            casillas[fila][columna].setBorderPainted(false);
            panelCentro.add(casillas[fila][columna]);
            return crearCasillas(panelCentro, fila, columna - 1);
        }      
        return crearCasillas(panelCentro, fila - 1, 5);
    }
    
    public void crearPiezas(JButton[][] casillas, int fila, int columna, String num){
        ponerImagen(casillas[fila][columna], "/Imagenes/HombreLobo"+num+".png");
            
        ponerImagen(casillas[fila][columna + 1], "/Imagenes/Vampiro"+num+".png");
        
        ponerImagen(casillas[fila][columna + 2], "/Imagenes/Necromante"+num+".png");
        
        ponerImagen(casillas[fila][columna + 3], "/Imagenes/Necromante"+num+".png");
        
        ponerImagen(casillas[fila][columna + 4], "/Imagenes/Vampiro"+num+".png");
        
        ponerImagen(casillas[fila][columna + 5], "/Imagenes/HombreLobo"+num+".png");
    }
    
    public void ponerImagen(JButton casilla, String archivo){
        ImageIcon imagen = new ImageIcon(getClass().getResource(archivo));
        Image icono = imagen.getImage();
        Image escalada = icono.getScaledInstance(125, 125,Image.SCALE_SMOOTH);
        casilla.setIcon(new ImageIcon(escalada));
        casilla.setDisabledIcon(new ImageIcon(escalada));
    }
    
    public int inhabilitarCasillas(int fila, int columna){
        if(fila < 0){
            return 0;
        }
        if(columna >= 0){
            casillas[fila][columna].setOpaque(false);
            casillas[fila][columna].setContentAreaFilled(false);
            casillas[fila][columna].setBorderPainted(false);
            casillas[fila][columna].setEnabled(false);
            return inhabilitarCasillas(fila, columna - 1);
        }
        return inhabilitarCasillas(fila - 1, 5);
    }
    
    public JButton[][] getCasillas(){
        return casillas;
    }
    
}
