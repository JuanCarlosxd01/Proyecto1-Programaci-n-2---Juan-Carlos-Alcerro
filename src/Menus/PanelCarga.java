
package Menus;

import javax.swing.*;
import java.awt.*;

public class PanelCarga extends JPanel{
     public PanelCarga() {

        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        JLabel label = new JLabel("Cargando partida...");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 30));

        add(label);
    }
}
