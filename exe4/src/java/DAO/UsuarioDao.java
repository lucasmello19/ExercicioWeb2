/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;

/**
 *
 * @author LucasMello
 */
public class UsuarioDao {
    public boolean carregarPessoas(String login, String senha) {
        Connection connection = new ConnectionFactory().getConexaoMySQL();
        PreparedStatement stmt = null;
        ResultSet rs = null;  
        try { 
            
            stmt = connection.prepareStatement("SELECT login_usuario, senha_usuario\n" +
"	FROM tb_usuario where login_usuario = ? and senha_usuario = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
            

        } catch (SQLException exception) {
                    throw new RuntimeException("Erro. Origem="+exception.getMessage());
            } finally {
                if (rs != null)
                    try { rs.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar rs. Ex="+exception.getMessage()); }
                if (stmt != null)
                    try { stmt.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar stmt. Ex="+exception.getMessage()); }
                if (connection != null)
                    try { connection.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar conexão. Ex="+exception.getMessage()); }
                }
    }

    public List<Usuario> carregarUsuarios() {
        Connection connection = new ConnectionFactory().getConexaoMySQL();
        PreparedStatement stmt = null;
        ResultSet rs = null;  
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        try { 
            stmt = connection.prepareStatement("SELECT id_usuario, login_usuario, senha_usuario, nome_usuario\n" +
"	FROM tb_usuario");
            rs = stmt.executeQuery();
            

            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setLogin(rs.getString("login_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));

                usuarios.add(usuario);
            }

        } catch (SQLException exception) {
                    throw new RuntimeException("Erro. Origem="+exception.getMessage());
            } finally {
                if (rs != null)
                    try { rs.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar rs. Ex="+exception.getMessage()); }
                if (stmt != null)
                    try { stmt.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar stmt. Ex="+exception.getMessage()); }
                if (connection != null)
                    try { connection.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar conexão. Ex="+exception.getMessage()); }
                }
        return usuarios;
    }
    
    
    public Usuario carregarUsuario(String login, String senha) {
        
        Connection connection = new ConnectionFactory().getConexaoMySQL();
        PreparedStatement stmt = null;
        ResultSet rs = null;  
        Usuario usuario = new Usuario();
        
        try { 
            stmt = connection.prepareStatement("SELECT id_usuario, login_usuario, senha_usuario, nome_usuario\n" +
"	FROM tb_usuario where login_usuario = ? and senha_usuario = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            

            if (rs.next()){
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setLogin(rs.getString("login_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));

            }

        } catch (SQLException exception) {
                    throw new RuntimeException("Erro. Origem="+exception.getMessage());
            } finally {
                if (rs != null)
                    try { rs.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar rs. Ex="+exception.getMessage()); }
                if (stmt != null)
                    try { stmt.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar stmt. Ex="+exception.getMessage()); }
                if (connection != null)
                    try { connection.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar conexão. Ex="+exception.getMessage()); }
                }
        return usuario;
    }
    
    
    public boolean cadastrarUsuario(String login, String senha, String nome) {
        Connection connection = new ConnectionFactory().getConexaoMySQL();
        PreparedStatement stmt = null;
        ResultSet rs = null;  
        try { 
            
            stmt = connection.prepareStatement("INSERT INTO tb_usuario(login_usuario, senha_usuario, nome_usuario) VALUES (?, ?, ?)");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.setString(3, nome);
            stmt.executeUpdate();
            
            if (stmt != null) {
                return true;
            } else {
                return false;
            }
            

        } catch (SQLException exception) {
                    throw new RuntimeException("Erro. Origem="+exception.getMessage());
            } finally {
                if (rs != null)
                    try { rs.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar rs. Ex="+exception.getMessage()); }
                if (stmt != null)
                    try { stmt.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar stmt. Ex="+exception.getMessage()); }
                if (connection != null)
                    try { connection.close(); }
                    catch (SQLException exception) { System.out.println("Erro ao fechar conexão. Ex="+exception.getMessage()); }
                }
    }
}
