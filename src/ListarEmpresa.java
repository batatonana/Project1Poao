
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarEmpresa extends JFrame {

    private JFrame frame;
    private JPanel panelA, panelB;
    private JButton  voltar, submit;
    private Font fonte = new Font("Arial", Font.BOLD, 30);
    private JComboBox dropdown;
    private Color fgColor = new Color(10, 10, 10);
    private Color bgColor = new Color(100, 100, 150);

    public ListarEmpresa() {
        // Set frame Dimensions
        frame = new JFrame();
        frame.setTitle("Aula 01");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        voltar = new JButton();
        voltar.setText("Voltar");
        voltar.setBounds (500, 700, 200,40);
        voltar.setFont(fonte);
        voltar.setForeground(fgColor);
        voltar.setBackground(bgColor);
        voltar.addActionListener(new ButtonListener());

        submit = new JButton();
        submit.setText("Submit");
        submit.setFont(fonte);
        submit.setForeground(fgColor);
        submit.setBackground(bgColor);
        submit.addActionListener(new ButtonListener());
        
        // String[] s= {"Listar todas", "Listar maior lucro", "Mostrar clientes"};
        // dropdown = new JComboBox();
        String country[]={"India","Aus","U.S.A","England","Newzealand"};
        dropdown = new JComboBox(country);


        StarThrive manager = new StarThrive();
        manager.readObjFile();

        String[][] data = manager.data();
        String[] columnNames = { "Nome", "Tipo", "Distrito", "Despesa Anual", "Receita Anual", "Lucro" };
        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        
        panelB = new JPanel();
        panelB.setLayout(new GridLayout(1,2));
        panelB.add(dropdown);
        panelB.add(submit);
        panelA = new JPanel();
        panelA.setLayout(new BorderLayout());
        panelA.add(sp, BorderLayout.CENTER);
        panelA.add(voltar, BorderLayout.SOUTH);
        panelA.add(panelB, BorderLayout.NORTH);
            
        frame.add(panelA);
        // Frame Visible = true
        frame.setVisible(true);
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

