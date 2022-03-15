//construtor(array(atletas)), sets() + gets()

package Backend;

import java.io.Serializable;

public class Equipa implements Serializable {
    
    private String n_Equipa;

    public Equipa() { 

    }

    //getters

    public String getN_equipa() { return n_Equipa; }

    //setters

    public void setN_equipa(String n_Equipa){ this.n_Equipa = n_Equipa; }
}
