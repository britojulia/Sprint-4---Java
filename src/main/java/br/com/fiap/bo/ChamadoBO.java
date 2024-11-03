package br.com.fiap.bo;

import br.com.fiap.dao.ChamadoDAO;

import br.com.fiap.to.ChamadoTO;


import java.util.ArrayList;

public class ChamadoBO {
    public ChamadoDAO chamadoDAO;

    public ArrayList<ChamadoTO> findAll(){
        chamadoDAO = new ChamadoDAO();
        return chamadoDAO.findAll();
    }

    public ChamadoTO findByCodigo(Long id_chamado){
        chamadoDAO = new ChamadoDAO();
        return chamadoDAO.findByCodigo(id_chamado);
    }

    public ChamadoTO save(ChamadoTO chamado){
        chamadoDAO = new ChamadoDAO();
        //valida se a descricao pro chamado é valida, e nao apenas uma letra
        if (chamado.getDescricao() == null || chamado.getDescricao().length() < 5) {
            System.out.println("Descrição muito curta, precisamos de mais informações.");
            return null;
        }
        //valida se o tipo de serviço pro chamado é valido, e nao apenas uma letra
        if (chamado.getTipo_servico() == null || chamado.getTipo_servico().length() < 5) {
            System.out.println("O tipo de serviço é muito curto, precisamos de mais informações.");
            return null;
        }
        return chamadoDAO.save(chamado);
    }

    public ChamadoTO update(ChamadoTO chamado){
        chamadoDAO = new ChamadoDAO();
        //valida se a descricao pro chamado é valida, e nao apenas uma letra
        if (chamado.getDescricao() == null || chamado.getDescricao().length() < 5) {
            System.out.println("Descrição muito curta, precisamos de mais informações.");
            return null;
        }
        //valida se o tipo de serviço pro chamado é valido, e nao apenas uma letra
        if (chamado.getTipo_servico() == null || chamado.getTipo_servico().length() < 5) {
            System.out.println("O tipo de serviço é muito curto, precisamos de mais informações.");
            return null;
        }
        return chamadoDAO.update(chamado);
    }

    public Boolean delete(Long id_chamado){
        chamadoDAO = new ChamadoDAO();
        return chamadoDAO.delete(id_chamado);
    }
}
