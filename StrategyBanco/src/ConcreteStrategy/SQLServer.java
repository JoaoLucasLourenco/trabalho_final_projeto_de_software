package ConcreteStrategy;

import Strategy.IBancoDados;

import java.sql.*;
public class SQLServer implements IBancoDados {
    private Connection conn;
    private Statement stmt;
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public Statement getStmt() {
        return stmt;
    }
    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    @Override
    public void Instancia() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(
            	    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=master;integratedSecurity=true;encrypt=true;trustServerCertificate=true"
            	);

        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao conectar com o banco: " + ex.getMessage());
        } catch (ClassNotFoundException exception) {
            System.err.println("Driver do Banco não localizado");
        }
    }


    @Override
    public void Execute(String sql) {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Erro ao executar SQL: " + e.getMessage());
        }
    }

    @Override
    public ResultSet Select(String sql) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Erro na consulta: " + e.getMessage());
            return null;
        }
    }
}
