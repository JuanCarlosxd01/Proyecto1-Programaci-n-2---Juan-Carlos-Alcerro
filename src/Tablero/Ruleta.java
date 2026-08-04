
package Tablero;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class Ruleta extends JPanel{
    
    private double angulo = 0;
    private Timer timer;
    private double velocidad = 30;
    int centroX = 150;
    int centroY = 150;
    int radio = 100;  
    int x;
    int y;
    
    public Ruleta(JPanel panelPrincipal){ 
        
        setLayout(new GridBagLayout());
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(288, 0));
        panelPrincipal.add(this, BorderLayout.WEST);
        timer();
        girarRuleta();
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
                        velocidad = 30;
                        timer.start();
                    }
                }       
            }
        });
    }
    
    public void timer(){
        timer = new Timer(16, e ->{
            angulo += velocidad; 
            velocidad *= 0.98;
            
            if(velocidad<0.2){
                timer.stop();
            }   
            repaint();
        });
    }
    
    public void obtenerResultado(){
        
    }
    
    public void noitificarJuego(){
        
    }
}
