package com.uniftec.petmatchprojeto.Models;

public class Animal {

    private Integer id;
    private String raca;
    private String cor;
    private String porte;
    private Integer idade;
    private int imagemResourceId;
    public Animal(
            Integer id,
            String raca,
            String cor,
            String porte,
            Integer idade, Integer imagemResourceId
    ) {
        this.id = id;
        this.raca = raca;
        this.cor = cor;
        this.porte = porte;
        this.idade = idade;
        this.imagemResourceId = imagemResourceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setCep(Integer idade) {
        this.idade = idade;
    }

    public Integer getImagemResourceId() {
        return imagemResourceId;
    }

    public void setImagemResourceId(Integer imagemResourceId) {
       this.imagemResourceId = imagemResourceId;
    }
}
