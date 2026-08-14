
package Juego;

import javax.swing.*;
import java.awt.*;

public class PanelFinalPartida extends JPanel{
    
    private JLabel lblGanador;
    
    public PanelFinalPartida(String ganador, String perdedor, String forma){
        setOpaque(false);
        setLayout(new GridBagLayout());
        JPanel panelMensaje = new JPanel();
        panelMensaje.setOpaque(false);
        
        panelMensaje.setLayout(new BoxLayout(panelMensaje, BoxLayout.Y_AXIS));
        if(forma.equals("rendirse")){
            lblGanador = new JLabel(perdedor + " se ha retirado. ¡Felicidades, " + ganador +", has ganado 3 puntos!");
        }
        else{
            lblGanador = new JLabel("¡" + ganador + "ha ganado!");
        }
        
        
        lblGanador.setForeground(Color.WHITE);
        lblGanador.setFont(new Font("Arial", Font.BOLD, 30));
        lblGanador.setAlignmentX(Component.CENTER_ALIGNMENT);      
        
        panelMensaje.add(lblGanador);
        panelMensaje.add(Box.createVerticalStrut(30));
        
        add(panelMensaje);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g.create();
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
    
}
