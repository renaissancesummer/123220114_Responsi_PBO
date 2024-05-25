/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dosen;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ModelDosen {
    private Integer id;
    private String nama, nidn, no_hp, email;
    
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

    public String getno_hp() {
        return no_hp;
    }

    public void setno_hp(String no_hp) {
        this.no_hp = no_hp;
    }
    
    public String getemail() {
        return email;
    }
    
    public void setemail(String email) {
        this.email = email;
    }
}
