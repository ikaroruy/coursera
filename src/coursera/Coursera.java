/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera;

import coursera.dao.impl.UsuarioDAOImpl;
import coursera.domain.Usuario;

/**
 *
 * @author dunkelheit
 */
public class Coursera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
            
        UsuarioDAOImpl userDAOImpl = new UsuarioDAOImpl();
        
        
        Usuario usuario = userDAOImpl.recuperar("duda");
        
        System.out.println(usuario.getNome() + " " + usuario.getEmail());
        
    }
    
}
