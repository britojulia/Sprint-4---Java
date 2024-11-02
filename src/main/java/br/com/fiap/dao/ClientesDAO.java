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

    public ClientesTO save (ClientesTO  cliente){
        String sql = "insert into clientes (nome, cpf, telefone, email, senha) values(?, ?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setLong(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getSenha());
            if (ps.executeUpdate() > 0){
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao salvar" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id_cliente{
        String sql = "delete from clientes where id_cliente = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_cliente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Erro ao excluir " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ClientesTO update(ClientesTO cliente){
        String sql = "update clientes set nome=?, cpf=?, telefone=?, email=?, senha=? where id_cliente=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setLong(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getSenha());
            ps.setLong(6, cliente.getId_cliente());
            if (ps.executeUpdate() > 0){
                return cliente;
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
