
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApagarEmpresa extends JFrame{

    private JFrame frame;
    private JButton submeter, voltar;
    private JPanel panelA, panelB;
    private JList lista;
    private JScrollPane sp;

    private Font fonte = new Font("Arial", Font.BOLD, 25);
    private Color fgColor = new Color(10, 10, 10);
    private Color bgColor = new Color(100, 100, 150);

    private StarThrive manager = new StarThrive();

    public ApagarEmpresa() {
        frame = new JFrame();
        frame.setTitle("Aula 01");
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel labelName = new JLabel("Apagar empresa", SwingConstants.CENTER);
        labelName.setFont(fonte);

        voltar = new JButton("Voltar");
        voltar.setBounds(500, 700, 200, 40);
        voltar.setFont(fonte);
        voltar.setForeground(fgColor);
        voltar.setBackground(bgColor);
        voltar.addActionListener(new ButtonListener());

        submeter = new JButton("Apagar");
        submeter.setBounds(500, 700, 200, 40);
        submeter.setFont(fonte);
        submeter.setForeground(fgColor);
        submeter.setBackground(bgColor);
        submeter.addActionListener(new ButtonListener());

        
        String[] data = new String[manager.data().length];
        for (int i = 0; i < data.length; i++) {
            data[i] = manager.data()[i][0];
        }

        lista = new JList(data);

        sp = new JScrollPane(lista);
        

        panelB = new JPanel();
        panelB.setLayout(new GridLayout(1, 2));
        panelB.add(sp);
        panelB.add(submeter);


        panelA = new JPanel();
        panelA.setLayout(new BorderLayout());
        panelA.add(labelName, BorderLayout.NORTH);
        panelA.add(voltar, BorderLayout.SOUTH);
        panelA.add(panelB, BorderLayout.CENTER);

        frame.add(panelA);
        frame.setVisible(true);
    }

    private void apagar(){
        panelB.remove(sp);
        panelB.remove(submeter);
        String[] data = new String[manager.data().length];
        for (int i = 0; i < data.length; i++) {
            data[i] = manager.data()[i][0];
        }
        lista = new JList(data);
        sp = new JScrollPane(lista);
        manager.saveFile();
        panelB.add(sp);
        panelB.add(submeter);
        frame.invalidate();
        frame.validate();
        frame.repaint();
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
                case "Apagar":
                    if(lista.getSelectedValue() != null){
                        int option = JOptionPane.showConfirmDialog(null, "Pretende apagar a empresa " + lista.getSelectedValue(), "Comfirmar", JOptionPane.YES_NO_OPTION);
                        if(option == 0 ){
                            if(manager.delete(lista.getSelectedIndex()) == 0){
                                apagar();
                                JOptionPane.showMessageDialog(null, "Empresa apagada com sucesso", "Empresa apagada", JOptionPane.YES_OPTION);

                            }else{
                                JOptionPane.showMessageDialog(null, "Erro ao apagar empresa", "empresa nao apagada", JOptionPane.YES_OPTION);
                            }   
                        }
                    }
                    break;
            }
        }
    }

}