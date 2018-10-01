/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOProduto;
import Model.ModelProduto;

/**
 *
 * @author Marcos
 */
public class ControllerProduto {

    DAOProduto daoProduto = new DAOProduto();

    public int buscaUltimoCodController(String pTabela, String campo) {
        return daoProduto.buscaUltimoCodDAO(pTabela, campo);
    }

    public int registraProdutoController(ModelProduto pModelProduto) {
        return daoProduto.registraProdutoDAO(pModelProduto);
    }

}
