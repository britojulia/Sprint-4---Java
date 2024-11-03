package br.com.fiap.bo;


import br.com.fiap.dao.VeiculosDAO;
import br.com.fiap.to.VeiculosTO;

import java.util.ArrayList;

public class VeiculosBO {
    public VeiculosDAO veiculosDAO;

    public ArrayList<VeiculosTO> findAll(){
        veiculosDAO = new VeiculosDAO();
        return veiculosDAO.findAll();
    }

    public VeiculosTO findByCodigo(String placa){
        veiculosDAO = new VeiculosDAO();
        return veiculosDAO.findByCodigo(placa);
    }

    public VeiculosTO save(VeiculosTO veiculo){
        veiculosDAO = new VeiculosDAO();
        //valida se a placa do carro é do formato brasileiro aaa1a11
        if (veiculo.getPlaca() == null || !veiculo.getPlaca().matches("[A-Z]{3}\\d[A-Z]\\d{2}")) {
            System.out.println("Placa inválida. A placa deve seguir o formato AAA1A11.");
            return null;
        }
        return veiculosDAO.save(veiculo);
    }

    public VeiculosTO update(VeiculosTO veiculo){
        veiculosDAO = new VeiculosDAO();
        //valida se a placa do carro é do formato brasileiro aaa1a11
        if (veiculo.getPlaca() == null || !veiculo.getPlaca().matches("[A-Z]{3}\\d[A-Z]\\d{2}")) {
            System.out.println("Placa inválida. A placa deve seguir o formato AAA1A11.");
            return null;
        }
        return veiculosDAO.save(veiculo);
    }

    public Boolean delete(String placa){
        veiculosDAO = new VeiculosDAO();
        return veiculosDAO.delete(placa);
    }

}
