/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera.domain;

/**
 *
 * @author dunkelheit
 */
public class Usuario {
    
    private String login;
    private String nome;
    private String email;
    private String senha;
    private Integer pontos;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", pontos=" + pontos + '}';
    }

}
