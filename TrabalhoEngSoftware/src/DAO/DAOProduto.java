/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexoes.ConnectionFactory;
import Model.ModelProduto;

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
}
