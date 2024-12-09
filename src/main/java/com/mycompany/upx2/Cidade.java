package com.mycompany.upx2;

public class Cidade {
    private int idCidade;
    private String nomeCidade;
    private int fkIdEstado;

    public Cidade() {}

    public Cidade(String nomeCidade, int fkIdEstado) {
        this.nomeCidade = nomeCidade;
        this.fkIdEstado = fkIdEstado;
    }

    public int getIdCidade() { return idCidade; }
    public void setIdCidade(int idCidade) { this.idCidade = idCidade; }
    public String getNomeCidade() { return nomeCidade; }
    public void setNomeCidade(String nomeCidade) { this.nomeCidade = nomeCidade; }
    public int getFkIdEstado() { return fkIdEstado; }
    public void setFkIdEstado(int fkIdEstado) { this.fkIdEstado = fkIdEstado; }
}
