package br.com.fiap.bo;

import br.com.fiap.dao.AgendamentoDAO;
import br.com.fiap.dao.ChamadoDAO;
import br.com.fiap.to.AgendametoTO;
import br.com.fiap.to.ChamadoTO;

import java.util.ArrayList;

public class AgendamentoBO {
    public AgendamentoDAO agendamentoDAO;

    public ArrayList<AgendametoTO> findAll(){
        agendamentoDAO = new AgendamentoDAO();
        //regras de negocio
        return agendamentoDAO.findAll();
    }

    public AgendametoTO findByCodigo(Long id_agendamento){
        agendamentoDAO = new AgendamentoDAO();
        //regras de negocio
        return agendamentoDAO.findByCodigo(id_agendamento);
    }

    public AgendametoTO save(AgendametoTO agenda){
        agendamentoDAO = new AgendamentoDAO();
        //regras de negocio
        return agendamentoDAO.save(agenda);
    }

    public AgendametoTO update(AgendametoTO agenda){
        agendamentoDAO = new AgendamentoDAO();
        //regras de negocio
        return agendamentoDAO.update(agenda);
    }

    public Boolean delete(Long id_agendamento){
        agendamentoDAO = new AgendamentoDAO();
        //regras de negocio
        return agendamentoDAO.delete(id_agendamento);
    }
}
