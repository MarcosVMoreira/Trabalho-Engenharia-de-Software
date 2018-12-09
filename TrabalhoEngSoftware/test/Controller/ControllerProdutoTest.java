/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelProduto;
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
public class ControllerProdutoTest {

    public ControllerProdutoTest() {
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
     * Test of buscaUltimoCodController method, of class ControllerProduto.
     */
    @Test
    public void testBuscaUltimoCodController() {
        System.out.println("buscaUltimoCodController");
        String pTabela = "produtostest";
        String campo = "prod_cod";
        ControllerProduto instance = new ControllerProduto();
        int expResult = 1;
        int result = instance.buscaUltimoCodController(pTabela, campo);
        System.out.println("O valor printado é " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of registraProdutoController method, of class ControllerProduto.
     */
    @Test
    public void testRegistraProdutoController() {
        System.out.println("registraProdutoController");
        ModelProduto pModelProduto = null;
        ControllerProduto instance = new ControllerProduto();
        int expResult = 0;
        int result = instance.registraProdutoController(pModelProduto);
        assertEquals(expResult, instance.registraProdutoController(pModelProduto));
    }

}
