
package Tablero;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import Juego.*;

public class Ruleta extends JPanel{
   
    private boolean[] arcosHabilitados = {true, true, true, true, true, true};
    
    private double angulo = 0;
    private Timer timer;
    private double velocidad = (int)(Math.random()*200);
    private int centroX = 150;
    private int centroY = 150;
    private int radio = 100;  
    private int x;
    private int y;
    private double vueltas;
    private int vEntero;
    private Color color;
    private double resultado;
    private ActionListener listenerDetenido; // listener para saber si se detuvo la ruleta
    private boolean puedeGirar = true;
    
    public Ruleta(Color color){ 
        setOpaque(false);
        this.color = color;
        setPreferredSize(new Dimension(288, 300)); 
        timer();
        girarRuleta();
    }
   
    
    @Override
    protected void paintComponent(Graphics dibujar){
        super.paintComponent(dibujar);
        Graphics2D dibujar2 = (Graphics2D) dibujar;
        
        AffineTransform original = dibujar2.getTransform();
        dibujar2.rotate(Math.toRadians(angulo), centroX, centroY);
        dibujar2.setColor(Color.white);
        dibujar2.fillArc(50, 50, 200, 200, 0, 60);
        dibujar2.setColor(color);
        dibujar2.fillArc(50, 50, 200, 200, 60, 60);
        dibujar2.setColor(Color.white);
        dibujar2.fillArc(50, 50, 200, 200, 120, 60);
        dibujar2.setColor(color);
        dibujar2.fillArc(50, 50, 200, 200, 180, 60);
        dibujar2.setColor(Color.white);
        dibujar2.fillArc(50, 50, 200, 200, 240, 60);
        dibujar2.setColor(color);
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
                 if (distancia <= radio && puedeGirar) { 
                    puedeGirar = false;
                    velocidad = (int)(Math.random()*200);
                    timer.start();

                }       
            }
        });
    }
    
    private void timer(){
        timer = new Timer(16, e ->{
            angulo += velocidad; 
            velocidad *= 0.98;
            
            vueltas = angulo/360;
            vEntero = (int)vueltas;
            double conversion = 360 * (vueltas - (double)vEntero); 
            
            if(velocidad<0.2){
                timer.stop();
                resultado = conversion + 90;
                
                if(listenerDetenido != null){
                    listenerDetenido.actionPerformed(null);
                }
            }   
            repaint();
        });
    }
    
    public String getResultado(){
        if(resultado > 360){
            resultado = resultado - 360;
        }
       
        if((resultado >= 0 && resultado < 60) || (resultado >= 180 && resultado < 240)) {
            return "Hombre Lobo";
        }
        else if((resultado >= 60 && resultado < 120) || (resultado >= 240 && resultado < 300)){
            return "Vampiro";
        }
        else if((resultado >= 120 && resultado < 180) || (resultado >= 300 && resultado < 360)){
            return "Necromante";
        } 
        return "";
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public void setListenerDetenido(ActionListener listener){
        this.listenerDetenido = listener;
    }
    
    public void habilitarRulera(){
        puedeGirar = true;
    } 

}
