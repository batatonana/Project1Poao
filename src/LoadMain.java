
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoadMain extends JFrame{

    private JPanel panelA;
    private JFrame frame;
    private JButton botao1, botao2, botao3, botao4;
    private Font fonte = new Font("Arial", Font.BOLD, 25);
    private Color fgColor = new Color(10, 10, 10);
    private Color bgColor = new Color(100, 100, 150);

    public LoadMain() {
        frame = new JFrame();
        frame.setTitle("Aula 01");

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
        botao4 = new JButton();

        botao1.setText("Adicionar empresa");
        botao2.setText("Editar empresa");
        botao3.setText("Apagar empresa");
        botao4.setText("Listar empresas");

        //atribui posicao e tamnho aos botoes
        botao1.setBounds (100, 100, 275,70);
        botao2.setBounds (100, 200, 275,70);
        botao3.setBounds (100, 300, 275,70);
        botao4.setBounds (100, 400, 275,70);

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

        botao4.setFont(fonte);
        botao4.setForeground(fgColor);
        botao4.setBackground(bgColor);

        //atribui acoes aos botoes
        botao1.addActionListener(new ButtonListener());
        botao2.addActionListener(new ButtonListener());
        botao3.addActionListener(new ButtonListener());
        botao4.addActionListener(new ButtonListener());

        //cria painel e addiciona os compenentes
        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(labelName);
        panel.add(botao1);
        panel.add(botao2);
        panel.add(botao3);
        panel.add(botao4);

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
                    new AddEmpresa();
                    break;
                case "Editar empresa":
                    JOptionPane.showMessageDialog(null, "Editar empresa");
                    break;
                case "Apagar empresa":
                    frame.setVisible(false);
                    frame.dispose();
                    new ApagarEmpresa();
                    break;
                case "Listar empresas":
                    frame.setVisible(false);
                    frame.dispose();
                    new ListarEmpresa();
                    break;
            }
        }
    }

}