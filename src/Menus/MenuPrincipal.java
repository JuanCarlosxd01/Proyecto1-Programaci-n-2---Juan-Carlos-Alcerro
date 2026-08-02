
package Menus;

import java.awt.*;
import javax.swing.*;

public class MenuPrincipal extends Menu{
    
    public MenuPrincipal(String texto){
        super(texto);
        
        JButton btnJugar = Botones(columna, panel, "JUGAR VAMPIRE WARGAME");
        JButton btnMiCuenta = Botones(columna, panel, "MI CUENTA");
        JButton btnReportes = Botones(columna, panel, "REPORTES");
        JButton btnCerrarSesion = Botones(columna, panel, "CERRAR SESION");
        
        JPanel principalJugar = new JPanel();
        BoxLayout columnaJugar = BoxLayouts(principalJugar);
        principalJugar.setLayout(columnaJugar);
        IniciarSesion sesion = new IniciarSesion(this, principalJugar, usuarios, "Iniciar Sesion", "Nombre de Usuario: ", "Contraseña: ", "Ingresar", "Regresar"); 
        contenedor.add(principalJugar, "Jugar");
        btnJugar.addActionListener(e -> {    
            cambiarPanel("Jugar");
        }); 
    }
}
