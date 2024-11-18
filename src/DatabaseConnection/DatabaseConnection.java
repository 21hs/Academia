package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // URL de conexão com o banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/academia?serverTimezone=UTC"; // Adicionando timezone
    private static final String user = "root";
    private static final String password = "root";
    
    private static Connection conn;
    
    // Método para obter a conexão
    public static Connection getConexao() {
        try {
            // Verifica se a conexão já está estabelecida ou foi fechada
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão com o banco de dados estabelecida.");
            }
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Método para fechar a conexão com o banco de dados
    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão com o banco de dados fechada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}