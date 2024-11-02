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

}
