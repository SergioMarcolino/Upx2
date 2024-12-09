package com.mycompany.upx2;

import java.time.LocalDateTime;

public class HistoricoPaciente {
    private int idAlocacaoPaciente;
    private LocalDateTime dataAtendimento;
    private int fkIdAlocacao;
    private int fkIdProfissional;
    private int fkIdPaciente;

    public HistoricoPaciente() {}

    public HistoricoPaciente(LocalDateTime dataAtendimento, int fkIdAlocacao, int fkIdProfissional, int fkIdPaciente) {
        this.dataAtendimento = dataAtendimento;
        this.fkIdAlocacao = fkIdAlocacao;
        this.fkIdProfissional = fkIdProfissional;
        this.fkIdPaciente = fkIdPaciente;
    }

    public int getIdAlocacaoPaciente() { return idAlocacaoPaciente; }
    public void setIdAlocacaoPaciente(int idAlocacaoPaciente) { this.idAlocacaoPaciente = idAlocacaoPaciente; }
    public LocalDateTime getDataAtendimento() { return dataAtendimento; }
    public void setDataAtendimento(LocalDateTime dataAtendimento) { this.dataAtendimento = dataAtendimento; }
    public int getFkIdAlocacao() { return fkIdAlocacao; }
    public void setFkIdAlocacao(int fkIdAlocacao) { this.fkIdAlocacao = fkIdAlocacao; }
    public int getFkIdProfissional() { return fkIdProfissional; }
    public void setFkIdProfissional(int fkIdProfissional) { this.fkIdProfissional = fkIdProfissional; }
    public int getFkIdPaciente() { return fkIdPaciente; }
    public void setFkIdPaciente(int fkIdPaciente) { this.fkIdPaciente = fkIdPaciente; }
}
