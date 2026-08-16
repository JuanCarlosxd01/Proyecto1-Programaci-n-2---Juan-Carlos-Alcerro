
package Menus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import musica.*;

public class IniciarSesion extends JPanel{
    
    MenuDeInicio ventana;
    protected Usuario usuarioActivo;
    ImageIcon imgBoton = new ImageIcon(getClass().getResource("/Imagenes/boton.png"));
    Musica sonidoBoton = new Musica("MusiquitaBoton");
    protected JPasswordField campoContrasena;
    protected JCheckBox chkMostrar;
    protected char caracterOriginal;
    
    public IniciarSesion(MenuDeInicio ventana, JPanel principal, ArrayList<Usuario> usuarios, String txtTitulo, String txtIngCampo1, String txtIngCampo2, String txtBoton1, String txtBoton2){  
        setOpaque(false);
        setSize(800,800);
        this.ventana = ventana; 
        
        JLabel Titulo = new JLabel(txtTitulo);
        Titulo.setForeground(Color.WHITE);
        Titulo.setFont(new Font("Arial", Font.BOLD, 20));
        Titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField campoUsuario = new JTextField(15);
        JPanel ingUsuario = campoTexto(txtIngCampo1, campoUsuario);
        campoContrasena = new JPasswordField(15);
        JPanel ingContrasena = campoTexto(txtIngCampo2, campoContrasena);
        caracterOriginal = campoContrasena.getEchoChar();
        chkMostrar = new JCheckBox("Mostrar contraseña");
        chkMostrar.setOpaque(false);
        chkMostrar.setForeground(Color.WHITE);
        chkMostrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        chkMostrar.addActionListener(e -> {
            mostrarContrasenas(chkMostrar.isSelected());
        });
        
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fila.setOpaque(false);
        JButton btnIngresar = Botones(txtBoton1);
        JButton btnRegresar = Botones(txtBoton2);
        fila.add(btnIngresar);
        fila.add(Box.createHorizontalStrut(50));
        fila.add(btnRegresar);
        
        
        btnIngresar.addActionListener(e -> {
            sonidoBoton.reproducir();
            int numUsuarios = usuarios.size();
            String leerUsuario = campoUsuario.getText();
            String leerContrasena = new String(campoContrasena.getPassword());
            UIManager.put("OptionPane.background", Color.BLACK);
            UIManager.put("Panel.background", Color.BLACK);
            UIManager.put("OptionPane.messageForeground", Color.WHITE);
            accionarBoton(leerUsuario, leerContrasena, usuarios, numUsuarios - 1);
            campoUsuario.setText(""); 
            campoContrasena.setText(""); 
            chkMostrar.setSelected(false);
            campoContrasena.setEchoChar(caracterOriginal);
            limpiarCamposExtra(); 
        });     
        btnRegresar.addActionListener(e -> {
            sonidoBoton.reproducir();
            campoUsuario.setText(""); 
            campoContrasena.setText("");
            chkMostrar.setSelected(false);
            campoContrasena.setEchoChar(caracterOriginal);
            limpiarCamposExtra(); 
            ventana.cambiarPanel("MenuDeInicio");
        });
        
        principal.add(Box.createVerticalStrut(150));
        principal.add(Titulo);
        principal.add(Box.createVerticalStrut(40));
        principal.add(ingUsuario);
        principal.add(Box.createVerticalStrut(20));
        principal.add(ingContrasena);
        principal.add(chkMostrar);
        principal.add(Box.createVerticalStrut(30));
        principal.add(fila);    
        setVisible(true); 
        
        
    }
    
    public JPanel campoTexto(String texto, JTextField campoTxt){
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fila.setOpaque(false);
        JLabel txtLabel = new JLabel(texto);
        txtLabel.setForeground(Color.WHITE);
        fila.add(txtLabel);
        fila.add(Box.createHorizontalStrut(20));
        fila.add(campoTxt);
      
        return fila;
    }
    
    public JButton Botones(String texto){
        Dimension d = new Dimension(200, 60);
        JButton boton = new JButton(texto, imgBoton);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.CENTER);
        boton.setPreferredSize(d);
        boton.setMaximumSize(d);
        
        return boton;
    }
    
    public void accionarBoton(String leerUsuario, String leerContrasena, ArrayList<Usuario> usuarios, int numUsuarios){
        leerUsuario = leerUsuario.replaceAll("\\s+", "");
        if(numUsuarios < 0){
            JOptionPane.showMessageDialog(this, "No hay usuarios registrados en el juego", "Error", JOptionPane.ERROR_MESSAGE);
            ventana.cambiarPanel("MenuDeInicio");
            return;
        }
        
        Usuario usuario = usuarios.get(numUsuarios);

        if (usuario.getUsuario().equals(leerUsuario)) {
            if (usuario.getContrasena().equals(leerContrasena)) {
                usuarioActivo = usuario;
                JOptionPane.showMessageDialog(this, "Ha ingresado correctamente.", "Inicio de sesión", JOptionPane.INFORMATION_MESSAGE);
                MenuPrincipal menuP = new MenuPrincipal(usuarioActivo, usuarios, "MENU PRINCIPAL", ventana.contenedor, ventana.transicion);
                ventana.contenedor.add(menuP, "MenuPrincipal");
                ventana.cambiarPanel("MenuPrincipal");
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                ventana.cambiarPanel("MenuDeInicio");
                return;
            }
        }
        
        if(numUsuarios == 0){
            JOptionPane.showMessageDialog(this, "Nombre de usuario incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
            ventana.cambiarPanel("MenuDeInicio");
            return;
        }
        
        accionarBoton(leerUsuario, leerContrasena, usuarios, numUsuarios - 1);
    }
    
    protected void mostrarContrasenas(boolean mostrarTexto){
        if(mostrarTexto){
            campoContrasena.setEchoChar((char) 0);
        }
        else{
            campoContrasena.setEchoChar(caracterOriginal);
        }
    }
    
    protected void limpiarCamposExtra(){
    
    }

}
