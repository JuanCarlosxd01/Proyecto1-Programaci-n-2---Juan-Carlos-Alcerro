
package Menus;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MenuPrincipal extends Menu{
    private Usuario usuarioActivo;
    
    public MenuPrincipal(Usuario usuarioActivo, ArrayList<Usuario> usuarios, String texto,  JPanel contenedor, CardLayout transicion){
        super(texto, contenedor, transicion);
        this.usuarioActivo = usuarioActivo;
        
        JLabel txtUsuario = new JLabel("Nombre de Usuario: " + usuarioActivo.getUsuario());
        txtUsuario.setForeground(Color.blue);
        txtUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        txtUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(30));
        panel.add(txtUsuario);  
        
        JButton btnJugar = Botones(columna, panel, "JUGAR VAMPIRE WARGAME", 40);
        JButton btnMiCuenta = Botones(columna, panel, "MI CUENTA", 40);
        JButton btnReportes = Botones(columna, panel, "REPORTES", 40);
        JButton btnCerrarSesion = Botones(columna, panel, "CERRAR SESION", 40);  
        
        btnJugar.addActionListener(e -> {
            sonidoBoton.reproducir();
            MenuJugar menuJ = new MenuJugar("JUGAR", contenedor, transicion, usuarios, usuarioActivo);
            contenedor.add(menuJ, "Jugar");
            cambiarPanel("Jugar");
        }); 
        
        
        btnMiCuenta.addActionListener(e -> {  
            sonidoBoton.reproducir();
            MenuMiCuenta menuC = new MenuMiCuenta("MI CUENTA", contenedor, transicion, usuarios, usuarioActivo);
            contenedor.add(menuC, "MiCuenta");
            cambiarPanel("MiCuenta");
        });
        
        
        btnReportes.addActionListener(e -> {
            sonidoBoton.reproducir();
            MenuReportes menuR = new MenuReportes("REPORTES", contenedor, transicion, usuarios, usuarioActivo);
            contenedor.add(menuR, "Reportes");
            cambiarPanel("Reportes");
        });
        
        
        btnCerrarSesion.addActionListener(e -> {
            sonidoBoton.reproducir();
            this.usuarioActivo = null;
            cambiarPanel("MenuDeInicio");
        });
        
        add(panel);
    }
}
