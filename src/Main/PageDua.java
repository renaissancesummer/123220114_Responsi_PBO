/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author PC PRAKTIKUM
 */
public class PageDua extends JFrame implements ActionListener {
    JLabel header = new JLabel();
    JLabel subheader = new JLabel("Silahkan pilih untuk melanjutkan.");

    JButton tombolMahasiswa = new JButton("Mahasiswa");
    JButton tombolDosen = new JButton("Dosen");
    JButton tombolLogout = new JButton("Logout");

    PageDua(String username) {
        setVisible(true);
        setSize(480, 320);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        add(header);
        add(subheader);
        add(tombolMahasiswa);
        add(tombolDosen);
        add(tombolLogout);
        
        // Memberikan tulisan pada label header
        header.setText("Selamat datang, " + username);
        header.setFont(header.getFont().deriveFont(20.0f));
        header.setBounds(20, 20, 440, 24);
        subheader.setBounds(20, 50, 440, 16);

        tombolMahasiswa.setBounds(30, 100, 410, 36);
        tombolDosen.setBounds(30, 150, 410, 36);
        tombolLogout.setBounds(30, 200, 410, 36);

        tombolMahasiswa.addActionListener(this);
        tombolDosen.addActionListener(this);
        tombolLogout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolDosen) {
            new View.Dosen.ViewData();
            this.dispose();
        } else if (e.getSource() == tombolMahasiswa) {
            new View.Mahasiswa.ViewData();
            this.dispose();
        }else if (e.getSource() == tombolLogout) {
            //new PageDua(username);
            this.dispose();
    }}

}
