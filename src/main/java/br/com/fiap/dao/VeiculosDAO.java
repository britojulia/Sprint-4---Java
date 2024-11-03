package br.com.fiap.dao;


import br.com.fiap.to.VeiculosTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculosDAO extends Repository{
    public ArrayList<VeiculosTO> findAll(){
        ArrayList<VeiculosTO> veiculos = new ArrayList<VeiculosTO>();
        String sql = "select placa, modelo, cor, marca, cpf_cliente from veiculos order by placa";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    VeiculosTO veiculo = new VeiculosTO();
                    veiculo.setPlaca(rs.getString("placa"));
                    veiculo.setModelo(rs.getString("modelo"));
                    veiculo.setCor(rs.getString("cor"));
                    veiculo.setMarca(rs.getString("marca"));
                    veiculo.setCpf(rs.getString("cpf_cliente"));
                    veiculos.add(veiculo);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculos;
    }

    public VeiculosTO findByCodigo(String placa) {
        VeiculosTO veiculo = new VeiculosTO();
        String sql = "select placa, modelo, cor, marca, cpf_cliente from veiculos where placa = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                veiculo = new VeiculosTO();
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setCpf(rs.getString("cpf_cliente"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculo;
    }

    public VeiculosTO save(VeiculosTO veiculo) {
        String sql = "insert into veiculos (placa, modelo, cor, marca, cpf_cliente) values(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getModelo());
            ps.setString(3, veiculo.getCor());
            ps.setString(4, veiculo.getMarca());
            ps.setString(5, veiculo.getCpf());

            if (ps.executeUpdate() > 0) {
                return veiculo;
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

    public boolean delete(String placa){
        String sql = "delete from veiculos where placa = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, placa);
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Erro ao excluir " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public VeiculosTO update(VeiculosTO veiculo){
        String sql = "update veiculos set modelo=?, cor=?, marca=? where placa=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, veiculo.getModelo());
            ps.setString(2, veiculo.getCor());
            ps.setString(3, veiculo.getMarca());
            if (ps.executeUpdate() > 0){
                return veiculo;
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
