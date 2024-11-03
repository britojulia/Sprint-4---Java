package br.com.fiap.bo;

import br.com.fiap.dao.ClientesDAO;
import br.com.fiap.to.ClientesTO;

import java.util.ArrayList;

public class ClientesBO {
    public ClientesDAO clientesDAO;

    public ArrayList<ClientesTO> findAll(){
        clientesDAO = new ClientesDAO();
        //regras de negocio
        return clientesDAO.findAll();
    }

    public ClientesTO findByCodigo(String cpf){
        clientesDAO = new ClientesDAO();
        //regras de negocio
        return clientesDAO.findByCodigo(cpf);
    }

    public ClientesTO save(ClientesTO cliente){
        clientesDAO = new ClientesDAO();
        //regras de negocio
        return clientesDAO.save(cliente);
    }

    public ClientesTO update(ClientesTO cliente){
        clientesDAO = new ClientesDAO();
        //regras de negocio
        return clientesDAO.update(cliente);
    }

    public Boolean delete(String cpf){
        clientesDAO = new ClientesDAO();
        //regras de negocio
        return clientesDAO.delete(cpf);
    }

}
