import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaSwing extends JFrame {
    private Agenda agenda = new Agenda();
    private JTextArea textArea;

    public AgendaSwing() {
        setTitle("Agenda de Contatos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome:");
                String telefone = JOptionPane.showInputDialog("Telefone:");
                String email = JOptionPane.showInputDialog("Email:");
                agenda.adicionarContato(new Contato(nome, telefone, email));
                atualizarLista();
            }
        });
        panel.add(btnAdd);

        JButton btnList = new JButton("Listar");
        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarLista();
            }
        });
        panel.add(btnList);

        add(panel, BorderLayout.SOUTH);
    }

    private void atualizarLista() {
        StringBuilder sb = new StringBuilder();
        for (Contato contato : agenda.listarContatos()) {
            sb.append(contato).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AgendaSwing().setVisible(true);
            }
        });
    }
}
