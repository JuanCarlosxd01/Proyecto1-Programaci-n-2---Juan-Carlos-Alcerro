
package Menus;

public class Usuario {
    
    private String usuario;
    private String contrasena;
    // agregar atributos
    
    public Usuario(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }      
}
