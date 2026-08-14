
package Menus;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MenuRanking extends Menu{
    
    private ArrayList<Usuario> ranking = new ArrayList<>();
    private JTextArea areaRank;
    private JScrollPane scroll;
    Usuario temp = null;
    
    public MenuRanking(String titulo, JPanel contenedor, CardLayout transicion, ArrayList<Usuario> usuarios){
        super(titulo, contenedor, transicion);
        ranking = usuarios;
        areaRank = new JTextArea();
        areaRank.setPreferredSize(new Dimension(400, 300));
        areaRank.setOpaque(false);
        areaRank.setEditable(false);
        areaRank.setFocusable(false);
        cambiarFuente();
        scroll = new JScrollPane(areaRank);
        scroll.setPreferredSize(new Dimension(400, 300));
        scroll.setOpaque(false);
        scroll.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));
        scroll.getViewport().setOpaque(false);
        
        ordenarRanking(ranking, ranking.size() - 1, ranking.size() - 1);
        agregarRanking(areaRank);
        
        panel.add(Box.createVerticalStrut(30));
        panel.add(scroll); 
        JButton btnRegresar = Botones(columna, panel, "REGRESAR", 40);
        
        btnRegresar.addActionListener(e -> {
            cambiarPanel("MenuPrincipal");
        });
        
        add(panel);
    }
    
    public int ordenarRanking(ArrayList<Usuario> ranking, int i, int j){
        if(i <= 0){
            return -1;
        }
        if(j > 0){
            temp = ranking.get(i);
            if(temp.getPuntos() > ranking.get(j - 1).getPuntos()){
                ranking.remove(i);
                ranking.add(j - 1, temp);
            }
            return ordenarRanking(ranking, i , j - 1);
        }
        return ordenarRanking(ranking, i - 1, i - 1);
    }
    
    private void cambiarFuente(){
        areaRank.setFont(new Font("Serif", Font.BOLD, 16));
        areaRank.setForeground(Color.WHITE);
        areaRank.setLineWrap(true);
        areaRank.setWrapStyleWord(true);
        areaRank.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    private void agregarRanking(JTextArea areaRank){
        int cont = 0;
        for (int i = 0; i < ranking.size(); i++) {
            cont++;
            areaRank.append(cont + ". " + ranking.get(i).getUsuario() + ": " + ranking.get(i).getPuntos() + " puntos.\n\n");
        }
    }
}
