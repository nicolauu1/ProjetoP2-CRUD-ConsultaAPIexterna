CREATE TABLE IF NOT EXISTS cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(22),
    nomeProduto VARCHAR(255),
    codigoProduto VARCHAR(50),
    tamanho VARCHAR(10),
    cor VARCHAR(50),
    endereco VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(50),
    cep VARCHAR(22)
);