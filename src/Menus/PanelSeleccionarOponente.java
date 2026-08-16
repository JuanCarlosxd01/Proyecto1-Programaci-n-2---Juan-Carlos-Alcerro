
package Menus;

import Tablero.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class PanelSeleccionarOponente extends Menu{
    
    
    public PanelSeleccionarOponente(String titulo, JPanel contenedor, CardLayout transicion, ArrayList<Usuario> usuarios, Usuario usuarioActivo){
        super(titulo, contenedor, transicion);
        DefaultComboBoxModel<Usuario> modelo = new DefaultComboBoxModel<>();
        
        for(Usuario usuario : usuarios){
            if(!usuario.equals(usuarioActivo)){
               modelo.addElement(usuario); 
            }
        }
        JComboBox<Usuario> lista = new JComboBox<>(modelo);// Hacer que los jugadores tengan un usuario 
        
        panel.add(Box.createVerticalStrut(80));
        panel.add(lista); 
        panel.add(Box.createVerticalStrut(80));
        
        JLabel mensaje = new JLabel("");
        mensaje.setForeground(Color.red);
        mensaje.setFont(new Font("Arial", Font.BOLD, 10));
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(mensaje);
        
        JButton btnContinuar = Botones(columna, panel, "CONTINUAR", 60);
        JButton btnRegresar = Botones(columna, panel, "REGRESAR", 60);  
        
        add(panel);
        
        btnContinuar.addActionListener(e ->{ 
            sonidoBoton.reproducir();
            Usuario usuarioOponente = (Usuario) lista.getSelectedItem();
            if(usuarioOponente != null){
                ventana.getMusicaFondo().detener();
                ventana.cargarPartida(usuarioActivo, usuarioOponente, contenedor, transicion);
            }
            else{
                mensaje.setText("NO HAY MAS USUARIOS REGISTRADOS");
            }
            
        });
        
        btnRegresar.addActionListener(e ->{
            cambiarPanel("Jugar");
        });
    } 
    
    
}
