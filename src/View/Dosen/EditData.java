/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Dosen;

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author PC PRAKTIKUM
 */
public class EditData extends JFrame{
    // Membuat sebuah instance bernama controller dari class "ControllerMahasiswa".
    ControllerDosen controller;
    
    JLabel header = new JLabel("Edit Dosen");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputemail = new JLabel("email");
    JLabel labelInputnohp = new JLabel("nomor hp");
    JTextField inputNama = new JTextField();
    JTextField inputemail = new JTextField();
    JTextField inputnohp = new JTextField();
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolKembali = new JButton("Kembali");

    public EditData(ModelDosen dosen) {
        setTitle("Edit Dosen");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 240);

        add(header);
        add(labelInputNama);
        add(labelInputemail);
        add(labelInputnohp);
        add(inputNama);
        add(inputemail);
        add(inputnohp);
        add(tombolEdit);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputemail.setBounds(20, 96, 440, 24);
        inputemail.setBounds(18, 120, 440, 36);
        tombolKembali.setBounds(20, 160, 215, 40);
        tombolEdit.setBounds(240, 160, 215, 40);
        
        // Masukkin nama dan nim yang didapat dari halaman sebelumnya.
        inputNama.setText(dosen.getnama());
        inputnohp.setText(dosen.getno_hp());
        inputemail.setText(dosen.getemail());
        
        controller = new ControllerDosen(this);

        /* 
          Memberikan event handling untuk tombol kembali,
          Ketika tombol kembali diklik, maka akan kembali ke halaman ViewData().
         */
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new View.Dosen.ViewData();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editDosen(dosen.getid());
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }
    
    public String getInputNIDN() {
        return inputemail.getText();
    }
}
