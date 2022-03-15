package Backend;

import java.io.Serializable;


public class Treinador extends Utilizador implements Serializable {
    
    private String nome, email, numero, tipoTreinador;
    
    //construtor

    public Treinador() { }
    
    public Treinador(String username , String password,String nome, String email, String numero, String tipoTreinador ) {
        super(password,username);
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.tipoTreinador = tipoTreinador;
    } 
    
    //getters

    public String getNome() { return nome; }

    public String getNumero() { return numero; }
    
    public String getEmail() { return email; }

    public String getTipo() { return tipoTreinador; }
    
    //setters

    public void setNome(String nome) { this.nome = nome; }

    public void setNumero(String numero) { this.numero = numero; }
    
    public void setEmail(String email) { this.email = email; }
    
    public void setTipo(String tipoTreinador) { this.tipoTreinador = tipoTreinador; }
}
