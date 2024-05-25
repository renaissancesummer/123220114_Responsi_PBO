/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Mahasiswa;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ModelMahasiswa {
    private Integer id;
    private String nama, nim, email, password, angkatan ;
   
    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getnama() {
        return nama;
    }

    public void setnama(String nama) {
        this.nama = nama;
    }

    public String getnim() {
        return nim;
    }

    public void setnim(String nim) {
        this.nim = nim;
    }
    
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
    
    public String getangkatan() {
        return angkatan;
    }

    public void setangkatan(String angkatan) {
        this.angkatan = angkatan;
    }
}
