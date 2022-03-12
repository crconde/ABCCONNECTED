package Frontend;

import Backend.ListaUtilizadores;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import Backend.*;

public class JanelaRegistar extends javax.swing.JDialog {

    private Atleta atleta;
    private Sistema sistema;
    
    public JanelaRegistar(Sistema sistema, Atleta atleta) {
        initComponents();
        
        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);           
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);                        
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //Redimensiona a janela de login
        this.setSize(470,480);
        
        //Guarda a referencia ao sistema
        this.sistema = sistema;   
        
        //Guarda a referencia ao utente
        this.atleta = atleta;
        
        //No caso de um registo novo
        if (registoNovo()) {    
            //Altera o titulo da janela
            //Como construimos sempre uma nova janela, as caixas de texto já estão limpas
            setTitle("Registo Atleta :");
            textNomeCompleto.requestFocus();
        }
    }

    private boolean registoNovo() {
        //Se atleta == null consideramos que é um novo registo
        return atleta == null;
    }

    private void guardar() {
        
        if (registoNovo() && textNomeCompleto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza por favor o nome pretendido!");            
            textNomeCompleto.requestFocus();
            return;
        }
         
        if (textUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza por favor o seu nome!");            
            textUsername.requestFocus();
            return;
        }
        
        if (textEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza por favor o seu email!");            
            textEmail.requestFocus();
            return;
        }
        
        if (textPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza por favor a sua password!");
            textPassword.requestFocus();
            return;
        }    
        
        if (textPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza por favor a sua password!");
            textPassword.requestFocus();
            return;
        }    
        
        if (textEscalao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza por favor o seu escalao!");            
            textEscalao.requestFocus();
            return;
        }
        
        if (textConfirmaPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Confirme por favor a sua password!");
            textConfirmaPassword.requestFocus();
            return;
        }              
        
        /*if (textPassword != textConfirmaPassword) {
            JOptionPane.showMessageDialog(this, "As duas passwords nao sao iguais!");
            textPassword.requestFocus();
            return;
        }*/
        
        String password = new String(textPassword.getPassword());
        String confirmaPassword = new String(textConfirmaPassword.getPassword());
        if(password.equals(confirmaPassword))
        {
            if (registoNovo()) 
            {      
                Atleta novo = new Atleta();
                novo.setNome(textNomeCompleto.getText());
                novo.setUsername(textUsername.getText());
                novo.setEmail(textEmail.getText());
                novo.setEscalao(textEscalao.getText());
                novo.setData_Nascimento(datechooserDN.getDate());
                novo.setPassword(password);   
                try 
                {
                    sistema.getUtilizadorList().adicionar(novo);
                } 
                catch (ListaUtilizadores.UtilizadorDuplicadoException ex) 
                {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                    return;
                }
            }
        }
        else
        { 
           JOptionPane.showMessageDialog(null,"Por favor introduza uma password correta.");
           return;
        }
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso!");
        fechar();
    }

    private void fechar() {
        //Executa o metodo de fechar definido em DefaultCloseOperation
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textNomeCompleto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textUsername = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        textPassword = new javax.swing.JPasswordField();
        textConfirmaPassword = new javax.swing.JPasswordField();
        textEscalao = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        datechooserDN = new com.toedter.calendar.JDateChooser();

        jLabel1.setText("Nome Completo");

        jLabel2.setText("Username");

        jLabel3.setText("Email");

        jLabel4.setText("Data de Nascimento");

        jLabel5.setText("Password");

        jLabel6.setText("Confirmar Password");

        jLabel7.setText("Escalão");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNomeCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(textUsername)
                    .addComponent(textEmail)
                    .addComponent(textPassword)
                    .addComponent(textConfirmaPassword)
                    .addComponent(textEscalao)
                    .addComponent(datechooserDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(datechooserDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textConfirmaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textEscalao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSair))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        fechar();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSair;
    private com.toedter.calendar.JDateChooser datechooserDN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField textConfirmaPassword;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textEscalao;
    private javax.swing.JTextField textNomeCompleto;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}
