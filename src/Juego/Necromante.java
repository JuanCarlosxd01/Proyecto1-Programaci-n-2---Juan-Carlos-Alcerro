
package Juego;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Necromante extends Pieza{
    ArrayList<Zombie> zombies = new ArrayList<>();
    String habilidad;
    private int[][] movimientos = {
                  { 2, 0}, 
        { 0, -2},           { 0, 2},
                  {-2, 0}, 
    };
    private JButton[][] casillas;
    private Jugador oponente;
    private int posxZombie;
    private int posyZombie;
    private Zombie zombie = null;
    private int num;
    
    public Necromante(boolean habilitada, int posX, int posY){
        super(4, 3, 1, habilitada, posX, posY);
    }
    
    
    public void ataqueEspecial(){
        if("ATAQUE LANZA".equals(habilidad)){
            ataqueLanza("ATAQUE");
        }
        else if("INVOCAR ZOMBIE".equals(habilidad)){
            invocarZombie(num);
        }
    }
    
    public void ataqueLanza(String accion){
        int[][] casillasAdyacentes = new int[movimientos.length][2];
        for (int i = 0; i < movimientos.length; i++) {
            casillasAdyacentes[i][0] = movimientos[i][0] + getPosX();
            casillasAdyacentes[i][1] = movimientos[i][1] + getPosY();
        }
        for (int i = 0; i < casillasAdyacentes.length; i++) {
            int filaTemp = casillasAdyacentes[i][0];
            int columnaTemp = casillasAdyacentes[i][1];
            if(filaTemp >= 0 && filaTemp < casillas.length && columnaTemp >= 0 && columnaTemp < casillas.length){
                boolean bloqueado = false;
                if(Math.abs(movimientos[i][0]) == 2 || Math.abs(movimientos[i][1]) == 2){
                    int filaMedio = getPosX() + movimientos[i][0] / 2;
                    int columnaMedio = getPosY() + movimientos[i][1] / 2;
                    if(casillas[filaMedio][columnaMedio].getIcon() != null){
                        bloqueado = true;
                    }
                }
                if(!bloqueado && casillas[filaTemp][columnaTemp].getIcon() != null){
                    for (int j = 0; j < oponente.getPiezas().size(); j++) {
                        if(filaTemp == oponente.getPieza(j).getPosX() && columnaTemp == oponente.getPieza(j).getPosY() && oponente.getPieza(j).getHabilitada()){
                            if(accion.equals("ATAQUE")){
                                casillas[filaTemp][columnaTemp].setEnabled(true);
                                casillas[filaTemp][columnaTemp].setOpaque(true);
                                casillas[filaTemp][columnaTemp].setContentAreaFilled(true);
                                casillas[filaTemp][columnaTemp].setBorderPainted(true);
                                casillas[filaTemp][columnaTemp].setBackground(Color.RED);  
                            }
                            else if(accion.equals("OPCIONES")){
                                Partida.hayOpciones = true;
                            }
                            
                        }
                    }
                }
            }
        }
                
    }
    
    public void invocarZombie(int num){
        zombie = new Zombie(true, posxZombie, posyZombie);
        ponerImagen(casillas[posxZombie][posyZombie], "/Imagenes/Zombie"+num+".png");
                
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
        casilla.setDisabledIcon(new ImageIcon(escalada));
    }
    
    public Zombie getZombie(){
        return zombie;
    }
    
    public String getHabilidad(){
        return habilidad;
    }
    
    public void setNum(int num){
        this.num = num;
    }
    
    @Override
    public String toString(){
         return "El Necromante";
     }

}
