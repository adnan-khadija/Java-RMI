/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import dao.IDao;
import dao.MachineIDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;

/**
 *
 * @author lenovo
 */
public class Serveur {
    public static void main(String[] args) {
        try {
            MachineIDao dao1 = new MachineService();
            IDao<Salle> dao2 = new SalleService();
            LocateRegistry.createRegistry(1091);
            Naming.bind("rmi://localhost:1091/dao1", dao1); 
            Naming.bind("rmi://localhost:1091/dao2", dao2); 
            
            System.out.println("Serveur En attente");
        } catch (RemoteException ex) {
            System.out.println("Erreur 1:" + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Erreur 2:" + ex.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println("Erreur 3:" + ex.getMessage());
        }
    }
}
