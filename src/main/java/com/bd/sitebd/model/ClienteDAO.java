package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClienteDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    // Método para inserir um cliente no banco de dados
    public void inserir(Cliente cli) {
        String sql = "INSERT INTO cliente(nome, cpf, nomeProduto, codigoProduto, tamanho, cor, endereco, bairro, cidade, estado, cep) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Object[] parametros = new Object[] {
            cli.getNome(),
            cli.getCpf(),
            cli.getNomeProduto(),
            cli.getCodigoProduto(),
            cli.getTamanho(),
            cli.getCor(),
            cli.getEndereco(),
            cli.getBairro(),
            cli.getCidade(),
            cli.getEstado(),
            cli.getCep()
        };
        jdbc.update(sql, parametros);
    }
    
    // Método para obter todos os clientes do banco de dados
    public List<Map<String, Object>> obterTodosClientes() {
        String sql = "SELECT * FROM cliente;";
        return jdbc.queryForList(sql);
    }

    // Método para atualizar um cliente
    public void atualizarCliente(int id, Cliente cli) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, nomeProduto = ?, codigoProduto = ?, tamanho = ?, cor = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id = ?";
        jdbc.update(sql, cli.getNome(), cli.getCpf(), cli.getNomeProduto(), cli.getCodigoProduto(), cli.getTamanho(), cli.getCor(),
                    cli.getEndereco(), cli.getBairro(), cli.getCidade(), cli.getEstado(), cli.getCep(), id);
    }

    // Método para obter um cliente específico pelo id
    public Cliente obterCliente(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        return Tool.converterCliente(jdbc.queryForMap(sql, id));
    }

    // Método para deletar um cliente pelo id
    public void deletarCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        jdbc.update(sql, id);
    }
}