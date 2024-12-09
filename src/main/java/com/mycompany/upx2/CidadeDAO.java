package com.mycompany.upx2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeDAO extends GenericDAO<Cidade> {
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Cidade (nome_cidade, fk_id_estado) VALUES (?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Cidade SET nome_cidade = ?, fk_id_estado = ? WHERE id_cidade = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Cidade WHERE id_cidade = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT id_cidade, nome_cidade, fk_id_estado FROM Cidade WHERE id_cidade = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, Cidade cidade) throws SQLException {
        stmt.setString(1, cidade.getNomeCidade());
        stmt.setInt(2, cidade.getFkIdEstado());
        stmt.setInt(3, cidade.getIdCidade());
    }

    @Override
    protected Cidade getEntityFromResultSet(ResultSet rs) throws SQLException {
        Cidade cidade = new Cidade();
        cidade.setIdCidade(rs.getInt("id_cidade"));
        cidade.setNomeCidade(rs.getString("nome_cidade"));
        cidade.setFkIdEstado(rs.getInt("fk_id_estado"));
        return cidade;

    }
    public void salvar(Cidade cidade) {
        String sql = getInsertQuery();
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
    
            stmt.setString(1, cidade.getNomeCidade());
            stmt.setInt(2, cidade.getFkIdEstado());
    
            stmt.executeUpdate();
            System.out.println("Cidade salva com sucesso!");
    
        } catch (SQLException e) {
            System.err.println("Erro ao salvar a cidade: " + e.getMessage());
        }
    }
    
    public void atualizar(Cidade cidade) {
        String sql = getUpdateQuery();
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
    
            stmt.setString(1, cidade.getNomeCidade());
            stmt.setInt(2, cidade.getFkIdEstado());
            stmt.setInt(3, cidade.getIdCidade());
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cidade atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma cidade encontrada com o ID fornecido.");
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar a cidade: " + e.getMessage());
        }
    }
    public void deletar(int idCidade) {
        String sql = getDeleteQuery();
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
    
            stmt.setInt(1, idCidade);
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cidade deletada com sucesso!");
            } else {
                System.out.println("Nenhuma cidade encontrada com o ID fornecido.");
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao deletar a cidade: " + e.getMessage());
        }
    }
        
}
