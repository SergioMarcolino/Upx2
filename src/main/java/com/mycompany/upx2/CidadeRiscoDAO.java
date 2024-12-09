package com.mycompany.upx2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeRiscoDAO extends GenericDAO<CidadeRisco> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO CidadeRisco (id_risco, id_cidade, tipo_de_risco) VALUES (?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE CidadeRisco SET tipo_de_risco = ? WHERE id_risco = ? AND id_cidade = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM CidadeRisco WHERE id_risco = ? AND id_cidade = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT id_risco, id_cidade, tipo_de_risco FROM CidadeRisco WHERE id_risco = ? AND id_cidade = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, CidadeRisco cidadeRisco) throws SQLException {
        stmt.setInt(1, cidadeRisco.getIdRisco());  // id_risco
        stmt.setInt(2, cidadeRisco.getIdCidade()); // id_cidade
        stmt.setString(3, cidadeRisco.getTipoDeRisco()); // tipo_de_risco
    }

    @Override
    protected CidadeRisco getEntityFromResultSet(ResultSet rs) throws SQLException {
        CidadeRisco cidadeRisco = new CidadeRisco();
        cidadeRisco.setIdRisco(rs.getInt("id_risco"));
        cidadeRisco.setIdCidade(rs.getInt("id_cidade"));
        cidadeRisco.setTipoDeRisco(rs.getString("tipo_de_risco"));
        return cidadeRisco;
    }

    // Método para inserir o risco
    public void salvarRisco(int idRisco, int idCidade, String tipoDeRisco) {
        String sql = "INSERT INTO Cidade_Risco (id_risco, id_cidade, tipo_de_risco) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Definindo os parâmetros
            stmt.setInt(1, idRisco); // Definindo o id_risco
            stmt.setInt(2, idCidade); // Definindo o id_cidade
            stmt.setString(3, tipoDeRisco); // Definindo o tipo_de_risco
            
            // Executando a inserção
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Risco inserido com sucesso!");
            } else {
                System.out.println("Erro ao inserir risco.");
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir risco: " + e.getMessage());
        }
    }

    // Teste para salvar um novo risco
    public static void main(String[] args) {
        CidadeRiscoDAO cidadeRisco = new CidadeRiscoDAO();
        // Chamar o método de salvar com os dados do risco
        cidadeRisco.salvarRisco(1, 101, "Alto");
    }
 }
