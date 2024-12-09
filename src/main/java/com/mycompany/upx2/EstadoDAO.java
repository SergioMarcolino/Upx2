package com.mycompany.upx2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoDAO extends GenericDAO<Estado> {
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Estado (nome_estado) VALUES (?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Estado SET nome_estado = ? WHERE id_estado = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Estado WHERE id_estado = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT id_estado, nome_estado FROM Estado WHERE id_estado = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, Estado estado) throws SQLException {
        stmt.setString(1, estado.getNomeEstado());
        stmt.setInt(2, estado.getIdEstado());
    }

    @Override
    protected Estado getEntityFromResultSet(ResultSet rs) throws SQLException {
        Estado estado = new Estado();
        estado.setIdEstado(rs.getInt("id_estado"));
        estado.setNomeEstado(rs.getString("nome_estado"));
        return estado;
    }
    public void salvar(Estado estado) {
        String sql = getInsertQuery();
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
    
            stmt.setString(1, estado.getNomeEstado());
    
            stmt.executeUpdate();
            System.out.println("Estado salvo com sucesso!");
    
        } catch (SQLException e) {
            System.err.println("Erro ao salvar o estado: " + e.getMessage());
        }
    }
    public void atualizar(Estado estado) {
        String sql = getUpdateQuery();
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
    
            stmt.setString(1, estado.getNomeEstado());
            stmt.setInt(2, estado.getIdEstado());
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Estado atualizado com sucesso!");
            } else {
                System.out.println("Nenhum estado encontrado com o ID fornecido.");
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o estado: " + e.getMessage());
        }
    }
    public void deletar(int idEstado) {
        String sql = getDeleteQuery();
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
    
            stmt.setInt(1, idEstado);
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Estado deletado com sucesso!");
            } else {
                System.out.println("Nenhum estado encontrado com o ID fornecido.");
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao deletar o estado: " + e.getMessage());
        }
    }
        
    
}
