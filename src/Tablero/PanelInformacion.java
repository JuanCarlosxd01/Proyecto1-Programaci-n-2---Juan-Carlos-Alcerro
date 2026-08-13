
package Tablero;

import java.awt.*;
import javax.swing.*;

public class PanelInformacion extends JPanel{
    
    Image fondo = new ImageIcon(getClass().getResource("/Imagenes/PanelInformacion.jpeg")).getImage();
    private JLabel lblJugador;
    private JLabel lblRival;
    private JLabel lblTurno;
    
    private JLabel lblPieza;
    private JLabel lblPosicion;
    
    private JLabel lblVida;
    private JLabel lblEscudo;
    private JLabel lblAtaque;
    
    private JLabel lblIntentos;
    private JButton btnRendirse;
    private ImageIcon boton = new ImageIcon(getClass().getResource("/Imagenes/btnRendirse.png"));
    private Image escalada;
    
    public PanelInformacion(JPanel panelPrincipal){ 
        Image icono = boton.getImage();
        escalada = icono.getScaledInstance(160, 65,Image.SCALE_SMOOTH);
        GridBagLayout layoutPanelI = new GridBagLayout();
        setLayout(layoutPanelI);        
        setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        setPreferredSize(new Dimension(0, 200));
        panelPrincipal.add(this, BorderLayout.SOUTH);
        crearComponentes();
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
    
    private void crearComponentes(){
        lblJugador = new JLabel("Jugador: ");
        lblRival = new JLabel("Rival: -");
        lblTurno = new JLabel("Turno: -");

        lblPieza = new JLabel("Pieza: -");
        lblPosicion = new JLabel("Posición: -");

        lblVida = new JLabel("❤️ Vida: -");
        lblEscudo = new JLabel("🛡 Escudo: -");
        lblAtaque = new JLabel("⚔ Ataque: -");
        
        agregarBloque("JUGADORES", new JLabel[]{lblJugador, lblRival, lblTurno}, 0);

        agregarBloque("PIEZA SELECCIONADA", new JLabel[]{lblPieza, lblPosicion}, 1);

        agregarBloque("ESTADISTICAS", new JLabel[]{lblVida, lblEscudo, lblAtaque}, 2);
        
        GridBagConstraints gbcRuleta = new GridBagConstraints();
        gbcRuleta.gridx = 3;
        gbcRuleta.gridy = 0;
        gbcRuleta.weightx = 1;
        gbcRuleta.weighty = 1;
        gbcRuleta.fill = GridBagConstraints.BOTH;
        gbcRuleta.insets = new Insets(10, 15, 10, 15);
        add(crearPanelRuleta(), gbcRuleta);
    }
    
    private void agregarBloque(String titulo, JLabel[] etiquetas, int columna){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = columna;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont( new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(0,0,153));
        GridBagConstraints tituloGbc = new GridBagConstraints();
        tituloGbc.gridx = 0;
        tituloGbc.gridy = 0;   
        tituloGbc.weightx = 1;
        tituloGbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lblTitulo, tituloGbc);
        for (int i = 0; i < etiquetas.length; i++) {
            etiquetas[i].setFont(new Font("Verdana", Font.BOLD, 16));
            etiquetas[i].setForeground(new Color(0,0,153));
            GridBagConstraints textoGbc = new GridBagConstraints();
            textoGbc.gridx = 0;
            textoGbc.gridy = i+1;
            textoGbc.weightx = 1;
            textoGbc.fill = GridBagConstraints.HORIZONTAL;
            textoGbc.insets = new Insets(4, 10, 4, 10);
            panel.add(etiquetas[i], textoGbc);
        }
            
        add(panel, gbc);
    }
    
    private JPanel crearPanelRuleta() {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        JLabel titulo = new JLabel("RULETA");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        titulo.setForeground(new Color(0,0,153));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblIntentos = new JLabel("Intentos de ruleta: 0");
        lblIntentos.setFont(new Font("Verdana", Font.BOLD, 16));
        lblIntentos.setForeground(new Color(0,0,153));

        btnRendirse = new JButton();
        btnRendirse.setPreferredSize(new Dimension(150, 100));
        btnRendirse.setIcon(new ImageIcon(escalada));
        btnRendirse.setContentAreaFilled(false);
        btnRendirse.setMargin(new Insets(0, 0, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 10, 5);
        panel.add(titulo, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 10, 8, 10);
        panel.add(lblIntentos, gbc);
        gbc.gridy = 2;
        gbc.insets = new Insets(8, 10, 5, 10);

        panel.add(btnRendirse, gbc);

        return panel;
    }
    
    public void actualizarJugador(String jugador) {
        lblJugador.setText("Jugador: " + jugador);
    }

    public void actualizarRival(String rival) {
        lblRival.setText("Rival: " + rival);
    }

    public void actualizarTurno(String turno) {
        lblTurno.setText("Turno del jugador: " + turno);
    }

    public void actualizarPieza(String pieza) {
        lblPieza.setText("Pieza: " + pieza);
    }

    public void actualizarPosicion(int fila, int columna) {
        lblPosicion.setText("Posición: (" + fila + ", " + columna + ")");
    }

    public void actualizarVida(int vida, int vidaMaxima) {
        lblVida.setText("❤️ Vida: " + vida + " / " + vidaMaxima);
    }

    public void actualizarEscudo(int escudo, int escudoMaximo) {
        lblEscudo.setText("🛡 Escudo: " + escudo + " / " + escudoMaximo);
    }

    public void actualizarAtaque(int ataque) {
        lblAtaque.setText("⚔ Ataque: " + ataque);
    }

    public void actualizarIntentos(int intentos) {
        lblIntentos.setText("Intentos de ruleta: " + intentos);
    }

    public JButton getBtnRendirse() {
        return btnRendirse;
    }
    
    
    
}
