
package Menus;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MenuMiCuenta extends Menu{
    
    ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/ImagenPanel.png"));

    
    public MenuMiCuenta(String titulo, JPanel contenedor, CardLayout transicion, ArrayList<Usuario> usuarios, Usuario usuarioActivo){
        super(titulo, contenedor, transicion);
        JButton btnInformacionPersonal = Botones(columna, panel, "INFORMACION PERSONAL", 40);
        JButton btnCambiarContrasena = Botones(columna, panel, "CAMBIAR CONTRASENA", 40);
        JButton btnCerrarCuenta = Botones(columna, panel, "CERRAR CUENTA", 40);
        JButton btnRegresar = Botones(columna, panel, "REGRESAR", 40);
        UIManager.put("OptionPane.background", Color.BLACK);
        UIManager.put("Panel.background", Color.BLACK);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        
        btnInformacionPersonal.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, usuarioActivo.mostrarInformacion());
        });
        
        btnCambiarContrasena.addActionListener(e -> {
            String cambioContra = JOptionPane.showInputDialog("Ingrese la nueva contraseña: ");
            if(cambioContra == null){
                return;
            }
            cambioContra = cambioContra.trim();
            if(cambioContra.isEmpty()){
                JOptionPane.showInputDialog(null,"El campo esta vacio.");
                return;
            }
            if(cambioContra.length() != 5){
                JOptionPane.showInputDialog(null ,"La contraseña debe tener exactamente 5 caracteres." );
                return;
            }
            
            String confirm = JOptionPane.showInputDialog("Confirme la nueva contraseña: ");
            
            if(confirm == null){
                JOptionPane.showInputDialog("El campo esta vacio.");
                return;
            }
            
            if(cambioContra.equals(confirm)){
                usuarioActivo.setContrasena(cambioContra);
                cambioContrasena(usuarios, usuarioActivo, usuarios.size() - 1);
                JOptionPane.showMessageDialog(null, "La contraseña ha sido reestablecida.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Intentelo de nuevo.");
            }
        });
        
        btnCerrarCuenta.addActionListener(e -> {
            sonidoBoton.reproducir();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar la cuenta?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if(opcion == JOptionPane.YES_OPTION){
                desactivarCuenta(usuarios, usuarioActivo, usuarios.size() - 1);
                cambiarPanel("MenuDeInicio"); //Cambia el atributo activo a false, actualizar para que cuando intenten ingresar o crear no pueda y que salga un mensajee 
            }
        });
    
        btnRegresar.addActionListener(e -> {
            sonidoBoton.reproducir();
            cambiarPanel("MenuPrincipal");
        });
        
        add(panel);
    }
    
    public int desactivarCuenta(ArrayList<Usuario> usuarios, Usuario usuarioActivo, int indice){
        if(indice < 0){
            return -1;
        }
        if(usuarios.get(indice).getUsuario().equals(usuarioActivo.getUsuario())){
            usuarios.get(indice).setActivo(false);
            usuarios.remove(indice);
            usuarioActivo = null;
            return indice;
        }
        return desactivarCuenta(usuarios, usuarioActivo, indice - 1);
    }
    
    public int cambioContrasena(ArrayList<Usuario> usuarios, Usuario usuarioActivo, int indice){
        if(indice < 0){
            return -1;
        }
        if(usuarios.get(indice).getUsuario().equals(usuarioActivo.getUsuario())){
            usuarios.get(indice).setContrasena(usuarioActivo.getContrasena());
            return indice;
        }
        return desactivarCuenta(usuarios, usuarioActivo, indice - 1);
    }  
}
