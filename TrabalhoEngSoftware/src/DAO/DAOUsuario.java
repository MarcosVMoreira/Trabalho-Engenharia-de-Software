/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexoes.ConnectionFactory;
import Model.ModelUsuario;

/**
 *
 * @author Marcos
 */
public class DAOUsuario extends ConnectionFactory {

    public int registraUsuarioDAO(ModelUsuario modelUsuario) {

        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO usuarios ("
                    + "usu_nome,"
                    + "usu_perfil,"
                    + "usu_login,"
                    + "usu_senha"
                    + ") VALUES ("
                    + "'" + modelUsuario.getNome() + "',"
                    + "'" + modelUsuario.getPerfil() + "',"
                    + "'" + modelUsuario.getLogin() + "',"
                    + "'" + modelUsuario.getSenha() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public int buscaUltimoCodDAO(String tabela) {
        try {
            this.conectar();
            return this.lastID(tabela);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
}
