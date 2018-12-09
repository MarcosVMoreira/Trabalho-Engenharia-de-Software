/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelUsuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos
 */
public class ControllerUsuarioTest {
    
    public ControllerUsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registraUsuarioController method, of class ControllerUsuario.
     */
    @Test
    public void testRegistraUsuarioController() {
        System.out.println("registraUsuarioController");
        ModelUsuario pModelUsuario = null;
        ControllerUsuario instance = new ControllerUsuario();
        int expResult = 0;
        int result = instance.registraUsuarioController(pModelUsuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscaUltimoCodController method, of class ControllerUsuario.
     */
    @Test
    public void testBuscaUltimoCodController() {
        System.out.println("buscaUltimoCodController");
        String pTabela = "";
        String campo = "";
        ControllerUsuario instance = new ControllerUsuario();
        int expResult = 0;
        int result = instance.buscaUltimoCodController(pTabela, campo);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsuarioController method, of class ControllerUsuario.
     */
    @Test
    public void testGetUsuarioController() {
        System.out.println("getUsuarioController");
        ModelUsuario pModelUsuario = null;
        ControllerUsuario instance = new ControllerUsuario();
        boolean expResult = false;
        boolean result = instance.getUsuarioController(pModelUsuario);
        assertEquals(expResult, result);
    }
    
}
