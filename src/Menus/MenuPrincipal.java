
package Menus;

import java.awt.*;
import javax.swing.*;

public class MenuPrincipal extends Menu{
    
    
    public MenuPrincipal(String texto,  JPanel contenedor, CardLayout transicion){
        super(texto, contenedor, transicion);
        JButton btnJugar = Botones(columna, panel, "JUGAR VAMPIRE WARGAME", 40);
        JButton btnMiCuenta = Botones(columna, panel, "MI CUENTA", 40);
        JButton btnReportes = Botones(columna, panel, "REPORTES", 40);
        JButton btnCerrarSesion = Botones(columna, panel, "CERRAR SESION", 40);
        
        crearPanel("Jugar");
        btnJugar.addActionListener(e -> {    
            cambiarPanel("Jugar");
        }); 
        
        crearPanel("MiCuenta");
        btnMiCuenta.addActionListener(e -> {    
            cambiarPanel("MiCuenta");
        });
        
        crearPanel("Reportes");
        btnReportes.addActionListener(e -> {
            cambiarPanel("Reportes");
        });
        
        crearPanel("CerrarSesion");
        btnCerrarSesion.addActionListener(e -> {
            cambiarPanel("CerrarSesion");
        });
        
        add(panel);
    }
}
