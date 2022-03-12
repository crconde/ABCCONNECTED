package Frontend;

import Backend.*;
import BaseDados.Serializacao;

public class Piloto {
    public static void main(String[] args) throws ListaUtilizadores.UtilizadorDuplicadoException {
        Sistema sistema;        
        String ficheiroDados = String.format("%s\\utilizadores.data", System.getProperty("user.dir"));
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        Serializacao bd = new Serializacao(ficheiroDados);        
        
        //Se o ficheiro de base de dados nao existir
        if (! bd.getFicheiro().exists()) {
            //Cria uma instancia do sistema
            sistema = new Sistema();      
            //Adiciona dois administradores para que possa ser possivel entrar no sistema
            sistema.getUtilizadorList().adicionar(new Administrador("admin", "admin"));
            sistema.getUtilizadorList().adicionar(new Treinador("treinador","treinador","Sergio Conceicao", "sergioconceicao@gmail.com", "917659524"));
        }else{
            sistema = bd.carregar();            
        }                 
        
        //Uma vez que a JanelaLogin é modal, este método irá bloquear até que a janela seja fechada.
        //A janela só fecha quando os dados de login são válidos.                
        JanelaLogin login = new JanelaLogin(sistema);               
        login.setVisible(true);
    
        JanelaPrincipal principal = new JanelaPrincipal(sistema, bd);
        principal.setVisible(true);

    }  
}
