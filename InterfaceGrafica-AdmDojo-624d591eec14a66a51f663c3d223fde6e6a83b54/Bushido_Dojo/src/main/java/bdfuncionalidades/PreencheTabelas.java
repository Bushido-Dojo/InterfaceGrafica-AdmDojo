package bdfuncionalidades;

import bd.conexaoBD.*;
import bd.conexaoBD.core.*;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PreencheTabelas {

    public void preencherTabela(JTable jTable, String consultaSQL) {
        try {
            BDSQLServer.COMANDO.prepareStatement(consultaSQL);

            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
            // Criar um modelo de tabela (TableModel) para armazenar os dados da consulta
            DefaultTableModel model = new DefaultTableModel();

            int numColunas = resultado.getMetaData().getColumnCount();
            for (int i = 1; i <= numColunas; i++) {
                model.addColumn(resultado.getMetaData().getColumnName(i));
            }

            // Adicionar as linhas ao modelo de tabela
            while (resultado.next()) {
                Object[] rowData = new Object[numColunas];
                for (int i = 1; i <= numColunas; i++) {
                    rowData[i - 1] = resultado.getObject(i);
                }
                model.addRow(rowData);
            }

            // Definir o modelo de tabela criado na JTable
            jTable.setModel(model);

            // Fechar o ResultSet após o uso
            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
