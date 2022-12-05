
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApagarEmpresa extends JFrame{

    private JFrame frame;
    private JButton submeter, voltar;
    private JPanel panelA;
    private JTextField nome;

    private Font fonte = new Font("Arial", Font.BOLD, 25);
    private Font fonte1 = new Font("Arial", Font.BOLD, 20);
    private Color fgColor = new Color(10, 10, 10);
    private Color bgColor = new Color(100, 100, 150);

    public ApagarEmpresa() {
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

        JLabel labelName = new JLabel("Apagar empresa");
        labelName.setBounds(400, 0, 200,100);
        labelName.setFont(fonte);

        JLabel labelName1 = new JLabel("empresa");
        labelName1.setBounds(150, 200, 100,50);
        labelName1.setFont(fonte1);

        nome = new JTextField();
        nome.setBounds (300, 200, 550,50);


        submeter = new JButton();
        submeter.setText("Submeter");
        submeter.setBounds (750, 700, 200,40);
        submeter.setFont(new Font("Arial", Font.BOLD, 30));
        submeter.setForeground(fgColor);
        submeter.setBackground(bgColor);

        voltar = new JButton();
        voltar.setText("Voltar");
        voltar.setBounds (500, 700, 200,40);
        voltar.setFont(new Font("Arial", Font.BOLD, 30));
        voltar.setForeground(fgColor);
        voltar.setBackground(bgColor);

        submeter.addActionListener(new ButtonListener());
        voltar.addActionListener(new ButtonListener());


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(labelName);
        panel.add(labelName1);
        panel.add(nome);

        panel.add(submeter);
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
                case "Submeter":
                    //ALTERAR PARA APAGAR SO AS EMPRESAS QUE EXISTEM
                    if (nome.getText().equals("qwerty"))
                        JOptionPane.showMessageDialog(null, "Empresa nao existe");
                    else
                        JOptionPane.showMessageDialog(null, "Empresa apagada");

                    frame.setVisible(false);
                    frame.dispose();
                    new LoadMain();
                    break;
            }
        }
    }

}