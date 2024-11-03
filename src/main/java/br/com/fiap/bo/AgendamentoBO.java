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
        return agendamentoDAO.findAll();
    }

    public AgendametoTO findByCodigo(Long id_agendamento){
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.findByCodigo(id_agendamento);
    }

    public AgendametoTO save(AgendametoTO agenda){
        agendamentoDAO = new AgendamentoDAO();
        //valida se o tipo de serviço pro chamado é valido, e nao apenas uma letra
        if (agenda.getTipo_servico() == null || agenda.getTipo_servico().length() < 5) {
            System.out.println("O tipo de serviço é muito curto, precisamos de mais informações.");
            return null;
        }
        return agendamentoDAO.save(agenda);
    }

    public AgendametoTO update(AgendametoTO agenda){
        agendamentoDAO = new AgendamentoDAO();
        //valida se o tipo de serviço pro chamado é valido, e nao apenas uma letra
        if (agenda.getTipo_servico() == null || agenda.getTipo_servico().length() < 5) {
            System.out.println("O tipo de serviço é muito curto, precisamos de mais informações.");
            return null;
        }
        return agendamentoDAO.update(agenda);
    }

    public Boolean delete(Long id_agendamento){
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.delete(id_agendamento);
    }
}
