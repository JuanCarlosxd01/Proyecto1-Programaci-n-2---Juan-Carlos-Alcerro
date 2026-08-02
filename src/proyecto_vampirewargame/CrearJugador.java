
package proyecto_vampirewargame;

import javax.swing.*;
import java.awt.*;

public class CrearJugador extends IniciarSesion{
    
    public CrearJugador(MenuDeInicio ventana, JPanel principal){
        super(ventana, principal, "Crear jugador", "Ingrese Usuario: ", "Ingrese Contraseña: ", "Crear", "Regresar");
    }
}
