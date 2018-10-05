/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOProduto;
import Model.ModelProduto;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos
 */
public class ControllerVenda {

    DAOProduto daoProduto = new DAOProduto();

    public LinkedList<ModelProduto> buscaListaProdutos() {
        return daoProduto.getListaProdutoDAO();
    }

}
