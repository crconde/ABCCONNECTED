package Frontend;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import Backend.Sistema;
import Backend.Atleta;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class JanelaLogin extends JDialog {

    private Sistema sistema;
    private Atleta atleta;
    
    public JanelaLogin(Sistema sistema) {
        initComponents();
        
        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);           
        
        //Não permite o redimensionamento da janela
        this.setResizable(true);
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //Redimensiona a janela de login
        this.setSize(307,285);
        
        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        
        setTitle("Login:");
        
        this.sistema = sistema;    
        
        textNomeUtilizador.requestFocus();
    }

    private void autenticar() {                
        if (textNomeUtilizador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza por favor o seu nome de utilizador!");            
            textNomeUtilizador.requestFocus();
            return;
        }
        
        if (textPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza por favor a sua password!");
            textPassword.requestFocus();
            return;
        }                              
        
        if (!sistema.autenticarUtilizador(textNomeUtilizador.getText(), new String(textPassword.getPassword()))){
            JOptionPane.showMessageDialog(this, "As credenciais introduzidas não correspondem a um utilizador válido.",
                     "Autenticação", JOptionPane.WARNING_MESSAGE);
            textNomeUtilizador.requestFocus();            
        }else{
            //Devolve o controlo da aplicação para o método main
            dispose();            
        }        
    }
    
    public void novoAtleta() {
        JanelaRegistar j = new JanelaRegistar(sistema, atleta);
        j.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        textNomeUtilizador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnRegistar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Nome de Utilizador");

        jLabel2.setText("Password");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnRegistar.setText("Registar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        jLabel3.setText("Não tem Conta?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistar)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textPassword)
                            .addComponent(textNomeUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNomeUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnSair))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        autenticar();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        sistema.terminar();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        novoAtleta();
    }//GEN-LAST:event_btnRegistarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField textNomeUtilizador;
    private javax.swing.JPasswordField textPassword;
    // End of variables declaration//GEN-END:variables
}
