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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author PC PRAKTIKUM
 */
public class LoginPage extends JFrame implements ActionListener {
    JLabel header = new JLabel("Selamat Datang!");
    JLabel subheader = new JLabel("Silakan masuk untuk melanjutkan.");
    JLabel labelUsername = new JLabel("Username");
    JLabel labelPassword = new JLabel("Password");
    JTextField inputUsername = new JTextField();
    JTextField inputPassword = new JTextField();

    JButton tombolLogin = new JButton("Login");

    LoginPage() {
        setVisible(true);
        setSize(480, 350);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        add(header);
        add(subheader);
        add(labelUsername);
        add(labelPassword);
        add(inputUsername);
        add(inputPassword);
        add(tombolLogin);

        header.setFont(header.getFont().deriveFont(20.0f));
        header.setBounds(20, 20, 440, 24);
        subheader.setBounds(20, 50, 440, 12);

        labelUsername.setBounds(20, 84, 440, 12);
        inputUsername.setBounds(18, 100, 420, 32);

        labelPassword.setBounds(20, 150, 440, 12);
        inputPassword.setBounds(18, 166, 420, 32);

        tombolLogin.setBounds(130, 240, 220, 36);
        tombolLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Mengambil nilai dari username yang diinput user di textfield
            String username = inputUsername.getText();
            String password = inputPassword.getText();
            
            // Memberikan error handling jika username kosong
            if (username.isEmpty()) {
                throw new Exception("Make sure the username and password are filled.");
            }
            
            if (password.isEmpty()) {
                throw new Exception("Make sure the username and password are filled.");
            }
            
            // Pindah halaman
            new PageDua(username);
            this.dispose();
        } catch (Exception error) {
            // Menampilkan error dalam bentuk popup
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}
