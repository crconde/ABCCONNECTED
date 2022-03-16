package Backend;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
public class Jogos implements Serializable {
    private int n_equipa, n_jornada;
    private String equipa_adv, competicao, local;
    private Atleta atleta;
    private Treinador treinador;
    private Date data;
    private Time hora; 
    public Jogos(int n_equipa,Atleta atleta,Treinador treinador,String equipa_adv,Date data,Time hora,String local,String competicao,int n_jornada){
        this.atleta = atleta;
        this.treinador =  treinador;
        this.data = data;
        this.hora = hora;
        this.n_equipa = n_equipa;
        this.n_jornada = n_jornada;
        this.equipa_adv = equipa_adv;
        this.competicao = competicao;
        this.local = local;
    }
    public Jogos(){}
    public int get_n_equipa(){
        return n_equipa;
    }
    public int get_n_jornada(){
        return n_jornada;
    }
    public String get_equipa_adversaria(){
        return equipa_adv;
    }
    public String get_competicao(){
        return competicao;
    }
    public String get_local(){
        return local;
    }
    public Atleta get_atleta(){
        return atleta;
    }
    public Treinador treinador(){
        return treinador;
    }
    public Date get_data(){
        return data;
    }
    public Time get_hora(){
        return hora;
    }
    public void set_n_equipa(int n_equipa){
        this.n_equipa = n_equipa;
    }
    public void set_n_jornada(int n_jornada){
        this.n_jornada = n_jornada;
    }
    public void set_equipa_adversaria(String equipa_adv){
        this.equipa_adv = equipa_adv;
    }
    public void set_competicao(String competicao){
        this.competicao = competicao;
    }
    public  void set_local(String local){
        this.local = local;
    }
    public void set_atleta(Atleta atleta){
        this.atleta = atleta;    
    }
    public void set_treinador(Treinador treinador){
        this.treinador = treinador;
    }
    public void set_data(Date data){
        this.data = data;
    }
    public void set_hora(Time hora){
        this.hora = hora;
    }
}
