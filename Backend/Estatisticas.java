package Backend;

import java.io.Serializable;

public class Estatisticas implements Serializable 
{
    
    private Jogos jogo;
    private ListaJogadas lista;
    private int periodo;
    
    //construtor
    public Estatisticas() { }
   
    public Estatisticas(Jogos jogo,ListaJogadas lista,int periodo) {
        this.jogo = jogo;
        this.lista = lista;
        this.periodo = periodo;
    } 
    
    //getters
    	
    public Jogos get_jogo() { return jogo; }
    public ListaJogadas get_lista_jogadas(){return lista;}
    public int get_periodo(){return periodo;}
    
    //setters
		
    public void set_lista_jogadas(ListaJogadas lista) { this.lista = lista; }
    public void set_jogo(Jogos jogo){this.jogo = jogo;}
    public void set_periodo(int periodo){this.periodo = periodo;}
    

}