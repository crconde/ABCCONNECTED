/* 
LISTA_EQUIPAS- hashmap(equipa,treinador) + sets() + gets()
*/

package Backend;
import java.io.Serializable;
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

    public void set_Equipa(Equipa equipa) throws EquipaDuplicadaException{
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

    public boolean get_EquipaTrue(Equipa n_equipa){
        return lista.containsKey(n_equipa);
    }

    

    public Equipa get_Equipa(Treinador  E) throws EquipaNaoExistenteException {
        if (lista.containsKey(treinador)) {
            return lista.get(treinador); 
            
        }
    }





}
