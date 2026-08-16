
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
    
    private Image imagenRuleta1;
    private Image imagenRuleta2;
    private Image imagenFlecha;
    private boolean imagenMostrar;
    private boolean deshabilitar1[] = {false, false, false, false, false, false};
    private boolean deshabilitar2[] = {false, false, false, false, false, false};
    
    public Ruleta(boolean imagenMostrar){ 
        setOpaque(false);
        imagenRuleta1 = new ImageIcon(getClass().getResource("/Imagenes/ruleta1.png")).getImage();
        imagenRuleta2 = new ImageIcon(getClass().getResource("/Imagenes/ruleta2.png")).getImage();
        imagenFlecha = new ImageIcon(getClass().getResource("/Imagenes/Flechita.png")).getImage();
        this.imagenMostrar = imagenMostrar;
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
        
        if(imagenMostrar){
           dibujar2.drawImage(imagenRuleta2, 50, 50, 200, 200, this);
            if(deshabilitar1[1]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 330, 60);
            }
            if(deshabilitar1[0]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 30, 60);
            }
            if(deshabilitar1[2]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 90, 60);
            }
            if(deshabilitar1[4]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 150, 60);
            }
            if(deshabilitar1[5]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 210, 60);
            }
            if(deshabilitar1[3]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 270, 60);
            }  
        }
        else{
           dibujar2.drawImage(imagenRuleta1, 50, 50, 200, 200, this);
           if(deshabilitar2[1]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 330, 60);
            }
            if(deshabilitar2[0]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 30, 60);
            }
            if(deshabilitar2[2]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 90, 60);
            }
            if(deshabilitar2[4]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 150, 60);
            }
            if(deshabilitar2[5]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 210, 60);
            }
            if(deshabilitar2[3]){
                dibujar2.setColor(new Color(255, 255, 255, 100));
                dibujar2.fillArc(50, 50, 200, 200, 270, 60);
            }
        }    
        
        dibujar2.setTransform(original);
        dibujar2.setColor(Color.BLACK);
        dibujar2.drawImage(imagenFlecha, 135, 10, 30, 70, this);
     
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
        boolean temp[];
        if(imagenMostrar){
            temp = deshabilitar1;
        }
        else{
            temp = deshabilitar2;
        } 
       
        if((resultado >= 210 && resultado < 270) && !temp[5]) {
            return "Hombre Lobo";
        }
        else if((resultado >= 30 && resultado < 90) && !temp[0]){
            return "Hombre Lobo";
        }
        if((resultado >= 150 && resultado < 210) && !temp[4]){
            return "Vampiro";
        }
        else if(((resultado >= 330 && resultado <= 360) || (resultado > 0 && resultado < 30)) && !temp[1]){
            return "Vampiro";
        }
        if((resultado >= 90 && resultado < 150) && !temp[2]){
            return "Necromante";
        } 
        else if((resultado >= 270 && resultado < 330) && !temp[3]){
            return "Necromante";
        }
        return "ninguna";
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public void setImagenMostrar(boolean imagenMostrar){
        this.imagenMostrar = imagenMostrar;
    }
    
    public void setListenerDetenido(ActionListener listener){
        this.listenerDetenido = listener;
    }
    
    public void habilitarRuleta(){
        puedeGirar = true;
    } 
    
    public void setdeshabilitar1(int i){
        deshabilitar1[i] = true;
    }
    
    public void setdeshabilitar2(int i){
        deshabilitar2[i] = true;
    }
    

}
