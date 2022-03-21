package Backend;

import java.util.TreeMap;

public class ListaAdmin {
    private TreeMap<String, Administrador> lista;

    public class AdministradorNaoExistenteException extends Exception {
        public AdministradorNaoExistenteException() { }
        public AdministradorNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class AdministradorDuplicadoException extends Exception {
        public AdministradorDuplicadoException() { }
        public AdministradorDuplicadoException(String message) {
            super(message);
        }        
    }

    public ListaAdmin() {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }   
    
    public void adicionar(Administrador administrador) throws AdministradorDuplicadoException{
        if (administrador == null) {
            throw new NullPointerException("O parâmetro 'administrador' não pode ser um valor nulo");
        }
        if (!lista.containsKey(administrador.getUsername())) {
            lista.put(administrador.getUsername(), administrador);
        }else{
            throw new AdministradorDuplicadoException(String.format("O administrador '%s' já existe na coleção", administrador.getUsername()));
        }
    }

    public boolean existe(String username) {
        return lista.containsKey(username);
    }
    
    public Administrador getAdministrador(String username) throws AdministradorNaoExistenteException {
        if (lista.containsKey(username)){
            return lista.get(username);
        }else{
            throw new AdministradorNaoExistenteException("Já existe um administrador com esse username");
        }
    }

}
