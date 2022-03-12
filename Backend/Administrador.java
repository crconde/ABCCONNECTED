package Backend;

import java.io.Serializable;


public class Administrador extends Utilizador implements Serializable {
	
    //construtor
    public Administrador() { }
    
    public Administrador(String password, String username) {
        super(password , username);
    } 
}	