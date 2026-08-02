
package proyecto_vampirewargame;

import javax.swing.*;
import java.awt.*;

public class IniciarSesion extends JPanel{
    
    MenuDeInicio ventana;
    public IniciarSesion(MenuDeInicio ventana, JPanel principal, String txtTitulo, String txtIngCampo1, String txtIngCampo2, String txtBoton1, String txtBoton2){  
        setSize(800,800);
        this.ventana = ventana; 
        
        JLabel Titulo = new JLabel(txtTitulo);
        Titulo.setForeground(Color.BLACK);
        Titulo.setFont(new Font("Arial", Font.BOLD, 15));
        Titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel ingUsuario = campoTexto(txtIngCampo1);
        JPanel ingContrasena = campoTexto(txtIngCampo2);
        
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnIngresar = Botones(txtBoton1);
        JButton btnRegresar = Botones(txtBoton2);
        fila.add(btnIngresar);
        fila.add(Box.createHorizontalStrut(50));
        fila.add(btnRegresar);
        
        principal.add(Box.createVerticalStrut(80));
        principal.add(Titulo);
        principal.add(Box.createVerticalStrut(80));
        principal.add(ingUsuario);
        principal.add(Box.createVerticalStrut(60));
        principal. add(ingContrasena);
        principal.add(Box.createVerticalStrut(60));
        principal.add(fila);    
        setVisible(true); 
        
        
    }
    
    public JPanel campoTexto(String texto){
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fila.add(new JLabel(texto));
        fila.add(new JTextField(15));
        fila.add(Box.createHorizontalStrut(50));
      
        return fila;
    }
    
    public static JButton Botones(String texto){
        Dimension d = new Dimension(300, 80);
        JButton boton = new JButton(texto);
        boton.setPreferredSize(d);
        boton.setMaximumSize(d);
        
        return boton;
    }

}
