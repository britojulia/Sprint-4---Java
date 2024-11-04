package br.com.fiap.dao;

import br.com.fiap.to.AgendametoTO;
import br.com.fiap.to.ChamadoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgendamentoDAO extends Repository{

    public ArrayList<AgendametoTO> findAll(){
        ArrayList<AgendametoTO> agendas = new ArrayList<AgendametoTO>();
        String sql = "select id_agendamento, data_agendamento, tipo_servico, status, clientes_cpf, veiculos_placa from agendamento order by id_agendamento";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    AgendametoTO agenda = new AgendametoTO();
                    agenda.setId_agendamento(rs.getLong("id_agendamento"));
                    agenda.setData_agendamento(rs.getDate("data_agendamento").toLocalDate());
                    agenda.setTipo_servico(rs.getString("tipo_servico"));
                    agenda.setStatus(rs.getString("status"));
                    agenda.setCpf(rs.getString("clientes_cpf"));
                    agenda.setPlaca(rs.getString("veiculos_placa"));
                    agendas.add(agenda);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return agendas;
    }

    public AgendametoTO findByCodigo(Long id_agendamento) {
        AgendametoTO agenda = new AgendametoTO();
        String sql = "select id_agendamento, data_agendamento, tipo_servico, status, clientes_cpf, veiculos_placa from agendamento where id_agendamento = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_agendamento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                agenda = new AgendametoTO();
                agenda.setId_agendamento(rs.getLong("id_agendamento"));
                agenda.setData_agendamento(rs.getDate("data_agendamento").toLocalDate());
                agenda.setTipo_servico(rs.getString("tipo_servico"));
                agenda.setStatus(rs.getString("status"));
                agenda.setCpf(rs.getString("clientes_cpf"));
                agenda.setPlaca(rs.getString("veiculos_placa"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return agenda;
    }

    public AgendametoTO save(AgendametoTO agenda) {
        String sql = "insert into agendamento ( data_agendamento, tipo_servico, status, clientes_cpf, veiculos_placa) values(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(agenda.getData_agendamento()));
            ps.setString(2, agenda.getTipo_servico());
            ps.setString(3, agenda.getStatus());
            ps.setString(4, agenda.getCpf());
            ps.setString(5, agenda.getPlaca());
            if (ps.executeUpdate() > 0) {
                return agenda;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id_agendamento){
        String sql = "delete from agendamento where id_agendamento = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_agendamento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Erro ao excluir " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public AgendametoTO update(AgendametoTO agenda){
        String sql = "update agendamento set data_agendamento=?, tipo_servico=?, status=?, clientes_cpf=?, veiculos_placa=? where id_agendamento=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDate(1, Date.valueOf(agenda.getData_agendamento()));
            ps.setString(2, agenda.getTipo_servico());
            ps.setString(3, agenda.getStatus());
            ps.setString(4, agenda.getCpf());
            ps.setString(5, agenda.getPlaca());
            ps.setLong(6, agenda.getId_agendamento());
            if (ps.executeUpdate() > 0){
                return agenda;
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao atualizar " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

}
