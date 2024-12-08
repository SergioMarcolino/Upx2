
package com.mycompany.upx2;

public class Profissional {
    private int id_Profissional; // ID gerado pelo banco
    private String nome;
    private String cpf;
    private String rg;
    private String especialidade;
    private String telefone;
    private String email;
    private int id_cidade;

    public Profissional(String nome, String cpf, String rg, String especialidade, String telefone, String email, int id_cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
        this.id_cidade = id_cidade;
    }

    public Profissional() {
        this.id_Profissional = id_Profissional;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;

    }

    public int getIdProfissional() {
        return id_Profissional;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setIdProfissional(int idProfissional) {
        this.id_Profissional = idProfissional;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_Profissional() {
        return id_Profissional;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }
}
