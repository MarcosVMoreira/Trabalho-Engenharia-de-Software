/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOUsuario;
import Model.ModelUsuario;

/**
 *
 * @author Marcos
 */
public class ControllerUsuario {

    DAOUsuario daoUsuario = new DAOUsuario();

    public int registraUsuarioController(ModelUsuario modelUsuario) {
        return daoUsuario.registraUsuarioDAO(modelUsuario);
    }

}
