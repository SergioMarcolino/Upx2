package com.mycompany.upx2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiscoDAO extends GenericDAO<Risco> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO risco (tipo_risco, nivel_gravidade, descricao) VALUES (?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE risco SET tipo_risco = ?, nivel_gravidade = ?, descricao = ? WHERE id_risco = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM risco WHERE id_risco = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT id_risco, tipo_risco, nivel_gravidade, descricao FROM risco WHERE id_risco = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, Risco risco) throws SQLException {
        stmt.setString(1, risco.getTipoRisco());
        stmt.setString(2, risco.getNivelGravidade());
        stmt.setString(3, risco.getDescricao());
        stmt.setInt(4, risco.getIdRisco());
    }

    @Override
    protected Risco getEntityFromResultSet(ResultSet rs) throws SQLException {
        Risco risco = new Risco();
        risco.setIdRisco(rs.getInt("id_risco"));
        risco.setTipoRisco(rs.getString("tipo_risco"));
        risco.setNivelGravidade(rs.getString("nivel_gravidade"));
        risco.setDescricao(rs.getString("descricao"));
        return risco;
    }

    public void salvar(Risco risco) {
        String sql = getInsertQuery();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, risco.getTipoRisco());
            stmt.setString(2, risco.getNivelGravidade());
            stmt.setString(3, risco.getDescricao());

            stmt.executeUpdate();
            System.out.println("Risco salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar o risco: " + e.getMessage());
        }
    }

    public void atualizar(Risco risco) {
        String sql = getUpdateQuery();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setString(1, risco.getTipoRisco());
            stmt.setString(2, risco.getNivelGravidade());
            stmt.setString(3, risco.getDescricao());
            stmt.setInt(4, risco.getIdRisco());
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Risco atualizado com sucesso!");
            } else {
                System.out.println("Nenhum risco encontrado com o ID fornecido.");
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o risco: " + e.getMessage());
        }
    }
    public void deletar(int idRisco) {
        String sql = getDeleteQuery();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, idRisco);
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Risco deletado com sucesso!");
            } else {
                System.out.println("Nenhum risco encontrado com o ID fornecido.");
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao deletar o risco: " + e.getMessage());
        }
    }
    
}
