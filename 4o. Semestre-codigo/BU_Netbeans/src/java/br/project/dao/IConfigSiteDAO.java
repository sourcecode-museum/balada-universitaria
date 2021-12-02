/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.project.dao;

import br.project.transferobject.ConfigSiteTO;
import java.util.ArrayList;
/**
 *
 * @author Heliomar
 */
public interface IConfigSiteDAO {
    public void update(ConfigSiteTO to) throws DAOException;
    public ArrayList buscarTodos() throws DAOException;
}
