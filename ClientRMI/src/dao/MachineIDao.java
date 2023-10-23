/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface MachineIDao extends IDao<Machine>{

     List<Machine> findBySalle (Salle salle)throws RemoteException;
}
