
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarEmpresa extends JFrame {

    private JFrame frame;
    private JPanel panelA, panelB;
    private JButton voltar, submit;
    private Font fonte = new Font("Arial", Font.BOLD, 30);
    private JComboBox dropdown;
    private Color fgColor = new Color(10, 10, 10);
    private Color bgColor = new Color(100, 100, 150);
    private JTable table;
    private JScrollPane sp;
    // Creating a StarTrhrive object and populating it
    private StarThrive manager = new StarThrive();

    public ListarEmpresa() {
        System.out.println("HEYYYYYYYYYYY");
        // Set frame Dimensions
        frame = new JFrame();
        frame.setTitle("Aula 01");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        voltar = new JButton("Voltar");
        voltar.setBounds(500, 700, 200, 40);
        voltar.setFont(fonte);
        voltar.setForeground(fgColor);
        voltar.setBackground(bgColor);
        voltar.addActionListener(new ButtonListener());

        submit = new JButton("Search");
        submit.setFont(fonte);
        submit.setForeground(fgColor);
        submit.setBackground(bgColor);
        submit.addActionListener(new ButtonListener());

        String country[] = { "Todas as empresas", "Empresas com maior lucro anual", "Empresas com maior receita anual",
                "Empresas com menor despesa anual", "Restaurantes com mais clientes" };
        dropdown = new JComboBox(country);
        panelB = new JPanel();
        panelB.setLayout(new GridLayout(1, 2));
        panelB.add(dropdown);
        panelB.add(submit);
        panelA = new JPanel();
        panelA.setLayout(new BorderLayout());
        listarTodos();
        panelA.add(voltar, BorderLayout.SOUTH);
        panelA.add(panelB, BorderLayout.NORTH);

        frame.add(panelA);
        // Frame Visible = true
        frame.setVisible(true);
    }
    private void listarTodos() {
        // Data
        String[][] data = manager.data();
        String[] columnNames = { "Nome", "Tipo", "Distrito", "Despesa Anual", "Receita Anual", "Lucro Anual" };

        // Make table uneditable
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Putting the JTable into the a scrollpanel and into panelA
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
        table.setModel(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        sp = new JScrollPane(table);
        panelA.add(sp, BorderLayout.CENTER);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    private void listarLucro() {
        String[][] data = manager.stats(0);
        String[] columnNames = { "Nome", "Tipo", "Lucro Anual" };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        panelA.remove(sp);
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
        table.setModel(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        sp = new JScrollPane(table);
        panelA.add(sp, BorderLayout.CENTER);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    private void listarReceita() {
        String[][] data = manager.stats(1);
        String[] columnNames = { "Nome", "Tipo", "Receita Anual" };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        panelA.remove(sp);
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
        table.setModel(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        sp = new JScrollPane(table);
        panelA.add(sp, BorderLayout.CENTER);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    private void listarDespesa() {
        String[][] data = manager.stats(2);
        String[] columnNames = { "Nome", "Tipo", "Despesa Anual" };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        panelA.remove(sp);
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
        table.setModel(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        sp = new JScrollPane(table);
        panelA.add(sp, BorderLayout.CENTER);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    private void listarMaiorCliente() {
        String[][] data = manager.clientes();
        String[] columnNames = { "Nome", "Tipo", "Distrito", "Clientes", "Despesa Anual", "Receita Anual", "Lucro Anual" };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        panelA.remove(sp);
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
        table.setModel(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        sp = new JScrollPane(table);
        panelA.add(sp, BorderLayout.CENTER);
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
                case "Search":
                    switch (dropdown.getSelectedIndex()) {
                        case 0:
                            panelA.remove(sp);
                            listarTodos();
                            break;
                        case 1:
                            listarLucro();
                            break;
                        case 2:
                            listarReceita();
                            break;
                        case 3:
                            listarDespesa();
                            break;
                        case 4:
                            listarMaiorCliente();
                            break;
                    }

                    break;
            }
        }
    }
}
