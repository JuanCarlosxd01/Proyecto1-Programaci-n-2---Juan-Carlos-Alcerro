
package Menus;

import java.util.Calendar;
public class Usuario {
    
    private String usuario;
    private String contrasena;
    private int puntos;
    private Calendar fechaIngreso;;
    private boolean activo;
    
    public Usuario(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
        puntos = 0;
        fechaIngreso = Calendar.getInstance();
        activo = true;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
    public int getPuntos(){
        return puntos;
    }
    
    public Calendar getFechaIngreso(){
        return fechaIngreso;
    }
    
    public boolean getActivo(){
        return activo;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    } 
    
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }
    
    public void setFechaIngreso(Calendar fechaIngreso){
        this.fechaIngreso = fechaIngreso;
    }
    
    public void setActivo(){
        this.activo = activo;
    }
    
    public String mostrarInformacion(){
        return "Nombre de Usuario: " + usuario + " Contrasena: " + contrasena + "Puntos conseguidos: " + puntos + "Fecha de Ingreso:" + fechaIngreso + "Cuenta activa: " + activo;
    }
}
