package com.uniftec.petmatchprojeto.Models;

public class UsuarioONG {

    private Integer id;
    private String nomeCompleto;
    private String email;
    private String senha;
    private String cep;
    private String cpfCnpj;

    public UsuarioONG(
            Integer id,
            String nomeCompleto,
            String email,
            String senha,
            String cep,
            String cpfCnpj
    ) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.cpfCnpj = cpfCnpj;
    }

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nomeCompleto;
    }

    public void setNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }


}
