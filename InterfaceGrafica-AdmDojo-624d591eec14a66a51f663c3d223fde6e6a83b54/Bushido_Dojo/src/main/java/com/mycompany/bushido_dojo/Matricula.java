
package com.mycompany.bushido_dojo;
import bd.conexaoBD.BDSQLServer;
import bd.conexaoBD.core.MeuResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Matricula extends javax.swing.JFrame {
    
    public Matricula() {
        initComponents();
        fillComboBox();
        
        
    }
    
    private void fillComboBox() {
            try {
                String query = """
                               SELECT CONCAT(Id_Aluno, ' ', nome, ' ', sobrenome) AS NomeCompleto
                               FROM Karate.Aluno A
                               WHERE NOT EXISTS (
                                   SELECT 1 
                                   FROM Karate.Matricula M 
                                   WHERE M.Id_Aluno = A.Id_Aluno
                               )
                               """;
                
                MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (query);
                
                
                
                while (resultado.next()) {
                    jcomboAlunos.addItem(resultado.getString(1));
                }

                
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao preencher o ComboBox.");
            }
            
        }
    
    
    private void displaySelectedAlunoInfo() {
        try {
            String selectedAluno = (String) jcomboAlunos.getSelectedItem();
            String[] partes = selectedAluno.split("\\s+");
            int idAluno = -1;
            if (partes.length >= 2) {
                // Obtém somente o número do ID (a primeira parte)
                 idAluno = Integer.parseInt(partes[0]);
            } else {
                System.out.println("Formato inválido do item selecionado.");
            }
            String query = "SELECT * FROM Karate.Aluno WHERE id_aluno = ?";
            BDSQLServer.COMANDO.prepareStatement(query);
            BDSQLServer.COMANDO.setInt(1, idAluno);
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
            
            if (resultado.next()) {
                int id = resultado.getInt(1);
                int idFaixa  = resultado.getInt(2);
                String nomeCompleto = resultado.getString(3) +" " + resultado.getString(4);
                String email = resultado.getString(6);
                String cpf = resultado.getString(5);
                Date dataNascimentoSQL = resultado.getDate(8);
                String DataNascimento = new SimpleDateFormat("dd/MM/yyyy").format(dataNascimentoSQL);
                
                labelNomeCompleto.setText(nomeCompleto);
                labelDataNascimento.setText(DataNascimento);
                labelCPF.setText(cpf);
                labelEmail.setText(email);
                String corFaixa = "";
                
                switch(idFaixa)
                {
                    case 0: corFaixa = "Branca"; 
                        break;
                    case 1: corFaixa = "Amarela";
                        break;
                    case 2: corFaixa = "Laranja";
                        break;
                    case 3: corFaixa = "Verde";
                        break;
                    case 4: corFaixa = "Azul";
                        break;
                    case 5: corFaixa ="Roxa";
                        break;
                    case 6: corFaixa ="Marrom";
                        break;
                    case 7: corFaixa ="Preta";
                        break;
                    default: JOptionPane.showMessageDialog(this, "Faixa Inválida recebida.");
                    
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

        curvedGradientePanel1 = new procedimentos.CurvedGradientePanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelBushido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        curvedGradientePanel3 = new procedimentos.CurvedGradientePanel();
        jcomboAlunos = new javax.swing.JComboBox<>();
        labelDataNascimento = new javax.swing.JLabel();
        labelAlunos = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        labelHorarios1 = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelNomeCompleto = new javax.swing.JLabel();
        labelHorarios = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        labelFaixa = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        roundButton2 = new procedimentos.RoundButton();
        jbotaoSairHome = new javax.swing.JButton();
        labelNome2 = new javax.swing.JLabel();

        javax.swing.GroupLayout curvedGradientePanel1Layout = new javax.swing.GroupLayout(curvedGradientePanel1);
        curvedGradientePanel1.setLayout(curvedGradientePanel1Layout);
        curvedGradientePanel1Layout.setHorizontalGroup(
            curvedGradientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        curvedGradientePanel1Layout.setVerticalGroup(
            curvedGradientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
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

        curvedGradientePanel3.setMinimumSize(new java.awt.Dimension(800, 600));
        curvedGradientePanel3.setLayout(null);

        jcomboAlunos.setBackground(new java.awt.Color(13, 32, 51));
        jcomboAlunos.setForeground(new java.awt.Color(255, 255, 255));
        jcomboAlunos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha o Aluno" }));
        jcomboAlunos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcomboAlunosItemStateChanged(evt);
            }
        });
        curvedGradientePanel3.add(jcomboAlunos);
        jcomboAlunos.setBounds(30, 70, 320, 22);

        labelDataNascimento.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelDataNascimento.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel3.add(labelDataNascimento);
        labelDataNascimento.setBounds(40, 250, 240, 30);

        labelAlunos.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelAlunos.setForeground(new java.awt.Color(255, 255, 255));
        labelAlunos.setText("Alunos:");
        curvedGradientePanel3.add(labelAlunos);
        labelAlunos.setBounds(30, 40, 70, 30);

        label.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Email");
        curvedGradientePanel3.add(label);
        label.setBounds(380, 210, 90, 30);

        labelHorarios1.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        labelHorarios1.setForeground(new java.awt.Color(255, 255, 255));
        labelHorarios1.setText("Nome");
        curvedGradientePanel3.add(labelHorarios1);
        labelHorarios1.setBounds(40, 110, 80, 30);

        labelEmail.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel3.add(labelEmail);
        labelEmail.setBounds(380, 250, 400, 30);

        labelNomeCompleto.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelNomeCompleto.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel3.add(labelNomeCompleto);
        labelNomeCompleto.setBounds(40, 150, 250, 30);

        labelHorarios.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        labelHorarios.setForeground(new java.awt.Color(255, 255, 255));
        labelHorarios.setText("Data de Nascimento");
        curvedGradientePanel3.add(labelHorarios);
        labelHorarios.setBounds(40, 210, 250, 30);

        label1.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Faixa");
        curvedGradientePanel3.add(label1);
        label1.setBounds(580, 110, 70, 30);

        labelFaixa.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelFaixa.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel3.add(labelFaixa);
        labelFaixa.setBounds(580, 150, 150, 30);

        label2.setFont(new java.awt.Font("Atletico Bold", 1, 24)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("CPF");
        curvedGradientePanel3.add(label2);
        label2.setBounds(380, 110, 50, 30);

        labelCPF.setFont(new java.awt.Font("Atletico Bold", 1, 18)); // NOI18N
        labelCPF.setForeground(new java.awt.Color(255, 255, 255));
        curvedGradientePanel3.add(labelCPF);
        labelCPF.setBounds(380, 150, 180, 30);

        roundButton2.setBackground(new java.awt.Color(13, 32, 51));
        roundButton2.setForeground(new java.awt.Color(255, 255, 255));
        roundButton2.setText("Matricular");
        roundButton2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        roundButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundButton2ActionPerformed(evt);
            }
        });
        curvedGradientePanel3.add(roundButton2);
        roundButton2.setBounds(340, 390, 110, 40);

        jbotaoSairHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home.png"))); // NOI18N
        jbotaoSairHome.setBorderPainted(false);
        jbotaoSairHome.setContentAreaFilled(false);
        jbotaoSairHome.setFocusPainted(false);
        jbotaoSairHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotaoSairHomeActionPerformed(evt);
            }
        });
        curvedGradientePanel3.add(jbotaoSairHome);
        jbotaoSairHome.setBounds(720, 390, 80, 80);

        labelNome2.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        labelNome2.setText("Home");
        curvedGradientePanel3.add(labelNome2);
        labelNome2.setBounds(740, 450, 90, 20);

        getContentPane().add(curvedGradientePanel3);
        curvedGradientePanel3.setBounds(-10, 80, 810, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcomboAlunosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcomboAlunosItemStateChanged
        displaySelectedAlunoInfo();
    }//GEN-LAST:event_jcomboAlunosItemStateChanged

    private void jbotaoSairHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotaoSairHomeActionPerformed
        new jframeHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbotaoSairHomeActionPerformed

    private void roundButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundButton2ActionPerformed
        String selectedAluno = (String) jcomboAlunos.getSelectedItem();
        String[] partes = selectedAluno.split("\\s+");
        int idAluno = -1;
        String nomeCompleto = "";
        
        if(selectedAluno.equals("Escolha o Aluno")){
            JOptionPane.showMessageDialog(this, "Escolha o Aluno que Deseja Matricular.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;  
        }
            
        
        if (partes.length >= 2) {
            idAluno = Integer.parseInt(partes[0]);

            // Forma o sobrenome a partir dos elementos do array, exceto o primeiro
            for (int i = 1; i < partes.length; i++) {
                nomeCompleto += partes[i] + " ";
            }

            nomeCompleto = nomeCompleto.trim(); // Remove o espaço em branco extra do final, se houver
        } else {
            System.out.println("Formato inválido do item selecionado.");
        }

        String query = "EXEC Karate.spRealizaPgtos ?";
        try {
            BDSQLServer.COMANDO.prepareStatement(query);
            BDSQLServer.COMANDO.setInt(1, idAluno);
            BDSQLServer.COMANDO.execute();
            BDSQLServer.COMANDO.commit();
            JOptionPane.showMessageDialog(this, "Matrícula do Aluno: " + nomeCompleto + idAluno+ " foi realizada com sucesso");
            new Matricula().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_roundButton2ActionPerformed

    static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Matricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private procedimentos.CurvedGradientePanel curvedGradientePanel1;
    private procedimentos.CurvedGradientePanel curvedGradientePanel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBushido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbotaoSairHome;
    private javax.swing.JComboBox<String> jcomboAlunos;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel labelAlunos;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelDataNascimento;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFaixa;
    private javax.swing.JLabel labelHorarios;
    private javax.swing.JLabel labelHorarios1;
    private javax.swing.JLabel labelNome2;
    private javax.swing.JLabel labelNomeCompleto;
    private procedimentos.RoundButton roundButton2;
    // End of variables declaration//GEN-END:variables
}
