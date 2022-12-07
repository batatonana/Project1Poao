

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/**
 * Main GUI class
 */
public class LoadMain extends JFrame{

    private JPanel panelA;
    private JFrame frame;
    private JButton botao1, botao2, botao3;
    private Font fonte = new Font("Arial", Font.BOLD, 25);
    private Color fgColor = new Color(10, 10, 10);
    private Color bgColor = new Color(100, 100, 150);
    private Empresa empresa;
    private StarThrive manager;

    /**
     * Class constructor to LoadMain
     * @param manager 
     */
    public LoadMain(StarThrive manager) {
        this.manager = manager;

        frame = new JFrame();
        frame.setTitle("StarThrive");

        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panelA = drawPanelMenu();
        panelA.setVisible(true);

        frame.add(panelA);
        frame.setVisible(true);
    }

    private JPanel drawPanelMenu() {

        JLabel labelName = new JLabel("Menu");
        labelName.setBounds (450, 0, 100,100);
        labelName.setFont(fonte);

        botao1 = new JButton();
        botao2 = new JButton();
        botao3 = new JButton();

        botao1.setText("Adicionar empresa");
        botao2.setText("Editar ou Apagar empresa");
        botao3.setText("Listar empresas");

        //atribui posicao e tamanho aos botoes
        botao1.setBounds (200, 300, 600,70);
        botao2.setBounds (200, 200, 600,70);
        botao3.setBounds (200, 100, 600,70);

        //define as cores dos botoes, o tamanho e cor da letra
        botao1.setFont(fonte);
        botao1.setForeground(fgColor);
        botao1.setBackground(bgColor); 

        botao2.setFont(fonte);
        botao2.setForeground(fgColor);
        botao2.setBackground(bgColor);

        botao3.setFont(fonte);
        botao3.setForeground(fgColor);
        botao3.setBackground(bgColor);

        //atribui acoes aos botoes
        botao1.addActionListener(new ButtonListener());
        botao2.addActionListener(new ButtonListener());
        botao3.addActionListener(new ButtonListener());

        //cria painel e addiciona os compenentes
        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(labelName);
        panel.add(botao1);
        panel.add(botao2);
        panel.add(botao3);

        return panel;

    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch (cmd) {
                case "Adicionar empresa":
                    frame.setVisible(false);
                    frame.dispose();
                    new AddEmpresa(manager, empresa);
                    break;
                case "Editar ou Apagar empresa":
                    frame.setVisible(false);
                    frame.dispose();
                    new ApagarEmpresa(manager);
                    break;
                case "Listar empresas":
                    frame.setVisible(false);
                    frame.dispose();
                    new ListarEmpresa(manager);
                    break;
            }
        }
    }

}