
package Menus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IniciarSesion extends JPanel{
    
    MenuDeInicio ventana;
    private String txtMensaje = "";
    protected Usuario usuarioActivo;
    
    public IniciarSesion(MenuDeInicio ventana, JPanel principal, ArrayList<Usuario> usuarios, String txtTitulo, String txtIngCampo1, String txtIngCampo2, String txtBoton1, String txtBoton2){  
        setSize(800,800);
        this.ventana = ventana; 
        
        JLabel Titulo = new JLabel(txtTitulo);
        Titulo.setForeground(Color.BLACK);
        Titulo.setFont(new Font("Arial", Font.BOLD, 15));
        Titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField campoUsuario = new JTextField(15);
        JPanel ingUsuario = campoTexto(txtIngCampo1, campoUsuario);
        JTextField campoContrasena = new JTextField(15);
        JPanel ingContrasena = campoTexto(txtIngCampo2, campoContrasena); 
        
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnIngresar = Botones(txtBoton1);
        JButton btnRegresar = Botones(txtBoton2);
        fila.add(btnIngresar);
        fila.add(Box.createHorizontalStrut(50));
        fila.add(btnRegresar);
        JLabel mensaje = new JLabel(txtMensaje);
        mensaje.setForeground(Color.red);
        mensaje.setFont(new Font("Arial", Font.BOLD, 10));
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnIngresar.addActionListener(e -> {
            int numUsuarios = usuarios.size();
            String leerUsuario = campoUsuario.getText();
            String leerContrasena = campoContrasena.getText();
            txtMensaje = accionarBoton(leerUsuario, leerContrasena, usuarios, numUsuarios - 1);  
            mensaje.setText(txtMensaje);
            campoUsuario.setText(""); //sujeto a cambios
            campoContrasena.setText(""); // sujeto a cambios
        });     
        btnRegresar.addActionListener(e -> {
            ventana.cambiarPanel("MenuDeInicio");
        });
        
        principal.add(Box.createVerticalStrut(80));
        principal.add(Titulo);
        principal.add(Box.createVerticalStrut(80));
        principal.add(ingUsuario);
        principal.add(Box.createVerticalStrut(60));
        principal. add(ingContrasena);
        principal.add(Box.createVerticalStrut(60));
        principal.add(mensaje);
        principal.add(Box.createVerticalStrut(60));
        principal.add(fila);    
        setVisible(true); 
        
        
    }
    
    public JPanel campoTexto(String texto, JTextField campoTxt){
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fila.add(new JLabel(texto));
        fila.add(campoTxt);
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
    
    public String accionarBoton(String leerUsuario, String leerContrasena, ArrayList<Usuario> usuarios, int numUsuarios){
        if(numUsuarios < 0){
            return "No hay usuarios registrados en el juego";
        }
        
        Usuario usuario = usuarios.get(numUsuarios);

        if (usuario.getUsuario().equals(leerUsuario)) {
            if (usuario.getContrasena().equals(leerContrasena)) {
                usuarioActivo = usuario;
                MenuPrincipal menuP = new MenuPrincipal(usuarioActivo, "MENU PRINCIPAL", ventana.contenedor, ventana.transicion);
                ventana.contenedor.add(menuP, "MenuPrincipal");
                ventana.cambiarPanel("MenuPrincipal");
                return "Ha ingresado correctamente.";
            } else {
                return "Contraseña incorrecta.";
            }
        }
        
        if(numUsuarios == 0){
            return "Nombre de usuario incorrecto.";
        }
        
        return accionarBoton(leerUsuario, leerContrasena, usuarios, numUsuarios - 1);
    }

}
