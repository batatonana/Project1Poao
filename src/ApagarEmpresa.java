
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *Class os the GUI to edit and delete empresas
 */
public class ApagarEmpresa extends JFrame {

    private JFrame frame;
    private JButton apagar, voltar, editar;
    private JPanel panelA, panelB, panelC, panelD;
    private JList lista;
    private JScrollPane sp;

    private Font fonte = new Font("Arial", Font.BOLD, 25);
    private Color fgColor = new Color(10, 10, 10);
    private Color bgColor = new Color(100, 100, 150);

    private StarThrive manager;
    private String[] dados;
    private JLabel labels[];
    private JTextField textFields[];

    public ApagarEmpresa(StarThrive manager) {
        this.manager = manager;

        frame = new JFrame();
        frame.setTitle("Editar");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel labelName = new JLabel("Apagar empresa", SwingConstants.CENTER);
        labelName.setFont(fonte);

        voltar = new JButton("Voltar");
        voltar.setFont(fonte);
        voltar.setForeground(fgColor);
        voltar.setBackground(bgColor);
        voltar.addActionListener(new ButtonListener());

        apagar = new JButton("Apagar");
        apagar.setFont(fonte);
        apagar.setForeground(fgColor);
        apagar.setBackground(bgColor);
        apagar.addActionListener(new ButtonListener());

        editar = new JButton("Editar");
        editar.setFont(fonte);
        editar.setForeground(fgColor);
        editar.setBackground(bgColor);
        editar.addActionListener(new ButtonListener());

        String[] data = new String[manager.data().length];
        for (int i = 0; i < data.length; i++) {
            data[i] = manager.data()[i][0];
        }

        lista = new JList(data);

        sp = new JScrollPane(lista);

        panelC = new JPanel();
        panelC.setLayout(new GridLayout(2, 1));
        panelC.add(apagar);
        panelC.add(editar);

        panelB = new JPanel();
        panelB.setLayout(new GridLayout(1, 2));
        panelB.add(sp);
        panelB.add(panelC);

        panelA = new JPanel();
        panelA.setLayout(new BorderLayout());
        panelA.add(labelName, BorderLayout.NORTH);
        panelA.add(voltar, BorderLayout.SOUTH);
        panelA.add(panelB, BorderLayout.CENTER);

        frame.add(panelA);
        frame.setVisible(true);
    }

    private void apagar() {
        panelB.remove(sp);
        panelB.add(panelC);

        //Populating the array data
        String[] data = new String[manager.data().length];
        for (int i = 0; i < data.length; i++) {
            data[i] = manager.data()[i][0];
        }
        manager.saveFile();

        lista = new JList(data);

        sp = new JScrollPane(lista);

        panelB.add(sp);
        panelB.add(panelC);

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    private void editLayout(int i) {
        panelA.remove(panelB);
        frame.invalidate();
        frame.validate();
        frame.repaint();

        String empresa = manager.get(i).toString();
        String[] empresaArray = empresa.split("\n");
        labels = new JLabel[empresaArray.length - 2];
        textFields = new JTextField[empresaArray.length - 2];

        panelD = new JPanel();
        panelD.setLayout(new GridLayout(empresaArray.length - 1, 2));

        for (int j = 2; j < empresaArray.length; j++) {
            labels[j - 2] = new JLabel(empresaArray[j].split(":")[0].strip());
            panelD.add(labels[j - 2]);
            textFields[j - 2] = new JTextField(empresaArray[j].split(":")[1].strip());
            panelD.add(textFields[j - 2]);
        }

        JButton cancelar = new JButton("Cancelar");
        cancelar.setFont(fonte);
        cancelar.setForeground(fgColor);
        cancelar.setBackground(bgColor);
        cancelar.addActionListener(new ButtonListener());

        JButton confirmar = new JButton("Confirmar");
        confirmar.setFont(fonte);
        confirmar.setForeground(fgColor);
        confirmar.setBackground(bgColor);
        confirmar.addActionListener(new ButtonListener());

        panelD.add(cancelar);
        panelD.add(confirmar);

        panelA.add(panelD);
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
                    new LoadMain(manager);
                    break;
                case "Apagar":
                    if (lista.getSelectedValue() != null) {
                        int option = JOptionPane.showConfirmDialog(null,
                                "Pretende apagar a empresa " + lista.getSelectedValue(), "Comfirmar",
                                JOptionPane.YES_NO_OPTION);
                        if (option == 0) {
                            if (manager.delete(lista.getSelectedIndex()) == 0) {
                                apagar();
                                JOptionPane.showMessageDialog(null, "Empresa apagada com sucesso", "Empresa apagada",
                                        JOptionPane.YES_OPTION);

                            } else {
                                JOptionPane.showMessageDialog(null, "Erro ao apagar empresa", "empresa nao apagada",
                                        JOptionPane.YES_OPTION);
                            }
                        }
                    }
                    break;
                case "Editar":
                    if (lista.getSelectedValue() != null) {
                        editLayout(lista.getSelectedIndex());
                    }
                    break;
                case "Cancelar":
                    panelA.remove(panelD);
                    panelA.add(panelB);
                    apagar();
                    break;
                case "Confirmar":
                    dados = new String[textFields.length];
                    int i = 0;
                    for (JTextField field : textFields) {
                        dados[i] = field.getText();
                        i++;
                    }
                    if(manager.get(lista.getSelectedIndex()).save(dados) == 0){
                        panelA.remove(panelD);
                        panelA.add(panelB);
                        apagar();
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro ao modificar empresa", "Erro",
                                        JOptionPane.YES_OPTION);
                        manager.get(lista.getSelectedIndex()).setValid(true);
                    }
                    break;
            }
        }
    }

}