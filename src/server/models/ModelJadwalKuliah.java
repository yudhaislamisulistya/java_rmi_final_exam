/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.models;

import java.io.Serializable;

/**
 *
 * @author 62853
 */
public class ModelJadwalKuliah implements Serializable{
     int id_praktikum;
    String nama, jam, hari, kelas, semester, created_at, updated_at;

    public ModelJadwalKuliah(int id_praktikum, String nama, String jam, String hari, String kelas, String semester, String created_at, String updated_at) {
        this.id_praktikum = id_praktikum;
        this.nama = nama;
        this.jam = jam;
        this.hari = hari;
        this.kelas = kelas;
        this.semester = semester;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId_praktikum() {
        return id_praktikum;
    }

    public void setId_praktikum(int id_praktikum) {
        this.id_praktikum = id_praktikum;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
