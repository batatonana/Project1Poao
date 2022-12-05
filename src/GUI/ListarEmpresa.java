package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarEmpresa extends JFrame {

    private JFrame frame;
    private JPanel panelA;
    private JButton  voltar;
    private Font fonte = new Font("Arial", Font.BOLD, 25);
    private Color fgColor = new Color(10, 10, 10);
    private Color bgColor = new Color(100, 100, 150);

    public ListarEmpresa() {
        frame = new JFrame();
        frame.setTitle("Aula 01");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panelA = drawPanel();
        panelA.setVisible(true);

        frame.add(panelA);
        frame.setVisible(true);

    }

    private JPanel drawPanel() {

        JLabel labelName = new JLabel("Lista de empresas");
        labelName.setBounds(400-25, 0, 250,100);
        labelName.setFont(fonte);

        voltar = new JButton();
        voltar.setText("Voltar");
        voltar.setBounds (500, 700, 200,40);
        voltar.setFont(new Font("Arial", Font.BOLD, 30));
        voltar.setForeground(fgColor);
        voltar.setBackground(bgColor);

        //atribui acoes aos botoes
        voltar.addActionListener(new ButtonListener());

        //cria painel e addiciona os compenentes
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(labelName);
        panel.add(lista);
        panel.add(voltar);

        return panel;
    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch (cmd) {
                case "Voltar":
                    frame.setVisible(false);
                    frame.dispose();
                    new LoadMain();
                    break;

            }
        }
    }

}

