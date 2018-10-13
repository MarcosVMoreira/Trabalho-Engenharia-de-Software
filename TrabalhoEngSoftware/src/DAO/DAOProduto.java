/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexoes.ConnectionFactory;
import Model.ModelProduto;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class DAOProduto extends ConnectionFactory {

    public int buscaUltimoCodDAO(String tabela, String campo) {
        try {
            this.conectar();
            return this.lastID(tabela, campo);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public int registraProdutoDAO(ModelProduto modelProduto) {

        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO produtos ("
                    + "prod_nome,"
                    + "prod_preco,"
                    + "prod_estoque"
                    + ") VALUES ("
                    + "'" + modelProduto.getNome() + "',"
                    + "'" + modelProduto.getPreco() + "',"
                    + "'" + modelProduto.getEstoque() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public LinkedList<ModelProduto> getListaProdutoDAO() {
        LinkedList<ModelProduto> listaModelProduto = new LinkedList<>();

        try {
            this.conectar();
            String sql = "SELECT prod_cod, prod_nome, prod_preco, prod_estoque "
                    + "FROM produtos ORDER BY prod_cod;";
            this.executarSQL(sql);

            while (this.getResultSet().next()) {
                ModelProduto modelProduto = new ModelProduto();
                modelProduto.setCod(this.getResultSet().getInt(1));
                modelProduto.setNome(this.getResultSet().getString(2));
                modelProduto.setPreco(this.getResultSet().getFloat(3));
                modelProduto.setEstoque(this.getResultSet().getInt(4));
                listaModelProduto.add(modelProduto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Array getListaProdutoDAO" + e);
            e.printStackTrace();
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProduto;
    }

}
