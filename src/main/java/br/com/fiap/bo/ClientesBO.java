package br.com.fiap.bo;

import br.com.fiap.dao.ClientesDAO;
import br.com.fiap.to.ClientesTO;

import java.util.ArrayList;

public class ClientesBO {
    public ClientesDAO clientesDAO;

    public ArrayList<ClientesTO> findAll(){
        clientesDAO = new ClientesDAO();
        return clientesDAO.findAll();
    }

    public ClientesTO findByCodigo(String cpf){
        clientesDAO = new ClientesDAO();
        return clientesDAO.findByCodigo(cpf);
    }

    public ClientesTO save(ClientesTO cliente){
        clientesDAO = new ClientesDAO();

        //valida se o cpf do cliente possui 11 digitos
        if (cliente.getCpf() == null || cliente.getCpf().length() != 11) {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            return null;
        }

        //valida se o email é do formato aaaa@aa.com
        if (cliente.getEmail() == null || !cliente.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
            System.out.println("Formato de email inválido.");
            return null;
        }

        //valida se o telefone possui no minimo 10 digitcos com ddd (telefone fixo ou celular)
        if (cliente.getTelefone() == null || String.valueOf(cliente.getTelefone()).length() < 10) {
            System.out.println("Formato de telefone inválido, deve conter pelo menos 10 dígitos com DDD.");
            return null;
        }
        return clientesDAO.save(cliente);
    }

    public ClientesTO update(ClientesTO cliente){
        //valida se o cpf do cliente possui 11 digitos
        if (cliente.getCpf() == null || cliente.getCpf().length() != 11) {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            return null;
        }

        //valida se o email é do formato aaaa@aa.com
        if (cliente.getEmail() == null || !cliente.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
            System.out.println("Formato de email inválido.");
            return null;
        }

        //valida se o telefone possui no minimo 10 digitcos com ddd (telefone fixo ou celular)
        if (cliente.getTelefone() == null || String.valueOf(cliente.getTelefone()).length() < 10) {
            System.out.println("Formato de telefone inválido, deve conter pelo menos 10 dígitos com DDD.");
            return null;
        }
        return clientesDAO.update(cliente);
    }

    public Boolean delete(String cpf){
        clientesDAO = new ClientesDAO();
        //regras de negocio
        return clientesDAO.delete(cpf);
    }


}
