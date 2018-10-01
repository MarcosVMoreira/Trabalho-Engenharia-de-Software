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
    
        public boolean getUsuarioDAO(ModelUsuario pModelUsuario){       
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM usuarios"
                    + " WHERE usu_login = '" + pModelUsuario.getLogin()+ "' AND usu_senha = '" + pModelUsuario.getSenha() + "' "
                    + ";"
            );

            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }      
    }
}
