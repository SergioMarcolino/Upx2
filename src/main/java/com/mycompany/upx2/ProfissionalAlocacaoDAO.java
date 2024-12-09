package com.mycompany.upx2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ProfissionalAlocacaoDAO {

    public void salvar(Profissional_Alocacao profissionalAlocacao) {
        String sql = "INSERT INTO Profissional_Alocacao (id_profissional, id_alocacao, data_inicio_alocacao, data_termino_alocaçao) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, profissionalAlocacao.getFkIdProfissional());
            stmt.setInt(2, profissionalAlocacao.getFkIdAlocacao());
            stmt.setObject(3, profissionalAlocacao.getDataInicioAlocacao());
            stmt.setObject(4, profissionalAlocacao.getDataTerminoAlocacao());
    
            stmt.executeUpdate();
            System.out.println("Profissional alocado com sucesso!");
    
        } catch (SQLException e) {
            System.err.println("Erro ao alocar profissional: " + e.getMessage());
        }
    }
    
    
    

    public void deletar(int idProfissionalAlocacao) {
        String sql = "DELETE FROM Profissional_Alocacao WHERE id_profissional_alocacao = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProfissionalAlocacao);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Alocação de profissional deletada com sucesso!");
            } else {
                System.out.println("Nenhuma alocação encontrada com o ID fornecido.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar a alocação de profissional: " + e.getMessage());
        }
    }

    public void atualizar(Profissional_Alocacao profissionalAlocacao) {
        String sql = "UPDATE Profissional_Alocacao SET fk_id_profissional = ?, id_alocacao = ?, data_inicio_alocacao = ?, data_termino_alocaçao = ? WHERE id_profissional_alocacao = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, profissionalAlocacao.getFkIdProfissional());
            stmt.setInt(2, profissionalAlocacao.getFkIdAlocacao());
            stmt.setObject(3, profissionalAlocacao.getDataInicioAlocacao());
            stmt.setObject(4, profissionalAlocacao.getDataTerminoAlocacao());
            stmt.setInt(5, profissionalAlocacao.getIdProfissionalAlocacao());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Alocação de profissional atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma alocação encontrada com o ID fornecido.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar a alocação de profissional: " + e.getMessage());
        }
    }
    public boolean verificarDisponibilidade(int fkIdProfissional, LocalDate dataInicio, LocalDate dataTermino, int fkIdCidade) {
        String sql = "SELECT 1 " +
                     "FROM Profissional_Alocacao pa " +
                     "INNER JOIN Alocacao a ON pa.id_alocacao = a.id_alocacao " +
                     "WHERE pa.id_profissional = ? " +
                     "AND a.id_cidade = ? " +
                     "AND ( " +
                     "      (pa.data_inicio_alocacao <= ? AND pa.data_termino_alocacao >= ?) OR " +
                     "      (pa.data_inicio_alocacao >= ? AND pa.data_termino_alocacao <= ?) " +
                     ")";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, fkIdProfissional);
            stmt.setInt(2, fkIdCidade);
            stmt.setObject(3, dataInicio);
            stmt.setObject(4, dataTermino);
            stmt.setObject(5, dataInicio);
            stmt.setObject(6, dataTermino);
    
            ResultSet rs = stmt.executeQuery();
            return !rs.next(); // Retorna verdadeiro se não houver sobreposição de datas
    
        } catch (SQLException e) {
            System.err.println("Erro ao verificar a disponibilidade do profissional: " + e.getMessage());
            return false;
        }
    }
    
 }




