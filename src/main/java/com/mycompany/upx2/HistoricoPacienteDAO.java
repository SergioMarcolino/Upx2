package com.mycompany.upx2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoricoPacienteDAO extends GenericDAO<HistoricoPaciente> {
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO HistoricoPaciente (data_atendimento, fk_id_alocacao, fk_id_profissional, fk_id_paciente) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE HistoricoPaciente SET data_atendimento = ?, fk_id_alocacao = ?, fk_id_profissional = ?, fk_id_paciente = ? WHERE id_alocacao_paciente = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM HistoricoPaciente WHERE id_alocacao_paciente = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT id_alocacao_paciente, data_atendimento, fk_id_alocacao, fk_id_profissional, fk_id_paciente FROM HistoricoPaciente WHERE id_alocacao_paciente = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, HistoricoPaciente historicoPaciente) throws SQLException {
        stmt.setObject(1, historicoPaciente.getDataAtendimento());
        stmt.setInt(2, historicoPaciente.getFkIdAlocacao());
        stmt.setInt(3, historicoPaciente.getFkIdProfissional());
        stmt.setInt(4, historicoPaciente.getFkIdPaciente());
        stmt.setInt(5, historicoPaciente.getIdAlocacaoPaciente());
    }

    @Override
    protected HistoricoPaciente getEntityFromResultSet(ResultSet rs) throws SQLException {
        HistoricoPaciente historicoPaciente = new HistoricoPaciente();
        historicoPaciente.setIdAlocacaoPaciente(rs.getInt("id_alocacao_paciente"));
        historicoPaciente.setDataAtendimento(rs.getTimestamp("data_atendimento").toLocalDateTime());
        historicoPaciente.setFkIdAlocacao(rs.getInt("fk_id_alocacao"));
        historicoPaciente.setFkIdProfissional(rs.getInt("fk_id_profissional"));
        historicoPaciente.setFkIdPaciente(rs.getInt("fk_id_paciente"));
        return historicoPaciente;
    }
}
