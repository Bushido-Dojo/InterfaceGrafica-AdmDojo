/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bushido_dojo.Deletes;

import bd.conexaoBD.BDSQLServer;
import bd.conexaoBD.core.MeuResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dudac
 */
public class jframeDeleteAluno extends javax.swing.JFrame {

    /**
     * Creates new form jframeDeleteAluno
     */
    public jframeDeleteAluno() {
        initComponents();
        fillComboBox();
    }
    
    
    private void fillComboBox() {
            try {
                String query = """
                               SELECT CONCAT(Id_Aluno, ' ', nome, ' ', sobrenome) AS NomeCompleto
                               FROM Karate.Aluno A
                               """;
                
                MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (query);
                
                
                
                while (resultado.next()) {
                    jComboAlunos.addItem(resultado.getString(1));
                }

                
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao preencher o ComboBox.");
            }
            
        }
    
    
    private void displaySelectedAlunoInfo() {
        try {
            String selectedAluno = (String) jComboAlunos.getSelectedItem();
            String[] partes = selectedAluno.split("\\s+");
            int idAluno = -1;
            if (partes.length >= 2) {
                // Obtém somente o número do ID (a primeira parte)
                 idAluno = Integer.parseInt(partes[0]);
            } else {
                System.out.println("Formato inválido do item selecionado.");
            }
            String query = """
                           SELECT A.*, 
                               CASE 
                                   WHEN M.id_aluno IS NOT NULL THEN 'Sim' 
                                   ELSE 'Não' 
                               END AS Matriculado
                           FROM Karate.Aluno A
                           LEFT JOIN Karate.Matricula M ON A.id_aluno = M.id_aluno
                           WHERE A.id_aluno = ?""";
            BDSQLServer.COMANDO.prepareStatement(query);
            BDSQLServer.COMANDO.setInt(1, idAluno);
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
            
            if (resultado.next()) {
                int idFaixa  = resultado.getInt(2);
                String nomeCompleto = resultado.getString(3) +" " + resultado.getString(4);
                String email = resultado.getString(6);
                String cpf = resultado.getString(5);
                Date dataNascimentoSQL = resultado.getDate(8);
                String DataNascimento = new SimpleDateFormat("dd/MM/yyyy").format(dataNascimentoSQL);
                String matriculado = resultado.getString(11);
                
                labelNomeCompleto.setText(nomeCompleto);
                labelMatriculado.setText(DataNascimento);
                labelCPF.setText(cpf);
                labelEmail.setText(email);
                labelMatriculado.setText(matriculado);
                labelDataNascimento.setText(DataNascimento);
                String corFaixa = "";
                
                switch(idFaixa)
                {
                    case 0 -> corFaixa = "Branca";
                    case 1 -> corFaixa = "Amarela";
                    case 2 -> corFaixa = "Laranja";
                    case 3 -> corFaixa = "Verde";
                    case 4 -> corFaixa = "Azul";
                    case 5 -> corFaixa ="Roxa";
                    case 6 -> corFaixa ="Marrom";
                    case 7 -> corFaixa ="Preta";
                    default -> JOptionPane.showMessageDialog(this, "Faixa Inválida recebida.");
                    
                }
                labelFaixa.setText(corFaixa);
               
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao exibir informações do aluno.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelBushido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        curvedGradientePanel1 = new procedimentos.CurvedGradientePanel();
        jLabel2 = new javax.swing.JLabel();
        jComboAlunos = new javax.swing.JComboBox<>();
        labelHorarios1 = new javax.swing.JLabel();
        labelNomeCompleto = new javax.swing.JLabel();
        labelMatriculado = new javax.swing.JLabel();
        labelHorarios = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        labelFaixa = new javax.swing.JLabel();
        labelHorarios2 = new javax.swing.JLabel();
        labelDataNascimento = new javax.swing.JLabel();
        roundButton2 = new procedimentos.RoundButton();
        jbotaoSairHome = new javax.swing.JButton();
        labelNome2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(13, 32, 51));
        jPanel1.setLayout(null);

        jLabelBushido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        jPanel1.add(jLabelBushido);
        jLabelBushido.setBounds(10, 0, 50, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/BushidoDojo DomineODomDaArte.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 10, 310, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 80);

        curvedGradientePanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Deletar Aluno");
        curvedGradientePanel1.add(jLabel2);
        jLabel2.setBounds(70, 20, 120, 30);

        jComboAlunos.setBackground(new java.awt.Color(13, 32, 51));
        jComboAlunos.setForeground(new java.awt.Color(255, 255, 255));
        jComboAlunos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Aluno" }));
        jComboAlunos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboAlunosItemStateChanged(evt);
            }
        });
        curvedGradientePanel1.add(jComboAlunos);
        jComboAlunos.setBounds(90, 90, 220, 22);

        labelHorarios1.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        labelHorarios1.setForeground(new java.awt.Color(255, 255, 255));
        labelHorarios1.setText("Matriculado:");
        curvedGradientePanel1.add(labelHorarios1);
        labelHorarios1.setBounds(60, 330, 170, 30);

        labelNomeCompleto.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelNomeCompleto.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel1.add(labelNomeCompleto);
        labelNomeCompleto.setBounds(60, 180, 250, 30);

        labelMatriculado.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelMatriculado.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel1.add(labelMatriculado);
        labelMatriculado.setBounds(60, 360, 140, 30);

        labelHorarios.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        labelHorarios.setForeground(new java.awt.Color(255, 255, 255));
        labelHorarios.setText("Data de Nascimento");
        curvedGradientePanel1.add(labelHorarios);
        labelHorarios.setBounds(60, 240, 250, 30);

        label2.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("CPF");
        curvedGradientePanel1.add(label2);
        label2.setBounds(360, 140, 50, 30);

        labelCPF.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelCPF.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel1.add(labelCPF);
        labelCPF.setBounds(360, 180, 180, 30);

        label.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Email");
        curvedGradientePanel1.add(label);
        label.setBounds(350, 240, 90, 30);

        labelEmail.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel1.add(labelEmail);
        labelEmail.setBounds(350, 280, 400, 30);

        label1.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Faixa");
        curvedGradientePanel1.add(label1);
        label1.setBounds(600, 140, 70, 30);

        labelFaixa.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelFaixa.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel1.add(labelFaixa);
        labelFaixa.setBounds(600, 180, 150, 30);

        labelHorarios2.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        labelHorarios2.setForeground(new java.awt.Color(255, 255, 255));
        labelHorarios2.setText("Nome");
        curvedGradientePanel1.add(labelHorarios2);
        labelHorarios2.setBounds(60, 140, 80, 30);

        labelDataNascimento.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelDataNascimento.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel1.add(labelDataNascimento);
        labelDataNascimento.setBounds(60, 280, 240, 30);

        roundButton2.setBackground(new java.awt.Color(13, 32, 51));
        roundButton2.setText("Deletar");
        roundButton2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        roundButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundButton2ActionPerformed(evt);
            }
        });
        curvedGradientePanel1.add(roundButton2);
        roundButton2.setBounds(320, 420, 110, 40);

        jbotaoSairHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home.png"))); // NOI18N
        jbotaoSairHome.setBorderPainted(false);
        jbotaoSairHome.setContentAreaFilled(false);
        jbotaoSairHome.setFocusPainted(false);
        jbotaoSairHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotaoSairHomeActionPerformed(evt);
            }
        });
        curvedGradientePanel1.add(jbotaoSairHome);
        jbotaoSairHome.setBounds(720, 390, 80, 80);

        labelNome2.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        labelNome2.setText("Home");
        curvedGradientePanel1.add(labelNome2);
        labelNome2.setBounds(740, 450, 90, 20);

        getContentPane().add(curvedGradientePanel1);
        curvedGradientePanel1.setBounds(-10, 80, 810, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAlunosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboAlunosItemStateChanged
        displaySelectedAlunoInfo();
    }//GEN-LAST:event_jComboAlunosItemStateChanged

    private void roundButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundButton2ActionPerformed
        String selectedAluno = (String) jComboAlunos.getSelectedItem();
        String[] partes = selectedAluno.split("\\s+");
        int idAluno = -1;
        String nomeCompleto = "";

        if(selectedAluno.equals("Selecione o Aluno")){
            JOptionPane.showMessageDialog(this, "Selecione o Aluno que Deseja Deletar.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (partes.length >= 2) {
            idAluno = Integer.parseInt(partes[0]);

            for (int i = 1; i < partes.length; i++) {
                nomeCompleto += partes[i] + " ";
            }

            nomeCompleto = nomeCompleto.trim(); // Remove o espaço em branco extra do final, se houver
        } else {
            System.out.println("Formato inválido do item selecionado.");
        }

        String query = "DELETE Karate.Aluno WHERE Id_Aluno = ?";
        try {
            BDSQLServer.COMANDO.prepareStatement(query);
            BDSQLServer.COMANDO.setInt(1, idAluno);
            BDSQLServer.COMANDO.execute();
            BDSQLServer.COMANDO.commit();
            JOptionPane.showMessageDialog(this, "Aluno " + nomeCompleto +" foi deletado do banco de dados.");
            new jframeDeleteAluno().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(jframeDeleteAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_roundButton2ActionPerformed

    private void jbotaoSairHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotaoSairHomeActionPerformed
        new jframeHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbotaoSairHomeActionPerformed

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
            java.util.logging.Logger.getLogger(jframeDeleteAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframeDeleteAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframeDeleteAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframeDeleteAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframeDeleteAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private procedimentos.CurvedGradientePanel curvedGradientePanel1;
    private javax.swing.JComboBox<String> jComboAlunos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBushido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbotaoSairHome;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelDataNascimento;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFaixa;
    private javax.swing.JLabel labelHorarios;
    private javax.swing.JLabel labelHorarios1;
    private javax.swing.JLabel labelHorarios2;
    private javax.swing.JLabel labelMatriculado;
    private javax.swing.JLabel labelNome2;
    private javax.swing.JLabel labelNomeCompleto;
    private procedimentos.RoundButton roundButton2;
    // End of variables declaration//GEN-END:variables
}
