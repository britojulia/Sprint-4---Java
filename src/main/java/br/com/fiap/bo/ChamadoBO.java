package br.com.fiap.bo;

import br.com.fiap.dao.ChamadoDAO;
import br.com.fiap.dao.ClientesDAO;
import br.com.fiap.to.ChamadoTO;
import br.com.fiap.to.ClientesTO;

import java.util.ArrayList;

public class ChamadoBO {
    public ChamadoDAO chamadoDAO;

    public ArrayList<ChamadoTO> findAll(){
        chamadoDAO = new ChamadoDAO();
        //regras de negocio
        return chamadoDAO.findAll();
    }

    public ChamadoTO findByCodigo(Long id_chamado){
        chamadoDAO = new ChamadoDAO();
        //regras de negocio
        return chamadoDAO.findByCodigo(id_chamado);
    }

    public ChamadoTO save(ChamadoTO chamado){
        chamadoDAO = new ChamadoDAO();
        //regras de negocio
        return chamadoDAO.save(chamado);
    }

    public ChamadoTO update(ChamadoTO chamado){
        chamadoDAO = new ChamadoDAO();
        //regras de negocio
        return chamadoDAO.update(chamado);
    }

    public Boolean delete(Long id_chamado){
        chamadoDAO = new ChamadoDAO();
        //regras de negocio
        return chamadoDAO.delete(id_chamado);
    }
}
