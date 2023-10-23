/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrmi;

import dao.IDao;
import dao.MachineIDao;
import entities.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class ClientRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MachineIDao dao1=  (MachineIDao) Naming.lookup("rmi://localhost:1091/dao1");
            IDao<Salle> dao2= (IDao<Salle>) Naming.lookup("rmi://localhost:1091/dao2");

           /* dao2.create(new Salle("Salle3"));
            dao2.create(new Salle("Salle4"));
            dao1.create(new Machine("SE", "Acer", 4000,dao2.findById(3)));
            dao1.create(new Machine("GRD", "Lenovo", 5500,dao2.findById(4)));
       */ for (Machine m: dao1.findAll()){
            System.out.println(m);
        }
       for(Machine m: dao1.findBySalle(dao2.findById(1))){
           System.out.println(m);
           
       }

        } catch (RemoteException ex) {
            System.out.println("Erreur1 :"+ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println("Erreur2 :"+ex.getMessage());     
        } catch (MalformedURLException ex) {
         System.out.println("Erreur3 :"+ex.getMessage());    
        }
        
    }
    
}
