
package Juego;

import javax.swing.*;
import java.awt.*;
import musica.*;

public class PanelFinalPartida extends JPanel{
    
    private JLabel lblPerdedor;
    private JLabel lblGanador;
    Musica musicaFinal = new Musica("MusiquitaGanar");
    
    public PanelFinalPartida(String ganador, String perdedor, String forma){
        musicaFinal.reproducir();
        setOpaque(false);
        setLayout(new GridBagLayout());
        JPanel panelMensaje = new JPanel();
        panelMensaje.setOpaque(false);
        
        panelMensaje.setLayout(new BoxLayout(panelMensaje, BoxLayout.Y_AXIS));
        if(forma.equals("rendirse")){
            lblPerdedor = new JLabel(perdedor + " se ha retirado.");
            lblGanador = new JLabel("¡Felicidades, " + ganador +", has ganado 3 puntos!");
        }
        else if(forma.equals("Acabar con todas las piezas")){
            lblPerdedor = new JLabel(ganador + " venció a " + perdedor + ".");
            lblGanador = new JLabel("¡Felicidades has ganado 3 puntos!");
        }
        lblPerdedor.setForeground(Color.WHITE);
        lblPerdedor.setFont(new Font("Arial", Font.BOLD, 30));
        lblPerdedor.setAlignmentX(Component.CENTER_ALIGNMENT); 
        lblGanador.setForeground(Color.WHITE);
        lblGanador.setFont(new Font("Arial", Font.BOLD, 30));
        lblGanador.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        panelMensaje.add(lblPerdedor);
        panelMensaje.add(Box.createVerticalStrut(30));
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
