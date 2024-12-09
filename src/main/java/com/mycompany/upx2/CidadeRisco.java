package com.mycompany.upx2;

public class CidadeRisco {
    private int idRisco;
    private int idCidade;
    private String tipoDeRisco;

    public CidadeRisco() {}

    public CidadeRisco(int idRisco, int idCidade, String tipoDeRisco) {
        this.idRisco = idRisco;
        this.idCidade = idCidade;
        this.tipoDeRisco = tipoDeRisco;
    }

    public int getIdRisco() { return idRisco; }
    public void setIdRisco(int idRisco) { this.idRisco = idRisco; }
    public int getIdCidade() { return idCidade; }
    public void setIdCidade(int idCidade) { this.idCidade = idCidade; }
    public String getTipoDeRisco() { return tipoDeRisco; }
    public void setTipoDeRisco(String tipoDeRisco) { this.tipoDeRisco = tipoDeRisco; }
}
