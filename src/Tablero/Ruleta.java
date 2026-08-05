
package Tablero;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class Ruleta extends JPanel{
    
    private double angulo = 0;
    private Timer timer;
    private double velocidad = (int)(Math.random()*200);
    int centroX = 150;
    int centroY = 150;
    int radio = 100;  
    int x;
    int y;
    double vueltas;
    int vEntero;
    static int[][] movimientos = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private static int filaSeleccionada;
    private static int columnaSeleccionada;
    
    public Ruleta(JPanel panelPrincipal, JButton[][] casillas){ 
        setLayout(new GridBagLayout());
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(288, 0));
        panelPrincipal.add(this, BorderLayout.WEST);
    }
   
    
    @Override
    protected void paintComponent(Graphics dibujar){
        super.paintComponent(dibujar);
        Graphics2D dibujar2 = (Graphics2D) dibujar;
        
        AffineTransform original = dibujar2.getTransform();
        dibujar2.rotate(Math.toRadians(angulo), centroX, centroY);
     
        dibujar2.setColor(Color.red);
        dibujar2.fillArc(50, 50, 200, 200, 0, 60);
        dibujar2.setColor(Color.blue);
        dibujar2.fillArc(50, 50, 200, 200, 60, 60);
        dibujar2.setColor(Color.yellow);
        dibujar2.fillArc(50, 50, 200, 200, 120, 60);
        dibujar2.setColor(Color.red);
        dibujar2.fillArc(50, 50, 200, 200, 180, 60);
        dibujar2.setColor(Color.blue);
        dibujar2.fillArc(50, 50, 200, 200, 240, 60);
        dibujar2.setColor(Color.yellow);
        dibujar2.fillArc(50, 50, 200, 200, 300, 60);
        
        dibujar2.setTransform(original);
        dibujar2.setColor(Color.BLACK);
        dibujar2.fillRect(145, 10, 10, 35);
     
    }
    
    
    
    public void girarRuleta(){  
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                x = e.getX();
                y = e.getY();
                
                int dx = x - centroX;
                int dy = y - centroY;
                double distancia = Math.sqrt(dx * dx + dy * dy);
                 if (distancia <= radio) {
                     if(!timer.isRunning()){   
                        velocidad = (int)(Math.random()*200);
                        timer.start();
                    }
                }       
            }
        });
    }
    
    public void timer(JButton[][] casillas){
        timer = new Timer(16, e ->{
            angulo += velocidad; 
            velocidad *= 0.98;
            
            vueltas = angulo/360;
            vEntero = (int)vueltas;
            double conversion = 360 * (vueltas - (double)vEntero); 
            
            if(velocidad<0.2){
                timer.stop();
                obtenerResultado(casillas, conversion + 90);
            }   
            repaint();
        });
    }
    
    public void obtenerResultado(JButton[][] casillas, double resultado){
        if(resultado > 360){
            resultado = resultado - 360;
        }
        
        if((resultado > 0 && resultado < 60) || (resultado > 180 && resultado < 240)) {
            detectarPiezas(casillas, 0, 5, casillas.length - 1, casillas[0].length - 1);
        }
        else if((resultado > 60 && resultado < 120) || (resultado > 240 && resultado < 300)){
            detectarPiezas(casillas, 1, 4, casillas.length - 1, casillas[0].length - 1);
        }
        else if((resultado > 120 && resultado < 180) || (resultado > 300 && resultado < 360)){
            detectarPiezas(casillas, 2, 3, casillas.length - 1, casillas[0].length - 1);
        }
    }
    
    public int detectarPiezas(JButton[][] casillas, int cPieza1, int cPieza2, int tFila, int tColumna){
        if(tFila<0){
            return 0;
        }
        if(tColumna >= 0){ // Sujeto a cambios
            if((casillas[0][cPieza1] == casillas[tFila][tColumna]) || (casillas[0][cPieza2] == casillas[tFila][tColumna])){
                casillas[tFila][tColumna].setEnabled(true);
                casillas[0][cPieza1].setBackground(Color.red);
                casillas[0][cPieza2].setBackground(Color.red);
            }
            return detectarPiezas(casillas, cPieza1, cPieza2, tFila, tColumna - 1);
        }
        return detectarPiezas(casillas, cPieza1, cPieza2, tFila - 1, 5);
    }
    
    public static void casillasDisponibles(JButton[][] casillas, int fila, int columna){
        filaSeleccionada = fila;
        columnaSeleccionada = columna;
        
        for (int[] movimiento : movimientos) {

            int nuevaFila = fila + movimiento[0];
            int nuevaColumna = columna + movimiento[1];

            if (nuevaFila >= 0 && nuevaFila < 6 && nuevaColumna >= 0 && nuevaColumna < 6) {
                if (casillas[nuevaFila][nuevaColumna].getIcon() == null) {
                    casillas[nuevaFila][nuevaColumna].setBackground(Color.GREEN);
                    casillas[nuevaFila][nuevaColumna].setEnabled(true);
                }
            }
        }
        
    }
    
    
    public void notificarJuego(){
        
    }
}
