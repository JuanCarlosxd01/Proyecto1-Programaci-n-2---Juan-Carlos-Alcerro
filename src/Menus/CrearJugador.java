
package Menus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CrearJugador extends IniciarSesion{
    
    
    public CrearJugador(MenuDeInicio ventana, JPanel principal, ArrayList<Usuario> usuarios){
        super(ventana, principal, usuarios, "Crear jugador", "Ingrese Nombre de Usuario: ", "Ingrese Contraseña: ", "Crear", "Regresar");
    }
    
    // si los campos estan vacios debe poner un aviso de que estan vacios 
    @Override
    public String accionarBoton(String leerUsuario, String leerContrasena, ArrayList<Usuario> usuarios, int numUsuarios){
        leerUsuario = leerUsuario.replaceAll("\\s+", "");
        if(leerContrasena.length() != 5){
            return "La contraseña debe tener 5 caracteres.";
        }
        
        if(numUsuarios < 0){
            Usuario usuario = new Usuario(leerUsuario, leerContrasena);
            usuarios.add(usuario);
            usuarioActivo = usuario;
            MenuPrincipal menuP = new MenuPrincipal(usuarioActivo, "MENU PRINCIPAL", ventana.contenedor, ventana.transicion);
            ventana.contenedor.add(menuP, "MenuPrincipal");
            ventana.cambiarPanel("MenuPrincipal");
            return "Usuario creado correctamente";
        }
        
        if(leerUsuario.equals(usuarios.get(numUsuarios).getUsuario())){
            return "El nombre de usuario ya no esta disponible";
        }
        
        return accionarBoton(leerUsuario, leerContrasena, usuarios, numUsuarios - 1);
    }
    
}
