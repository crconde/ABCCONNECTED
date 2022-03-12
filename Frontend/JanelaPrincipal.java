package Frontend;

import javax.swing.JOptionPane;
import BaseDados.Serializacao;
import Backend.*;


public class JanelaPrincipal extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao bd;

    public JanelaPrincipal(Sistema sistema, Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        
        //Força a maximização da janela
        this.setExtendedState(JanelaPrincipal.MAXIMIZED_BOTH);    
        
        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        //Apenas mostra o menu de administração se o utilizador for um administrador
        mnuAdministrador.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        
        //Apenas mostra o menu de gestão se o utilizador for um gestor
        mnuTreinador.setVisible(sistema.getUtilizadorLigado() instanceof Treinador);
        
        //Apenas mostra o menu do utente se o utilizador for um utente
        mnuAtleta.setVisible(sistema.getUtilizadorLigado() instanceof Atleta);
        
    }
    private void listarRegistoAcessos() 
    {
        ListagemAcessos acessos = new ListagemAcessos(sistema);
        acessos.setVisible(true);
    }
    private void guardarAlteracoes() {
        bd.guardar(sistema);
    }
    
    public Sistema getSistema() {
        return sistema;
    }
    
    private void terminar() {        
        if (JOptionPane.showConfirmDialog(null, 
                "Deseja realmente terminar o programa?", 
                "Terminar", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            guardarAlteracoes();
            sistema.terminar();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuPrincipal = new javax.swing.JMenuBar();
        mnuGeral = new javax.swing.JMenu();
        mniGuardar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniTerminar = new javax.swing.JMenuItem();
        mnuAdministrador = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuTreinador = new javax.swing.JMenu();
        mnuAtleta = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuGeral.setText("Geral");

        mniGuardar.setText("Guardar dados");
        mniGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGuardarActionPerformed(evt);
            }
        });
        mnuGeral.add(mniGuardar);
        mnuGeral.add(jSeparator1);

        mniTerminar.setText("Terminar");
        mniTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTerminarActionPerformed(evt);
            }
        });
        mnuGeral.add(mniTerminar);

        mnuPrincipal.add(mnuGeral);

        mnuAdministrador.setText("Administrador");
        mnuAdministrador.setToolTipText("");

        jMenuItem1.setText("Acessos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuAdministrador.add(jMenuItem1);

        mnuPrincipal.add(mnuAdministrador);

        mnuTreinador.setText("Treinador");
        mnuPrincipal.add(mnuTreinador);

        mnuAtleta.setText("Atleta");
        mnuPrincipal.add(mnuAtleta);

        setJMenuBar(mnuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGuardarActionPerformed
        guardarAlteracoes();
        JOptionPane.showMessageDialog(this, "Alterações guardadas!");
    }//GEN-LAST:event_mniGuardarActionPerformed
    
    private void mniTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTerminarActionPerformed
        terminar();
    }//GEN-LAST:event_mniTerminarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        listarRegistoAcessos();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mniGuardar;
    private javax.swing.JMenuItem mniTerminar;
    private javax.swing.JMenu mnuAdministrador;
    private javax.swing.JMenu mnuAtleta;
    private javax.swing.JMenu mnuGeral;
    private javax.swing.JMenuBar mnuPrincipal;
    private javax.swing.JMenu mnuTreinador;
    // End of variables declaration//GEN-END:variables
}
