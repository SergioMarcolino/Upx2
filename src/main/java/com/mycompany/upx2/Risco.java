package com.mycompany.upx2;

public class Risco {
    private int idRisco;
    private String tipoRisco;
    private String nivelGravidade;
    private String descricao;

    // Getters e Setters
    public int getIdRisco() {
        return idRisco;
    }

    public void setIdRisco(int idRisco) {
        this.idRisco = idRisco;
    }

    public String getTipoRisco() {
        return tipoRisco;
    }

    public void setTipoRisco(String tipoRisco) {
        this.tipoRisco = tipoRisco;
    }

    public String getNivelGravidade() {
        return nivelGravidade;
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Risco{" +
                "idRisco=" + idRisco +
                ", tipoRisco='" + tipoRisco + '\'' +
                ", nivelGravidade=" + nivelGravidade +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public void setNivelGravidade(String nivelGravidade) {
        this.nivelGravidade = nivelGravidade;
    }
}
