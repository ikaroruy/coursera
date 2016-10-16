/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import coursera.dao.impl.UsuarioDAOImpl;
import coursera.domain.Usuario;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author dunkelheit
 */
public class TesteUsuarioDAO {
    
    JdbcDatabaseTester jdt;
    UsuarioDAOImpl usuarioDAOImpl;
    
    @Before
    public void setUp() throws Exception {
        
        usuarioDAOImpl = new UsuarioDAOImpl();
        jdt = new JdbcDatabaseTester("org.postgresql.Driver","jdbc:postgresql://localhost/coursera", "postgres", "admin");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/dados.xml"));
        jdt.onSetup();
    }
            
   
   @Test
   public void inserirTest() throws Exception {
       Usuario u = new Usuario();
       u.setLogin("maria");
       u.setNome("Maria Tereza");
       u.setEmail("mt@gmail.com");
       u.setSenha("maria");
       u.setPontos(1);
        
       usuarioDAOImpl.inserir(u);
       
       IDataSet currentDataset = jdt.getConnection().createDataSet();
       ITable currentTable = currentDataset.getTable("USUARIO");
       FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
       IDataSet expectedDataSet = loader.load("/verifica.xml");
       ITable expectedTable = expectedDataSet.getTable("USUARIO");
       Assertion.assertEquals(expectedTable, currentTable);
   }
   
   
   @Test
   public void recuperarTest() {
       Usuario u = usuarioDAOImpl.recuperar("duda");
       assertEquals("duda@gmail.com", u.getEmail()); 
   }
   
   @Test
   public void adicionarPontosTest() {
       usuarioDAOImpl.adicionarPontos("joao", 1);
       Usuario u = usuarioDAOImpl.recuperar("joao");
       assertEquals("3", u.getPontos().toString()); 
   }
   
    
   @Test
   public void rankingTest() {
       List<Usuario> lista = usuarioDAOImpl.ranking();
       assertEquals(2, lista.size());
       assertEquals("joao", lista.get(0).getLogin());
   }
    
}
