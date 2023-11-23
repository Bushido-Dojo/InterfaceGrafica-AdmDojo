import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://regulus.cotuca.unicamp.br\\sqlExpress:1433;databaseName=BD23319;trustServerCertificate=True;";

        String usuario = "BD23319";
        String senha = "BD23319";

        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // Se a conexão for bem-sucedida, você pode realizar operações no banco de dados aqui
            if (conexao != null) {
                System.out.println("Conexão estabelecida com sucesso! Teste de conexão bem-sucedido.");
            }

            // Feche a conexão quando terminar de usá-la
            conexao.close();
        } catch (SQLException e) {
            // Trate qualquer exceção ou erro de conexão aqui
            e.printStackTrace();
        }
    }
}
