/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Mahasiswa;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ModelTable extends AbstractTableModel {
     // Berfungsi untuk menyimpan daftar mahasiswa
    List<ModelMahasiswa> daftarMahasiswa;

    /*
      Nama kolom tabelnya disimpan ke dalam variabel "namaKolom" yang memiliki 
      tipe data Array String.
     */
    String kolom[] = {"id", "nama", "nim", "email", "password" , "angkatan"};

    /*
      Karena daftarMahasiswa memiliki tipe data List, kita harus mengubahnya
      terlebih dahulu ke dalam tipe data Array Object supaya dapat 
      dimasukkan ke dalam table.
     */
    public ModelTable(List<ModelMahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    // Method untuk mengambil jumlah baris dari tabel
    @Override
    public int getRowCount() {
        return daftarMahasiswa.size();
    }

    // Method untuk mengambil jumlah kolom dari tabel
    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarMahasiswa.get(rowIndex).getid();
            case 1:
                return daftarMahasiswa.get(rowIndex).getnama();
            case 2:
                return daftarMahasiswa.get(rowIndex).getnim();
            case 3:
                return daftarMahasiswa.get(rowIndex).getemail();
            case 4:
                return daftarMahasiswa.get(rowIndex).getpassword();
            case 5:
                return daftarMahasiswa.get(rowIndex).getangkatan();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
