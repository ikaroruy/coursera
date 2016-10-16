/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera.dao;

import coursera.domain.Usuario;
import java.util.List;

/**
 *
 * @author dunkelheit
 */
public interface UsuarioDAO {
    
     //insere um novo usuário no banco de dados
   public void inserir(Usuario u);
   
   //recupera o usuário pelo seu login
   public Usuario recuperar(String login);
   
   //adiciona os pontos para o usuário no banco
   public void adicionarPontos(String login, int pontos);
   
   //retorna a lista de usuários ordenada por pontos (maior primeiro)
   public List<Usuario> ranking();
    
}
