
package Menus;

import java.awt.*;
import javax.swing.*;

public class MenuMiCuenta extends Menu{
    public MenuMiCuenta(String titulo, JPanel contenedor, CardLayout transicion){
        super(titulo, contenedor, transicion);
        
        JButton btnInformacionPersonal = Botones(columna, panel, "INFORMACION PERSONAL", 40);
        JButton btnCambiarContrasena = Botones(columna, panel, "CAMBIAR CONTRASENA", 40);
        JButton btnCerrarCuenta = Botones(columna, panel, "CERRAR CUENTA", 40);
        JButton btnRegresar = Botones(columna, panel, "REGRESAR", 40);
        
        
        btnRegresar.addActionListener(e -> {
            cambiarPanel("MenuPrincipal");
        });
        
        add(panel);
    }
    
}
