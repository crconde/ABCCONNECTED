package Backend;

import java.io.Serializable;
import java.util.TreeMap;

public class ListaAtleta implements Serializable{
    
    private TreeMap<String, Atleta> lista;

    public class AtletaNaoExistenteException extends Exception {
        public AtletaNaoExistenteException() { }
        public AtletaNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class AtletaDuplicadoException extends Exception {
        public AtletaDuplicadoException() { }
        public AtletaDuplicadoException(String message) {
            super(message);
        }        
    }

    public ListaAtleta() {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void adicionar(Atleta atleta) throws AtletaDuplicadoException {
        if (atleta == null) {
            throw new NullPointerException("O parâmetro 'Atleta' não pode ser um valor nulo!");
        }        
        
        if (!lista.containsKey(atleta.getUsername())) {
            lista.put(atleta.getUsername(), atleta);
        }else{
            throw new AtletaDuplicadoException(String.format("O Atleta '%s' já existe na coleção", atleta.getUsername()));
        } 
    } 

    public boolean existe(String username) {
        return lista.containsKey(username);
    }
    
    public Utilizador getAtleta(String username) throws AtletaNaoExistenteException {
        if (lista.containsKey(username)){
            return lista.get(username);
        }else{
            throw new AtletaNaoExistenteException("Já existe um Atleta com esse username");
        }
    }
    
}