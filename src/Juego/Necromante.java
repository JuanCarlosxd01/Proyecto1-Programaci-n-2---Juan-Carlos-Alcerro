
package Juego;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Necromante extends Pieza{
    ArrayList<Zombie> zombies = new ArrayList<>();
    String habilidad;
    private int[][] movimientos = {
         { 1, -1}, { 1, 0}, { 1, 1},
        { 0, -1},           { 0, 1},
        {-1, -1}, {-1, 0}, {-1, 1},

        { 2, -2}, { 2, 0}, { 2, 2},
        { 0, -2},           { 0, 2},
        {-2, -2}, {-2, 0}, {-2, 2}
    };
    private JButton[][] casillas;
    private Jugador oponente;
    private int posxZombie;
    private int posyZombie;
    private Zombie zombie = null;
    
    public Necromante(boolean habilitada, int posX, int posY){
        super(4, 3, 1, habilitada, posX, posY);
    }
    
    
    public void ataqueEspecial(){
        if(habilidad.equals("ATAQUE LANZA")){
            Ataque = Ataque/2;
            ataqueLanza();
        }
        else if(habilidad.equals("INVOCAR ZOMBIE")){
            invocarZombie();
        }
        else if(habilidad.equals("ATAQUE ZOMBIE")){
            ataqueZombie();
        }
    }
    
    public void ataqueLanza(){
        int[][] casillasAdyacentes = new int[16][2];
        for (int i = 0; i < movimientos.length; i++) {
            casillasAdyacentes[i][0] = movimientos[i][0] + getPosX();
            casillasAdyacentes[i][1] = movimientos[i][1] + getPosY();
        }
        for (int i = 0; i < casillasAdyacentes.length; i++) {
            int filaTemp = casillasAdyacentes[i][0];
            int columnaTemp = casillasAdyacentes[i][1];
            if(filaTemp >= 0 && filaTemp < casillas.length && columnaTemp >= 0 && columnaTemp < casillas.length){
                if(casillas[filaTemp][columnaTemp].getIcon() != null){
                    for (int j = 0; j < 6; j++) {
                        if(filaTemp == oponente.getPieza(j).getPosX() && columnaTemp == oponente.getPieza(j).getPosY() && oponente.getPieza(j).getHabilitada()){
                            casillas[filaTemp][columnaTemp].setEnabled(true);
                            casillas[filaTemp][columnaTemp].setBackground(Color.RED);  
                        }
                    }
                }
            }
        }
                
    }
    
    public void invocarZombie(){
        zombie = new Zombie(true, posxZombie, posyZombie);
        ponerImagen(casillas[posxZombie][posyZombie], "/Imagenes/Zombie.png");
                
    }
    
    public void ataqueZombie(){
        
    }
    
    public void setHabilidad(String habilidad){
        this.habilidad = habilidad;
    }
    
    public void setCasillas(JButton[][] casillas){
        this.casillas = casillas;
    } 
    
    public void setOponente(Jugador oponente){
        this.oponente = oponente;
    } 
    
    public void setPosxZombie(int posxZombie){
        this.posxZombie = posxZombie;
    } 
    
    public void setPosyZombie(int posyZombie){
        this.posyZombie = posyZombie;
    } 
    
    public void ponerImagen(JButton casilla, String archivo){
        ImageIcon imagen = new ImageIcon(getClass().getResource(archivo));
        Image icono = imagen.getImage();
        Image escalada = icono.getScaledInstance(150, 150,Image.SCALE_SMOOTH);
        casilla.setIcon(new ImageIcon(escalada));
    }
    
    public Zombie getZombie(){
        return zombie;
    }
}
