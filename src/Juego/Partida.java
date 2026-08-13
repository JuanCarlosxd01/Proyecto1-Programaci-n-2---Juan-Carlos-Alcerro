
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
    int numPieza = -1;
    boolean moverPieza = false;
    boolean atacarEnemigo = false;
    boolean invocar = false;
    Necromante nSeleccionado = null;
    boolean lanzaN = false;
    
    int xVieja;
    int yVieja;
    JButton botones[] = new JButton[3];
    int xPieza;
    int yPieza;
    boolean habilidadActiva = false;
    int filaTemp;
    int columnaTemp;
    JButton btnAtaqueDistancia;
    JButton btnInvocar;
    JButton btnAtaqueZombie;
    boolean ataqueZombie = false;
    static boolean hayOpciones = false;
    boolean hayZombie = false;
    PanelHistorial panelH;
    int xEnemiga;
    int yEnemiga;
    PanelInformacion panelI;

    public Partida(Tablero tablero, Usuario usuarioActivo, Usuario usuarioOponente, JButton btnAtacar, JButton btnHabilidad, JButton btnMover, PanelHistorial panelH, PanelInformacion panelI){
        this.panelI = panelI;
        ruleta = new Ruleta(Color.GRAY);
        this.panelH = panelH;
        this.tablero = tablero;
        casillas = tablero.getCasillas();
        botones[0] = btnAtacar;
        botones[1] = btnHabilidad;
        botones[2] = btnMover;
        btnAtaqueDistancia = VentanaTablero.Botones("⚔");
        btnInvocar = VentanaTablero.Botones("☠");
        btnAtaqueZombie = VentanaTablero.Botones("Z");
        
        jugador1 = new Jugador(usuarioActivo, false, Color.BLACK, 0);
        jugador2 = new Jugador(usuarioOponente, false, Color.gray, 5);
        jugadorTurno = jugador1;
        jugadorRival = jugador2;
        clickCasilla();
        clickBotones();
        
        tablero.inhabilitarCasillas(5, 5);
        panelI.actualizarJugador(jugadorTurno.getUsuario().getUsuario());
        panelI.actualizarRival(jugadorRival.getUsuario().getUsuario());
        iniciarTurno();
    }
    
    public void iniciarTurno(){
        botones[0].setEnabled(false);
        botones[1].setEnabled(false);
        botones[2].setEnabled(false);
        ruleta.habilitarRuleta();
        panelH.agregarMovimiento("Es turno del jugador: " + jugadorTurno.getUsuario().getUsuario() + ".");
        panelI.actualizarTurno(jugadorTurno.getUsuario().getUsuario());
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
        btnInvocar.setEnabled(true);
        btnAtaqueDistancia.setEnabled(true);
        btnAtaqueZombie.setEnabled(true);
        numPieza = -1;
        xVieja = 0;
        yVieja = 0;
        lanzaN = false;
        hayOpciones = false;
        habilidadActiva = false;
        invocar = false;
        ataqueZombie = false;
        hayZombie = false;
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
        boolean hayPieza = false;
        int xTemp1;
        int yTemp1;
        int xTemp2;
        int yTemp2;
        
        String resultado = ruleta.getResultado();
        if(resultado.equals("Hombre Lobo")){
            if(jugadorTurno.getPieza(0).getHabilitada()){
                xTemp1 = jugadorTurno.getPieza(0).getPosX();
                yTemp1 = jugadorTurno.getPieza(0).getPosY();
                casillas[xTemp1][yTemp1].setEnabled(true);
                aparecerBotones(xTemp1, yTemp1);
                casillas[xTemp1][yTemp1].setBackground(Color.GREEN); 
                hayPieza = true;
            }
            if(jugadorTurno.getPieza(5).getHabilitada()){
                xTemp2 = jugadorTurno.getPieza(5).getPosX();
                yTemp2 = jugadorTurno.getPieza(5).getPosY();
                casillas[xTemp2][yTemp2].setEnabled(true);
                aparecerBotones(xTemp2, yTemp2);
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
                aparecerBotones(xTemp1, yTemp1);
                casillas[xTemp1][yTemp1].setBackground(Color.GREEN);
                hayPieza = true;
            }
            if(jugadorTurno.getPieza(4).getHabilitada()){
                xTemp2 = jugadorTurno.getPieza(4).getPosX();
                yTemp2 = jugadorTurno.getPieza(4).getPosY();
                casillas[xTemp2][yTemp2].setEnabled(true);
                aparecerBotones(xTemp2, yTemp2);
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
                aparecerBotones(xTemp1, yTemp1);
                casillas[xTemp1][yTemp1].setBackground(Color.GREEN); 
                hayPieza = true;
            }
            if(jugadorTurno.getPieza(3).getHabilitada()){
                xTemp2 = jugadorTurno.getPieza(3).getPosX();
                yTemp2 = jugadorTurno.getPieza(3).getPosY();
                casillas[xTemp2][yTemp2].setEnabled(true);
                aparecerBotones(xTemp2, yTemp2);
                casillas[xTemp2][yTemp2].setBackground(Color.GREEN); 
                hayPieza = true;
            }  
            piezasSeleccionadas = hayPieza;
        }    
        hayPieza = false;
    }
    
    
    public void casillasDisponibles(int fila, int columna, String opcion){
        int[][] casillasAdyacentes = new int[8][2];
        for (int i = 0; i < movimientos.length; i++) {
            casillasAdyacentes[i][0] = movimientos[i][0] + fila;
            casillasAdyacentes[i][1] = movimientos[i][1] + columna;
        }
        
        for (int i = 0; i < casillasAdyacentes.length; i++) {
            
            filaTemp = casillasAdyacentes[i][0];
            columnaTemp = casillasAdyacentes[i][1];
            
            if(filaTemp >= 0 && filaTemp < casillas.length && columnaTemp >= 0 && columnaTemp < casillas.length){
                if(opcion.equals("MOVER")){
                    if(casillas[filaTemp][columnaTemp].getIcon() == null ){
                        casillas[filaTemp][columnaTemp].setEnabled(true);
                        aparecerBotones(filaTemp, columnaTemp);
                        casillas[filaTemp][columnaTemp].setBackground(Color.YELLOW);  
                        moverPieza = true;
                        xVieja = fila;
                        yVieja = columna;
                    }    
                }
                else if(opcion.equals("ATACAR") || opcion.equals("OPCIONES")){
                    if(casillas[filaTemp][columnaTemp].getIcon() != null){
                        for (int j = 0; j < jugadorRival.getPiezas().size(); j++) {
                            if(filaTemp == jugadorRival.getPieza(j).getPosX() && columnaTemp == jugadorRival.getPieza(j).getPosY() && jugadorRival.getPieza(j).getHabilitada()){
                                if(opcion.equals("ATACAR")){
                                    casillas[filaTemp][columnaTemp].setEnabled(true);
                                    aparecerBotones(filaTemp, columnaTemp);
                                    casillas[filaTemp][columnaTemp].setBackground(Color.RED); 
                                    atacarEnemigo = true; 
                                }
                                else if(opcion.equals("OPCIONES")){
                                    hayOpciones = true;
                                }
                                
                            }
                        }
                    }   
                }
            }
        }
        if(!opcion.equals("OPCIONES") ){
            piezasSeleccionadas = false;
        }
    }  

    public void moverPieza(int viejaFila, int viejaColumna, int nuevaFila, int nuevaColumna, int numPieza){  
            
        casillas[nuevaFila][nuevaColumna].setIcon(casillas[viejaFila][viejaColumna].getIcon());
        casillas[nuevaFila][nuevaColumna].setDisabledIcon(casillas[viejaFila][viejaColumna].getIcon());
        casillas[viejaFila][viejaColumna].setIcon(null);
        jugadorTurno.getPieza(numPieza).setPosX(nuevaFila);
        jugadorTurno.getPieza(numPieza).setPosY(nuevaColumna);
        tablero.inhabilitarCasillas(5, 5);     
        
        
        jugadaMensaje("MOVER");
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
                            xPieza = filaTemp;
                            yPieza = columnaTemp;
                            numPieza = pieza;
                            casillas[filaTemp][columnaTemp].setBackground(Color.ORANGE);
                            tablero.inhabilitarCasillas(5, 5);
                            aparecerBotones(filaTemp, columnaTemp);
                            hayOpciones = false;
                            casillasDisponibles(xPieza, yPieza, "OPCIONES");
                            botones[0].setEnabled(true);
                            botones[1].setEnabled(true);
                            botones[2].setEnabled(true);
                            Pieza piezaSeleccionada = jugadorTurno.getPieza(numPieza);
                            actualizarPanelInfo(piezaSeleccionada);
                            if(!hayOpciones){
                                botones[0].setEnabled(false);
                            }
                            if(!hayOpciones && jugadorTurno.getPieza(numPieza) instanceof Vampiro){
                                botones[1].setEnabled(false);
                            }
                            
                        }
                    }
                    else if(numPieza != -1 && moverPieza){
                        moverPieza(xVieja, yVieja, filaTemp, columnaTemp, numPieza); 
                    }
                    else if(numPieza != -1 && atacarEnemigo){
                        xEnemiga = filaTemp;
                        yEnemiga = columnaTemp;
                        if(!habilidadActiva){
                            hacerAtaque(filaTemp, columnaTemp, numPieza);
                            quitarBotones();
                        }
                        else {
                            jugadorTurno.getPieza(numPieza).ataqueEspecial();
                            terminarTurno();
                        }
                    }
                    else if(numPieza != -1 && invocar){
                        xEnemiga = filaTemp;
                        yEnemiga = columnaTemp;
                        nSeleccionado.setPosxZombie(filaTemp);
                        nSeleccionado.setPosyZombie(columnaTemp);
                        if(jugadorTurno == jugador1){
                            nSeleccionado.setNum(1);
                        }
                        else{
                            nSeleccionado.setNum(2);
                        }
                        nSeleccionado.ataqueEspecial();
                        jugadaMensaje("HABILIDAD ESPECIAL");
                        jugadorTurno.getPiezas().add(nSeleccionado.getZombie());
                        quitarBotones();
                    }
                    else if(numPieza != -1 && ataqueZombie){
                        numPieza = piezaCasilla(xEnemiga, yEnemiga);
                        casillasDisponibles(filaTemp, columnaTemp, "ATACAR"); 
                    }
                });
            }
        }
    }
    
    
    public int piezaCasilla(int fila, int columna){
        for (int i = 0; i < jugadorTurno.getPiezas().size(); i++) {
            if(jugadorTurno.getPieza(i).getHabilitada() && fila == jugadorTurno.getPieza(i).getPosX() && columna == jugadorTurno.getPieza(i).getPosY()){
                return i;
            }
        }
        return -1;
    }
    
    public void clickBotones(){
        botones[0].addActionListener(e -> {
            botones[0].setEnabled(false);
            botones[1].setEnabled(false);
            botones[2].setEnabled(false);
            casillasDisponibles(xPieza, yPieza, "ATACAR"); 
        });
        
        botones[1].addActionListener(e -> { 
            botones[0].setEnabled(false);
            botones[1].setEnabled(false);
            botones[2].setEnabled(false);
            if(jugadorTurno.getPieza(numPieza) instanceof HombreLobo){
                jugadaMensaje("HABILIDAD ESPECIAL");
                if (piezasSeleccionadas) {
                    HombreLobo pieza = (HombreLobo)(jugadorTurno.getPieza(numPieza));
                    pieza.setCasillas(casillas);
                    xVieja = xPieza;
                    yVieja = yPieza;
                    pieza.ataqueEspecial();
                    moverPieza = true;
                    piezasSeleccionadas = false;
                }
            }
            else if(jugadorTurno.getPieza(numPieza) instanceof Necromante){
                nSeleccionado = (Necromante)(jugadorTurno.getPieza(numPieza));
                nSeleccionado.setCasillas(casillas);
                 nSeleccionado.setOponente(jugadorRival);
                accionarHabilidadesNecromante();
                agregarBotones();
            }
            
            else if(jugadorTurno.getPieza(numPieza) instanceof Vampiro){
                jugadaMensaje("HABILIDAD ESPECIAL");
                Vampiro pieza = (Vampiro)(jugadorTurno.getPieza(numPieza)); 
                pieza.setPartida(this);
                casillasDisponibles(xPieza, yPieza, "ATACAR"); 
                habilidadActiva = true;
            }
        });

        botones[2].addActionListener(e -> {
            botones[0].setEnabled(false);
            botones[1].setEnabled(false);
            botones[2].setEnabled(false);
            if(piezasSeleccionadas){
                casillasDisponibles(xPieza, yPieza, "MOVER"); 
            }
        });   
    }
    
    
    public void hacerAtaque(int xEnemigo, int yEnemigo, int numPieza){
        int ataque = jugadorTurno.getPieza(numPieza).getAtaque();
        for (int i = 0; i < jugadorRival.getPiezas().size(); i++) {
            int x = jugadorRival.getPieza(i).getPosX();
            int y = jugadorRival.getPieza(i).getPosY();
            if(xEnemigo == x && yEnemigo == y){
                if(!lanzaN){
                    if(jugadorRival.getPieza(i).getEscudo() <= 0){
                        jugadorRival.getPieza(i).setVida(jugadorRival.getPieza(i).getVida() - ataque);
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
                    }
                    if(jugadorRival.getPieza(i).getVida() <= 0){
                        jugadorRival.getPieza(i).setVida(0);
                    }
                    jugadaMensaje("ATAQUE");
                    
                    if(jugadorRival.getPieza(i).getVida() <= 0){
                        jugadorRival.getPieza(i).setHabilitada(false);
                        casillas[x][y].setIcon(null);
                        jugadaMensaje("MATAR PIEZA");
                    }
                    break;
                }
                else if(lanzaN){
                    jugadorRival.getPieza(i).setVida(jugadorRival.getPieza(i).getVida() - ataque);
                    jugadaMensaje("HABILIDAD ESPECIAL");
                     if(jugadorRival.getPieza(i).getVida() <= 0){
                        jugadorRival.getPieza(i).setVida(0);
                        jugadorRival.getPieza(i).setHabilitada(false);
                        casillas[x][y].setIcon(null);
                        jugadaMensaje("MATAR PIEZA");
                        
                    }
                     jugadorTurno.getPieza(numPieza).setAtaque(ataque * 2);
                     break;
                }
                
            }
        }
        tablero.inhabilitarCasillas(5, 5);  
        atacarEnemigo = false;
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
    
    public void agregarBotones(){
        Dimension tamano = new Dimension(50, 20);
        btnAtaqueDistancia.setPreferredSize(tamano );
        btnAtaqueDistancia.setMaximumSize(tamano );
        btnInvocar.setPreferredSize(tamano );
        btnInvocar.setMaximumSize(tamano);
        btnAtaqueZombie.setPreferredSize(tamano);
        btnAtaqueZombie.setMaximumSize(tamano);
        VentanaTablero.getPanelRuleta().add(btnAtaqueDistancia, 6);
        VentanaTablero.getPanelRuleta().add(btnInvocar, 7);
        VentanaTablero.getPanelRuleta().add(btnAtaqueZombie, 8);
        VentanaTablero.getPanelRuleta().add(Box.createVerticalStrut(10), 9);
        VentanaTablero.getPanelRuleta().revalidate();
        VentanaTablero.getPanelRuleta().repaint();
    }
    
    public void accionarHabilidadesNecromante(){
        hayOpciones = false;
        nSeleccionado.ataqueLanza("OPCIONES");
        if(!hayOpciones){
            btnAtaqueDistancia.setEnabled(false);
        }
        btnAtaqueDistancia.addActionListener(e ->{
            btnInvocar.setEnabled(false);
            btnAtaqueDistancia.setEnabled(false);
            btnAtaqueZombie.setEnabled(false);
            nSeleccionado.setOponente(jugadorRival);
            nSeleccionado.setHabilidad("ATAQUE LANZA");
            lanzaN = true;
            habilidadActiva = false;
            nSeleccionado.ataqueEspecial();
            atacarEnemigo = true;
            piezasSeleccionadas = false;
            casillas[xPieza][yPieza].setOpaque(false);
            casillas[xPieza][yPieza].setContentAreaFilled(false);
            casillas[xPieza][yPieza].setBorderPainted(false);
            casillas[xPieza][yPieza].setEnabled(false);
        });
        
        btnInvocar.addActionListener(e -> {
            btnInvocar.setEnabled(false);
            btnAtaqueDistancia.setEnabled(false);
            btnAtaqueZombie.setEnabled(false);
            nSeleccionado.setHabilidad("INVOCAR ZOMBIE");
            piezasSeleccionadas = false;
            casillasSinPiezas();
            invocar = true;
        });
        hayOpciones = false;
        seleccionarZombies("OPCIONES");
        hayZombies();
        if(!hayOpciones || !hayZombie){
            btnAtaqueZombie.setEnabled(false);
        }
        btnAtaqueZombie.addActionListener(e -> {
            btnInvocar.setEnabled(false);
            btnAtaqueDistancia.setEnabled(false);
            btnAtaqueZombie.setEnabled(false);
            ataqueZombie = true;
            piezasSeleccionadas = false;
            tablero.inhabilitarCasillas(5, 5);
            seleccionarZombies("ATAQUE");
            nSeleccionado.ataqueEspecial();
        });
    }
    
    public void casillasSinPiezas(){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                if(casillas[i][j].getIcon() == null){
                    casillas[i][j].setEnabled(true);
                    aparecerBotones(i, j);
                    casillas[i][j].setBackground(new Color(220, 220, 220)); 
                }
            }
        }
    }
    
    public void seleccionarZombies(String opcion){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                for (int k = 0; k < jugadorTurno.getPiezas().size(); k++) {
                    if(Math.max(Math.abs(jugadorTurno.getPieza(k).getPosX() - nSeleccionado.getPosX()), Math.abs(jugadorTurno.getPieza(k).getPosY() - nSeleccionado.getPosY()))  >= 3){
                        if(i == jugadorTurno.getPieza(k).getPosX() && j == jugadorTurno.getPieza(k).getPosY() && jugadorTurno.getPieza(k) instanceof Zombie){
                            if(opcion.equals("ATAQUE")){
                                casillas[i][j].setEnabled(true);
                                aparecerBotones(i, j);
                                casillas[i][j].setBackground(Color.GREEN); 
                            }
                            else if(opcion.equals("OPCIONES")){
                                hayOpciones = true;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void quitarBotones(){
        VentanaTablero.getPanelRuleta().remove(btnAtaqueDistancia);
        VentanaTablero.getPanelRuleta().remove(btnInvocar);
        VentanaTablero.getPanelRuleta().remove(btnAtaqueZombie);
        VentanaTablero.getPanelRuleta().revalidate();
        VentanaTablero.getPanelRuleta().repaint();
        tablero.inhabilitarCasillas(5, 5);
        terminarTurno();
    }
    
    public void aparecerBotones(int x, int y){
        casillas[x][y].setOpaque(true);
        casillas[x][y].setContentAreaFilled(true);
        casillas[x][y].setBorderPainted(true);
    }
    
    public void jugadaMensaje(String accion){
        Pieza p1 = jugadorTurno.getPieza(numPieza);
        Pieza p2 = null;
        for (int i = 0; i < jugadorRival.getPiezas().size(); i++) {
            if(jugadorRival.getPieza(i).getPosX() == xEnemiga && jugadorRival.getPieza(i).getPosY() == yEnemiga){
                p2 = jugadorRival.getPieza(i);
            }
        }
        switch (accion){
            case "ATAQUE":
                panelH.agregarMovimiento("Se atacó la pieza "  + p2 + " y se le quitaron " 
                + p1.getAtaque() + "  puntos; le quedan " + p2.getEscudo() + " puntos de escudo y " + p2.getVida() + " de vida.");
                break;
                
            case "MOVER":
                panelH.agregarMovimiento("La pieza " + p1 + " se ha desplazado hacia (" + p1.getPosX() + ", " + p1.getPosY() + ").");
                break;
                
            case "HABILIDAD ESPECIAL":
                if(p1 instanceof HombreLobo){
                    panelH.agregarMovimiento("El Hombre Lobo ha usado su HABILIDAD ESPECIAL");
                }
                else if(p1 instanceof Vampiro){
                    panelH.agregarMovimiento("El Vampiro ha usado su HABILIDAD ESPECIAL");
                }
                else if(p1 instanceof Necromante){
                    switch (nSeleccionado.getHabilidad()){
                        case "ATAQUE LANZA":
                            panelH.agregarMovimiento("El Necromante ha usado su ATAQUE LANZA y atacó la pieza "  + p2 + " la cual ha restado 2 de vida.");
                            break;
                        case "INVOCAR ZOMBIE":
                            panelH.agregarMovimiento("El Necromante ha invocado un zombie en (" + xEnemiga + ", " + yEnemiga + ").");
                            break;
                    }
                }
                break;
           
            case "MATAR PIEZA":
                panelH.agregarMovimiento("Se destruyó la pieza " + p2 + " del jugador " + jugadorRival.getUsuario().getUsuario());
                break;
                
            default:
                break;
        }
    }
    
    public void hayZombies(){
        hayZombie = false;
        for (int i = 0; i < jugadorTurno.getPiezas().size(); i++) {
            if (jugadorTurno.getPieza(i) instanceof Zombie) {
                Pieza pieza = jugadorTurno.getPieza(i);
                if (pieza instanceof Zombie && pieza.getHabilitada()) {
                    hayZombie = true;
                    return;
                }
            }
        }
    }
    
    public void actualizarPanelInfo(Pieza piezaSeleccionada){
        panelI.actualizarPieza(piezaSeleccionada.toString());
        panelI.actualizarPosicion(piezaSeleccionada.getPosX(), piezaSeleccionada.getPosY());
        panelI.actualizarVida(piezaSeleccionada.getVida(), piezaSeleccionada.getVidaMax());
        panelI.actualizarEscudo(piezaSeleccionada.getEscudo(), piezaSeleccionada.getEscudoMax());
        panelI.actualizarAtaque(piezaSeleccionada.getAtaque());
    }
    

    
}
