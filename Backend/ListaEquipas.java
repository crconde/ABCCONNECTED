

package Backend;

import java.util.TreeMap;


public class ListaEquipas {
    
    private TreeMap<Equipa, Treinador> lista;

    public class EquipaNaoExistenteException extends Exception {
        public EquipaNaoExistenteException() { }
        public EquipaNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class EquipaDuplicadaException extends Exception {
        public EquipaDuplicadaException() { }
        public EquipaDuplicadaException(String message) {
            super(message);
        }        
    }

    public ListaEquipas() {
        lista = new TreeMap<>();        
    }

    public void adicionar(Equipa equipa) throws EquipaDuplicadaException{
        if (equipa == null) {
            throw new NullPointerException("O parâmetro 'stock' não pode ser um valor nulo");
        }
        if (!lista.containsKey(equipa)) {
            lista.put(equipa, equipa.getTreinador());
        }
        else {
            throw new EquipaDuplicadaException(String.format("A equipa '%s' já existe na coleção",equipa));
        }
    }

    public boolean existe(Equipa n_equipa){
        return lista.containsKey(n_equipa);
    }

    

    public Treinador get_Equipa(Equipa n_Equipa) throws EquipaNaoExistenteException {
        if (lista.containsKey(n_Equipa)) {
            return lista.get(n_Equipa); 
        
        }
        else {
            throw new EquipaNaoExistenteException("A equipa já existe na lista");
        }
    }

    public void apagar(Equipa n_equipa ){
        lista.remove(n_equipa);
    }

   



}
