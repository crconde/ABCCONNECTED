package Backend;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import Backend.ListaUtilizadores.UtilizadorDuplicadoException;

public class Sistema implements Serializable {
    private final ListaUtilizadores utilizadores;
    private Utilizador utilizadorLigado;
    private ListaAcessos listaEntradas;
    public Calendar dataAdmin =  Calendar.getInstance();
    public Calendar dataTreinador =  Calendar.getInstance();
    
    public Sistema() {
        utilizadores = new ListaUtilizadores();
        listaEntradas = new ListaAcessos();
        dataAdmin.set(1989 , 4 , 21);
        dataTreinador.set(1991, 5, 10);
    }
    public ListaAcessos getListaEntradas() 
    {
        return listaEntradas;
    }
    public ListaUtilizadores getUtilizadorList() {
        return utilizadores;
    }
    
    public boolean autenticarUtilizador(String nomeUtilizador, String password) {        
        if (utilizadores.existe(nomeUtilizador)) {
            try{
                Utilizador u = utilizadores.getUtilizador(nomeUtilizador);                
                if (u.getPassword().equals(password)){
                    utilizadorLigado = u;
                    listaEntradas.set_Acesso(new RegistoAcesso(utilizadorLigado, LocalDateTime.now()));
                    return true;
                }                
            }catch (ListaUtilizadores.UtilizadorNaoExistenteException e) {}                        
        }        
        return false;        
    }
    
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }
    
    public void inicializar() throws UtilizadorDuplicadoException {
        utilizadores.adicionar(new Administrador("admin","admin"));
        utilizadores.adicionar(new Treinador("treinador","treinador","Sergio Conceicao", "sergioconceicao@gmail.com", "917659524"));
    }
    
    public void terminar() {
        System.exit(0);
    }
}
