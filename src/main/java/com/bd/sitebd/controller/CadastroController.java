package com.bd.sitebd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.sitebd.model.Cliente;
import com.bd.sitebd.model.ClienteService;
import com.bd.sitebd.model.Tool;

@Controller
public class CadastroController {

    @Autowired
    private ApplicationContext context;

    // Página inicial
    @GetMapping("/")
    public String principal() {
        return "principal";
    }

    // Página de cadastro de cliente
    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("cliente", new Cliente(0, "", "", "", "", "", "", "", "", "", "", ""));
        return "cadastro";
    }
    

    // Cadastro de cliente (envio do formulário)
    @PostMapping("/cadastro")
    public String cadastrar(Model model, @ModelAttribute Cliente cli) {
        ClienteService cs = context.getBean(ClienteService.class);
        cs.inserir(cli);
        return "sucesso";
    }

    // Listagem de todos os clientes
    @GetMapping("/listagem")
    public String listagem(Model model) {
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String, Object>> lista = cs.obterTodosClientes();
      
        List<Cliente> listaClientes = new ArrayList<>();
        for (Map<String, Object> registro : lista) {
            listaClientes.add(Tool.converterCliente(registro));
        }
        model.addAttribute("clientes", listaClientes);  // Certifique-se de que o nome do atributo seja 'clientes'
        return "listagem";
    }
    

    // Página de atualização de um cliente
    @GetMapping("/atualizar/{id}")
    public String atualizar(Model model, @PathVariable int id) {
        ClienteService cs = context.getBean(ClienteService.class);
        Cliente cli = cs.obterCliente(id);
        model.addAttribute("id", id);
        model.addAttribute("cliente", cli);
        return "atualizar";
    }

    // Atualiza um cliente
    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Cliente cli) {
        ClienteService cs = context.getBean(ClienteService.class);
        cs.atualizarCliente(id, cli);
        return "redirect:/listagem"; // Redireciona após a atualização
    }

    // Deleta um cliente
    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        ClienteService cs = context.getBean(ClienteService.class);
        cs.deletarCliente(id);
        return "redirect:/listagem"; // Redireciona após a exclusão
    }
}