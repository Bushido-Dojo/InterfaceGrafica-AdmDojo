/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bushido_dojo.Cadastros;

import bd.conexaoBD.BDSQLServer;
import com.mycompany.bushido_dojo.jframeHome;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dudac
 */
public class jframeCadastroProfessor extends javax.swing.JFrame {

    /**
     * Creates new form jframeCadastroProfessor
     */
    public jframeCadastroProfessor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelCadastro = new javax.swing.JLabel();
        labelAlunos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFieldNome = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jFieldSobrenome = new javax.swing.JFormattedTextField();
        jFieldCpf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jcomboboxSexo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jFieldTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jpanel_Borda_Arredondada2 = new procedimentos.jpanel_Borda_Arredondada();
        jBotaoCadastrarProf = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jpanel_Borda_Arredondada3 = new procedimentos.jpanel_Borda_Arredondada();
        jBotaoSairParaHome = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        curvedGradientePanel1 = new procedimentos.CurvedGradientePanel();
        jLabelBushido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(13, 32, 51));
        jPanel1.setLayout(null);

        labelCadastro.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        labelCadastro.setForeground(new java.awt.Color(255, 255, 255));
        labelCadastro.setText("Cadastro:");
        jPanel1.add(labelCadastro);
        labelCadastro.setBounds(30, 150, 130, 50);

        labelAlunos.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        labelAlunos.setForeground(new java.awt.Color(251, 136, 52));
        labelAlunos.setText("Professores");
        jPanel1.add(labelAlunos);
        labelAlunos.setBounds(550, 160, 160, 50);

        jLabel3.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SEXO");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(240, 270, 40, 20);

        jFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFieldNomeKeyTyped(evt);
            }
        });
        jPanel1.add(jFieldNome);
        jFieldNome.setBounds(110, 220, 100, 22);

        jLabel4.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 210, 50, 40);

        jFieldSobrenome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFieldSobrenomeKeyTyped(evt);
            }
        });
        jPanel1.add(jFieldSobrenome);
        jFieldSobrenome.setBounds(110, 270, 110, 22);

        try {
            jFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFieldCpf);
        jFieldCpf.setBounds(290, 220, 80, 20);

        jLabel6.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CPF");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(250, 220, 30, 20);

        jcomboboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Sexo", "Masculino", "Feminino" }));
        jPanel1.add(jcomboboxSexo);
        jcomboboxSexo.setBounds(290, 270, 130, 22);

        jLabel7.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sobrenome");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 260, 90, 50);

        try {
            jFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFieldTelefone);
        jFieldTelefone.setBounds(110, 370, 90, 20);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ProfKarate.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(550, 200, 160, 250);

        jLabel8.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TELEFONE");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 350, 70, 60);

        jpanel_Borda_Arredondada2.setBackground(new java.awt.Color(251, 136, 52));
        jpanel_Borda_Arredondada2.setLayout(null);

        jBotaoCadastrarProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadastroProf.png"))); // NOI18N
        jBotaoCadastrarProf.setBorderPainted(false);
        jBotaoCadastrarProf.setContentAreaFilled(false);
        jBotaoCadastrarProf.setFocusPainted(false);
        jBotaoCadastrarProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoCadastrarProfActionPerformed(evt);
            }
        });
        jpanel_Borda_Arredondada2.add(jBotaoCadastrarProf);
        jBotaoCadastrarProf.setBounds(60, 0, 190, 60);

        jLabel5.setFont(new java.awt.Font("The Bold Font", 1, 18)); // NOI18N
        jLabel5.setText("Cadastrar");
        jpanel_Borda_Arredondada2.add(jLabel5);
        jLabel5.setBounds(10, 10, 110, 40);

        jPanel1.add(jpanel_Borda_Arredondada2);
        jpanel_Borda_Arredondada2.setBounds(30, 450, 230, 60);

        jpanel_Borda_Arredondada3.setBackground(new java.awt.Color(251, 136, 52));
        jpanel_Borda_Arredondada3.setLayout(null);

        jBotaoSairParaHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home.png"))); // NOI18N
        jBotaoSairParaHome.setBorderPainted(false);
        jBotaoSairParaHome.setContentAreaFilled(false);
        jBotaoSairParaHome.setFocusPainted(false);
        jBotaoSairParaHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoSairParaHomeActionPerformed(evt);
            }
        });
        jpanel_Borda_Arredondada3.add(jBotaoSairParaHome);
        jBotaoSairParaHome.setBounds(60, 0, 190, 60);

        jLabel10.setFont(new java.awt.Font("The Bold Font", 1, 18)); // NOI18N
        jLabel10.setText("Home");
        jpanel_Borda_Arredondada3.add(jLabel10);
        jLabel10.setBounds(10, 10, 110, 40);

        jPanel1.add(jpanel_Borda_Arredondada3);
        jpanel_Borda_Arredondada3.setBounds(350, 450, 230, 60);
        jPanel1.add(curvedGradientePanel1);
        curvedGradientePanel1.setBounds(0, 100, 800, 510);

        jLabelBushido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        jPanel1.add(jLabelBushido);
        jLabelBushido.setBounds(10, 20, 50, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/BushidoDojo DomineODomDaArte.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 30, 310, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-1, -3, 960, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotaoSairParaHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoSairParaHomeActionPerformed
        new jframeHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBotaoSairParaHomeActionPerformed

    private void jBotaoCadastrarProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoCadastrarProfActionPerformed
        String nome = jFieldNome.getText();
        String sobrenome = jFieldSobrenome.getText();
        String cpf = jFieldCpf.getText();
        String sexo = jcomboboxSexo.getSelectedItem().toString();
        String telefone = jFieldTelefone.getText();
        String query = "exec Karate.spCadastroProf ?,?,?,?,?";

        switch(sexo)
        {
            case "Feminino" -> sexo = "F";
            case "Masculino" -> sexo = "M";
            default -> {
                JOptionPane.showMessageDialog(this, "Selecione um Sexo válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if(nome.isEmpty() || sobrenome.isEmpty() || cpf.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Certifique-se de completar todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            try {
                BDSQLServer.COMANDO.prepareStatement(query);
                BDSQLServer.COMANDO.setString(1,nome);
                BDSQLServer.COMANDO.setString(2,sobrenome);
                BDSQLServer.COMANDO.setString(3,cpf);
                BDSQLServer.COMANDO.setString(4, sexo);
                BDSQLServer.COMANDO.setString(5, telefone);
                BDSQLServer.COMANDO.execute();
                BDSQLServer.COMANDO.commit();
                JOptionPane.showMessageDialog(this, "Aluno Cadastrado..", "Alerta", JOptionPane.WARNING_MESSAGE);
                new jframeCadastroProfessor().setVisible(true);
                this.dispose();

            } catch (SQLException ex) {
                Logger.getLogger(jframeCadastroProfessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jBotaoCadastrarProfActionPerformed

    private void jFieldSobrenomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFieldSobrenomeKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c)||(c==KeyEvent.VK_SPACE) ||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_PERIOD)||(c==KeyEvent.VK_BACK_SPACE))){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jFieldSobrenomeKeyTyped

    private void jFieldNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFieldNomeKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c)||(c==KeyEvent.VK_SPACE) ||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_PERIOD)||(c==KeyEvent.VK_BACK_SPACE))){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jFieldNomeKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jframeCadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframeCadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframeCadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframeCadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframeCadastroProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private procedimentos.CurvedGradientePanel curvedGradientePanel1;
    private javax.swing.JButton jBotaoCadastrarProf;
    private javax.swing.JButton jBotaoSairParaHome;
    private javax.swing.JFormattedTextField jFieldCpf;
    private javax.swing.JFormattedTextField jFieldNome;
    private javax.swing.JFormattedTextField jFieldSobrenome;
    private javax.swing.JFormattedTextField jFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBushido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcomboboxSexo;
    private procedimentos.jpanel_Borda_Arredondada jpanel_Borda_Arredondada2;
    private procedimentos.jpanel_Borda_Arredondada jpanel_Borda_Arredondada3;
    private javax.swing.JLabel labelAlunos;
    private javax.swing.JLabel labelCadastro;
    // End of variables declaration//GEN-END:variables
}
