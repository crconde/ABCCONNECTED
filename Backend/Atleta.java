package Backend;

import java.io.Serializable;
import java.util.Date;


public class Atleta extends Utilizador implements Serializable 
{
    
    private String escalao, nome, email, numero;
    
    private Date data_nascimento;
    
    //construtor
    public Atleta() { }
   
    public Atleta(String username , String password ,String escalao, Date data_nascimento,String nome, String email, String numero) {
        super(password,username);
        this.escalao = escalao;
        this.data_nascimento = data_nascimento; 
        this.nome = nome;
        this.email = email;
        this.numero = numero;
    } 
    
    //getters
    	
    public String getEscalao() { return escalao; }

    public String getNome() { return nome; }

    public String getNumero() { return numero; }
    
    public String getEmail() { return email; }
    
    public Date getData_Nascimento() { return data_nascimento; }
    
    //setters
		
    public void setEscalao(String escalao) { this.escalao = escalao; }
    
    public void setData_Nascimento(Date data_nascimento) { this.data_nascimento = data_nascimento; }

    public void setNome(String nome) { this.nome = nome; }

    public void setNumero(String numero) { this.numero = numero; }
    
    public void setEmail(String email) { this.email = email; }    
}