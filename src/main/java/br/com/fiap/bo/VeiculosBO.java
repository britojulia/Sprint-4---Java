package br.com.fiap.bo;


import br.com.fiap.dao.VeiculosDAO;
import br.com.fiap.to.VeiculosTO;

import java.util.ArrayList;

public class VeiculosBO {
    public VeiculosDAO veiculosDAO;

    public ArrayList<VeiculosTO> findAll(){
        veiculosDAO = new VeiculosDAO();
        //regras de negocio
        return veiculosDAO.findAll();
    }

    public VeiculosTO findByCodigo(String placa){
        veiculosDAO = new VeiculosDAO();
        //regras de negocio
        return veiculosDAO.findByCodigo(placa);
    }

    public VeiculosTO save(VeiculosTO veiculo){
        veiculosDAO = new VeiculosDAO();
        //regras de negocio
        return veiculosDAO.save(veiculo);
    }

    public VeiculosTO update(VeiculosTO veiculo){
        veiculosDAO = new VeiculosDAO();
        //regras de negocio
        return veiculosDAO.update(veiculo);
    }

    public Boolean delete(String placa){
        veiculosDAO = new VeiculosDAO();
        //regras de negocio
        return veiculosDAO.delete(placa);
    }
}
