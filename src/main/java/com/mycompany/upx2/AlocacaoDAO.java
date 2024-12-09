package com.mycompany.upx2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlocacaoDAO extends GenericDAO<Alocacao> {
    
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Alocacao (data_alocacao, id_risco, id_cidade) VALUES (?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Alocacao SET data_alocacao = ?, id_risco = ?, id_cidade = ? WHERE id_alocacao = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Alocacao WHERE id_alocacao = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT id_alocacao, data_alocacao, fk_id_risco, id_cidade FROM Alocacao WHERE id_alocacao = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, Alocacao alocacao) throws SQLException {
        stmt.setObject(1, alocacao.getDataAlocacao());
        stmt.setInt(2, alocacao.getFkIdRisco());
        stmt.setInt(3, alocacao.getIdCidade()); // Atribuindo idCidade
        stmt.setInt(4, alocacao.getIdAlocacao());
    }

    @Override
    protected Alocacao getEntityFromResultSet(ResultSet rs) throws SQLException {
        Alocacao alocacao = new Alocacao();
        alocacao.setIdAlocacao(rs.getInt("id_alocacao"));
        alocacao.setDataAlocacao(rs.getDate("data_alocacao").toLocalDate());
        alocacao.setFkIdRisco(rs.getInt("fk_id_risco"));
        alocacao.setIdCidade(rs.getInt("id_cidade")); // Adicionando idCidade
        return alocacao;
    }

    public void salvar(Alocacao alocacao) {
        String sql = getInsertQuery();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setObject(1, alocacao.getDataAlocacao());
            stmt.setInt(2, alocacao.getFkIdRisco());
            stmt.setInt(3, alocacao.getIdCidade()); // Atribuindo idCidade

            stmt.executeUpdate();
            System.out.println("Alocação adicionada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar a alocação: " + e.getMessage());
        }
    }

    public void atualizar(Alocacao alocacao) {
        String sql = getUpdateQuery();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setObject(1, alocacao.getDataAlocacao());
            stmt.setInt(2, alocacao.getFkIdRisco());
            stmt.setInt(3, alocacao.getIdCidade()); // Atribuindo idCidade
            stmt.setInt(4, alocacao.getIdAlocacao());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Alocação atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma alocação encontrada para o ID fornecido.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar a alocação: " + e.getMessage());
        }
    }

    public void deletar(int idAlocacao) {
        String sql = getDeleteQuery();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAlocacao);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Alocação deletada com sucesso!");
            } else {
                System.out.println("Nenhuma alocação encontrada com o ID fornecido.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar a alocação: " + e.getMessage());
        }
    }
}
