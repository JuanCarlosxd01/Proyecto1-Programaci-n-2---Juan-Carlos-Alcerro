
package Menus;

import javax.swing.*;
import java.util.ArrayList;

public class CrearJugador extends IniciarSesion{
    
    private JPasswordField campoConfirmacion;
            
    public CrearJugador(MenuDeInicio ventana, JPanel principal, ArrayList<Usuario> usuarios){
        super(ventana, principal, usuarios, "Crear jugador", "Ingrese Nombre de Usuario: ", "Ingrese Contraseña: ", "Crear", "Regresar");
        campoConfirmacion = new JPasswordField(15);
        JPanel panelConfirmacion = campoTexto("Confirme Contraseña: ", campoConfirmacion);
        chkMostrar.setText("Mostrar contraseñas");
        principal.remove(chkMostrar);
        principal.add(panelConfirmacion, 6);
        principal.add(Box.createVerticalStrut(10), 7);
        principal.add(chkMostrar, 8);
        principal.revalidate();
        principal.repaint();
    }
    
    // si los campos estan vacios debe poner un aviso de que estan vacios 
    @Override
    public void accionarBoton(String leerUsuario, String leerContrasena, ArrayList<Usuario> usuarios, int numUsuarios){
        leerUsuario = leerUsuario.replaceAll("\\s+", "");
        String confirmacion = new String (campoConfirmacion.getPassword());
        if(leerUsuario.isEmpty() || leerContrasena.isEmpty() || confirmacion.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            ventana.cambiarPanel("MenuDeInicio");
            return;
        }
        if(!leerContrasena.equals(confirmacion)){
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            ventana.cambiarPanel("MenuDeInicio");
            return;
        }
            
        if(leerContrasena.length() != 5){
            JOptionPane.showMessageDialog(this, "La contraseña debe tener 5 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            ventana.cambiarPanel("MenuDeInicio");
            return;
        }
        
        if(numUsuarios < 0){
            Usuario usuario = new Usuario(leerUsuario, leerContrasena);
            usuarios.add(usuario);
            usuarioActivo = usuario;
            JOptionPane.showMessageDialog(this, "Usuario creado correctamente", "Inicio de sesión", JOptionPane.INFORMATION_MESSAGE);
            MenuPrincipal menuP = new MenuPrincipal(usuarioActivo, usuarios, "MENU PRINCIPAL", ventana.contenedor, ventana.transicion);
            ventana.contenedor.add(menuP, "MenuPrincipal");
            ventana.cambiarPanel("MenuPrincipal");
            return;
        }
        
        if(leerUsuario.equals(usuarios.get(numUsuarios).getUsuario())){
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya no esta disponible", "Error", JOptionPane.ERROR_MESSAGE);
            ventana.cambiarPanel("MenuDeInicio");
            return;
        }
        
        accionarBoton(leerUsuario, leerContrasena, usuarios, numUsuarios - 1);
    }
    
    @Override
    protected void mostrarContrasenas(boolean mostrarTexto){
        super.mostrarContrasenas(mostrarTexto);
        if(campoConfirmacion != null){
            if(mostrarTexto){
                campoConfirmacion.setEchoChar((char) 0);
            }
            else{
                campoConfirmacion.setEchoChar(caracterOriginal);
            }
        }
    }
    
    @Override
    protected void limpiarCamposExtra(){
        campoConfirmacion.setText("");
        campoConfirmacion.setEchoChar(caracterOriginal);
    }
    
}
