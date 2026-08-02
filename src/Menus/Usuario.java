
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
    
    public void setActivo(boolean activo){
        this.activo = activo;
    }
    
    public String mostrarInformacion(){
        return "Nombre de Usuario: " + usuario + "\nContrasena: " + contrasena + "\nPuntos conseguidos: " + puntos + 
                "\nFecha de Ingreso:" + fechaIngreso.get(Calendar.DAY_OF_MONTH) + "/" + fechaIngreso.get(Calendar.MONTH) + "/" + fechaIngreso.get(Calendar.YEAR) +
                "\nCuenta activa: " + activo;
    }
}
