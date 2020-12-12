/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import server.models.ModelInformasi;
import server.models.ModelJadwalKuliah;
import server.models.ModelUser;

/**
 *
 * @author 62853
 */
public interface RMIMethod extends Remote{
    public List<ModelInformasi> getDataInformasi() throws RemoteException;
    public boolean insertDataInformasi(ModelInformasi MI) throws RemoteException;
    public boolean updateDataInformasi(ModelInformasi MI) throws RemoteException;
    public boolean deleteDataInformasi(int id) throws RemoteException;
    
    public List<ModelJadwalKuliah> getDataJadwalKuliah() throws RemoteException;
    public boolean insertDataJadwalKuliah(ModelJadwalKuliah MJK) throws RemoteException;
    public boolean updateDataJadwalKuliah(ModelJadwalKuliah MJK) throws RemoteException;
    public boolean deleteDataJadwalKuliah(int id) throws RemoteException;
    
    public boolean checkUser(String username, String password) throws RemoteException;
    public List<ModelUser> getDataUser() throws RemoteException;
    public boolean insertDataUser(ModelUser MU) throws RemoteException;
    public boolean updateDataUser(ModelUser MU) throws RemoteException;
    public boolean deleteDataUser(int id) throws RemoteException;
}
