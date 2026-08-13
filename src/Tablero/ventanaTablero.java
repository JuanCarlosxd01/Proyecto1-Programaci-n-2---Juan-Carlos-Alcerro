
package Tablero;

import java.awt.*;
import javax.swing.*;
import Menus.*;
import Juego.*;


public final class VentanaTablero extends JPanel{
    
    JPanel panelPrincipal;
    BorderLayout border;
    static JButton btnHabilidad;
    static JButton btnAtacar;
    static JButton btnMover;
    static JPanel panelRuleta = new JPanel(){
        private Image fondo = new ImageIcon(getClass().getResource("/Imagenes/PanelRuleta.jpeg")).getImage();
        
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    };
    
    public VentanaTablero(VentanaPrincipal ventana, Usuario usuarioActivo, Usuario usuarioOponente){
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        border = new BorderLayout();
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(border);
        
        panelRuleta.setLayout(new BoxLayout(panelRuleta, BoxLayout.Y_AXIS));
        JPanel pBotones = new JPanel();
        btnAtacar = Botones("ATACAR");
        btnHabilidad = Botones("HABILIDAD"); 
        btnMover = Botones("MOVER"); 
        
        Tablero tablero = new Tablero(panelPrincipal);
        
        PanelInformacion panelI = new PanelInformacion(panelPrincipal);
        
        PanelHistorial panelH = new PanelHistorial(panelPrincipal);  
        
        Partida partida = new Partida(tablero, usuarioActivo, usuarioOponente, btnAtacar, btnHabilidad, btnMover, panelH);
        
        pBotones.setLayout(new GridLayout(3, 1, 5, 5));
        panelRuleta.add(partida.getRuleta());
        panelRuleta.add(Box.createVerticalStrut(10));

        panelRuleta.add(btnAtacar); 
        panelRuleta.add(Box.createVerticalStrut(10));
        panelRuleta.add(btnHabilidad); 
        panelRuleta.add(Box.createVerticalStrut(10));
        panelRuleta.add(btnMover); 
        panelRuleta.add(Box.createVerticalStrut(60));
        panelPrincipal.add(panelRuleta, BorderLayout.WEST);
        
        ventana.getContentPane().removeAll();
        ventana.add(panelPrincipal);
        ventana.revalidate();
        ventana.repaint();
    }
    
    public static JButton Botones(String texto){
        Dimension d = new Dimension(120, 40);
        JButton boton = new JButton(texto);
        boton.setPreferredSize(d);
        boton.setMinimumSize(d);
        boton.setMaximumSize(d);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);     
        return boton;
    }
    public static JPanel getPanelRuleta(){
        return panelRuleta;
    }
  
   
}
