package com.mycompany.upx2;

public class Estado {
    private int idEstado;
    private String nomeEstado;

    public Estado() {}

    public Estado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public int getIdEstado() { return idEstado; }
    public void setIdEstado(int idEstado) { this.idEstado = idEstado; }
    public String getNomeEstado() { return nomeEstado; }
    public void setNomeEstado(String nomeEstado) { this.nomeEstado = nomeEstado; }
}
