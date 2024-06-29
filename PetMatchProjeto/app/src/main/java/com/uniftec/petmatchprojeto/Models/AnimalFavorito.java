package com.uniftec.petmatchprojeto.Models;


public class AnimalFavorito {
    private String cor;
    private String raca;
    private int idade;
    private int imagemResourceId;
    public AnimalFavorito(String cor, String raca, int idade, int imagemResourceId) {
        this.cor = cor;
        this.raca = raca;
        this.idade = idade;
        this.imagemResourceId = imagemResourceId;
    }

    public String getCor() {
        return cor;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public int getImagemResourceId() {
        return imagemResourceId;
    }
}
