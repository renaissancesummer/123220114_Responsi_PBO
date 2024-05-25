/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dosen.ModelTable;
import Model.Dosen.ModelDosen;
import Model.Dosen.DAODosen;
import Model.Dosen.InterfaceDAODosen;
import java.util.List;
import javax.swing.JOptionPane;
import View.Dosen.*;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ControllerDosen {
    ViewData halamanTable;
    InputData halamanInput;
    EditData halamanEdit;

    InterfaceDAODosen daoDosen;

    // Membuat variabel "daftarMahasiswa" untuk menyimpan data mahasiswa yg diambil dari DB.
    List<ModelDosen> daftarDosen;
    
    /*
      Kalo temen-temen liat di sini, ada 3 fungsi contructor yang masing-masing memiliki
      parameter yang berbeda. Nah, hal ini disebut dengan "function overloading",
      yaitu sebuah fungsi yang memiliki nama sama tetapi memiliki parameter yang berbeda.
      
      Mengapa kita butuh "function overloading"?
      Karena dalam hal ini, controller mahasiswa akan digunakan pada 3 halaman atau 3 view yang berbeda, 
      yaitu Halaman Table, Halaman Input, dan Halaman Edit.
    */
    public ControllerDosen(ViewData halamanTable) {
        this.halamanTable = halamanTable;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(InputData halamanInput) {
        this.halamanInput = halamanInput;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(EditData halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoDosen = new DAODosen();
    }

    public void showAllDosen() {  
        /*
          Mengambil daftar mahasiswa dari database, 
          kemudian disimpan ke dalam variabel bernama list.
         */
        daftarDosen = daoDosen.getAll(); 
        
        /* 
          Supaya daftarMahasiswa dapat dimasukkan ke dalam tabel, kita perlu 
          mengubah daftarMahasiswa yang memiliki tipe data List menjadi 
          tipe data Array Object. Jika pada pertemuan kemarin kita melakukannya
          secara manual menggunakan looping, kali ini kita tidak perlu melakukan hal tersebut,
          karena class ModelTabel sudah otomatis mengubahnya menjadi tipe data yang sesuai.
          
          Caranya kita hanya perlu membuat sebuah instance dari class ModelTable,
          kemudian kita masukkan variabel daftarMahasiswa sebagai parameter constructor
          supaya dapat diubah menjadi sebuah isi table yang dapat dimasukkan ke dalam tabel.
         */
        ModelTable table = new ModelTable(daftarDosen);
        
        // Mengisi tabel yang berada pada halaman Table Mahasiswa
        halamanTable.getTableDosen().setModel(table);
    }
     public void deleteDosen(Integer baris) {
        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );
        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {           
            daoDosen.delete(id);
            
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllDosen();
        }
       
    }
    public void insertDosen() {
        try {
            ModelDosen dosenBaru = new ModelDosen();
           
            String nama = halamanInput.getInputNama();
            String no_hp = halamanInput.getInputnohp();
            String email = halamanInput.getInputemail();

            
            if ("".equals(nama) || "".equals(no_hp) || "".equals(email)) {
                throw new Exception("Nama atau NIM tidak boleh kosong!");
            }
            
            dosenBaru.setnama(nama);
            dosenBaru.setno_hp(no_hp);

            daoDosen.insert(dosenBaru);
            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan.");
            halamanInput.dispose();
            new ViewData();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editDosen(int id) {
        try {
            ModelDosen dosenYangMauDiedit = new ModelDosen();
           
            String nama = halamanEdit.getInputNama();
            String no_hp = halamanEdit.getInputnohp();
            String email = halamanEdit.getInputemail();

            if ("".equals(nama) || "".equals(no_hp)|| "".equals(email)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
            
            // Mengisi id, nama dan nim dari "mahasiswa baru" yang dibuat tadi.
            dosenYangMauDiedit.setId(id);
            dosenYangMauDiedit.setNama(nama);
            dosenYangMauDiedit.setnohp(no_hp);
            dosenYangMauDiedit.setemail(email);
            daoDosen.update(dosenYangMauDiedit);
            JOptionPane.showMessageDialog(null, "Data Dosen berhasil diubah.");

            halamanEdit.dispose();
            new ViewData();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteMahasiswa(Integer baris) {
        // Mengambil id dan nama berdasarkan baris yang dipilih
        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );

        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {
            
            // Pop up
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            
            // Memanggil method "showAllMahasiswa()" untuk merefresh table.
            showAllDosen();
        }
    }
    public void kembali (){
        //new Main.Menu();         
    }
}
