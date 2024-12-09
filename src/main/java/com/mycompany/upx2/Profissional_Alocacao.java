package com.mycompany.upx2;

import java.time.LocalDate;

public class Profissional_Alocacao {
    private int idProfissionalAlocacao;
    private int IdProfissional; // Relacionamento com Profissional
    private int IdAlocacao;     // Relacionamento com Alocacao
    private int IdCidade;       // Relacionamento com Cidade
    private LocalDate dataInicioAlocacao;  // Data de início da alocação
    private LocalDate dataTerminoAlocacao; // Data de término da alocação

    public Profissional_Alocacao() {}

    public Profissional_Alocacao(int fkIdProfissional, int fkIdAlocacao, int fkIdCidade, 
                                 LocalDate dataInicioAlocacao, LocalDate dataTerminoAlocacao) {
        this.IdProfissional = fkIdProfissional;
        this.IdAlocacao = fkIdAlocacao;
        this.IdCidade = fkIdCidade;
        this.dataInicioAlocacao = dataInicioAlocacao;
        this.dataTerminoAlocacao = dataTerminoAlocacao;
    }

    public int getIdProfissionalAlocacao() {
        return idProfissionalAlocacao;
    }

    public void setIdProfissionalAlocacao(int idProfissionalAlocacao) {
        this.idProfissionalAlocacao = idProfissionalAlocacao;
    }

    public int getFkIdProfissional() {
        return IdProfissional;
    }

    public void setFkIdProfissional(int fkIdProfissional) {
        this.IdProfissional = fkIdProfissional;
    }

    public int getFkIdAlocacao() {
        return IdAlocacao;
    }

    public void setFkIdAlocacao(int fkIdAlocacao) {
        this.IdAlocacao = fkIdAlocacao;
    }

    public int getFkIdCidade() {
        return IdCidade;
    }

    public void setFkIdCidade(int fkIdCidade) {
        this.IdCidade = fkIdCidade;
    }

    public LocalDate getDataInicioAlocacao() {
        return dataInicioAlocacao;
    }

    public void setDataInicioAlocacao(LocalDate dataInicioAlocacao) {
        this.dataInicioAlocacao = dataInicioAlocacao;
    }

    public LocalDate getDataTerminoAlocacao() {
        return dataTerminoAlocacao;
    }

    public void setDataTerminoAlocacao(LocalDate dataTerminoAlocacao) {
        this.dataTerminoAlocacao = dataTerminoAlocacao;
    }
}
