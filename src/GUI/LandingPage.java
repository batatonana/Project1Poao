package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class LandingPage extends  JFrame implements ActionListener{

    private JFrame frame;
    private JPanel panelA;
    private JButton login;

    public LandingPage() {

        frame = new JFrame();
        frame.setTitle("Aula 01");
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panelA = drawPanel();
        panelA.setVisible(true);

        frame.add(panelA);
        frame.setVisible(true);
    }

    private JPanel drawPanel() {
        
        login = new JButton();
        login.setText("Login");
        login.setBounds (500-125, 500, 250,70);

        login.setFont(new Font("Arial", Font.BOLD, 30));
        login.setForeground(new Color(10, 10, 10));
        login.setBackground(new Color(100, 100, 150));

        //atribui acoes aos botoes
        login.addActionListener(this::actionPerformed);

        //cria painel e addiciona os compenentes
        JPanel panel = new JPanel();    
        panel.setLayout(null);
        panel.add(login);

        return panel;
    }

    @Override
    public void actionPerformed (ActionEvent e) {

        frame.setVisible(false);
        frame.dispose();
        new LoadMain();
    }

}
