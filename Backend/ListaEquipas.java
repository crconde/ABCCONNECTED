/* 
LISTA_EQUIPAS- hashmap(equipa,treinador) + sets() + gets()
*/

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

    public void set_Equipa(Equipa equipa) throws EquipaDuplicadaException{
        if (equipa == null) {
            throw new NullPointerException("O parâmetro 'stock' não pode ser um valor nulo");
        }
        if (condition) {
            
        }
    }

    public void get_Equipa(){

    }





}
