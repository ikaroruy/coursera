/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera.dao.impl;

import coursera.dao.UsuarioDAO;
import coursera.domain.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dunkelheit
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void inserir(Usuario u) {

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/coursera", "postgres", "admin")) {

            String sql = "INSERT INTO usuario(login, nome, email, senha, pontos) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, u.getLogin());
            stm.setString(2, u.getNome());
            stm.setString(3, u.getEmail());
            stm.setString(4, u.getSenha());
            stm.setInt(5, u.getPontos());
            stm.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível executar o acesso", e);

        }

    }

    @Override
    public Usuario recuperar(String login) {
       
        Usuario u = new Usuario();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/coursera", "postgres", "admin")) {

            String sql = "SELECT * FROM usuario WHERE login = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setPontos(rs.getInt("pontos"));
            }

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível executar o acesso", e);
        }
        return u;
    }

    @Override
    public void adicionarPontos(String login, int pontos) {

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/coursera", "postgres", "admin")) {
                
            String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, pontos);
            stm.setString(2, login);
            stm.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível executar o acesso", e);

        }
    }

    @Override
    public List<Usuario> ranking() {

        List<Usuario> usuariosList = new ArrayList<>();

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/coursera", "postgres", "admin")) {

            String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setNome("nome");
                u.setEmail("email");
                u.setSenha("senha");
                u.setPontos(Integer.SIZE);
                usuariosList.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível executar o acesso", e);

        }

        return usuariosList;

    }

}
