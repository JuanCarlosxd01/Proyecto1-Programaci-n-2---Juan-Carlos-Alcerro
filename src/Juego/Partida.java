
package Juego;

import Tablero.*;
import javax.swing.*;
import java.awt.*;
import Menus.*;

public class Partida {
    
    Jugador jugador1;
    Jugador jugador2;
    Tablero tablero;
    JButton[][] casillas;
    Jugador jugadorTurno;
    Jugador jugadorRival;
    Ruleta ruleta;
    int[][] movimientos = { {1, -1},{ 1, 0},{ 1, 1},
                            {0, -1},       { 0, 1}, 
                            {-1,-1},{-1, 0},{-1, 1}};
    boolean piezasSeleccionadas = false;
    int numPieza;
    boolean moverPieza = false;
    boolean atacarEnemigo = false;
    
    int xVieja;
    int yVieja;
    JButton botones[] = new JButton[3];
    int xPieza;
    int yPieza;

    public Partida(Tablero tablero, Usuario usuarioActivo, Usuario usuarioOponente, JButton btnAtacar, JButton btnHabilidad, JButton btnMover){
        ruleta = new Ruleta(Color.GRAY);
        this.tablero = tablero;
        casillas = tablero.getCasillas();
        botones[0] = btnAtacar;
        botones[1] = btnHabilidad;
        botones[2] = btnMover;
        
        jugador1 = new Jugador(usuarioActivo, false, Color.BLACK, 0);
        jugador2 = new Jugador(usuarioOponente, false, Color.gray, 5);
        jugadorTurno = jugador1;
        jugadorRival = jugador2;
        clickCasilla();
        clickBotones();
        
        tablero.inhabilitarCasillas(5, 5);
        iniciarTurno();
    }
    
    public void iniciarTurno(){
        botones[0].setEnabled(false);
        botones[1].setEnabled(false);
        botones[2].setEnabled(false);
        ruleta.habilitarRulera();
        
        jugadorTurno.setTurno(true);
        if(jugadorTurno == jugador1){
            ruleta.setColor(Color.GRAY);
            
            ruleta.setListenerDetenido(e ->{
                habilitarPiezas(); 
            });
        }
        
        else{
            ruleta.setColor(Color.BLACK);
            
            ruleta.setListenerDetenido(e ->{
                habilitarPiezas();
            });
        }
    }   
    
    public void terminarTurno(){
        numPieza = 0;
        xVieja = 0;
        yVieja = 0;
        jugadorTurno.setTurno(false);
        cambiarTurno();
       
    }
    
    public void cambiarTurno(){
        if(jugadorTurno == jugador1){
            jugadorTurno = jugador2; 
            jugadorRival = jugador1;
        }
        else{
            jugadorTurno = jugador1;
            jugadorRival = jugador2;
        }
        iniciarTurno();
    }  
    
    public void habilitarPiezas(){
        int xTemp1;
        int yTemp1;
        int xTemp2;
        int yTemp2;
        boolean hayPieza = false;
        
        String resultado = ruleta.getResultado();
        if(resultado.equals("Hombre Lobo")){
            if(jugadorTurno.getPieza(0).getHabilitada()){
                xTemp1 = jugadorTurno.getPieza(0).getPosX();
                yTemp1 = jugadorTurno.getPieza(0).getPosY();
                casillas[xTemp1][yTemp1].setEnabled(true);
                casillas[xTemp1][yTemp1].setBackground(Color.GREEN); 
                hayPieza = true;
            }
            if(jugadorTurno.getPieza(5).getHabilitada()){
                xTemp2 = jugadorTurno.getPieza(5).getPosX();
                yTemp2 = jugadorTurno.getPieza(5).getPosY();
                casillas[xTemp2][yTemp2].setEnabled(true);
                casillas[xTemp2][yTemp2].setBackground(Color.GREEN); 
                hayPieza = true;
            }  
            piezasSeleccionadas = hayPieza;
        }
        
        else if(resultado.equals("Vampiro")){
            if(jugadorTurno.getPieza(1).getHabilitada()){
                xTemp1 = jugadorTurno.getPieza(1).getPosX();
                yTemp1 = jugadorTurno.getPieza(1).getPosY();
                casillas[xTemp1][yTemp1].setEnabled(true);
                casillas[xTemp1][yTemp1].setBackground(Color.GREEN);
                hayPieza = true;
            }
            if(jugadorTurno.getPieza(4).getHabilitada()){
                xTemp2 = jugadorTurno.getPieza(4).getPosX();
                yTemp2 = jugadorTurno.getPieza(4).getPosY();
                casillas[xTemp2][yTemp2].setEnabled(true);
                casillas[xTemp2][yTemp2].setBackground(Color.GREEN);
                hayPieza = true;
            }  
            piezasSeleccionadas = hayPieza;
        }
        
        else if(resultado.equals("Necromante")){
            if(jugadorTurno.getPieza(2).getHabilitada()){
                xTemp1 = jugadorTurno.getPieza(2).getPosX();
                yTemp1 = jugadorTurno.getPieza(2).getPosY();
                casillas[xTemp1][yTemp1].setEnabled(true);
                casillas[xTemp1][yTemp1].setBackground(Color.GREEN); 
                hayPieza = true;
            }
            if(jugadorTurno.getPieza(3).getHabilitada()){
                xTemp2 = jugadorTurno.getPieza(3).getPosX();
                yTemp2 = jugadorTurno.getPieza(3).getPosY();
                casillas[xTemp2][yTemp2].setEnabled(true);
                casillas[xTemp2][yTemp2].setBackground(Color.GREEN); 
                hayPieza = true;
            }  
            piezasSeleccionadas = hayPieza;
        }    
    }
    
    
    public void casillasDisponibles(int fila, int columna, String opcion){
        int[][] casillasAdyacentes = new int[8][2];
        for (int i = 0; i < movimientos.length; i++) {
            casillasAdyacentes[i][0] = movimientos[i][0] + fila;
            casillasAdyacentes[i][1] = movimientos[i][1] + columna;
        }
        
        for (int i = 0; i < casillasAdyacentes.length; i++) {
            
            int filaTemp = casillasAdyacentes[i][0];
            int columnaTemp = casillasAdyacentes[i][1];
            
            if(filaTemp >= 0 && filaTemp < casillas.length && columnaTemp >= 0 && columnaTemp < casillas.length){
                if(opcion.equals("MOVER")){
                    if(casillas[filaTemp][columnaTemp].getIcon() == null ){
                        casillas[filaTemp][columnaTemp].setEnabled(true);
                        casillas[filaTemp][columnaTemp].setBackground(Color.YELLOW); 
                        xVieja = fila;
                        yVieja = columna;
                        moverPieza = true;
                    }    
                }
                else if(opcion.equals("ATACAR")){
                    if(casillas[filaTemp][columnaTemp].getIcon() != null){
                        for (int j = 0; j < 6; j++) {
                            if(filaTemp == jugadorRival.getPieza(j).getPosX() && columnaTemp == jugadorRival.getPieza(j).getPosY() && jugadorRival.getPieza(j).getHabilitada()){
                                casillas[filaTemp][columnaTemp].setEnabled(true);
                                casillas[filaTemp][columnaTemp].setBackground(Color.RED); 
                                atacarEnemigo = true; 
                            }
                        }
                    }   
                }
            }
        }
        piezasSeleccionadas = false;
    }  

    public void moverPieza(int viejaFila, int viejaColumna, int nuevaFila, int nuevaColumna, int numPieza){  
            
        casillas[nuevaFila][nuevaColumna].setIcon(casillas[viejaFila][viejaColumna].getIcon());
        casillas[viejaFila][viejaColumna].setIcon(null);
        jugadorTurno.getPieza(numPieza).setPosX(nuevaFila);
        jugadorTurno.getPieza(numPieza).setPosY(nuevaColumna);
        tablero.inhabilitarCasillas(5, 5);     
        
        moverPieza = false;
        
        terminarTurno();
    }
    
    private void clickCasilla() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                int filaTemp = i;
                int columnaTemp = j;  
                casillas[i][j].addActionListener(e ->{ 
                    if(piezasSeleccionadas){
                        int pieza = piezaCasilla(filaTemp, columnaTemp);
                        if(pieza != -1){
                            botones[0].setEnabled(true);
                            botones[1].setEnabled(true);
                            botones[2].setEnabled(true);
                            xPieza = filaTemp;
                            yPieza = columnaTemp;
                            numPieza = pieza;
                        }
                    }
                    else if(numPieza != -1 && moverPieza){
                        moverPieza(xVieja, yVieja, filaTemp, columnaTemp, numPieza); 
                    }
                    else if(numPieza != -1 && atacarEnemigo){
                        hacerAtaque(filaTemp, columnaTemp, numPieza);
                    }
                });
            }
        }
    }
    
    
    public int piezaCasilla(int fila, int columna){
        for (int i = 0; i < 6; i++) {
            if(jugadorTurno.getPieza(i).getHabilitada() && fila == jugadorTurno.getPieza(i).getPosX() && columna == jugadorTurno.getPieza(i).getPosY()){
                return i;
            }
        }
        return -1;
    }
    
    public void clickBotones(){
        botones[0].addActionListener(e -> {
            casillasDisponibles(xPieza, yPieza, "ATACAR"); 
        });

        botones[1].addActionListener(e -> {
            
        });

        botones[2].addActionListener(e -> {
            if(piezasSeleccionadas){
                casillasDisponibles(xPieza, yPieza, "MOVER"); 
            }
        });   
    }
    
    public void hacerAtaque(int xEnemigo, int yEnemigo, int numPieza){
        int ataque = jugadorTurno.getPieza(numPieza).getAtaque();
        for (int i = 0; i < 6; i++) {
            int x = jugadorRival.getPieza(i).getPosX();
            int y = jugadorRival.getPieza(i).getPosY();
            if(xEnemigo == x && yEnemigo == y){
                if(jugadorRival.getPieza(i).getEscudo() <= 0){
                    jugadorRival.getPieza(i).setVida(jugadorRival.getPieza(i).getVida() - ataque);
                    System.out.println("Vida: " + jugadorRival.getPieza(i).getVida());
                    System.out.println("Escudo: " +jugadorRival.getPieza(i).getEscudo());
                }
                else{
                    int escudo = jugadorRival.getPieza(i).getEscudo();
                    if(escudo >= ataque){
                        jugadorRival.getPieza(i).setEscudo(escudo - ataque);
                    }
                    else{
                        int residuo = ataque - escudo;
                        jugadorRival.getPieza(i).setEscudo(0);
                        jugadorRival.getPieza(i).setVida(jugadorRival.getPieza(i).getVida() - residuo);
                    }    
                    System.out.println("Vida: " + jugadorRival.getPieza(i).getVida());
                    System.out.println("Escudo: " +jugadorRival.getPieza(i).getEscudo());
                }
                if(jugadorRival.getPieza(i).getVida() <= 0){
                    jugadorRival.getPieza(i).setVida(0);
                    jugadorRival.getPieza(i).setHabilitada(false);
                    casillas[x][y].setIcon(null);
                    System.out.println("Vida: " + jugadorRival.getPieza(i).getVida());
                    System.out.println("Escudo: " +jugadorRival.getPieza(i).getEscudo());
                }
                break;
            }
        }
        tablero.inhabilitarCasillas(5, 5);  
        atacarEnemigo = false;
        terminarTurno();
    }
    
    
    public Jugador getJugador1(){
        return jugador1;
    }
    
    public Jugador getJugador2(){
        return jugador2;
    }
    
    public Ruleta getRuleta(){
        return ruleta;
    }
    
}
