/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.utils;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.interfaces.RMIMethod;
import server.models.ModelInformasi;
import server.models.ModelJadwalKuliah;
import server.models.ModelUser;

/**
 *
 * @author 62853
 */
public class CRUD extends UnicastRemoteObject implements RMIMethod{
    public CRUD() throws RemoteException {
        koneksi();
    }

    private Connection connection;
    private  void koneksi(){
        String DB = "jdbc:mysql://localhost/java_tugasakhir";
        String root = "root";
        String pass = "";

        try {
            connection = (Connection) DriverManager.getConnection(DB, root, pass);
            if (connection != null){
                System.out.println("Data Berhasil Konek");
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<ModelInformasi> getDataInformasi() throws RemoteException {
        List<ModelInformasi> data = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tb_informasi");
            while (resultSet.next()) {                
                data.add(new ModelInformasi(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    @Override
    public boolean insertDataInformasi(ModelInformasi MI) throws RemoteException {
        boolean status = false;
        String sql = "INSERT INTO tb_informasi (title, content) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MI.getTitle());
            preparedStatement.setString(2, MI.getContent());
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
        }
        return status;
    }
    

    @Override
    public boolean updateDataInformasi(ModelInformasi MI) throws RemoteException {
        boolean status = false;
        String sql = "UPDATE tb_informasi SET title = ?, content = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MI.getTitle());
            preparedStatement.setString(2, MI.getContent());
            preparedStatement.setInt(3, MI.getId());
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public boolean deleteDataInformasi(int id) throws RemoteException {
        boolean status = false;
        String sql = "DELETE FROM tb_informasi WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public List<ModelJadwalKuliah> getDataJadwalKuliah() throws RemoteException {
        List<ModelJadwalKuliah> data = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tb_jadwalkuliah");
            while (resultSet.next()) {
                data.add(new ModelJadwalKuliah(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    @Override
    public boolean insertDataJadwalKuliah(ModelJadwalKuliah MJK) throws RemoteException {
        boolean status = false;
        String sql = "INSERT INTO tb_jadwalkuliah (nama, jam, hari, kelas, semester) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MJK.getNama());
            preparedStatement.setString(2, MJK.getJam());
            preparedStatement.setString(3, MJK.getHari());
            preparedStatement.setString(4, MJK.getKelas());
            preparedStatement.setString(5, MJK.getSemester());
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public boolean updateDataJadwalKuliah(ModelJadwalKuliah MJK) throws RemoteException {
        boolean status = false;
        String sql = "UPDATE tb_jadwalkuliah SET nama = ?, jam = ?, hari = ?, kelas = ?, semester = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MJK.getNama());
            preparedStatement.setString(2, MJK.getJam());
            preparedStatement.setString(3, MJK.getHari());
            preparedStatement.setString(4, MJK.getKelas());
            preparedStatement.setString(5, MJK.getSemester());
            preparedStatement.setInt(6, MJK.getId_praktikum());
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public boolean deleteDataJadwalKuliah(int id) throws RemoteException {
        boolean status = false;
        String sql = "DELETE FROM tb_jadwalkuliah WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public List<ModelUser> getDataUser() throws RemoteException {
        List<ModelUser> data = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tb_users");
            while (resultSet.next()) {
                data.add(new ModelUser(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    @Override
    public boolean insertDataUser(ModelUser MU) throws RemoteException {
        boolean status = false;
        String sql = "INSERT INTO tb_users (username, password) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MU.getUsername());
            preparedStatement.setString(2, MU.getPassword());
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public boolean updateDataUser(ModelUser MU) throws RemoteException {
        boolean status = false;
        String sql = "UPDATE tb_users SET username = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MU.getUsername());
            preparedStatement.setString(2, MU.getPassword());
            preparedStatement.setInt(3, MU.getId());
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public boolean deleteDataUser(int id) throws RemoteException {
        boolean status = false;
        String sql = "DELETE FROM tb_users WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public boolean checkUser(String username, String password) throws RemoteException {
        boolean status = false;
        try {
            String sql = "SELECT * FROM tb_users WHERE username = '"+username+"' AND password = '"+password+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                status = true;
            }
            System.out.println(status);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    

}
