
package Menus;

import java.awt.*;
import javax.swing.*;

public class MenuHistorial extends Menu{
    
    private JTextArea areaPartidas;
    private JScrollPane scroll;
    private Usuario usuarioActivo;
    
    public MenuHistorial(String titulo, JPanel contenedor, CardLayout transicion, Usuario usuarioActivo){
        super(titulo, contenedor, transicion);
        this.usuarioActivo = usuarioActivo;
        areaPartidas = new JTextArea();
        areaPartidas.setPreferredSize(new Dimension(400, 300));
        areaPartidas.setOpaque(false);
        areaPartidas.setEditable(false);
        areaPartidas.setFocusable(false);
        cambiarFuente();
        scroll = new JScrollPane(areaPartidas);
        scroll.setPreferredSize(new Dimension(400, 300));
        scroll.setOpaque(false);
        scroll.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));
        scroll.getViewport().setOpaque(false);
        
        agregarPartidas(areaPartidas);
        
        panel.add(Box.createVerticalStrut(30));
        panel.add(scroll); 
        JButton btnRegresar = Botones(columna, panel, "REGRESAR", 40);
        
        btnRegresar.addActionListener(e -> {
            sonidoBoton.reproducir();
            cambiarPanel("MenuPrincipal");
        });
        
        add(panel);
    }
    
    private void cambiarFuente(){
        areaPartidas.setFont(new Font("Serif", Font.BOLD, 16));
        areaPartidas.setForeground(Color.WHITE);
        areaPartidas.setLineWrap(true);
        areaPartidas.setWrapStyleWord(true);
        areaPartidas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    private void agregarPartidas(JTextArea areaPartidas){
        int cont = 0;
        for (int i = 0; i < usuarioActivo.getPartidas().size() ; i++) {
            cont++;
            areaPartidas.append(cont + ". Partida #" +cont+ " : \n" + usuarioActivo.getPartidas().get(i) +"\n\n");
        }
    }
    
}
