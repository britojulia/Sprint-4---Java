package br.com.fiap.dao;

import br.com.fiap.to.ChamadoTO;
import br.com.fiap.to.VeiculosTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChamadoDAO extends Repository{

    public ArrayList<ChamadoTO> findAll(){
        ArrayList<ChamadoTO> chamados = new ArrayList<ChamadoTO>();
        String sql = "select id_chamado, descricao, tipo_servico, data_chamado, clientes_cpf from chamado order by id_chamado";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    ChamadoTO chamado = new ChamadoTO();
                    chamado.setId_chamado(rs.getLong("id_chamado"));
                    chamado.setDescricao(rs.getString("descricao"));
                    chamado.setTipo_servico(rs.getString("tipo_servico"));
                    chamado.setData_chamado(rs.getDate("data_chamado").toLocalDate());
                    chamado.setCpf(rs.getString("clientes_cpf"));
                    chamados.add(chamado);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return chamados;
    }

    public ChamadoTO findByCodigo(Long id_chamado) {
        ChamadoTO chamado = new ChamadoTO();
        String sql = "select id_chamado, descricao, tipo_servico, data_chamado, clientes_cpf from chamado where id_chamado = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_chamado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                chamado.setId_chamado(rs.getLong("id_chamado"));
                chamado.setDescricao(rs.getString("descricao"));
                chamado.setTipo_servico(rs.getString("tipo_servico"));
                chamado.setData_chamado(rs.getDate("data_chamado").toLocalDate());
                chamado.setCpf(rs.getString("clientes_cpf"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return chamado;
    }

    public ChamadoTO save(ChamadoTO chamado) {
        String sql = "insert into chamado (descricao, tipo_servico, data_chamado, clientes_cpf) values( ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, chamado.getDescricao());
            ps.setString(2, chamado.getTipo_servico());
            ps.setDate(3, Date.valueOf(chamado.getData_chamado()));
            ps.setString(4, chamado.getCpf());
            if (ps.executeUpdate() > 0) {
                return chamado;
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

    public boolean delete(Long id_chamado){
        String sql = "delete from chamado where id_chamado = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_chamado);
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Erro ao excluir " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ChamadoTO update(ChamadoTO chamado){
        String sql = "update chamado set descricao=?, tipo_servico=?, data_chamado=?, clientes_cpf=? where id_chamado=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, chamado.getDescricao());
            ps.setString(2, chamado.getTipo_servico());
            ps.setDate(3, Date.valueOf(chamado.getData_chamado()));
            ps.setString(4, chamado.getCpf());
            ps.setLong(5, chamado.getId_chamado());
            if (ps.executeUpdate() > 0){
                return chamado;
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
