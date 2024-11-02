package br.com.fiap.dao;

import br.com.fiap.to.ClientesTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDAO extends Repository{
    public ArrayList<ClientesTO> findAll(){
        ArrayList<ClientesTO> clientes = new ArrayList<ClientesTO>();
        String sql = "select * from clientes order by id_cliente";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    ClientesTO cliente = new ClientesTO();
                    cliente.setId_cliente(rs.getLong("id_cliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setTelefone(rs.getLong("telefone"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setSenha(rs.getString("senha"));
                    clientes.add(cliente);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }

    public ClientesTO findByCodigo(Long id_cliente){
        ClientesTO cliente = new ClientesTO();
        String sql = "select * from clientes where id_cliente = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_cliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                cliente.setId_cliente(rs.getLong("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getLong("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na contulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }

}
