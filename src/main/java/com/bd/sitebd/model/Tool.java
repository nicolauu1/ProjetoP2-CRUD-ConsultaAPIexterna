package com.bd.sitebd.model;

import java.util.Map;

public class Tool {
    public static Cliente converterCliente(Map<String, Object> registro) {
        return new Cliente(
            (Integer) registro.get("id"), 
            (String) registro.get("nome"), 
            (String) registro.get("cpf"),
            (String) registro.get("nomeProduto"),
            (String) registro.get("codigoProduto"),
            (String) registro.get("tamanho"),
            (String) registro.get("cor"),
            (String) registro.get("endereco"),  // Novo campo
            (String) registro.get("bairro"),    // Novo campo
            (String) registro.get("cidade"),    // Novo campo
            (String) registro.get("estado"),     // Novo campo
            (String) registro.get("cep") 
        );
    }
}