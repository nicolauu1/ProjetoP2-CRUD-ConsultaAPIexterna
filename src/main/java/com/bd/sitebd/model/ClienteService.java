package com.bd.sitebd.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    public void inserir(Cliente cliente) {
        clienteDAO.inserir(cliente);
    }

    public List<Map<String, Object>> obterTodosClientes() {
        return clienteDAO.obterTodosClientes();
    }

    public Cliente obterCliente(int id) {
        return clienteDAO.obterCliente(id);
    }

    public void atualizarCliente(int id, Cliente cliente) {
        clienteDAO.atualizarCliente(id, cliente);
    }

    public void deletarCliente(int id) {
        clienteDAO.deletarCliente(id);
    }
}