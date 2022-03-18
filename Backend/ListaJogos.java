package Backend;

import java.io.Serializable;
import java.util.Date;
import java.util.TreeMap;

public class ListaJogos implements Serializable {
    private TreeMap<Date, Jogos> lista;

    public class JogoNaoExistenteException extends Exception {
        public JogoNaoExistenteException() { }
        public JogoNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class JogoDuplicadoException extends Exception {
        public JogoDuplicadoException() { }
        public JogoDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaJogos() {
        lista = new TreeMap<>();        
    }
    
    public void adicionar(Jogos jogo) throws JogoDuplicadoException {
        if (jogo == null) {
            throw new NullPointerException("O parâmetro 'jogo' não pode ser um valor nulo!");
        }        
        
        if (!lista.containsKey(jogo.get_data())) {
            lista.put(jogo.get_data(), jogo);
        }else{
            throw new JogoDuplicadoException(String.format("O jogo '%s' já existe na coleção", jogo.get_data()));
        }
        
    }      
    
    public boolean existe(Date data) {
        return lista.containsKey(data);
    }
    
    public Jogos get_Jogo(Date data) throws JogoNaoExistenteException {
        if (lista.containsKey(data)){
            return lista.get(data);
        }else{
            throw new JogoNaoExistenteException("Já existe um Jogo com nessa data.");
        }
    }
}
