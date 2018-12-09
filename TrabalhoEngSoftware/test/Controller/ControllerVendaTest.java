/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelProduto;
import java.util.LinkedList;
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
public class ControllerVendaTest {
    
    public ControllerVendaTest() {
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
     * Test of buscaListaProdutos method, of class ControllerVenda.
     */
    @Test
    public void testBuscaListaProdutos() {
        System.out.println("buscaListaProdutos");
        ControllerVenda instance = new ControllerVenda();
        LinkedList<ModelProduto> expResult = instance.buscaListaProdutos();
        LinkedList<ModelProduto> result = instance.buscaListaProdutos();
        assertEquals(expResult.get(0).getEstoque(), result.get(0).getEstoque());
    }

    /**
     * Test of calculaTotal method, of class ControllerVenda.
     */
    @Test
    public void testCalculaTotal() {
        System.out.println("calculaTotal");
        LinkedList<ModelProduto> pProdutos = null;
        ControllerVenda instance = new ControllerVenda();
        float expResult = 0.0F;
        float result = instance.calculaTotal(pProdutos);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of realizaVenda method, of class ControllerVenda.
     */
    @Test
    public void testRealizaVenda() {
        System.out.println("realizaVenda");
        LinkedList<ModelProduto> listaVendas = null;
        ControllerVenda instance = new ControllerVenda();
        boolean expResult = false;
        boolean result = instance.realizaVenda(listaVendas);
        assertEquals(expResult, result);
    }
    
}
