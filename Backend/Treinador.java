package Backend;

import java.io.Serializable;


public class Treinador extends Utilizador implements Serializable {
    
    private String nome, email, numero;
    
    //construtor

    public Treinador() { }
    
    public Treinador(String username , String password,String nome, String email, String numero) {
        super(password,username);
        this.nome = nome;
        this.email = email;
        this.numero = numero;
    } 
    
    //getters

    public String getNome() { return nome; }

    public String getNumero() { return numero; }
    
    public String getEmail() { return email; }
    
    //setters

    public void setNome(String nome) { this.nome = nome; }

    public void setNumero(String numero) { this.numero = numero; }
    
    public void setEmail(String email) { this.email = email; }   
}
