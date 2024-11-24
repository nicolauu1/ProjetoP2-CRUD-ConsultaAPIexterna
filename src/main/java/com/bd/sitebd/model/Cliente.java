package com.bd.sitebd.model;

public class Cliente {

    private Integer id; // Atributo id
    private String nome, cpf, nomeProduto, codigoProduto, tamanho, cor, endereco, bairro, cidade, estado, cep; // Novo atributo cep

    // Construtor com 12 parâmetros (incluindo id e cep)
    public Cliente(Integer id, String nome, String cpf, String nomeProduto, String codigoProduto, String tamanho,
                   String cor, String endereco, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.tamanho = tamanho;
        this.cor = cor;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep; // Inicializa o campo cep
    }

    // Getters e setters para os atributos
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }

    public String getCodigoProduto() { return codigoProduto; }
    public void setCodigoProduto(String codigoProduto) { this.codigoProduto = codigoProduto; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; } // Getter para cep
    public void setCep(String cep) { this.cep = cep; } // Setter para cep
}