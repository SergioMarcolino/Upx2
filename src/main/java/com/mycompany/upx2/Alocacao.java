package com.mycompany.upx2;

import java.time.LocalDate;

public class Alocacao {
    private int idAlocacao;
    private LocalDate dataAlocacao;
    private int fkIdRisco;
    private int idCidade; // Novo atributo

    public Alocacao() {}

    public Alocacao(LocalDate dataAlocacao, int fkIdRisco, int idCidade) {
        this.dataAlocacao = dataAlocacao;
        this.fkIdRisco = fkIdRisco;
        this.idCidade = idCidade;
    }

    public int getIdAlocacao() { 
        return idAlocacao; 
    }

    public void setIdAlocacao(int idAlocacao) { 
        this.idAlocacao = idAlocacao; 
    }

    public LocalDate getDataAlocacao() { 
        return dataAlocacao; 
    }

    public void setDataAlocacao(LocalDate dataAlocacao) { 
        this.dataAlocacao = dataAlocacao; 
    }

    public int getFkIdRisco() { 
        return fkIdRisco; 
    }

    public void setFkIdRisco(int fkIdRisco) { 
        this.fkIdRisco = fkIdRisco; 
    }

    public int getIdCidade() { 
        return idCidade; 
    }

    public void setIdCidade(int idCidade) { 
        this.idCidade = idCidade; 
    }
}
