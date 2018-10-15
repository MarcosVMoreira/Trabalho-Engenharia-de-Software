/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOProduto;
import Model.ModelProduto;
import java.util.LinkedList;
import java.util.Observable;
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

    public float calculaTotal(LinkedList<ModelProduto> pProdutos) {
        float total = 0;
        for (int i = 0; i < pProdutos.size(); i++) {
            total += pProdutos.get(i).getPreco() * pProdutos.get(i).getEstoque();
        }
        return total;
    }

    public boolean realizaVenda(LinkedList<ModelProduto> listaVendas) {
        LinkedList<ModelProduto> listaBanco;
        listaBanco = daoProduto.getListaProdutoDAO();

        try {
            for (int i = 0; i < listaBanco.size(); i++) {
                for (int j = 0; j < listaVendas.size(); j++) {
                    if (listaVendas.get(j).getCod() == listaBanco.get(i).getCod()) {
                        listaVendas.get(j).setEstoque(listaBanco.get(i).getEstoque() - listaVendas.get(j).getEstoque());
                    }
                }
            }

            for (int i = 0; i < listaVendas.size(); i++) {
                daoProduto.atualizarProdutosDAO(listaVendas.get(i));
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
