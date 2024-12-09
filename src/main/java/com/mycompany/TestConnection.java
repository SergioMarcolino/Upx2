package com.mycompany;

import java.sql.Connection;
import java.sql.SQLException;

import com.mycompany.upx2.DatabaseConnection;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Conexão bem-sucedida com o banco de dados!");
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao tentar conectar ao banco de dados:");
            e.printStackTrace();
        }   
    }
}
