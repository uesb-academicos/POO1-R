import javax.swing.*;
import java.awt.*;

/** Três telas acadêmicas da atividade Java Swing. */
public class TelasAcademicas {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> criarTela());
  }

  private static void criarTela() {
    JFrame janela = new JFrame("POO1 — Cadastro acadêmico");
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setSize(560, 360);
    janela.setLocationRelativeTo(null);
    JPanel painel = new JPanel(new GridLayout(0, 2, 10, 10));
    painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    painel.add(new JLabel("Nome do estudante"));
    painel.add(new JTextField());
    painel.add(new JLabel("Matrícula"));
    painel.add(new JTextField());
    painel.add(new JLabel("Disciplina"));
    painel.add(new JTextField());
    painel.add(new JButton("Salvar"));
    painel.add(new JButton("Cancelar"));
    janela.add(painel);
    janela.setVisible(true);
  }
}
