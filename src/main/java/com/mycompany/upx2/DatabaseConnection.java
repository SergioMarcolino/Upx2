/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.upx2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=alocacaoMedicos;integratedSecurity=true;"
            + "encrypt=true;trustServerCertificate=true;";

  // Conexão com o banco de dados
  public static Connection getConnection() {
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL);
    } catch(ClassNotFoundException e){
        throw new RuntimeException("Driver JDBC não encontrado: ", e);
    }
    catch (SQLException e) {
        throw new RuntimeException("Erro ao conectar com o banco de dados", e);
    }
}


    // Fechar a conexão
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    // Fechar o PreparedStatement
    public static void closeStatement(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro com a biblioteca PreparetedStatement: ", e);
            }
        }
    }

    // Fechar o ResultSet
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro com a biblioteca ResultSet: ", e);
            }
        }

    }
}