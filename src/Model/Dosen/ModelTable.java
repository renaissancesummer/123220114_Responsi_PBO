/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dosen;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ModelTable extends AbstractTableModel{
    // Berfungsi untuk menyimpan daftar mahasiswa
    List<Model.Dosen.ModelDosen> daftarDosen;
    String kolom[] = {"id", "nama", "no_hp", "email"};

    public ModelTable(List<Model.Dosen.ModelDosen> daftarDosen) {
        this.daftarDosen = daftarDosen;
    }

    // Method untuk mengambil jumlah baris dari tabel
    @Override
    public int getRowCount() {
        return daftarDosen.size();
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
                return daftarDosen.get(rowIndex).getid();
            case 1:
                return daftarDosen.get(rowIndex).getnama();
            case 2:
                return daftarDosen.get(rowIndex).getno_hp();
            case 3:
                return daftarDosen.get(rowIndex).getemail();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
