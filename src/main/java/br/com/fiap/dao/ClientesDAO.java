package br.com.fiap.dao;

import br.com.fiap.to.ClientesTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDAO extends Repository{
    public ArrayList<ClientesTO> findAll(){
        ArrayList<ClientesTO> clientes = new ArrayList<ClientesTO>();
        String sql = "select * from clientes order by cpf";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    ClientesTO cliente = new ClientesTO();
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
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

    public ClientesTO findByCodigo(String cpf){
        ClientesTO cliente = new ClientesTO();
        String sql = "select * from clientes where cpf = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
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

    public ClientesTO save (ClientesTO cliente){
        String sql = "insert into clientes (cpf, nome, telefone, email, senha) values(?, ?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
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

    public boolean delete(String cpf){
        String sql = "delete from clientes where cpf = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cpf);
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Erro ao excluir " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ClientesTO update(ClientesTO cliente){
        String sql = "update clientes set nome=?, telefone=?, email=?, senha=? where cpf=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cliente.getNome());
            ps.setLong(2, cliente.getTelefone());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getSenha());
            ps.setString(5, cliente.getCpf());
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
