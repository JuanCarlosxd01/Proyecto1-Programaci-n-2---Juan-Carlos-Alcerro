
package Juego;

import java.util.Calendar;

public class RegistroPartida {
    private String jugador;
    private String oponente;
    private String ganador;
    private String forma;
    private Calendar tiempo;
    
    public RegistroPartida(String jugador, String oponente, String ganador, String forma, Calendar tiempo){
        this.jugador = jugador;
        this.oponente = oponente;
        this.ganador = ganador;
        this.forma = forma;
        this.tiempo = tiempo;
    }
    
    public String toString(){
        return "• Host: " + jugador + "\n" + 
                "• Oponente: " + oponente + "\n" +
                "• Ganador: " + ganador + "\n" +
                "• Forma: " + forma + "\n" + 
                "• Fecha" +  tiempo.get(Calendar.DAY_OF_MONTH) + "/" +
                (tiempo.get(Calendar.MONTH) + 1) + "/" +
                tiempo.get(Calendar.YEAR) + " - " +
                tiempo.get(Calendar.HOUR) + ":" +
                String.format("%02d", tiempo.get(Calendar.MINUTE));
    }
}

