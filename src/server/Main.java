/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.ui.HalamanUtama;
import server.utils.CRUD;

/**
 *
 * @author 62853
 */
public class Main {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(8989);
            CRUD crud = new CRUD();
            registry.rebind("rmiServer", crud);
            System.out.println("Server RMI Jalan");
            new HalamanUtama().setVisible(true);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
