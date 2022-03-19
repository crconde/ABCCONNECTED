package Backend;

import java.util.TreeMap;

public class ListaJogadas {
    private TreeMap<Integer, Jogadas> lista;

    public class JogadaNaoExistenteException extends Exception {
        public JogadaNaoExistenteException() { }
        public JogadaNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class JogadaDuplicadoException extends Exception {
        public JogadaDuplicadoException() { }
        public JogadaDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaJogadas() {
        lista = new TreeMap<>();        
    }
    
    public void adicionar(Jogadas jogada) throws JogadaDuplicadoException {
        if (jogada == null) {
            throw new NullPointerException("O parâmetro 'jogada' não pode ser um valor nulo!");
        }        
        
        if (!lista.containsKey(jogada.get_id_jogada())) {
            lista.put(jogada.get_id_jogada(), jogada);
        }else{
            throw new JogadaDuplicadoException(String.format("A jogada '%s' já existe na coleção", jogada.get_atleta()));
        }
        
    }      
    
    public boolean existe(int id_jogada) {
        return lista.containsKey(id_jogada);
    }
    
    public Jogadas get_Jogada(int id_jogada) throws JogadaNaoExistenteException {
        if (lista.containsKey(id_jogada)){
            return lista.get(id_jogada);
        }else{
            throw new JogadaNaoExistenteException("Já existe um Jogo com esse id.");
        }
    }
}
