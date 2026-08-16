
package Tablero;

import java.awt.*;
import javax.swing.*;
import Menus.*;
import Juego.*;
import musica.*;


public final class VentanaTablero extends JPanel{
    
    CardLayout transicion;
    JPanel contenedor;
    JPanel panelPrincipal;
    BorderLayout border;
    JButton btnHabilidad;
    JButton btnAtacar;
    JButton btnMover;
    JPanel panelRuleta = new JPanel(){
        private Image fondo = new ImageIcon(getClass().getResource("/Imagenes/PanelRuleta.jpeg")).getImage();
        
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    };
    private PanelFinalPartida panelFinal;
    private VentanaPrincipal ventana;
    ImageIcon imgBoton = new ImageIcon(getClass().getResource("/Imagenes/boton2.png"));
    Musica musicaTablero;
    
    public VentanaTablero(VentanaPrincipal ventana, Usuario usuarioActivo, Usuario usuarioOponente, JPanel contenedor, CardLayout transicion){
        this.ventana = ventana;
        this.contenedor = contenedor;
        this.transicion = transicion;
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        border = new BorderLayout();
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(border);
        musicaTablero = new Musica("MusiquitaJuego");
        musicaTablero.setVolumen(-15.0f);
        musicaTablero.repetir();
        
        panelRuleta.setLayout(new BoxLayout(panelRuleta, BoxLayout.Y_AXIS));
        JPanel pBotones = new JPanel();
        btnAtacar = Botones("ATACAR");
        btnHabilidad = Botones("HABILIDAD"); 
        btnMover = Botones("MOVER"); 
        
        Tablero tablero = new Tablero(panelPrincipal);
        
        PanelInformacion panelI = new PanelInformacion(panelPrincipal);
        
        PanelHistorial panelH = new PanelHistorial(panelPrincipal);  
        
        Partida partida = new Partida(tablero, usuarioActivo, usuarioOponente, btnAtacar, btnHabilidad, btnMover, panelH, panelI, panelPrincipal, this);
        
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
        add(panelPrincipal);
        ventana.revalidate();
        ventana.repaint();
    }
    
    public JButton Botones(String texto){
        Dimension d = new Dimension(120, 40);
        JButton boton = new JButton(texto, imgBoton);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setPreferredSize(d);
        boton.setMinimumSize(d);
        boton.setMaximumSize(d);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.CENTER);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);     
        return boton;
    }
    public JPanel getPanelRuleta(){
        return panelRuleta;
    }
    
    public void mostrarPanelFinal(String ganador, String perdedor, String forma){
        panelFinal = new PanelFinalPartida(ganador, perdedor, forma);
        panelFinal.setBounds(0, 0, 1536, 864);
        contenedor.add(panelFinal, "panelFinal");
        transicion.show(contenedor, "panelFinal");
        ventana.setSize(800,800);
        ventana.setLocationRelativeTo(null);
        panelFinal.setVisible(true);
        Timer timer = new Timer(3000, e ->{
            transicion.show(contenedor, "MenuPrincipal");
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    public Musica getMusicaTablero(){
        return musicaTablero;
    }
  
   
}
