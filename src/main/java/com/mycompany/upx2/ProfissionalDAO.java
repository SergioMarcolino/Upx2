package com.mycompany.upx2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfissionalDAO extends GenericDAO<Profissional> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Profissional (nome, cpf, rg, especialidade, telefone, email, id_cidade) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Profissional SET nome = ?, cpf = ?, rg = ?, especialidade = ?, telefone = ?, email = ?, id_cidade = ? WHERE id_profissional = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Profissional WHERE id_profissional = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT id_profissional, nome, cpf, rg, especialidade, telefone, email, id_cidade FROM Profissional WHERE id_profissional = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, Profissional profissional) throws SQLException {
        stmt.setString(1, profissional.getNome());
        stmt.setString(2, profissional.getCpf());
        stmt.setString(3, profissional.getRg());
        stmt.setString(4, profissional.getEspecialidade());
        stmt.setString(5, profissional.getTelefone());
        stmt.setString(6, profissional.getEmail());
        stmt.setInt(7, profissional.getId_cidade());  // Aqui está a adição de id_cidade
        stmt.setInt(8, profissional.getIdProfissional());  // Para a operação de UPDATE
    }

    @Override
    protected Profissional getEntityFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_profissional");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        String rg = rs.getString("rg");
        String especialidade = rs.getString("especialidade");
        String telefone = rs.getString("telefone");
        String email = rs.getString("email");
        int idCidade = rs.getInt("id_cidade");  // Obtendo id_cidade

        Profissional profissional = new Profissional();
        profissional.setIdProfissional(id);
        profissional.setNome(nome);
        profissional.setCpf(cpf);
        profissional.setRg(rg);
        profissional.setEspecialidade(especialidade);
        profissional.setTelefone(telefone);
        profissional.setEmail(email);
        profissional.setId_cidade(idCidade);  // Definindo id_cidade no objeto Profissional

        return profissional;
    }

    public Profissional buscarPorId(int idProfissional) {
        String sql = "SELECT * FROM Profissional WHERE id_profissional = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Profissional profissional = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProfissional);
            rs = stmt.executeQuery();

            if (rs.next()) {
                profissional = new Profissional();
                profissional.setIdProfissional(rs.getInt("id_profissional"));
                profissional.setNome(rs.getString("nome"));
                profissional.setCpf(rs.getString("cpf"));
                profissional.setRg(rs.getString("rg"));
                profissional.setEspecialidade(rs.getString("especialidade"));
                profissional.setTelefone(rs.getString("telefone"));
                profissional.setEmail(rs.getString("email"));
                profissional.setId_cidade(rs.getInt("id_cidade")); // Preenchendo id_cidade
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar recursos
            DatabaseConnection.closeResultSet(rs);
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }

        return profissional;
    }

    // Método para atualizar
    public void atualizar(Profissional profissional) {
        String sql =  "UPDATE Profissional SET nome = ?, cpf = ?, rg = ?, especialidade = ?, telefone = ?, email = ?, id_cidade = ? WHERE id_profissional = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(7, profissional.getId_cidade());  // Atualizando id_cidade
            stmt.setInt(8, profissional.getIdProfissional());  // ID do profissional a ser atualizado
            stmt.setString(1, profissional.getNome());
            stmt.setString(2, profissional.getCpf());
            stmt.setString(3, profissional.getRg());
            stmt.setString(4, profissional.getEspecialidade());
            stmt.setString(5, profissional.getTelefone());
            stmt.setString(6, profissional.getEmail());

            stmt.executeUpdate();
            System.out.println("Profissional atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }

    // Método para deletar profissional
    public void deletar(int idProfissional) {
        String sql = getDeleteQuery();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProfissional); // Define o ID do profissional a ser deletado

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Profissional deletado com sucesso!");
            } else {
                System.out.println("Nenhum profissional encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fecha recursos
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }
}
